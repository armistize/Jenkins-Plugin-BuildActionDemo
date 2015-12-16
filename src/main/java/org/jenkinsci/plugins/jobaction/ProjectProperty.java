/**
 * @author  Tawit K.
 */
package org.jenkinsci.plugins.jobaction;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;

import hudson.Extension;
import hudson.Launcher;
import hudson.model.BuildListener;
import hudson.model.JobProperty;
import hudson.model.JobPropertyDescriptor;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;

public class ProjectProperty extends JobProperty<AbstractProject<?,?>> {

    public static boolean enable;

    public boolean isEnable() {
        return enable;
    }
    
    public void setEnable(boolean enable) {
        this.enable = enable;
    }
    
    @Override
    public boolean perform(AbstractBuild<?, ?> build, Launcher launcher, BuildListener listener) throws InterruptedException, IOException {
        if(enable) {
	    	JobAction action = new JobAction();
	        build.getActions().add(action);
        }
    	return true;
    }
    
    @Extension
    public static class DescriptorImpl extends JobPropertyDescriptor
    {
    	public DescriptorImpl(){
            load();
        }

        @Override
        public String getDisplayName() {
            return Constants.DISPLAY_NAME;
        }
  
        @Override
        public boolean isApplicable(java.lang.Class jobType) {
            return AbstractProject.class.isAssignableFrom(jobType);
        }  
        
        @Override
        public JobProperty<?> newInstance(StaplerRequest req, JSONObject formData) {
          ProjectProperty prop = new ProjectProperty();
          if(formData.containsKey(Constants.OPTINAL_BLOCK_NAME)) {
              prop.setEnable(true);
          }
    	  return prop;
        }
    }
}