package com.gdu.contact.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gdu.contact.domain.ContactDTO;
import com.gdu.contact.service.ContactService;

@Controller
public class ContactController {


	@Autowired
	private ContactService contactService;
	
	
	@GetMapping("/")
	public String list() {
		return "list";
	}
	
	
	@GetMapping("con/list")
	public String list(Model model) { // Model은 forward할 속성(Attribute)을 저장할 때 사용한다.
		model.addAttribute("contacts", ContactService.findAllContacts());
		return "contact/list"; // board폴더의 list.jsp로 forward
	}
	
	@GetMapping("con/write")
	public String write() {
		return "contact/write"; // board 폴더의 write.jsp로 forward
	}
	
	@PostMapping("con/add")
	public String add(ContactDTO contact) {
		contactService.saveContact(contact); // saveBoard()로부터 0/1이 반환되지만 처리하지 않았다.
		return "redirect:/con/list";
	}
	
	/*
	@GetMapping("con/detail")
	public String detail(@RequestParam(value="conNo", required=false, defaultValue = "0") int conNo
			           , Model model) {
		model.addAttribute("contact", contactService.findContactByNo(conNo));
		return "contact/detail";
	}
	
	@PostMapping("con/edit")
	public String edit(int conNo
			         , Model model) {
		model.addAttribute("contact", ContactDTO.class); // ContactDTO.findContactByNo(conNo)
		return "contact/edit";
	}
	
	@PostMapping("con/modify")
	public String modify(ContactDTO contact) {
		contactService.modifyContact(contact); // modifyBoard()로부터 0/1이 반환되지만 처리하지 않음.
		return "redirect:/con/detail?conNo=" + contact.getconNo();
	}
	
	@PostMapping("con/remove")
	public String remove(int conNo) {
		contactService.removeContact(conNo); // removeBoard()로부터 0/1이 반환되지만 처리하지 않음.
		return "redirect:/con/list";
	}
	*/
}
