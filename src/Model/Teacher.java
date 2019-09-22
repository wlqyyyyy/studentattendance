package Model;

import java.io.InputStream;

/**
 * 
 * @author apple
 *教师实体表设计
 */
public class Teacher {
	private int id;
	private String sn;//教师工号
	private String name;
	private String password;
	private int clazzId;
	private String sex;
	private String mobile;
	private String xibu;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	
	public int getClazzId() {
		return clazzId;
	}
	public void setClazzId(int clazzId) {
		this.clazzId = clazzId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setxibu(String xibu) {
		this.xibu = xibu;
	}
	public String getxibu() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
