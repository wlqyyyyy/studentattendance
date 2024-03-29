package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Util.DbUtil;

/**
 * 基础dao
 * @author apple
 *
 */
public class BaseDao {
	private DbUtil dbUtil = new DbUtil();
	/**
	 * 关闭数据库
	 */
	public void closeCon(){
		dbUtil.closeCon();
	}
	/**
	 * 基础查询,多条查询
	 */
	public ResultSet query(String sql){
		try {
			PreparedStatement prepareStatement = dbUtil.getConnection().prepareStatement(sql);
			return prepareStatement.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	} 
	/**
	 *改变数据库内容操作
	 */
	public boolean update(String sql){
		try {
			return dbUtil.getConnection().prepareStatement(sql).executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
