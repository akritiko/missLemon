/**
 * 
 */
package org.akritiko.misslemon.util;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * Provides machine specific information. 
 *  - Screen width
 *  - Screen height
 * 
 * @version 1.0.0, 05 Jan 2013 
 * @author Apostolos Kritikos <akritiko@gmail.com>
 *
 */
public class MachineUtility {
	
	private static Dimension screenSize;
	
	static {
		Toolkit tk = Toolkit.getDefaultToolkit();
		screenSize = tk.getScreenSize();
	}
	
	public static int getScreenWidth() {
		return screenSize.width;
	}
	
	public static int getScreenHeight() {
		return screenSize.height;
	}
}
