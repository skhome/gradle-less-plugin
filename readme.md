# About #

This project is a gradle plugin to easily use a [LESS](http://www.lesscss.org) compiler with your gradle build script.

## Usage ##
 
To use the plugin add the following snippet to your build script.

	buildscript {

		repositories {
			mavenCentral()
			mavenRepo url: 'https://github.com/skhome/maven-repository/raw/master'
		}

		dependencies {
			classpath "net.skhome:gradle-less-plugin:1.0.0"
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
