package com.jd.consumer.service;

import com.jd.api.model.BlogVO;
import com.jd.api.service.BlogService;
import com.jd.consumer.mapper.BlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Administrator on 2018/11/12.
 */
@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    private BlogMapper blogMapper;
    @Override
    public List<BlogVO> getBlog() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        List<BlogVO> list=blogMapper.getBlog();
        for(BlogVO blogVO:list){
            blogVO.setTime(sdf.format(blogVO.getCreateTime()));
        }
        return list;
    }

    @Override
    public List<BlogVO> getBlogNew() {
        return blogMapper.getBlogNew();
    }
}
