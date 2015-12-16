/**
 * @author  Tawit K.
 */
package org.jenkinsci.plugins.jobaction;

import java.io.IOException;

import javax.servlet.ServletException;

import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;

import hudson.model.RootAction;

public class JobAction implements RootAction {

	private String textBoxValue;

	public JobAction() {
		// TODO: initialize
	}

	public void click() {
		// TODO: Do your work here after user perform click to your action.
	}

	public void doConfigSubmit(StaplerRequest request, StaplerResponse response)
			throws ServletException, IOException, InterruptedException {
		// TODO: Do your work here after submit button was pressed.
	}

	public String getDisplayName() {
		return Constants.DISPLAY_NAME;
	}

	public String getIconFileName() {
		return Constants.ICON_PATH;
	}

	public String getTextBoxValue() {
		return textBoxValue;
	}

	public String getUrlName() {
		return Constants.URL_NAME;
	}
}
