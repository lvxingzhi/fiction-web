package com.note.fiction.proxy;

import com.note.base.dto.ResponseDTO;
import com.note.base.enums.DeleteEnum;
import com.note.base.enums.FictionStatusEnum;
import com.note.base.enums.FictionTypeEnum;
import com.note.base.utils.JsonUtil;
import com.note.base.utils.ObjectUtil;
import com.note.base.utils.UUIDGenerator;
import com.note.fiction.dto.request.FictionAddReq;
import com.note.fiction.dto.request.FictionChapterAddReq;
import com.note.fiction.entity.*;
import com.note.fiction.service.FictionBaseService;
import com.note.fiction.service.FictionChapterService;
import com.note.fiction.service.FictionExtentionService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 管理
 */
@Component("fiction.service.adminServiceProxy")
public class AdminServiceProxy {

    @Resource(name = "fiction.service.fictionBaseService")
    private FictionBaseService fictionBaseService;

    @Resource(name = "fiction.service.fictionExtentionService")
    private FictionExtentionService fictionExtentionService;

    @Resource(name = "fiction.service.fictionChapterService")
    private FictionChapterService fictionChapterService;


    public String createFiction(String json) {
        FictionAddReq fictionAddReq = JsonUtil.fromJson(json, FictionAddReq.class);
        FictionBaseEntity fictionBaseEntity = transFictionBaseEntity(fictionAddReq);
        FictionExtentionEntity fictionExtentionEntity = transFictionExtentionEntity(fictionBaseEntity,fictionAddReq);
        FictionRankEntity fictionRankEntity = transFictionRankEntity(fictionBaseEntity);
        fictionBaseService.createFiction(fictionBaseEntity,fictionExtentionEntity,fictionRankEntity);
        ResponseDTO responseDTO = ResponseDTO.getSuccessInstance();
        responseDTO.addData(ResponseDTO.DATA,fictionBaseEntity);
        return responseDTO.toString();
    }

    public String createFictionChapter(String json) {
        FictionChapterAddReq fictionChapterAddReq = JsonUtil.fromJson(json, FictionChapterAddReq.class);
        FictionChapterEntity fictionChapterEntity = transFictionChapterEntity(fictionChapterAddReq);
        FictionChapterExtentionEntity fictionChapterExtentionEntity = transFictionChapterExtentionEntity(fictionChapterEntity,fictionChapterAddReq);
        FictionExtentionEntity fictionExtentionEntity = transUpdateFictionExtentionEntity(fictionChapterEntity,fictionChapterAddReq);

        FictionChapterEntity searchChapterRequest = new FictionChapterEntity();
        searchChapterRequest.setFictionCode(fictionChapterAddReq.getFictionCode());
        searchChapterRequest.setChapterSort(fictionChapterAddReq.getChapterSort());
        List<FictionChapterEntity> existsEntity = fictionChapterService.findByCondition(searchChapterRequest);
        if(ObjectUtil.notNull(existsEntity)){
            return "1";
        }
        searchChapterRequest.setChapterSort(fictionChapterAddReq.getChapterSort()-1);
        List<FictionChapterEntity> preEntityList = fictionChapterService.findByCondition(searchChapterRequest);
        searchChapterRequest.setChapterSort(fictionChapterAddReq.getChapterSort()+1);
        List<FictionChapterEntity> nextEntityList = fictionChapterService.findByCondition(searchChapterRequest);
        if(ObjectUtil.notNull(preEntityList)){
            fictionChapterExtentionEntity.setPreviousCode(preEntityList.get(0).getLogicCode());

        }
        if(ObjectUtil.notNull(nextEntityList)){
            fictionChapterExtentionEntity.setNextCode(nextEntityList.get(0).getLogicCode());
        }

        fictionBaseService.createFictionChapter(fictionChapterEntity,fictionChapterExtentionEntity,fictionExtentionEntity,preEntityList,nextEntityList);
        return "0";
    }

    private FictionBaseEntity transFictionBaseEntity(FictionAddReq fictionAddReq) {
        FictionBaseEntity fictionBaseEntity = new FictionBaseEntity();
        fictionBaseEntity.setLogicCode(UUIDGenerator.uuid());
        fictionBaseEntity.setTitle(fictionAddReq.getTitle());
        fictionBaseEntity.setShortDesc(fictionAddReq.getShortDesc());
        fictionBaseEntity.setCoverPhoto(fictionAddReq.getCoverPhoto());
        fictionBaseEntity.setTypeCode(fictionAddReq.getTypeCode());
        fictionBaseEntity.setTypeName(FictionTypeEnum.getByType(fictionAddReq.getTypeCode()).getDesc());
        fictionBaseEntity.setAuthorName(fictionAddReq.getAuthorName());
        fictionBaseEntity.setFictionStatus(FictionStatusEnum.ING.getType());
        fictionBaseEntity.setCreateTime(new Date());
        fictionBaseEntity.setModifyTime(fictionBaseEntity.getCreateTime());
        fictionBaseEntity.setCreateUserCode("admin");
        fictionBaseEntity.setModifyUserCode("admin");
        fictionBaseEntity.setIsDelete(DeleteEnum.NOT_DELETE.getType());
        return fictionBaseEntity;
    }

