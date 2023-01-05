package life4fun.enumerate;

import life4fun.dto.KeyValue;


public enum LoginFilterValidate {
	LOGIN_MEMBER("/MemberServlet", new KeyValue<String, String>("method", "member")),
	LOGIN_PASSWORD("/MemberServlet", new KeyValue<String, String>("method", "password")),
	LOGIN_UPDATEMEMBER("/MemberServlet", new KeyValue<String, String>("method", "updateMember")),
	LOGIN_UPDATEPASSWORD("/MemberServlet", new KeyValue<String, String>("method", "updatePassword")),
	LOGIN_ORDER("/MemberServlet", new KeyValue<String, String>("method", "order")),
	LOGIN_FINDORDERDETAILS("/MemberServlet", new KeyValue<String, String>("method", "findOrderDetails")),
	LOGIN_SHOWORDERDETAILS("/MemberServlet", new KeyValue<String, String>("method", "showOrderDetails")),
	LOGIN_ORDERSEARCH("/MemberServlet", new KeyValue<String, String>("method", "orderSearch"))
	;
	
	private String path;
	private KeyValue<String, String> param;
	
	private LoginFilterValidate(String path, KeyValue<String, String> param) {
		this.path = path;
		this.param = param;
	}

	public String getPath() {
		return path;
	}

	public KeyValue<String, String> getParam() {
		return param;
	}

}
