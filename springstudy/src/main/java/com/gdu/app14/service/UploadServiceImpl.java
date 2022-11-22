package com.gdu.app14.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.app14.mapper.UploadMapper;

@Service
public class UploadServiceImpl implements UploadService {

	@Autowired
	private UploadMapper attachMapper;
	
	
}
