package life4fun.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import life4fun.dao.BaseDao;
import life4fun.dao.StreetNameDao;
import life4fun.entity.StreetName;


public class StreetNameDaoImpl extends BaseDao<StreetName> implements StreetNameDao<StreetName> {
	@Override
	public List<StreetName> findAddress(Connection conn) throws SQLException {
		String sql = "select * from streetname";
		return findAll(conn, sql);
	}
}
