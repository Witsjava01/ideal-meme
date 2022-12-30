package life4fun.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import life4fun.dao.StreetNameDao;
import life4fun.dao.impl.StreetNameDaoImpl;
import life4fun.dto.ServiceResult;
import life4fun.entity.StreetName;
import life4fun.service.StreetNameService;
import life4fun.utils.JdbcUtils;
import lombok.var;

public class StreetNameServiceImpl implements StreetNameService {
	private StreetNameDao streetName = new StreetNameDaoImpl();

	@Override
	public ServiceResult<List<StreetName>> findAllStreetName() {
		String msg = "";
		// 獲取資料庫連接對象
		var conn = JdbcUtils.getConnection();
		
		List<StreetName> streetNameList = new ArrayList<>();
		try {
			
			
			// 事務開始
			JdbcUtils.beginTransaction(conn);
			streetNameList = streetName.findAddress(conn);
			
		} catch (SQLException e) { // SQL例外處理
			e.printStackTrace();
			// 取得錯誤訊息
			msg = e.getMessage();
			// 回滾事務
			JdbcUtils.rollbackTransaction(conn);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			msg = e.getMessage();
			JdbcUtils.rollbackTransaction(conn);
		} finally {
			// 釋放資源<
			JdbcUtils.release(conn);
		}
		ServiceResult<List<StreetName>> result = new ServiceResult<>(msg, streetNameList);
		return result;
	}
}
