package life4fun.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import life4fun.utils.JdbcUtils;



@SuppressWarnings(value = { "rawtypes", "unchecked" })

public abstract class BaseDao<T> {

  private QueryRunner queryRunner;
  // 泛型T的類型
  private Class<T> type;

  // 構造器
  public BaseDao() {
    queryRunner = new QueryRunner();

    // 獲取T的類型
    Class clazz = this.getClass();
    ParameterizedType parameterizedType = (ParameterizedType) clazz.getGenericSuperclass();
    Type[] types = parameterizedType.getActualTypeArguments();

    if (types.length > 0) {
      this.type = (Class<T>) types[0];
    } else {
      this.type = null;
    }
  }

  /**
   * 獲取資料庫連接
   *
   * @return
   */
  @Deprecated 
  protected Connection getConnection() {
    return JdbcUtils.getConnection();
  }

  /**
   * 釋放資料庫連接
   *
   * @param conn
   */
  @Deprecated
  protected void release(Connection conn) {
    JdbcUtils.release(conn);
  }

  /**
   * 通用的SQL更新操作(INSERT,UPDATE,DELETE)，適用於事務
   *
   * @param conn:   Connection連接對象。
   * @param sql:    可含?預留位置的SQL語句
   * @param params: ?預留位置對應的可變參數
   * @return: 執行sql語句受影響的行數
   *
   *          注意：需要傳入Connection連接對象的方法，適用於事務，Connection在提交事務或回滾事務時釋放回連接池。下同
 * @throws SQLException 
   */
  public int update(Connection conn, String sql, Object... params) throws SQLException {
    return queryRunner.update(conn, sql, params);
  }

  /**
   * 通用的SQL更新操作(INSERT,UPDATE,DELETE)，適用於非事務
   *
   * @param sql
   * @param params
   * @return
   *
   *         注意：不需要傳入Connection連接對象的方法，適用於非事務，沒事執行sql語句前，從連接池獲取連接，執行完sql後，在釋放回連接池。下同
 * @throws SQLException 
   */
  @Deprecated
  public int update(String sql, Object... params) throws SQLException {
    Connection conn = getConnection();
    int rows = update(conn, sql, params);
    release(conn);
    return rows;
  }

  /**
   * 執行插入一條記錄，並獲取自增ID值
   *
   * @param conn:   Connection連接對象
   * @param sql:    可含?預留位置的SQL語句
   * @param params: ?預留位置對應的可變參數
   * @return: 自增ID值
   */
  public Integer insert(Connection conn, String sql, Object... params) throws SQLException{
    BigInteger auto_increment_id = (BigInteger) queryRunner.insert(conn, sql, new ScalarHandler<>(), params);
    return auto_increment_id == null ? null : auto_increment_id.intValue();

  }

  @Deprecated
  public Integer insert(String sql, Object... params) throws SQLException {
    Connection conn = getConnection();
    Integer auto_id = insert(conn, sql, params);
    release(conn);
    return auto_id;
  }

  /**
   * 執行查詢SQL獲取第一行，並轉為一個Bean對象
   *
   * @param conn:   Connection連接對象
   * @param sql:    可含?預留位置的SQL語句
   * @param params: ?預留位置對應的可變參數
   * @return: T的Bean對象
 * @throws SQLException 
   */
  public T getBean(Connection conn, String sql, Object... params) throws SQLException {
    return queryRunner.query(conn, sql, new BeanHandler<T>(type), params);
  }

  @Deprecated
  public T getBean(String sql, Object... params) throws SQLException {
    Connection conn = getConnection();
    T bean = getBean(conn, sql, params);
    release(conn);
    return bean;
  }

  /**
   * 執行查詢SQL獲取所有行，每行並轉為轉為一個Bean對象，這些Bean對象組成一個List並返回
   *
   * @param conn:   Connection連接對象
   * @param sql:    可含?預留位置的SQL語句
   * @param params: ?預留位置對應的可變參數
   * @return: T的Bean對象組成的List
 * @throws SQLException 
   */
  public List<T> getBeanList(Connection conn, String sql, Object... params) throws SQLException {
    return queryRunner.query(conn, sql, new BeanListHandler<T>(type), params);
  }

  @Deprecated
  public List<T> getBeanList(String sql, Object... params) throws SQLException {
    Connection conn = getConnection();
    List<T> list = getBeanList(conn, sql, params);
    release(conn);
    return list;
  }
  
  public List<T> findAll(Connection conn, String sql, Object... params) throws SQLException {
	    return queryRunner.query(conn, sql, new BeanListHandler<T>(type), params);
	  }

  @Deprecated
  public List<T> findAll(String sql, Object... params) {
    List<T> list = null;
    try (Connection conn = getConnection()) {
      list = queryRunner.query(conn, sql, new BeanListHandler<T>(type), params);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return list;
  }

  @Deprecated
  public List<T> findAll() throws SQLException {
    List<T> list = null;
    Connection conn = getConnection();
    final String sql = "select * from " + type.getSimpleName();
    list = queryRunner.query(conn, sql, new BeanListHandler<T>(type));
    /*
    try (Connection conn = getConnection()) {
      final String sql = "select * from " + type.getSimpleName();
      list = queryRunner.query(conn, sql, new BeanListHandler<T>(type));
    } catch (SQLException e) {
      e.printStackTrace();
    }
    */
    return list;
  }

  /**
   * 執行返回一個值的SQL查詢語句
   *
   * 可用來執行像 select count(*) from ...這樣的sql語句
   *
   * @param conn:   Connection連接對象
   * @param sql:    可含?預留位置的SQL語句
   * @param params: ?預留位置對應的可變參數
   * @return: 返回查詢SQL執行後返回的單一的值
 * @throws SQLException 
   */
  public <E> E getValue(Connection conn, String sql, Object... params) throws SQLException {
    return (E) queryRunner.query(conn, sql, new ScalarHandler<>(), params);
  }

  @Deprecated
  public <E> E getValue(String sql, Object... params) throws SQLException {
    Connection conn = getConnection();
    E value = getValue(conn, sql, params);
    release(conn);
    return value;
  }

}
