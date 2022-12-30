package life4fun.service.impl;

import life4fun.dao.LoginDao;
import life4fun.dao.impl.LoginDaoImpl;
import life4fun.dto.ServiceResult;
import life4fun.entity.Member;
import life4fun.exception.ServiceException;
import life4fun.service.LoginService;
import life4fun.utils.JdbcUtils;
import lombok.var;

public class LoginServiceImpl implements LoginService {
	public LoginDao loginDao = new LoginDaoImpl();

	@Override
	public ServiceResult<Member> findMember(String phoneNumber, String password) {

		// 獲取資料庫連接對象
		var conn = JdbcUtils.getConnection();
		Member member = null;
		ServiceResult<Member> result = new ServiceResult<>();
		try {
			// 事務開始
			member = loginDao.findMember(conn, phoneNumber);
			// 如果用電話號碼甚麼都沒查到就回傳null>代表沒有這筆資料
			if (member == null) {
				result.setMsg("您輸入的會員帳號或密碼錯誤!");
				return result;
				// 如果有資料了
			} else {
				// 取DB的password 如果DB的password與輸入密碼值不相同
				System.out.println("memberPassword:" + member.getPassword());
				if (!password.equals(member.getPassword())) {
					result.setMsg("您輸入的會員帳號或密碼錯誤!");
					return result;
				} else {
					result.setData(member);
					return result;
				}
			}
			// 事務結束，提交事務
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
