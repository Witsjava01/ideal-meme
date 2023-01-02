package life4fun.enumerate;

import life4fun.dto.KeyValue;


public enum LoginFilterVaildate {
	LOGIN_PASSWORD("/LoginServlet", new KeyValue("method", "password")),
	LOGIN_UPDATEPASSWORD("/LoginServlet", new KeyValue("method", "updateMember"))
	;
	
	private String path;
	private KeyValue<String, String>[] params;
	
	private LoginFilterVaildate(String path, KeyValue<String, String>... params) {
		this.path = path;
		this.params = params;
	}

	public String getPath() {
		return path;
	}

	public KeyValue<String, String>[] getParams() {
		return params;
	}

}
