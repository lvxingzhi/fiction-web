package com.note.fiction.service;

import com.note.fiction.dao.FictionExtentionDao;
import com.note.fiction.entity.FictionExtentionEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/5/7.
 */
@Service("fiction.service.fictionExtentionService")
public class FictionExtentionService {

    @Resource(name = "fiction.service.fictionExtentionDao")
    private FictionExtentionDao fictionExtentionDao;

    public FictionExtentionEntity findByFictionCode(String fictionCode){
        return fictionExtentionDao.findByFictionCode(fictionCode);
    }

    public int updateStatistics(FictionExtentionEntity entity){
        return fictionExtentionDao.updateStatistics(entity);
    }

}
