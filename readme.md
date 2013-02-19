# About #

This project is a gradle plugin to easily use a [LESS](http://www.lesscss.org) compiler with your gradle build script.

## Installation ##

This project is currently not available in any public Maven repository, so the installation requires a few manual steps.

1.  clone the repository `git clone git://github.com/skhome/gradle-less-plugin.git`
2.  install the plugin locally `gradle install`
 
The latest snapshot release should now be available in your local Maven repository.
 
## Usage ##
 
To use the plugin add the following snippet to your build script.

	buildscript {

		repositories {
			mavenCentral()
			mavenLocal()
		}

		dependencies {
			classpath group: 'net.skhome', name: 'gradle-less-plugin', version: '0.2.0-SNAPSHOT'
		}

	}
 	
	apply plugin: 'less'
 	
The plugin will add a `less` extension to your build script which you can use to configure the plugin.

	less {
		sourceDir "${webAppDirName}/less"
		outputDir "${webAppDirName}/css"
		includes '**/*.less'
		excludes 'reset.less'
		compress true
	}

For a documentation on all configuration options please see the plugin [extension](https://github.com/skhome/gradle-less-plugin/blob/master/src/main/groovy/net/skhome/gradle/plugin/less/LessPluginExtension.groovy)

## LICENSE ##

Copyright © 2000 Sascha Krueger
This work is free. You can redistribute it and/or modify it under the
terms of the Do What The Fuck You Want To Public License, Version 2,
as published by Sam Hocevar. See the COPYING file for more details.
