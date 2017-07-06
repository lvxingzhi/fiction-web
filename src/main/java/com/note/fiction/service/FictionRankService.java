package com.note.fiction.service;

import com.note.fiction.dao.FictionRankDao;
import com.note.fiction.dto.request.FictionRankSearchReq;
import com.note.fiction.dto.response.FictionRankSearchResp;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * <p>TODO </p>
 * <p>
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 *
 * @author lvxz5
 * @version 1.0
 * @date 2017/2/28
 * @since 1.0
 */
@Service("fiction.service.fictionRankService")
public class FictionRankService {

    @Resource(name = "fiction.service.fictionRankDao")
    private FictionRankDao fictionRankDao;

    public List<FictionRankSearchResp> searchByCondition(FictionRankSearchReq fictionRankSearchReq){
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("searchContent",fictionRankSearchReq);
        RowBounds rowBounds = new RowBounds(fictionRankSearchReq.getOffset(),fictionRankSearchReq.getLimit());
        return fictionRankDao.selectByCondition(map,rowBounds);
    }

}
