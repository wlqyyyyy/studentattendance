package Util;

public class SnUtil {
	public static String generateSn(int clazzId){
		String sn = "";
		sn = "S" + clazzId + System.currentTimeMillis();
		return sn;
	}
	public static String generateTeacherSn(int clazzId){
		String sn = "";
		sn = "T" + clazzId + System.currentTimeMillis();
		return sn;
	}
}
