package life4fun.service;

import java.util.List;

import life4fun.dto.ServiceResult;
import life4fun.entity.Member;
import life4fun.entity.Order;
import life4fun.entity.OrderDetails;


public interface MemberService {
	public ServiceResult<Member> findMember(String phoneNumber, String password);

	public String addMember(Member member);

	public boolean checkMember(String phoneNumber);

	public String updateMember(Member member);

	public String updatePassword(String newPassword, String phoneNumber);

	public ServiceResult<List<Order>> findOrder(String phoneNumber);

	public ServiceResult<List<Order>> findOrder(String phoneNumber, Integer OrderId);

	public ServiceResult<List<Order>> findOrderToDetails(String phoneNumber, Integer OrderId);

	public ServiceResult<List<OrderDetails>> findOrderetails(Integer OrderId);

	public ServiceResult<Member> findMemberById(Integer id);

	public Member findMemberByMemberId(Integer id);
}


