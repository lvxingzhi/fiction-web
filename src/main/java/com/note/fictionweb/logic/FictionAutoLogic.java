package com.note.fictionweb.logic;

import com.note.base.dto.ResponseDTO;
import com.note.base.dto.file.BaseDto;
import com.note.base.dto.file.ChapterDto;
import com.note.base.dto.file.FileParseDto;
import com.note.base.exception.SystemException;
import com.note.base.utils.FileParseUtil;
import com.note.base.utils.JsonUtil;
import com.note.base.utils.ObjectUtil;
import com.note.base.utils.UUIDGenerator;
import com.note.fiction.dto.request.FictionAddReq;
import com.note.fiction.dto.request.FictionChapterAddReq;
import com.note.fiction.dto.request.FictionSearchReq;
import com.note.fiction.entity.FictionBaseEntity;
import com.note.fiction.proxy.AdminServiceProxy;
import com.note.fiction.service.FictionBaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/23.
 */
@Component("fiction.service.fictionAutoLogic")
public class FictionAutoLogic {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource(name = "fiction.service.adminServiceProxy")
    private AdminServiceProxy adminServiceProxy;

    @Resource(name = "fiction.service.fictionBaseService")
    private FictionBaseService fictionBaseService;

    public boolean parseFiction(String fileName) throws IOException, SQLException {
        FictionBaseEntity fictionBaseEntity = null;
        try {
            FileParseDto fileParseDto = new FileParseDto();
            fileParseDto.setPath("H:/temp/");
            fileParseDto.setFileName(fileName);
            fileParseDto.setEncode(FileParseUtil.judgeTxtCode(fileParseDto.getPath()+fileParseDto.getFileName()));
            logger.info("#########解析小说: " + fileParseDto.toString());

            Map<String, Object> resultMap = FileParseUtil.accessAuto(fileParseDto);
            BaseDto baseDto = (BaseDto) resultMap.get(FileParseUtil.BASE_DTO);
            List<ChapterDto> chapterDtoList = (List<ChapterDto>) resultMap.get(FileParseUtil.CHAPTER_DTO_LIST);
            chapterDtoList.forEach(s -> {
                logger.info("#########章节名称:" + s.getTitle());
            });

            FictionAddReq fictionAddReq = new FictionAddReq();
            fictionAddReq.setLogicCode(UUIDGenerator.uuid());
            fictionAddReq.setTitle(baseDto.getTitle());
            fictionAddReq.setShortDesc(baseDto.getShortDesc());
//            fictionAddReq.setCoverPhoto(baseDto.getPhoto());
//            fictionAddReq.setTypeCode(baseDto.getType());
            fictionAddReq.setCoverPhoto("/resources/image/head/" + fictionAddReq.getLogicCode() + ".jpg");
            fictionAddReq.setTypeCode("5");
            fictionAddReq.setAuthorName(baseDto.getAuthor());
            fictionAddReq.setFullDesc(baseDto.getFullDesc());
            if(ObjectUtil.isNull(fictionAddReq.getFullDesc())){
                fictionAddReq.setFullDesc(fictionAddReq.getShortDesc());
            }
            if(ObjectUtil.isNull(fictionAddReq.getShortDesc())){
                fictionAddReq.setShortDesc(fictionAddReq.getFullDesc());
            }
            if(ObjectUtil.isNull(fictionAddReq.getShortDesc())&&ObjectUtil.isNull(fictionAddReq.getFullDesc())){
                throw new SystemException(String.format("#########解析小说失败,名称:%s,原因:%s", fileName, "没有描述"));
            }


            FictionSearchReq fictionSearchReq = new FictionSearchReq();
            fictionSearchReq.setTitle(baseDto.getTitle());
            int count = fictionBaseService.selectFullCountByCondition(fictionSearchReq);
            if (count > 0) {
                throw new SystemException(String.format("#########解析小说失败,名称:{},原因:{},异常:{}", fictionAddReq.getTitle(), "名称重复", null));
            }
            String fictionResult = adminServiceProxy.createFiction(JsonUtil.toJson(fictionAddReq));
            ResponseDTO responseDTO = JsonUtil.fromJson(fictionResult, ResponseDTO.class);
            fictionBaseEntity = JsonUtil.fromJson(responseDTO.getData("data"), FictionBaseEntity.class);
            for (ChapterDto s : chapterDtoList) {
                FictionChapterAddReq fictionChapterAddReq = new FictionChapterAddReq();
                fictionChapterAddReq.setFictionCode(fictionBaseEntity.getLogicCode());
                fictionChapterAddReq.setChapterSort(s.getIndex());
                fictionChapterAddReq.setChapterName(s.getTitle());
                fictionChapterAddReq.setChapterType(1);// 1 free 2 not free
                fictionChapterAddReq.setChapterContent(s.getContent());
                adminServiceProxy.createFictionChapter(JsonUtil.toJson(fictionChapterAddReq));
            }
            logger.info("#########解析小说成功: " + fictionAddReq.getTitle());
            return true;
        } catch (Exception e) {
            if (ObjectUtil.notNull(fictionBaseEntity)) {
                fictionBaseService.deleteFiction(fictionBaseEntity.getLogicCode());
            }
            logger.error("#########解析小说异常:{} ",e);
            throw new SystemException(String.format("#########解析小说失败,名称:%s,原因:%s", fileName, "名称重复"), e);
        }
    }
}
