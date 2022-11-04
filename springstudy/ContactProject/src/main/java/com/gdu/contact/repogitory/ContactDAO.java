package com.gdu.contact.repogitory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.gdu.contact.domain.ContactDTO;

@Repository 
public class ContactDAO {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	
	private Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	
	private void close() {
		try {
			if(rs != null) {rs.close();}
			if(ps != null) {ps.close();}
			if(con != null) {con.close();}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public List<ContactDTO> selectAllContacts() {
      List<ContactDTO> contacts = new ArrayList<ContactDTO>();
      try {
    	  con = getConnection(); // getConnection private(빨간색)
    	  sql = "SELECT NO, NAME, TEL, ADDR, EMAIL, NOTE FROM CONTACT ORDER BY NO DESC";
    	  ps = con.prepareStatement(sql);
    	  rs = ps.executeQuery();
    	  while(rs.next()) {
    		  ContactDTO contact = new ContactDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
    		  contacts.add(contact);
    	  }
      } catch(Exception e) {
    	  e.printStackTrace();
      } finally {
    	  close();
      }
      return contacts;
   }

	
	public ContactDTO selectContactByNo(int conNo) {
		ContactDTO contact = null;
		try {
			con = getConnection();
			sql = "SELECT NO, NAME, TEL, ADDR, EMAIL, NOTE FROM CONTACT WHERE NO = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, conNo);
			rs = ps.executeQuery();
			if(rs.next()) {
				contact = new ContactDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
	         }
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return contact;
	}
	
	public int insertContact(ContactDTO contact) {
		int result = 0;
		try {
			con = getConnection();
			sql = "INSERT INTO CONTACT(NO, NAME, TEL, ADDR, EMAIL, NOTE)"
					+ " VALUES(BOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?)"; // 텍스트 자를 때 맨 앞 띄어쓰기
			ps = con.prepareStatement(sql);
			ps.setString(1, contact.getName()); // 첫번째 물음표에 들어갈 값
			ps.setString(2, contact.getTel()); 
			ps.setString(3, contact.getAddr()); 
			ps.setString(3, contact.getEmail()); 
			ps.setString(3, contact.getNote()); 
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	/*
	public int updateContact(ContactDTO contact) {
		int result = 0;
		try {
			con = getConnection();
			sql = "UPDATE CONTACT "
			    + "SET NAME = ?, TEL = ?, ADDR = ?, EMAIL = ?, NOTE = ?"
			    + "WHERE NO = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, contact.getName());
			ps.setString(2, contact.getTel());
			ps.setString(3, contact.getAddr());
			ps.setString(3, contact.getEmail());
			ps.setString(3, contact.getNote());
			result = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	public int deleteContact(int contact) {
		int result = 0;
		try {
			con = getConnection();
			sql = "DELETE FROM CONTACT WHERE NO = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, contact);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	*/
}
