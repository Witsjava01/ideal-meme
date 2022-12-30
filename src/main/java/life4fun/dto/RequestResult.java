package life4fun.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RequestResult {
	
	private boolean result;
	private String msg;
	private Object data;
	
	
	public static RequestResult success() {
		return new RequestResult(true);
	}
	
	public static RequestResult success(Object data) {
		return new RequestResult(true, null, data);
	}
	
	public static RequestResult fail(String msg) {
		return new RequestResult(false, msg, null);
	}

	public RequestResult(boolean result) {
		super();
		this.result = result;
	}
	
}
