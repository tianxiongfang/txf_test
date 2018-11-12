package com.jd.consumer.model;

import java.util.Date;

public class Blog {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog.id
     *
     * @mbggenerated Mon Nov 12 14:43:08 CST 2018
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog.title
     *
     * @mbggenerated Mon Nov 12 14:43:08 CST 2018
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog.content
     *
     * @mbggenerated Mon Nov 12 14:43:08 CST 2018
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog.file_id
     *
     * @mbggenerated Mon Nov 12 14:43:08 CST 2018
     */
    private Integer fileId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog.creator
     *
     * @mbggenerated Mon Nov 12 14:43:08 CST 2018
     */
    private Integer creator;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog.create_time
     *
     * @mbggenerated Mon Nov 12 14:43:08 CST 2018
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog.sort
     *
     * @mbggenerated Mon Nov 12 14:43:08 CST 2018
     */
    private Integer sort;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog.is_recommend
     *
     * @mbggenerated Mon Nov 12 14:43:08 CST 2018
     */
    private Integer isRecommend;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog.quantity
     *
     * @mbggenerated Mon Nov 12 14:43:08 CST 2018
     */
    private Integer quantity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog.is_stick
     *
     * @mbggenerated Mon Nov 12 14:43:08 CST 2018
     */
    private Integer isStick;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog.tag_id
     *
     * @mbggenerated Mon Nov 12 14:43:08 CST 2018
     */
    private Integer tagId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog.state
     *
     * @mbggenerated Mon Nov 12 14:43:08 CST 2018
     */
    private Integer state;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog.id
     *
     * @return the value of blog.id
     *
     * @mbggenerated Mon Nov 12 14:43:08 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog.id
     *
     * @param id the value for blog.id
     *
     * @mbggenerated Mon Nov 12 14:43:08 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog.title
     *
     * @return the value of blog.title
     *
     * @mbggenerated Mon Nov 12 14:43:08 CST 2018
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog.title
     *
     * @param title the value for blog.title
     *
     * @mbggenerated Mon Nov 12 14:43:08 CST 2018
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog.content
     *
     * @return the value of blog.content
     *
     * @mbggenerated Mon Nov 12 14:43:08 CST 2018
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog.content
     *
     * @param content the value for blog.content
     *
     * @mbggenerated Mon Nov 12 14:43:08 CST 2018
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog.file_id
     *
     * @return the value of blog.file_id
     *
     * @mbggenerated Mon Nov 12 14:43:08 CST 2018
     */
    public Integer getFileId() {
        return fileId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog.file_id
     *
     * @param fileId the value for blog.file_id
     *
     * @mbggenerated Mon Nov 12 14:43:08 CST 2018
     */
    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog.creator
     *
     * @return the value of blog.creator
     *
     * @mbggenerated Mon Nov 12 14:43:08 CST 2018
     */
    public Integer getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog.creator
     *
     * @param creator the value for blog.creator
     *
     * @mbggenerated Mon Nov 12 14:43:08 CST 2018
     */
    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog.create_time
     *
     * @return the value of blog.create_time
     *
     * @mbggenerated Mon Nov 12 14:43:08 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog.create_time
     *
     * @param createTime the value for blog.create_time
     *
     * @mbggenerated Mon Nov 12 14:43:08 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog.sort
     *
     * @return the value of blog.sort
     *
     * @mbggenerated Mon Nov 12 14:43:08 CST 2018
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog.sort
     *
     * @param sort the value for blog.sort
     *
     * @mbggenerated Mon Nov 12 14:43:08 CST 2018
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog.is_recommend
     *
     * @return the value of blog.is_recommend
     *
     * @mbggenerated Mon Nov 12 14:43:08 CST 2018
     */
    public Integer getIsRecommend() {
        return isRecommend;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog.is_recommend
     *
     * @param isRecommend the value for blog.is_recommend
     *
     * @mbggenerated Mon Nov 12 14:43:08 CST 2018
     */
    public void setIsRecommend(Integer isRecommend) {
        this.isRecommend = isRecommend;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog.quantity
     *
     * @return the value of blog.quantity
     *
     * @mbggenerated Mon Nov 12 14:43:08 CST 2018
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog.quantity
     *
     * @param quantity the value for blog.quantity
     *
     * @mbggenerated Mon Nov 12 14:43:08 CST 2018
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog.is_stick
     *
     * @return the value of blog.is_stick
     *
     * @mbggenerated Mon Nov 12 14:43:08 CST 2018
     */
    public Integer getIsStick() {
        return isStick;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog.is_stick
     *
     * @param isStick the value for blog.is_stick
     *
     * @mbggenerated Mon Nov 12 14:43:08 CST 2018
     */
    public void setIsStick(Integer isStick) {
        this.isStick = isStick;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog.tag_id
     *
     * @return the value of blog.tag_id
     *
     * @mbggenerated Mon Nov 12 14:43:08 CST 2018
     */
    public Integer getTagId() {
        return tagId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog.tag_id
     *
     * @param tagId the value for blog.tag_id
     *
     * @mbggenerated Mon Nov 12 14:43:08 CST 2018
     */
    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog.state
     *
     * @return the value of blog.state
     *
     * @mbggenerated Mon Nov 12 14:43:08 CST 2018
     */
    public Integer getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog.state
     *
     * @param state the value for blog.state
     *
     * @mbggenerated Mon Nov 12 14:43:08 CST 2018
     */
    public void setState(Integer state) {
        this.state = state;
    }
}