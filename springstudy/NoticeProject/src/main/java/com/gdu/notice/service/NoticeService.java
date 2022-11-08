package com.gdu.notice.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.gdu.notice.domain.NoticeDTO;

public interface NoticeService {
   public void findAllNotices(Model model);
   public void findNoticeByNo(int noticeNo, Model model);
   public void addNotice(HttpServletRequest request, HttpServletResponse response);
   public void modifyNotice(NoticeDTO notice, HttpServletResponse response);
   public void removeNotice(int noticeNo, HttpServletResponse response);
}
