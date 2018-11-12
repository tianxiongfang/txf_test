package com.jd.api.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.xml.bind.annotation.XmlElement;
import java.util.Date;

/**
 * Created by Administrator on 2018/11/12.
 */
public class BlogVO{
    private Integer id;

    private String title;


    private String content;


    private Integer fileId;


    private Integer creator;

    private Date createTime;

    private String time;


    private Integer sort;


    private Integer isRecommend;


    private Integer quantity;


    private Integer isStick;


    private Integer tagId;


    private Integer state;

    private String creatorName;


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }


    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }


    public Integer getFileId() {
        return fileId;
    }


    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }


    public Integer getCreator() {
        return creator;
    }


    public void setCreator(Integer creator) {
        this.creator = creator;
    }


    public Date getCreateTime() {
        return createTime;
    }


    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public Integer getSort() {
        return sort;
    }


    public void setSort(Integer sort) {
        this.sort = sort;
    }


    public Integer getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Integer isRecommend) {
        this.isRecommend = isRecommend;
    }


    public Integer getQuantity() {
        return quantity;
    }


    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getIsStick() {
        return isStick;
    }


    public void setIsStick(Integer isStick) {
        this.isStick = isStick;
    }


    public Integer getTagId() {
        return tagId;
    }


    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }


    public Integer getState() {
        return state;
    }


    public void setState(Integer state) {
        this.state = state;
    }


    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
