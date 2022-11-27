package life4fun.service;

import life4fun.entity.Member;
import life4fun.exception.VGBException;

public interface IMemberService {
	public Member login(String phoneNumberOrEmail, String password) throws VGBException;
	public void register(Member c) throws VGBException;
	public void update(Member c) throws VGBException;
}
