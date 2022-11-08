package com.gdu.notice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.notice.domain.NoticeDTO;

@Mapper
public interface NoticeMapper {

	public List<NoticeDTO> selectAllNotices(); // 메소드를 호출하면 xml파일의 id로 연결됨
	public int insertNotice(NoticeDTO notice);
	
}
