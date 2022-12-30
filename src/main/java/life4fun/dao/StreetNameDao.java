package life4fun.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import life4fun.entity.StreetName;


public interface StreetNameDao <T> {

	public List<StreetName> findAddress(Connection conn) throws SQLException;

}
