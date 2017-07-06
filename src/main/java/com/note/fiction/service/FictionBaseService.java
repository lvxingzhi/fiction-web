package com.note.fiction.service;

import com.note.base.dto.PageDto;
import com.note.base.utils.ObjectUtil;
import com.note.fiction.dao.*;
import com.note.fiction.dto.request.FictionFindOneReq;
import com.note.fiction.dto.request.FictionSearchReq;
import com.note.fiction.dto.response.FictionFindOneResp;
import com.note.fiction.dto.response.FictionSearchResp;
import com.note.fiction.entity.*;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2017/2/12.
 */
@Service("fiction.service.fictionBaseService")
public class FictionBaseService {

    @Resource(name = "fiction.service.fictionBaseDao")
    private FictionBaseDao fictionBaseDao;

    @Resource(name = "fiction.service.fictionRankDao")
    private FictionRankDao fictionRankDao;

    @Resource(name = "fiction.service.fictionExtentionDao")
    private FictionExtentionDao fictionExtentionDao;

    @Resource(name = "fiction.service.fictionChapterDao")
    private FictionChapterDao fictionChapterDao;

    @Resource(name = "fiction.service.fictionChapterExtentionDao")
    private FictionChapterExtentionDao fictionChapterExtentionDao;


    public List<FictionBaseEntity> selectByCondition(String name) throws SQLException {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("name", name);
        RowBounds rowBounds = new RowBounds(new PageDto().getOffset(), new PageDto().getLimit());
        return fictionBaseDao.selectByCondition(map, rowBounds);
    }

    public List<FictionSearchResp> selectFullByCondition(FictionSearchReq fictionSearchReq) throws SQLException {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("searchContent", fictionSearchReq);
        RowBounds rowBounds = new RowBounds(fictionSearchReq.getOffset(), fictionSearchReq.getLimit());
        return fictionBaseDao.selectFullByCondition(map, rowBounds);
    }

    public int selectFullCountByCondition(FictionSearchReq fictionSearchReq) throws SQLException {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("searchContent", fictionSearchReq);
        return  fictionBaseDao.selectFullCountByCondition(map);
    }

    public FictionFindOneResp findOneByCondition(FictionFindOneReq fictionFindOneReq) throws SQLException {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("searchContent", fictionFindOneReq);
        return fictionBaseDao.findOneByCondition(map);
    }

    public int createFiction(FictionBaseEntity fictionBaseEntity, FictionExtentionEntity fictionExtentionEntity, FictionRankEntity fictionRankEntity) {
        fictionBaseDao.add(fictionBaseEntity);
        fictionExtentionDao.add(fictionExtentionEntity);
        fictionRankDao.add(fictionRankEntity);
        return 1;
    }

    public int createFictionChapter(FictionChapterEntity fictionChapterEntity, FictionChapterExtentionEntity fictionChapterExtentionEntity
            , FictionExtentionEntity fictionExtentionEntity, List<FictionChapterEntity> preEntityList, List<FictionChapterEntity> nextEntityList) {
        fictionChapterDao.add(fictionChapterEntity);
        fictionChapterExtentionDao.add(fictionChapterExtentionEntity);
        if(ObjectUtil.notNull(preEntityList)){
            FictionChapterExtentionEntity preChapterExtentionEntity = new FictionChapterExtentionEntity();
            preChapterExtentionEntity.setChapterCode(preEntityList.get(0).getLogicCode());
            preChapterExtentionEntity.setNextCode(fictionChapterEntity.getLogicCode());
            fictionChapterExtentionDao.updatePreAndNext(preChapterExtentionEntity);
        }

        if(ObjectUtil.notNull(nextEntityList)){
            FictionChapterExtentionEntity nextChapterExtentionEntity = new FictionChapterExtentionEntity();
            nextChapterExtentionEntity.setChapterCode(nextEntityList.get(0).getLogicCode());
            nextChapterExtentionEntity.setPreviousCode(fictionChapterEntity.getLogicCode());
            fictionChapterExtentionDao.updatePreAndNext(nextChapterExtentionEntity);
        }

        fictionExtentionDao.updateStatistics(fictionExtentionEntity);
        return 1;
    }

}
