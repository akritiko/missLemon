/**
 * 
 */
package org.akritiko.misslemon.util;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * @author krap
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
