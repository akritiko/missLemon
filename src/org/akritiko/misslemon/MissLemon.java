/**
 * 
 */
package org.akritiko.misslemon;

import java.util.Calendar;

import org.akritiko.misslemon.gui.Log;
import org.akritiko.misslemon.util.DateUtility;
import org.akritiko.misslemon.util.MachineUtility;
import org.akritiko.misslemon.util.WebTirbouson;

/**
 * @author krap
 * 
 */
public class MissLemon {

	private static Log missLemonsLog;

	static {
		missLemonsLog = new Log();
		missLemonsLog.setLocation(
				MachineUtility.getScreenWidth()
						- MachineUtility.getScreenWidth() * 35 / 100,
				MachineUtility.getScreenHeight()
						- MachineUtility.getScreenHeight() * 74 / 100);
		missLemonsLog.setVisible(true);
	}

	public static void salute() {
		// TODO: add specific salutation (morning, evening, etc.) and the
		// current date / time in brackets (e.g. [02/02/2012, 15.15.15]
		DateUtility du = new DateUtility(Calendar.getInstance().getTime());
		missLemonsLog.updateLog("[" + du.getTheDate() + "]\n"
				+ "Hello sir. I wish you a spectacular day today!", true);
	}

	public static void visit(String url, String mode) {
		WebTirbouson.openURL(url);
		DateUtility du = new DateUtility(Calendar.getInstance().getTime());
		if (mode.equals("spy")) {
			String [] items = url.split("/");
			missLemonsLog.updateLog("\n[" + du.getTheDate() + "]\n"
					+ "I am spying on " + items[items.length-1], true);
		}
		else if (mode.equals("calculate")) {
			String [] items = url.replaceAll("%2B", "\\+").split("\\=");
			missLemonsLog.updateLog("\n[" + du.getTheDate() + "]\n"
					+ "I am calculating " + items[items.length-1], true);
		}
		else if (mode.equals("visit")){
			missLemonsLog.updateLog("\n[" + du.getTheDate() + "]\n"
					+ "I am visiting " + url, true);
		}
		
		else if (mode.equals("search")) {
			String [] items = url.replaceAll("%2B", "\\+").split("\\=");
			missLemonsLog.updateLog("\n[" + du.getTheDate() + "]\n"
					+ "I am searching for " + items[items.length-1], true);
		}
	}
	
	public static void reportFail() {
		DateUtility du = new DateUtility(Calendar.getInstance().getTime());
		missLemonsLog.updateLog("\n[" + du.getTheDate() + "]\n"
				+ "Sorry sir. I don't think I follow!", true);
	}

	public static Log getMissLemonsLog() {
		return missLemonsLog;
	}
}
