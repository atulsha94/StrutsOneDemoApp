package com.acc.service;

import com.acc.dao.DbUtils;

public class UserLoginService {

	public boolean checkUserLoginDetails(String userName,String password) {
		return DbUtils.getuserDetails(userName,password);
	}
}
