/**
 * 
 */
package org.akritiko.misslemon;

import org.akritiko.misslemon.gui.CommandWindow;
import org.akritiko.misslemon.util.MachineUtility;

/**
 * @author krap
 * 
 */
public class Main {
	public static void main(String[] args) {

		CommandWindow cw = new CommandWindow();
		cw.setLocation(
				MachineUtility.getScreenWidth()
						- MachineUtility.getScreenWidth() * 35 / 100,
				MachineUtility.getScreenHeight()
						- MachineUtility.getScreenHeight() * 90 / 100);
		cw.setVisible(true);

		// Initialize MissLemon
		MissLemon.salute();
	}
}
