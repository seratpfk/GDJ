package com.gdu.app13.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.app13.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public Map<String, Object> isReduceId(String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("isUser", userMapper.selectUserById(id) != null);
		result.put("isRetireUser", userMapper.selectRetireUserById(id) != null);
		return result;
	}

}
