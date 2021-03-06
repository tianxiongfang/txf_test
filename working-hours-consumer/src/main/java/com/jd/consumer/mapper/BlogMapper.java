package com.jd.consumer.mapper;

import com.jd.api.model.BlogVO;
import com.jd.consumer.model.Blog;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlogMapper {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbggenerated Mon Nov 12 14:43:08 CST 2018
     */
    int insert(Blog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbggenerated Mon Nov 12 14:43:08 CST 2018
     */
    int insertSelective(Blog record);

    List<BlogVO> getBlog();

    List<BlogVO> getBlogNew();
}