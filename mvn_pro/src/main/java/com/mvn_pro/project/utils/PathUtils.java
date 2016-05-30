package com.mvn_pro.project.utils;

public class PathUtils {

	/**
	 * 
	 * @return
	 */
	public static String getTomcatClassesPath() {
		return Thread.currentThread().getContextClassLoader().getResource("").toString().split("file:/")[1];
	}
	
	public static String getProjectName(){
		String [] strs = System.getProperty("user.dir").split("\\\\");
		return strs[strs.length-1];
	}
	
	public static String getProjectRootPath(){
		return System.getProperty("user.dir");
	}
}
