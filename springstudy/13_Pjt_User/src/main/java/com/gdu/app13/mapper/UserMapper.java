package com.gdu.app13.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.app13.domain.RetireUserDTO;
import com.gdu.app13.domain.UserDTO;

@Mapper
public interface UserMapper {
	public UserDTO selectUserById(String id);
	public RetireUserDTO selectRetireUserById(String id);
	public UserDTO selectUserByEmail(String email);
	public int insertUser(UserDTO user);
	public int updateAccessLog(String id);
	public int insertAccessLog(String id);
	public int deleteUser(int UserNo);
	public int insertRetireUser(RetireUserDTO retireUser);
	public UserDTO selectUserByIdPw(UserDTO user);
	
	// resultType이 생략되면 무조건 int
	// 업뎃 딜릿 인서트면 인트
}
