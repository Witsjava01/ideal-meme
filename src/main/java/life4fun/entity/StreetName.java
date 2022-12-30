package life4fun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StreetName {
	public Integer postalCode;
	public String city;
	public String district;
	public String road;
}
