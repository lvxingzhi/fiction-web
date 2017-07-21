package com.note.base.utils;

import com.note.base.dto.file.BaseDto;
import com.note.base.dto.file.ChapterDto;
import com.note.base.dto.file.FileParseDto;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>解析文件 </p>
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
public class FileParseUtil {

    public static final String BASE_DTO = "baseDto";
    public static final String CHAPTER_DTO_LIST = "chapterDtoList";

    /**
     * 解析chapter列表
     *
     * @param fileParseDto
     * @return
     * @throws IOException
     */
    public static List<ChapterDto> parse(FileParseDto fileParseDto) throws IOException {
        List<ChapterDto> chapterDtoList = new ArrayList<>();
        Path path = Paths.get(fileParseDto.getPath(), fileParseDto.getFileName());
//        Path path = FileSystems.getDefault().getPath("D:/", "abc.txt");
        BufferedReader reader = Files.newBufferedReader(path, Charset.forName(fileParseDto.getEncode()));
        System.out.println();
        String str = null;
        String title = "";
        int index = 1;
        ChapterDto chapterDto = null;
        boolean begain = false;
        while ((str = reader.readLine()) != null) {
            System.out.println(str);
            if (str.contains(fileParseDto.getHeadTag())) {
                begain = true;
            }
            if (begain && str.contains(fileParseDto.getHeadTag())) {
                chapterDto = new ChapterDto();
                title = str.replaceAll(fileParseDto.getHeadTag(), "");
                chapterDto.setTitle(title);
                chapterDto.setIndex(index);
                chapterDtoList.add(chapterDto);
                index += 1;
            } else if (begain) {
                chapterDto.setContent(ObjectUtil.dualStringNull(chapterDto.getContent()) + "\n" + str);
            }
        }

        // 统计字数
        chapterDtoList.forEach((ChapterDto t) ->
                t.setTotal(ObjectUtil.notNull(t.getContent()) ? t.getContent().length() : 0)
        );
        return chapterDtoList;
    }

    /**
     * 解析基本信息
     * <p>
     * <title><title/>
     * <author></author>
     * <shortDesc></shortDesc>
     * <type></type>
     * <photo></photo>
     * @return
     */
    public static BaseDto parseBase(List<String> list) throws IOException {
        BaseDto baseDto = new BaseDto();
        for (String s : list) {
            if (s.contains("<title>")) {
                String title = s.substring(s.indexOf("<title>") + 7, s.indexOf("</title>"));
                baseDto.setTitle(title);
            }
            if (s.contains("<author>")) {
                String author = s.substring(s.indexOf("<author>") + 8, s.indexOf("</author>"));
                baseDto.setAuthor(author);
            }
            if (s.contains("<shortDesc>")) {
                String shortDesc = s.substring(s.indexOf("<shortDesc>") + 12, s.indexOf("</shortDesc>"));
                baseDto.setShortDesc(shortDesc);
            }
            if (s.contains("<fullDesc>")) {
                String fullDesc = s.substring(s.indexOf("<fullDesc>") + 12, s.indexOf("</fullDesc>"));
                baseDto.setShortDesc(fullDesc);
            }
            if (s.contains("<type>")) {
                String type = s.substring(s.indexOf("<type>") + 6, s.indexOf("</type>"));
                baseDto.setType(type);
            }
            if (s.contains("<photo>")) {
                String photo = s.substring(s.indexOf("<photo>") + 7, s.indexOf("</photo>"));
                baseDto.setPhoto(photo);
            }
        }
        return baseDto;
    }

    public static Map<String,Object> access(FileParseDto fileParseDto) throws IOException {
        Path path = Paths.get(fileParseDto.getPath(), fileParseDto.getFileName()); //获取文件对象
        List<String> list = Files.readAllLines(path, Charset.forName(fileParseDto.getEncode()));
        Map<String,Object> resultMap = new HashMap<>();
        BaseDto baseDto = FileParseUtil.parseBase(list);
        List<ChapterDto> chapterDtoList = FileParseUtil.parseChapters(list);
        resultMap.put(BASE_DTO,baseDto);
        resultMap.put(CHAPTER_DTO_LIST,chapterDtoList);
        return resultMap;
    }

