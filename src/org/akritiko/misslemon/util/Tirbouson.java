package org.akritiko.misslemon.util;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.akritiko.misslemon.entities.LemonFileOrApplication;

public class Tirbouson {

	public Tirbouson() {

	}

	public boolean openAplication(LemonFileOrApplication lm) {
		String finalCommand = "";

		try {
			if (OSDetector.isWindows())
				finalCommand = lm.getWindowsExecutionCommand();
			else if (OSDetector.isLinux())
				finalCommand = lm.getLinuxExecutionCommand();
			else if (OSDetector.isMac())
				finalCommand = lm.getMacExecutionCommand();
			else
				// TODO: to be written to miss lemon's log
				System.err.println("Unknown Operating System");
			Runtime.getRuntime().exec(finalCommand);
		} catch (IOException e) {
			e.printStackTrace(System.err);
			return false;
		}
		
		return true;
	}

	public boolean openFile(File file) {
		try {
			if (Desktop.isDesktopSupported()) {
				Desktop.getDesktop().open(file);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
			return false;
		}
	}
}