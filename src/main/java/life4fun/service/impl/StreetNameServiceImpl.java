package life4fun.service.impl;

import java.util.ArrayList;
import java.util.List;

import life4fun.dao.StreetNameDao;
import life4fun.dao.impl.StreetNameDaoImpl;
import life4fun.dto.ServiceResult;
import life4fun.entity.StreetName;
import life4fun.exception.ServiceException;
import life4fun.service.StreetNameService;
import life4fun.utils.JdbcUtils;
import lombok.var;

public class StreetNameServiceImpl implements StreetNameService {
	private StreetNameDao streetName = new StreetNameDaoImpl();

	@Override
	public ServiceResult<List<StreetName>> findAllStreetName() {
		// 獲取資料庫連接對象
		var conn = JdbcUtils.getConnection();
		List<StreetName> streetNameList = new ArrayList<>();
		ServiceResult<List<StreetName>> result = new ServiceResult<>();
		try {
			streetNameList = streetName.findAddress(conn);
			result.setData(streetNameList);
			return result;
		} catch (Exception e) { // SQL例外處理
			// 取得錯誤訊息
			e.printStackTrace();
			// 回滾事務
			throw new ServiceException(e);
		} finally {
			// 釋放資源<
			JdbcUtils.release(conn);
		}
		
	}
}