    private FictionExtentionEntity transFictionExtentionEntity(FictionBaseEntity fictionBaseEntity,FictionAddReq fictionAddReq) {
        FictionExtentionEntity fictionExtentionEntity = new FictionExtentionEntity();
        fictionExtentionEntity.setLogicCode(UUIDGenerator.uuid());
        fictionExtentionEntity.setFictionCode(fictionBaseEntity.getLogicCode());
        fictionExtentionEntity.setFictionScore(900D);
        fictionExtentionEntity.setFictionScoreNum(100);
        fictionExtentionEntity.setFullDesc(fictionAddReq.getFullDesc());
        fictionExtentionEntity.setTotalChapter(0);
        fictionExtentionEntity.setTotalWord(0);
        fictionExtentionEntity.setLastUpdateTime(new Date());
        fictionExtentionEntity.setLevel(1);
        fictionExtentionEntity.setFictionViews(0);
        fictionExtentionEntity.setCreateTime(new Date());
        fictionExtentionEntity.setModifyTime(fictionExtentionEntity.getCreateTime());
        fictionExtentionEntity.setCreateUserCode("admin");
        fictionExtentionEntity.setModifyUserCode("admin");
        fictionExtentionEntity.setIsDelete(DeleteEnum.NOT_DELETE.getType());
        return fictionExtentionEntity;
    }

    private FictionRankEntity transFictionRankEntity(FictionBaseEntity fictionBaseEntity) {
        FictionRankEntity fictionRankEntity = new FictionRankEntity();
        fictionRankEntity.setLogicCode(UUIDGenerator.uuid());
        fictionRankEntity.setFictionCode(fictionBaseEntity.getLogicCode());
        fictionRankEntity.setFictionName(fictionBaseEntity.getTitle());
        fictionRankEntity.setFictionScore(10);
        fictionRankEntity.setFictionViews(0);
        fictionRankEntity.setIsDelete(DeleteEnum.NOT_DELETE.getType());
        fictionRankEntity.setCreateTime(new Date());
        fictionRankEntity.setModifyTime(fictionRankEntity.getCreateTime());
        fictionRankEntity.setCreateUserCode("admin");
        fictionRankEntity.setModifyUserCode("admin");
        return fictionRankEntity;
    }

    private FictionChapterEntity transFictionChapterEntity(FictionChapterAddReq fictionChapterAddReq){
        FictionChapterEntity fictionChapterEntity = new FictionChapterEntity();
        fictionChapterEntity.setLogicCode(UUIDGenerator.uuid());
        fictionChapterEntity.setFictionCode(fictionChapterAddReq.getFictionCode());
        fictionChapterEntity.setChapterSort(fictionChapterAddReq.getChapterSort());
        fictionChapterEntity.setChapterName(fictionChapterAddReq.getChapterName());
        fictionChapterEntity.setChapterType(fictionChapterAddReq.getChapterType());
        fictionChapterEntity.setChapterViews(0);
        fictionChapterEntity.setChapterWordCount(fictionChapterAddReq.getChapterContent().length());
        fictionChapterEntity.setCreateTime(new Date());
        fictionChapterEntity.setModifyTime(fictionChapterEntity.getCreateTime());
        fictionChapterEntity.setCreateUserCode("admin");
        fictionChapterEntity.setModifyUserCode("admin");
        fictionChapterEntity.setIsDelete(DeleteEnum.NOT_DELETE.getType());
        return fictionChapterEntity;
    }

    private FictionChapterExtentionEntity transFictionChapterExtentionEntity(FictionChapterEntity fictionChapterEntity,FictionChapterAddReq fictionChapterAddReq){
        FictionChapterExtentionEntity fictionChapterExtentionEntity = new FictionChapterExtentionEntity();
        fictionChapterExtentionEntity.setLogicCode(UUIDGenerator.uuid());
        fictionChapterExtentionEntity.setChapterCode(fictionChapterEntity.getLogicCode());
        fictionChapterExtentionEntity.setCreateTime(new Date());
        fictionChapterExtentionEntity.setModifyTime(fictionChapterExtentionEntity.getCreateTime());
        fictionChapterExtentionEntity.setCreateUserCode("admin");
        fictionChapterExtentionEntity.setModifyUserCode("admin");
        fictionChapterExtentionEntity.setIsDelete(DeleteEnum.NOT_DELETE.getType());
        fictionChapterExtentionEntity.setChapterContent(fictionChapterAddReq.getChapterContent());
        return fictionChapterExtentionEntity;
    }

    private FictionExtentionEntity transUpdateFictionExtentionEntity(FictionChapterEntity fictionChapterEntity,FictionChapterAddReq fictionChapterAddReq){
        FictionExtentionEntity fictionExtentionEntity = fictionExtentionService.findByFictionCode(fictionChapterEntity.getFictionCode());
        fictionExtentionEntity.setLastChapterCode(fictionChapterEntity.getLogicCode());
        fictionExtentionEntity.setLastChapterName(fictionChapterEntity.getChapterName());
        fictionExtentionEntity.setLastUpdateTime(new Date());
        fictionExtentionEntity.setTotalChapter(fictionExtentionEntity.getTotalChapter()+1);
        fictionExtentionEntity.setTotalWord(fictionExtentionEntity.getTotalWord()+fictionChapterAddReq.getChapterContent().length());
        return fictionExtentionEntity;
    }


}
