package org.akritiko.misslemon.util;

import java.lang.reflect.Method;
import javax.swing.JOptionPane;
import java.util.Arrays;

/**
 * Bare Bones Browser Launch for Java Utility class to open a web page from a
 * Swing application in the user's default browser. Supports: Mac OS X,
 * GNU/Linux, Unix, Windows XP/Vista.
 * 
 * @version 3.0.0, 05 Jan 2013
 * @author Apostolos Kritikos <akritiko@gmail.com>
 * 
 *         SOURCE CODE ORIGINALLY CREATD BY:
 * 
 * @author Dem Pilafian
 * @version 2.0.0, 26 May 2009
 * 
 *          AND FOUND AT: http://www.centerkey.com/java/browser/
 * 
 *          UNDER: Public Domain Software
 * 
 */
public class WebTirbouson {

	static final String[] browsers = { "firefox", "opera", "konqueror",
			"epiphany", "seamonkey", "galeon", "kazehakase", "mozilla",
			"netscape" };

	/**
	 * Opens the specified web page in a web browser
	 * 
	 * @param url
	 *            A web address (URL) of a web page 
	 *            (e.g. "http://www.google.com/")
	 */
	public static void openURL(String url) {
		try {
			if (OSDetector.isMac()) {
				Class<?> fileMgr = Class.forName("com.apple.eio.FileManager");
				Method openURL = fileMgr.getDeclaredMethod("openURL",
						new Class[] { String.class });
				openURL.invoke(null, new Object[] { url });
			} else if (OSDetector.isWindows())
				Runtime.getRuntime().exec(
						"rundll32 url.dll,FileProtocolHandler " + url);
			else { // assume Unix or Linux
				boolean found = false;
				for (String browser : browsers)
					if (!found) {
						found = Runtime.getRuntime()
								.exec(new String[] { "which", browser })
								.waitFor() == 0;
						if (found)
							Runtime.getRuntime().exec(
									new String[] { browser, url });
					}
				if (!found) {
					//TODO: Write to MissLemon log
					throw new Exception(Arrays.toString(browsers));
				}
			}
		} catch (Exception e) {
			//TODO: Write to MissLemon log
			JOptionPane.showMessageDialog(null,
					"Error attempting to launch web browser\n" + e.toString());
		}
	}
}