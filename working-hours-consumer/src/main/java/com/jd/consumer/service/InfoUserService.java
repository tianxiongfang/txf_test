package com.jd.consumer.service;

import com.jd.consumer.mapper.InfoUserMapper;
import com.jd.consumer.model.InfoUserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoUserService {
	@Autowired
	private InfoUserMapper infoUserMapper;


	public void addUser(InfoUserModel infoUserModel) {
		infoUserMapper.addUser(infoUserModel);
	}

	public InfoUserModel findUserByEmail(String email) {
		return infoUserMapper.findUserByEmail(email);
	}

	public int doLogin(InfoUserModel infoUserModel) {
		InfoUserModel userModel = findUserByEmail(infoUserModel.getEmail());
		if (userModel == null) {
			return -1;//用户不存在
		}

		if (!userModel.getPassword().equals(infoUserModel.getPassword())) {
			return 0;//密码错误
		}
		return 1;//登录认证成功
	}
}
