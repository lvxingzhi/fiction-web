package com.note.base.dto.file;

/**
 * <p>标题 </p>
 * <p>
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 *
 * @author lvxz5
 * @version 1.0
 * @date 2017/5/17
 * @since 1.0
 */
public class BaseDto {

    private String title;
    private String author;
    private String shortDesc;
    private String type;
    private String photo;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "BaseDto{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", shortDesc='" + shortDesc + '\'' +
                ", type='" + type + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
