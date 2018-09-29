package com.jd.provider.service.export;

import com.jd.api.model.InfoModel;
import com.jd.api.service.IInfoService;
import com.jd.provider.mapper.InfoMapper;
import com.jd.provider.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class InfoService implements IInfoService {
	@Autowired
	private InfoMapper infoMapper;
	@Autowired
	private RedisService redisService;

	/**
	 * 从mysql查询info信息，并缓存在redis
	 *
	 * @param id
	 * @return
	 */
	public InfoModel findInfoById(int id) {
		InfoModel infoModel = redisService.getObject("info:id:" + id, InfoModel.class);
		if (infoModel == null) {
			infoModel = infoMapper.findInfoById(id);
			redisService.setObject("info:id:" + id, infoModel, 3600, TimeUnit.SECONDS);
			infoModel.setFrom("mysql");
			return infoModel;
		} else {
			infoModel.setFrom("redis");
			return infoModel;
		}
	}

	public List<InfoModel> findInfosByName(String name) {
		List<InfoModel> infoModels = infoMapper.getInfosByName(name);
		return infoModels;
	}
}
