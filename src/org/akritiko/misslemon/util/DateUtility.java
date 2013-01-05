/**
 * 
 */
package org.akritiko.misslemon.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DateUtility create Date objects with specific format(s)
 * 
 * @version 1.0.0, 05/01/2013
 * @author Apostolos Kritikos <akritiko@gmail.com>
 */
public class DateUtility {
	
	private SimpleDateFormat formatter;
	private String theDate;

	public DateUtility(Date date) {
		//Default formatter: 05 Jan 2013, 01:42:00
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
