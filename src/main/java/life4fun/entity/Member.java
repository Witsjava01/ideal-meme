package life4fun.entity;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import life4fun.utils.ValidateUtils;
import life4fun.exception.VGBDataInvalidException;

public class Member {
	private String id; //必要, not null, PKey
	private String password; //必要, not null, 6~20個字元
	private String name; //必要, not null, 2~20個字元
	private char gender; //必要, 'M':男, 'F':女, 'U':Unknown	
	private String email; //必要, not null, unique index
	private LocalDate birthday; //必要(須年滿12歲)，
	private String city="";//必要, not null, 縣/市
	private String district="";//必要, not null, 行政區
	private String address="";//必要, not null, 詳細地址, 0~50字元
	private String phoneNumber=new String(""); //必要, not null, 0~30個字元

	
	public Member() {}
	
	public Member(String id, String password, String name) {
		this.setId(id);
		this.setPassword(password);
		this.setName(name);
	}
	
	public Member(String phoneNumber, String password, String name, 
		char gender, String email, String birthday) {
		this(phoneNumber, password, name);		
		this.setGender(gender);
		this.setEmail(email);
		this.setBirthday(birthday);
	}
	
	public String getId() {
		return this.id;
	}	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		if(ValidateUtils.checkPhoneNumber(phoneNumber)) {
			this.phoneNumber = phoneNumber;
		}else {
			throw new VGBDataInvalidException("電話號碼不正確: " + phoneNumber);
		}
	}
	
	
 	public String getPassword() {
		return this.password;
	}
	
 	public static final int MIN_PASSWORD_LENGTH = 6;
 	public static final int MAX_PASSWORD_LENGTH = 20;
	public void setPassword(String password) {
		if(password!=null && 
					password.length()>=MIN_PASSWORD_LENGTH && 
					password.length()<=MAX_PASSWORD_LENGTH) {
			this.password = password;
		}else {
			//第13章, 改成throw XXXException
			String msg = String.format("密碼必須%d~%d個字元，但您輸入的是 %s\n", 
					MIN_PASSWORD_LENGTH, MAX_PASSWORD_LENGTH, password);
			throw new VGBDataInvalidException(msg);
		}
	}
	
	
	
	public String getName() {
		return name;
	}

 	public static final int MIN_NAME_LENGTH = 2;
 	public static final int MAX_NAME_LENGTH = 20;
	public void setName(String name) {
		if(name!=null && 
				(name=name.trim()).length()>=2 && 
				 name.length()<=20) {
			this.name = name;
		}else{
			//第13章, 改成throw XXXException
			//System.err.println("客戶姓名必須2~20個字元:" + name);			
			String msg = String.format("客戶姓名必須%d~%d個字元，但您輸入的是:%s\n", 
					MIN_NAME_LENGTH, MAX_NAME_LENGTH, name);
			throw new VGBDataInvalidException(msg);
		}
	}


	public char getGender() {		
		return gender;
	}

	public static final char MALE='M';
	public static final char FEMALE='F';
	public static final char UNKNOWN='U';
	public void setGender(char gender) {
		if(gender==MALE || gender==FEMALE || gender==UNKNOWN) {
			this.gender = gender;
		}else {
			throw new VGBDataInvalidException("客戶性別資料輸入錯誤: " + gender);
		}
	}


	public LocalDate getBirthday() {
		return birthday;
	}
	
	public static final int MIN_AGE=12; //符合規則(須年滿12歲)
	public void setBirthday(LocalDate birthday) {//Encapsulate要的setter
		if(birthday==null) {
			//第13章，改成throw XXXException
			throw new IllegalArgumentException("客戶生日不得為null");
		}
		
		//檢查參數birthday符合規則(須年滿12歲)才指派給birthday屬性
		Period period = Period.between(birthday, LocalDate.now());
		int age = period.getYears();
		if(age>=MIN_AGE) {
			this.birthday = birthday;
		}else {
			//第13章，改成throw XXXException
			String msg = String.format("客戶生日必須年滿%d歲:%s", MIN_AGE, birthday);
			throw new VGBDataInvalidException(msg);
		}
	}
	
	/**
	 * 將year, month, day三個int參數轉換成LocalDate物件後，指派給birthday屬性
	 * @param year,month,day
	 */
	public void setBirthday(int year, int month, int day){
		//將year, month, day三個整數參數轉換成LocalDate物件
		try {
			LocalDate date = LocalDate.of(year, month, day); 
			
			//並呼叫this.setBirthday(date)來完成檢查與指派
			this.setBirthday(date);
		}catch(java.time.DateTimeException e) {
			throw new VGBDataInvalidException("客戶生日日期資料不正確: " + e.getMessage());
		}
	}
	
	/**
	 * 將dateStr字串參數轉換成LocalDate物件後，指派給birthday屬性
	 * @param dateStr: 生日日期字串，必須符合iso-8601日期(yyyy-MM-dd)
	 */
	public void setBirthday(String dateStr) {
		if(dateStr==null) this.setBirthday((LocalDate)null);
		
		//將dateStr字串參數轉換成LocalDate物件
		try {
			LocalDate date = LocalDate.parse(dateStr);
			
			//呼叫this.setBirthday(date)來完成檢查與指派
			this.setBirthday(date);
		}catch(DateTimeParseException e) {
			throw new VGBDataInvalidException("客戶生日日期格式應符合yyyy-MM-dd(如:2001-03-05)，但你輸入的是:" + dateStr);
		}
	}
		
	/**
	 * 
	 * @return
	 */
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		if(address==null) address="";		
		this.address = address.trim();
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getEmail() {
		return email;
	}

	private static final String EMAIL_PATTERN = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
	public void setEmail(String email) { // ^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$
		if(email!=null && email.matches(EMAIL_PATTERN)) {
			this.email = email;
		}else {
			throw new VGBDataInvalidException("email格式不正確:" + email);
		}
	}



	/**
	 * 從客戶birthday屬性計算客戶年齡
	 * @return int型態的客戶年齡
	 */	 
	 public int getAge() {
		 return getAge(this.birthday);
	 }
	
	 /**
	  * 從參數birthday計算客戶年齡
	  * @return int型態的客戶年齡
	 */
	 private int getAge(LocalDate birthday) {
		if(birthday!=null) { //參數birthday有資料，才可以算年齡
			Period period = Period.between(birthday, LocalDate.now());
//			System.out.println(
//				period.getYears() + "年" 
//						+ period.getMonths()+"月" + period.getDays()+"天"); //for test
			int age = period.getYears();
//			if(period.getMonths()==6 && period.getDays()>0 
//				|| period.getMonths()>6) {
//				age=age+1;
//			}			
			return age;
		}else{ //birthday屬性是null就回傳-1，表示無法計算年齡
			//TODO: 第13章，改成throw XXXException
			throw new VGBDataInvalidException("客戶生日為null，無法計算年齡");
			//return -1;
		}
	}

	@Override
	public String toString() {
		return this.getClass().getName() 
			+ "\nid="+id + ",密碼="+password + ",姓名=" + name 
			+ "\n, 性別=" + gender + ",email=" + email 
			+ "\n, 生日=" + birthday + ", 年齡=" + (birthday!=null?getAge() + "歲":"無法計算年齡") 
			+ "\n, 地址=" + address 
			+ "\n, 電話=" + phoneNumber;
	}	
	Integer i ;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result 
				+ ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Member))
			return false;
		Member other = (Member) obj;
		if (this.id == null) {
			if (other.id != null)
				return false;
		}else if (!id.equals(other.id))
			return false;
		return true;
	}
}
