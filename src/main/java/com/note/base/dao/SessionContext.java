package com.note.base.dao;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * <p>数据库访问容器 </p>
 * <p>
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 *
 * @author lvxz5
 * @version 1.0
 * @date 2017/3/13
 * @since 1.0
 */
public class SessionContext extends SqlSessionDaoSupport {

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public <E> List<E> selectList(String name, RowBounds rowBounds){
        return this.getSqlSession().selectList(name,rowBounds);
    }

    public <E> List<E> selectList(String name, Object object, RowBounds rowBounds){
        return this.getSqlSession().selectList(name,object,rowBounds);
    }

    public <E> E selectOne(String name){
        return this.getSqlSession().selectOne(name);
    }

    public <E> E selectOne(String name,Object object){
        return this.getSqlSession().selectOne(name,object);
    }

    public <E> int insert(String name,E E){
        return this.getSqlSession().insert(name,E);
    }

    public <E> int update(String name,E E){
        return this.getSqlSession().update(name,E);
    }


}
