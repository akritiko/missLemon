/**
 * 
 */
package org.akritiko.misslemon.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author krap
 *
 */
public class DateUtility {
	
	private SimpleDateFormat formatter;
	private String theDate;

	public DateUtility(Date date) {
		formatter = new SimpleDateFormat("dd MMM yyyy, HH:mm:ss");
		this.theDate = formatter.format(date);
	}

	public SimpleDateFormat getFormatter() {
		return formatter;
	}

	public void setFormatter(SimpleDateFormat formatter) {
		this.formatter = formatter;
	}

	public String getTheDate() {
		return theDate;
	}

	public void setTheDate(String theDate) {
		this.theDate = theDate;
	}
}
