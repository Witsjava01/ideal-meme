package life4fun.enumerate;

import life4fun.dto.KeyValue;


public enum LoginFilterValidate {
	LOGIN_MEMBER("/LoginServlet", new KeyValue<String, String>("method", "member")),
	LOGIN_PASSWORD("/LoginServlet", new KeyValue<String, String>("method", "password")),
	LOGIN_UPDATEMEMBER("/LoginServlet", new KeyValue<String, String>("method", "updateMember")),
	LOGIN_UPDATEPASSWORD("/LoginServlet", new KeyValue<String, String>("method", "updatePassword")),
	LOGIN_ORDER("/LoginServlet", new KeyValue<String, String>("method", "order")),
	LOGIN_ORDERDETAILS("/LoginServlet", new KeyValue<String, String>("method", "orderDetails")),
	TEST_TEST("/TestServlet", new KeyValue<String, String>("method1", "test"))
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
