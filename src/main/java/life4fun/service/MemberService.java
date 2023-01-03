package life4fun.service;

import java.util.List;

import life4fun.dto.ServiceResult;
import life4fun.entity.Member;
import life4fun.entity.Order;


public interface MemberService {
	public ServiceResult<Member> findMember(String phoneNumber, String password);

	public String addMember(Member member);

	public boolean checkMember(String phoneNumber);

	public String updateMember(Member member);

	public String updatePassword(String newPassword, String phoneNumber);

	public ServiceResult<List<Order>> findOrder(String phoneNumber);

	public ServiceResult<List<Order>> findOrder(String phoneNumber, Integer OrderId);

}


