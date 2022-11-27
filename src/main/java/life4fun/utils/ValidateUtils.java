package life4fun.utils;

public class ValidateUtils {
	//電話號碼驗證
	private static final String phoneNumberPattern = "0\\d{2,3}[-]?\\d{7,8}|0\\d{2,3}\\s?\\d{7,8}|13[0-9]\\d{8}|15[1089]\\d{8}";
	public static boolean checkPhoneNumber(String phoneNumber) { //0123456789
		if(phoneNumber!=null && phoneNumber.matches(phoneNumberPattern)) {//用regular expression來檢查phoneNumber的格式		
			return true;
		}		
		return false;		
	}
}
