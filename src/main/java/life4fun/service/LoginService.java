package life4fun.service;

import life4fun.dto.ServiceResult;
import life4fun.entity.Member;


public interface LoginService {
	public ServiceResult<Member> findMember(String phoneNumber, String password);

	public String addMember(Member member);

	public boolean checkMember(String phoneNumber);

	public String updateMember(Member member);

	public String updatePassword(String newPassword, String phoneNumber);

}


