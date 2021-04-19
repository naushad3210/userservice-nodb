package com.user.service;

import com.user.dto.UserInfo;
import com.user.exception.UserException;

public interface UserInfoService {
	
	UserInfo getUserInfo(Long userId) throws UserException;

}
