package org.akritiko.misslemon.util;

/**
 * OSDetector detects the type of the operating system of the
 * machine running Miss Lemon
 * 
 * @version 1.0.0, 05 Jan 2013
 * @author Apostolos Kritikos <akritiko@gmail.com>
 * 
 * SOURCE CODE ORIGINALLY FOUND ON:
 * http://www.mkyong.com/java/how-to-detect-os-in-java-systemgetpropertyosname/
 *
 */


public class OSDetector {

	private static boolean isWindows = false;
	private static boolean isLinux = false;
	private static boolean isMac = false;

	static {
		
		String os = System.getProperty("os.name").toLowerCase();
		isWindows = os.contains("win");
		isLinux = os.contains("nux") || os.contains("nix");
		isMac = os.contains("mac");
	}

	public static boolean isWindows() {
		return isWindows;
	}

	public static boolean isLinux() {
		return isLinux;
	}

	public static boolean isMac() {
		return isMac;
	}

}
