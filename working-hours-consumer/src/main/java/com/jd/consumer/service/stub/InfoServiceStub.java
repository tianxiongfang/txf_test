package com.jd.consumer.service.stub;

import com.jd.api.model.InfoModel;
import com.jd.api.service.IInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 本地存根类
 */
@Service
public class InfoServiceStub implements IInfoService {
	/*
	dubbo提供者暴露的服务
	 */
	@Autowired
	private IInfoService infoService;


	@Override
	public InfoModel findInfoById(int id) {
		return infoService.findInfoById(id);
	}

	@Override
	public List<InfoModel> findInfosByName(String name) {
		return infoService.findInfosByName(name);
	}
}
