package com.jd.provider.mapper;

import com.jd.api.model.InfoModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InfoMapper {
	InfoModel findInfoById(int id);

	List<InfoModel> getInfosByName(@Param("name") String name);
}
