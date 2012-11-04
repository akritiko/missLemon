/**
 * 
 */
package org.akritiko.misslemon.entities;

/**
 * @author KrAp <akritiko@gmail.com>
 *
 */
public class LemonFileOrApplication {
	
	private String alias;
	private String windowsCommand;
	private String linuxCommand;
	private String macCommand;
	
	public LemonFileOrApplication(String applicationName,
			String windowsExecutionCommand, String linuxExecutionCommand,
			String macExecutionCommand) {
		this.alias = applicationName;
		this.windowsCommand = windowsExecutionCommand;
		this.linuxCommand = linuxExecutionCommand;
		this.macCommand = macExecutionCommand;
	}

	public String getApplicationId() {
		return alias;
	}

	public void setApplicationId(String applicationId) {
		this.alias = applicationId;
	}

	public String getWindowsExecutionCommand() {
		return windowsCommand;
	}

	public void setWindowsExecutionCommand(String windowsExecutionCommand) {
		this.windowsCommand = windowsExecutionCommand;
	}

	public String getLinuxExecutionCommand() {
		return linuxCommand;
	}

	public void setLinuxExecutionCommand(String linuxExecutionCommand) {
		this.linuxCommand = linuxExecutionCommand;
	}

	public String getMacExecutionCommand() {
		return macCommand;
	}

	public void setMacExecutionCommand(String macExecutionCommand) {
		this.macCommand = macExecutionCommand;
	}
}