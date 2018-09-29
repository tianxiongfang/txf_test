package com.jd.api.service;

import com.jd.api.model.InfoModel;

import java.util.List;

public interface IInfoService {
	InfoModel findInfoById(int id);

	List<InfoModel> findInfosByName(String name);
}