    /**
     * 根据xml格式解析章节
     *
     * <chapterTitle></chapterTitle>
     * <chapterContent></chapterContent>
     * @return
     * @throws IOException
     */
    public static List<ChapterDto> parseChapters(List<String> list) throws IOException {
        List<ChapterDto> chapterDtoList = new ArrayList<>();
        ChapterDto chapterDto = null;
        for (int i=0;i<list.size();i++) {
            String s = list.get(i);
            if (s.contains("<chapterTitle>")) {
                chapterDto = new ChapterDto();
                chapterDtoList.add(chapterDto);
                String chapterTitle = s.substring(s.indexOf("<chapterTitle>") + 14, s.indexOf("</chapterTitle>"));
                chapterDto.setTitle(chapterTitle);
            }

            if (s.contains("<chapterContent>")) {
                String chapterContent = "";
                if(s.contains("</chapterContent>")){
                    chapterContent = s.substring(s.indexOf("<chapterContent>") + 16, s.indexOf("</chapterContent>"));
                }else{
                    chapterContent = s.substring(s.indexOf("<chapterContent>") + 16);
                    for(i+=1;i<list.size();i++){
                        s = list.get(i);
                        if(s.contains("</chapterContent>")){
                            chapterContent+=s.substring(0, s.indexOf("</chapterContent>"));
                            break;
                        }else{
                            chapterContent+=s;
                        }
                    }
                }
                chapterDto.setContent(chapterContent);
                chapterDto.setTotal(chapterContent.length());
                chapterDto.setIndex(chapterDtoList.size());
            }

        }
        return chapterDtoList;
    }



    public static Map<String,Object> accessAuto(FileParseDto fileParseDto) throws IOException {
        Path path = Paths.get(fileParseDto.getPath(), fileParseDto.getFileName()); //获取文件对象
        List<String> list = Files.readAllLines(path, Charset.forName(fileParseDto.getEncode()));
        Map<String,Object> resultMap = new HashMap<>();
        BaseDto baseDto = FileParseUtil.parseBase(list);
        List<ChapterDto> chapterDtoList = FileParseUtil.autoParseChapters(list);
        resultMap.put(BASE_DTO,baseDto);
        resultMap.put(CHAPTER_DTO_LIST,chapterDtoList);
        return resultMap;
    }

    /**
     * 自动解析文章章节
     *
     * @return
     */
    public static List<ChapterDto> autoParseChapters(List<String> list){
        List<ChapterDto> chapterDtoList = new ArrayList<>();
        ChapterDto chapterDto = null;
        for (int i=0;i<list.size();i++) {
            String s = list.get(i);
            if (isCountMatchChapterTitle(s)&&isMatchChapterTitle(s)) {
                chapterDto = new ChapterDto();
                chapterDtoList.add(chapterDto);
                String chapterTitle = s.trim();
                chapterDto.setTitle(chapterTitle);
                String chapterContent = "";
                for(i+=1;i<list.size();i++){
                    String sChild = list.get(i);
                    if (!isCountMatchChapterTitle(sChild)||!isMatchChapterTitle(sChild)) {
                        chapterContent += sChild;
                    }else{
                        i--;
                        break;
                    }
                }
                chapterDto.setContent(chapterContent);
                chapterDto.setTotal(chapterContent.length());
                chapterDto.setIndex(chapterDtoList.size());

            }



        }
        return chapterDtoList;
    }

    public static boolean isMatchChapterTitle(String s){
        String content = s.trim();
        if(content.matches("^第{1,6}章.*$")){
            return true;
        }
        if(content.matches("^第{1,6}节.*$")){
            return true;
        }
        if(content.matches("^☆.*")){
            return true;
        }
        return false;
    }

    public static boolean isCountMatchChapterTitle(String content){
        if(content.trim().length()<30){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b = "第一百零三章".matches("^第.*章$");
        System.out.println( b);
    }

}
