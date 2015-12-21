
#Introduction
This project contains a sample **Maven project** that demonstrates how to add new configuration to Jenkins job configuration. When the configuration is enabled,  you can see a new action button icon in Build section (for Jenkins and Hudson).

>
> **Tip:** If you are new to Jenkins plugin development please see [Detailed guides](https://github.com/armistize/Jenkins-Plugin-BuildActionDemo#detailed-guides) topic first.
>

#Building a Plugin
To build a plugin, run mvn install. This will create the file ./target/pluginname.hpi that you can deploy to Jenkins.
```
$ mvn clean install
```

#Add build action
in ProjectProperty.java
```JAVA
    @Override
    public boolean perform(AbstractBuild<?, ?> build, 
		Launcher launcher, BuildListener listener) {
        if(enable) {
	    	BuildAction action = new BuildAction();
	        build.getActions().add(action);
        }
    	return true;
    }
```

#Data Binding
in **/BuildAction/index.jelly
```XML
	<f:entry title="Text Box Title" >
		<f:textbox
			field="field" name="text_box_name"
			value="${it.getTextBoxValue()}"/>
	</f:entry>
```

in BuildAction.java
```JAVA
	private String textBoxValue;
	
	.....
	
	public String getTextBoxValue() {
		return textBoxValue;
	}
```

>
> **Note:** `BuildAction.java` is linked to `*.jelly` in BuildAction folder
>

#Detailed guides
[Jenkins Plugin tutorial](https://wiki.jenkins-ci.org/display/JENKINS/Plugin+tutorial)  
[Maven Tutorial](http://www.tutorialspoint.com/maven/)  
[Jenkins JavaDocs](http://javadoc.jenkins-ci.org/)  

#License
>The MIT License (MIT)

>Copyright (c) 2015 Tawit K.

>Permission is hereby granted, free of charge, to any person obtaining a copy
>of this software and associated documentation files (the "Software"), to deal
>in the Software without restriction, including without limitation the rights
>to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
>copies of the Software, and to permit persons to whom the Software is
>furnished to do so, subject to the following conditions:

>The above copyright notice and this permission notice shall be included in all
>copies or substantial portions of the Software.

>THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
