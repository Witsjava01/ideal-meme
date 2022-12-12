package life4fun.test;

import life4fun.entity.Member;
import life4fun.utils.ValidateUtils;

public class TestMember {
	public static void main(String[] args) {
		
		if(!ValidateUtils.checkPhoneNumber("0929380181")) {
			return;
		}
		
		Member member = new Member();		
		//member.setId("0929380181");
		member.setPhoneNumber("0929380181");
		member.setName(" 狄會貴                    ");
		//customer.password = "12345;lkj";
		member.setPassword("123jkl");
		member.setGender('M');
		member.setCity("桃園市");
		member.setDistrict("桃園區");
		
		//customer.birthday = LocalDate.of(10300, 5, 28);
		//customer.setBirthday(10300,5,28);		
		//customer.birthday = LocalDate.parse("+12010-12-09");		
		member.setBirthday("2010-06-10");
		
		member.setEmail("test@gmail.com");
		member.setAddress("       台北市               ");
		//System.out.println(customer.id); //A123456789
		System.out.println(member.getPhoneNumber()); //A123456789
		
		System.out.println("member.name:"+member.getName()); //狄會貴
		
		//System.out.println("password:"+customer.password); //asdf1234
		System.out.println("password:"+member.getPassword()); //asdf1234
		
		System.out.println("gender:"+member.getGender()); //M
		System.out.println("email:"+member.getEmail()); //test@gmail.com
		
		//System.out.println("birthday:"+customer.birthday); //2010-02-28
		System.out.println("birthday:"+member.getBirthday()); //2010-02-28
		System.out.println("city:"+member.getCity());
		System.out.println("district:"+member.getDistrict());
		System.out.println("address:"+member.getAddress());//

//		Period period= Period.between(customer.birthday, LocalDate.now());
//		System.out.println(period); //for test
//		int age = period.getYears();
//		if(period.getMonths()>6) {
//			age=age+1;
//		}
//		System.out.println(age);
		System.out.println("getAge():"+member.getAge() + "歲");
		System.out.println("*************************");
		System.out.println(member);
	}
}
