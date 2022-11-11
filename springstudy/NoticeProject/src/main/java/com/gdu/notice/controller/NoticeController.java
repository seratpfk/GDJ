package com.gdu.notice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.notice.service.NoticeService;

@Controller
public class NoticeController {

   @Autowired
   private NoticeService noticeService;
   
   @GetMapping("/")
   public String index() {
      return "index";
   }
   
   @GetMapping("/ntc/list")
   public String list(Model model) {
      noticeService.findAllNotices(model);
      return "notice/list";
   }
   
   @GetMapping("/ntc/write")
   public String write() {
      return "notice/write";
   }
   
   @PostMapping("/ntc/add")
   public void add(HttpServletRequest request, HttpServletResponse response) {
      noticeService.addNotice(request, response);
   }
   
   
   @GetMapping("/ntc/detail") // /ntc/detail?noticeNo=1
   public String detail(@RequestParam(value="noticeNo" , required=false, defaultValue="0") int noticeNo, Model model ) {
      noticeService.findNoticeByNo(noticeNo, model);
      
      return "notice/detail";
   }
   
   @PostMapping("/ntc/modify")
   public void modify(HttpServletRequest request, HttpServletResponse response) {
      noticeService.modifyNotice(request, response);
   }
   
   @PostMapping("/ntc/remove")
   public void remove(HttpServletRequest request, HttpServletResponse response) {
      noticeService.removeNotice(request, response);
      
   }
   
   
}