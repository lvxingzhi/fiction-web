package com.note.base.dto;

import com.note.base.utils.ObjectUtil;

/**
 * 分页实体
 */
public class PageDto {

    public static final int MIN = 1;
    public static final int MAX = 100000000;

    public static final int DEFAULT_SIZE=50;

    private int page = MIN;
    private int size = DEFAULT_SIZE;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        if( ObjectUtil.isNull(size)||size<0||size>MAX){
            size = DEFAULT_SIZE;
        }
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        if( ObjectUtil.isNull(page)||page<0||page>MAX){
            page = MIN;
        }
        this.page = page;
    }

    public int getOffset() {
        if(MIN == page){
            return 0;
        }else{
            return (page-1)*size;
        }

    }

    public int getLimit() {
        return size;
    }

}
