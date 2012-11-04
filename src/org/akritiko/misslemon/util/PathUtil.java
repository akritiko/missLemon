/*
 * @(#) PathUtil.java		1.0,	03/08/2009
 * 
 * Copyright (c) WeKnowIt 2009
 */

package org.akritiko.misslemon.util;

public class PathUtil {

	public static String resolvePath(String path) {
		if (path.contains("${")) {
			int startIndex = path.indexOf("@{");
			int endIndex = path.indexOf("}");
			if (endIndex < 0) {
				throw new IllegalArgumentException(path + " is not valid! "
						+ "@{ has no corresponding end bracket!");
			}
			String envVariableName = path.substring(startIndex + 3, endIndex);
			String envVariable = System.getenv(envVariableName);
			if (envVariable == null) {
				throw new IllegalStateException(envVariableName + " variable "
						+ "is not defined in this system!");
			}
			return envVariable + path.substring(endIndex + 1);
		} else {
			return path;
		}
	}

}
