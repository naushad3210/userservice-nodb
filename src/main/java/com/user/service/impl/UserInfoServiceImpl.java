package com.user.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.user.dto.UserInfo;
import com.user.exception.UserException;
import com.user.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Override
	public UserInfo getUserInfo(Long userId) throws UserException {

		Map<Long, UserInfo> userMap = new HashMap<>();
		
		userMap.put(1l, new UserInfo("John", 40, "john@goog.com"));
		userMap.put(2l, new UserInfo("Brad", 55, "brad@goog.com"));
		userMap.put(3l, new UserInfo("Leo", 45, "leo@goog.com"));
		userMap.put(4l, new UserInfo("Messi", 35, "messi@goog.com"));
		return userMap.get(userId);
	}

}
