package com.jd.consumer.mapper;

import com.jd.consumer.model.InfoUserModel;

public interface InfoUserMapper {
	InfoUserModel findUserByEmail(String email);

	void addUser(InfoUserModel infoUserModel);
}
