package com.DZQ.memory.bean;
//实体类
/*
*
* 此类为一个实体类，用于链接数据库，实现数据的操作
* */
public class MemoryBean {
    private  String id;//记录的编号
    private  String memoryContent;//记录的内容
    private  String saveTime;//记录保存时间
//alt+insert快捷键
    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getMemoryContent() {

        return memoryContent;
    }

    public void setMemoryContent(String memoryContent) {

        this.memoryContent = memoryContent;
    }

    public String getSaveTime() {

        return saveTime;
    }

    public void setSaveTime(String saveTime) {

        this.saveTime = saveTime;
    }
}
