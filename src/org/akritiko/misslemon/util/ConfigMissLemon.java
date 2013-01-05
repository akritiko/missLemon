package org.akritiko.misslemon.util;

import java.io.File;

/**
 * ConfigMissLemon provides a pool for directory locations (paths)
 * that are important for Miss Lemon's work. Works like a properties file
 * only with enhanced functionality
 * 
 * @version 2.0.0, 05 Jan 2013
 * @version 1.0.0, 03 Aug 2009
 * 
 * THIS SOURCE CODE WAS ORIGINALLY CREATED BY: 
 * 
 * @author Apostolos Kritikos <akritiko@gmail.com>
 * @author Symeon Papadopoulos <papadop@iti.gr>
 * 
 * AS PART OF THE EU FUNDED PROJECT WeKnowIt (http://www.weknowit.eu) on
 * behalf of the Informatics and Telematics Institute (http://www.iti.gr), 
 * Centre of Research and Technology Hellas (http://www.certh.gr/root.en.aspx)
 * 
 */
public class ConfigMissLemon {

	private volatile static ConfigMissLemon config = null;

	//TODO: Create mechanism to initialize .xml files and folder config if they do not exist!
	
	private String configFolderPath;
	private String configFilePath;
	private String xmlFolderPath;

	public ConfigMissLemon() {
		
		configFolderPath = "config";
		configFilePath = configFolderPath + File.separatorChar + "config.xml";
		xmlFolderPath = configFolderPath + File.separatorChar + "xml";
	}

	/**
	 * Returns a ConfigMissLemon object which can be used to get all the
	 * information stored to the attributes of this class
	 * 
	 * @return an instance of ConfigLogMerger
	 */
	public static ConfigMissLemon getConfig() {
		if (config == null) {
			config = (ConfigMissLemon) XmlIoUtil.readXmlObject("config/config.xml");
		}
		return config;
	}

	public String getConfigFolderPath() {
		return configFolderPath;
	}

	public void setConfigFolderPath(String configFolderPath) {
		this.configFolderPath = configFolderPath;
	}

	public String getConfigFilePath() {
		return configFilePath;
	}

	public void setConfigFilePath(String configFilePath) {
		this.configFilePath = configFilePath;
	}

	public static void setConfig(ConfigMissLemon config) {
		ConfigMissLemon.config = config;
	}

	public String getXmlFolderPath() {
		return xmlFolderPath;
	}

	public void setXmlFolderPath(String xmlFolderPath) {
		this.xmlFolderPath = xmlFolderPath;
	}

	/**
	 * Yet another main method
	 * 
	 * @param args
	 *            the classic main method's array parameter
	 */
	public static void main(String[] args) {
		ConfigMissLemon standard = new ConfigMissLemon();
		XmlIoUtil.writeXmlObject(standard, "config.xml");
//		ConfigMissLemon test = ConfigMissLemon.getConfig();
//		System.out.println(test.getCalendarAlertsPath());
	}
}