package life4fun.service;

import java.util.List;

import life4fun.dto.ServiceResult;
import life4fun.entity.StreetName;


public interface StreetNameService {

	public ServiceResult<List<StreetName>> findAllStreetName();
}
