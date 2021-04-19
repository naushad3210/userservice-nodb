package com.user.controller;

import static com.user.contant.Constants.USER_ID;
import static com.user.contant.Constants.USER_SERVICE_API_PATH;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.dto.UserInfo;
import com.user.exception.UserException;
import com.user.service.UserInfoService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(value = USER_SERVICE_API_PATH)
public class UserController {
	
	@Autowired
	private UserInfoService userInfoService;

	@GetMapping(path = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserInfo> getUserInfo( @PathVariable(value = USER_ID) Long userId)
			throws UserException {
		log.info("GET | USER | user id: {}", userId);
		
		UserInfo userInfo = userInfoService.getUserInfo(userId);
		
		log.debug("GET | USER | SUCCESS");
		return ResponseEntity.ok(userInfo);
	}

}
