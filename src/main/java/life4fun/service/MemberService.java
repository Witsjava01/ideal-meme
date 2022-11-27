package life4fun.service;

import life4fun.entity.Member;
import life4fun.exception.LoginFailedException;
import life4fun.exception.VGBException;

public class MemberService {
	private MemberDAO  dao = new MemberDAO();

	public Member login(String phoneNumberOrEmail, String password) 
			throws VGBException  {
		if(phoneNumberOrEmail==null  || password==null) {
			throw new IllegalArgumentException("會員登入必須輸入帳號密碼");
		}
		
		Member c = null;
		c = dao.selectCustomerByPhoneNumberOrEmail(phoneNumberOrEmail);
		if(c!=null) {
			if(!c.getPassword().equals(password)) {
				c=null;
			}
		}
		
		if(c!=null) {
			return c;	
		}else {
			throw new LoginFailedException("登入失敗，帳號或密碼不正確");
		}
	}
	
	public void register(Member c) throws VGBException{
		if(c==null) {
			throw new IllegalArgumentException("會員註冊客戶物件不得為null");
		}		
		dao.insert(c);
	}
	
	public void update(Member c) throws VGBException{
		if(c==null) {
			throw new IllegalArgumentException("修改會員時客戶物件不得為null");
		}		
		dao.update(c);
	}
}
