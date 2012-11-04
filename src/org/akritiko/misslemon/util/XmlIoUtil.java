/*
 * @(#) XmlIoUtil.java	1.0,	01/12/2008
 * 
 * Copyright (c) WeKnowIt 2008
 */

package org.akritiko.misslemon.util;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.thoughtworks.xstream.XStream;


/**
 * XmlIoUtil is a simple wrapper around the XStream library
 * that can be used for serializing and de-serializing POJOs
 * to and from XML files respectively.
 * 
 * @version 1.0 01/12/2008
 * @author papadop
 */
public class XmlIoUtil {

	/**
	 * Serialize the input Java object to XML format.
	 * 
	 * @param obj	The POJO to serialize.
	 * @param file	The output XML file.
	 */
	public static void writeXmlObject(Object obj, String file) {
		XStream xstream = new XStream();
		try {
			FileWriter fw = new FileWriter(file);
			try {
				ObjectOutputStream xmlOut = xstream.createObjectOutputStream(fw);
				try {
					xmlOut.writeObject(obj);
				} finally {
					xmlOut.close();
				}
			} finally {
				fw.close();
			}
		} catch (IOException ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * Deserialize from XML an object which was serialized by
	 * means of the writeXmlObject method.
	 * 
	 * @param file	XML file where the object has been serialized.
	 * @return		The POJO that was serialized in the input file.
	 */
	public static Object readXmlObject(String file) {
		XStream xstream = new XStream();
		Object outObj = null;
		try {
			FileReader fr = new FileReader(file);
			try {
				ObjectInputStream xmlIn = xstream.createObjectInputStream(fr);
				try {
					outObj = xmlIn.readObject();
				} finally {
					xmlIn.close();
				}
			} finally {
				fr.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex){
			ex.printStackTrace();
		}
		return outObj; 
	}
}