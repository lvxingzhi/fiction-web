package com.note.base.dto.file;

/**
 * <p>文件解析预处理对象 </p>
 * <p>
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 *
 * @author lvxz5
 * @version 1.0
 * @date 2017/3/20
 * @since 1.0
 */
public class FileParseDto {

    private String path; //路径
    private String fileName; //文件名
    private String headTag; // 断章头标识
    private String footTag; // 断章尾标识
    private String encode;// 文件编码格式

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getHeadTag() {
        return headTag;
    }

    public void setHeadTag(String headTag) {
        this.headTag = headTag;
    }

    public String getFootTag() {
        return footTag;
    }

    public void setFootTag(String footTag) {
        this.footTag = footTag;
    }

    public String getEncode() {
        return encode;
    }

    public void setEncode(String encode) {
        this.encode = encode;
    }

    @Override
    public String toString() {
        return "FileParseDto{" +
                "path='" + path + '\'' +
                ", fileName='" + fileName + '\'' +
                ", headTag='" + headTag + '\'' +
                ", footTag='" + footTag + '\'' +
                ", encode='" + encode + '\'' +
                '}';
    }
}
