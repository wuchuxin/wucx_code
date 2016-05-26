package com.mvn_pro.project.utils;

public class PathUtils {

	public static String getTomcatClassesPath() {
		return Thread.currentThread().getContextClassLoader().getResource("").toString().split("file:/")[1];
	}
}
