package com.gdu.contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.contact.domain.ContactDTO;
import com.gdu.contact.repogitory.ContactDAO;


@Service // Service가 사용하는 @Component
public class ContactServiceImpl implements ContactService {
	
	// Service는 DAO를 사용합니다.
	@Autowired // 컨테이너에 생성된 bean 중에서 BoardDAO 타입의 bean을 가져오시오.
	private ContactDAO dao;
	

	
	@Override
	public List<ContactDTO> findAllContacts() {
		return dao.selectAllContacts();
	}

	@Override
	public ContactDTO findContactByNo(int conNo) {
		return dao.selectContactByNo(conNo);
	}

	@Override
	public int saveContact(ContactDTO contact) {
		return dao.insertContact(contact);
	}


	@Override
	public int modifyContact(ContactDTO contact) {
		return dao.updateContact(contact);
	}

	@Override
	public int removeContact(int conNo) {
		return dao.deleteContact(conNo);
	}
	
}
