package com.note.fictionweb.logic;

import com.google.common.reflect.TypeToken;
import com.note.base.enums.FictionRankTypeEnum;
import com.note.base.utils.JsonUtil;
import com.note.fiction.dto.request.FictionRankSearchReq;
import com.note.fiction.dto.request.FictionSearchReq;
import com.note.fiction.dto.response.FictionRankSearchResp;
import com.note.fiction.dto.response.FictionSearchResp;
import com.note.fiction.proxy.FictionServiceProxy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.sql.SQLException;
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
 * @date 2017/5/10
 * @since 1.0
 */
@Component("web.logic.fictionLogic")
public class FictionLogic {

    @Resource(name="fiction.service.fictionServiceProxy")
    private FictionServiceProxy fictionServiceProxy;

    /**
     * 时间排序
     * @param type
     * @return
     * @throws IOException
     * @throws SQLException
     */
    public List<FictionSearchResp> findTimeFullList(String type) throws IOException, SQLException {
        FictionSearchReq fictionSearchReq = new FictionSearchReq();
        fictionSearchReq.setOrderBy("create_time");
        fictionSearchReq.setOrderByType("desc");
        fictionSearchReq.setSize(12);
        fictionSearchReq.setTypeCode(type);
        String fullJson = fictionServiceProxy.findFull(JsonUtil.toJson(fictionSearchReq));
        HashMap<String,Object> resultMap= JsonUtil.fromJson(fullJson,new TypeToken<HashMap<String,Object>>(){}.getType());
        List<FictionSearchResp> fullList = (List<FictionSearchResp>) resultMap.get("list");
        return fullList;
    }

    /**
     * 浏览量排序
     * @param type
     * @return
     * @throws IOException
     * @throws SQLException
     */
    public List<FictionSearchResp> findScoreFullList(String type) throws IOException, SQLException {
        FictionSearchReq fictionSearchReq = new FictionSearchReq();
        fictionSearchReq.setOrderBy("fiction_views");
        fictionSearchReq.setOrderByType("desc");
        fictionSearchReq.setSize(12);
        fictionSearchReq.setTypeCode(type);
        String fullJson = fictionServiceProxy.findFull(JsonUtil.toJson(fictionSearchReq));
        HashMap<String,Object> resultMap= JsonUtil.fromJson(fullJson,new TypeToken<HashMap<String,Object>>(){}.getType());
        List<FictionSearchResp> fullList = (List<FictionSearchResp>) resultMap.get("list");
        return fullList;
    }

    /**
     *查询
     * @param type
     * @return
     * @throws IOException
     * @throws SQLException
     */
    public HashMap<String, Object> findListByCondition(String type,String searchContent,Integer page,Integer size) throws IOException, SQLException {
        FictionSearchReq fictionSearchReq = new FictionSearchReq();
        fictionSearchReq.setTitle(searchContent);
        fictionSearchReq.setPage(page);
        fictionSearchReq.setSize(size);
        fictionSearchReq.setTypeCode(type);
        fictionSearchReq.setOrderBy("fiction_views");
        fictionSearchReq.setOrderByType("desc");
        String json = fictionServiceProxy.findFull(JsonUtil.toJson(fictionSearchReq));
        HashMap<String, Object> resultMap = JsonUtil.fromJson(json, new TypeToken<HashMap<String, Object>>() {
        }.getType());
        return resultMap;
    }

    /**
     * 浏览排序
     * @return
     */
    public List<FictionRankSearchResp> findRankViewList() throws IOException, SQLException {
        FictionRankSearchReq fictionRankSearchReq = new FictionRankSearchReq();
        fictionRankSearchReq.setRankType(FictionRankTypeEnum.VIEW.getType());
        fictionRankSearchReq.setSize(10);
        String viewsJson = fictionServiceProxy.findRankList(JsonUtil.toJson(fictionRankSearchReq));
        List<FictionRankSearchResp> viewsList = JsonUtil.fromJson(viewsJson, new TypeToken<List<FictionRankSearchResp>>() {
        }.getType());
        return viewsList;
    }

    /**
     * 分数排序
     * @return
     */
    public List<FictionRankSearchResp> findRankScoreList() throws IOException, SQLException {
        FictionRankSearchReq fictionRankSearchReq2 = new FictionRankSearchReq();
        fictionRankSearchReq2.setRankType(FictionRankTypeEnum.SCORE.getType());
        fictionRankSearchReq2.setSize(10);
        String scoreJson = fictionServiceProxy.findRankList(JsonUtil.toJson(fictionRankSearchReq2));
        List<FictionRankSearchResp> scoreList = JsonUtil.fromJson(scoreJson, new TypeToken<List<FictionRankSearchResp>>() {
        }.getType());
        return scoreList;
    }


}
