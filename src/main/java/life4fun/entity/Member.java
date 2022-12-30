package life4fun.entity;

import java.sql.Date;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	private String id;
	private String name;
	private String password;
	private String gender;
	private String email;
	private Date birthday;
	private String postalCode;
	private String city;
	private String district;
	private String road;
	private String address;
	private String phoneNumber;
	private Integer age;
	private Timestamp create_time;
	private Timestamp update_time;
}
