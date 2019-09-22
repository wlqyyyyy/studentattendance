package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Course;
import Model.Page;
import Util.StringUtil;

/**
 * 
 * @author apple
 *�γ����ݿ�
 */
public class CourseDao extends BaseDao {
	public boolean addCourse(Course course){
		String sql = "insert into s_course values(null,'"+course.getName()+"',"+course.getTeacherId()+",'"+course.getCourseDate()+"') ";
		return update(sql);
	}
	
	public List<Course> getCourseList(Course course,Page page){
		List<Course> ret = new ArrayList<Course>();
		String sql = "select * from s_course ";
		if(!StringUtil.isEmpty(course.getName())){
			sql += "and name like '%" + course.getName() + "%'";
		}
		if(course.getTeacherId() != 0){
			sql += " and teacher_id = " + course.getTeacherId() + "";
		}
		sql += " limit " + page.getStart() + "," + page.getPageSize();
		ResultSet resultSet = query(sql.replaceFirst("and", "where"));
		try {
			while(resultSet.next()){
				Course cl = new Course();
				cl.setId(resultSet.getInt("id"));
				cl.setName(resultSet.getString("name"));
				cl.setTeacherId(resultSet.getInt("teacher_id"));
				cl.setCourseDate(resultSet.getString("course_date"));
				ret.add(cl);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	
	public int getCourseListTotal(Course course){
		int total = 0;
		String sql = "select count(*)as total from s_course ";
		if(!StringUtil.isEmpty(course.getName())){
			sql += "and name like '%" + course.getName() + "%'";
		}
		if(course.getTeacherId() != 0){
			sql += " and teacher_id = " + course.getTeacherId() + "";
		}
		ResultSet resultSet = query(sql.replaceFirst("and", "where"));
		try {
			while(resultSet.next()){
				total = resultSet.getInt("total");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}
	
	public boolean editCourse(Course course) {
		// TODO Auto-generated method stub
		String sql = "update s_course set name = '"+course.getName()+"',teacher_id = "+course.getTeacherId()+",course_date = '"+course.getCourseDate()+"' where id = " + course.getId();
		return update(sql);
	}
	public boolean deleteCourse(String ids) {
		// TODO Auto-generated method stub
		String sql = "delete from s_course where id in("+ids+")";
		return update(sql);
	}
/**
	 * ���ÿγ��Ƿ���ѡ��
	 * @param courseId
	 * @return
	 */
	/*public boolean isFull(int courseId){
		boolean ret = false;
		String sql = "select * from s_course where selected_num >= max_num and id = " + courseId;
		ResultSet query = query(sql);
		try {
			if(query.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}*/
	/**
	 * ���¿γ���ѡ����
	 * @param courseId
	 */
	/*public void updateCourseSelectedNum(int courseId ,int num){
		String sql = "";
		if(num > 0){
			sql = "update s_course set selected_num = selected_num + "+ num + " where id = " + courseId;
		}else{
			sql = "update s_course set selected_num = selected_num - " + Math.abs(num) + " where id = " + courseId;
		}
		update(sql);
	}*/
	
}
