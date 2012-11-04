/**
 * 
 */
package org.akritiko.misslemon.entities;

/**
 * @author krap
 *
 */
public class LemonURL {
	
	private String URL;
	private String description;
	
	public LemonURL(String uRL, String description) {
		URL = uRL;
		this.description = description;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
