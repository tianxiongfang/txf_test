package com.jd.api.service;

import com.jd.api.model.BlogVO;

import java.util.List;

/**
 * Created by Administrator on 2018/11/12.
 */
public interface BlogService {
    List<BlogVO> getBlog();

    List<BlogVO> getBlogNew();
}
