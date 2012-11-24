# About #

This project is a gradle plugin to easily use a [LESS](http://www.lesscss.org) compiler with your gradle build script.

## Installation ##

This project is currently not available in any public Maven repository, so the installation requires a few manual steps.

1.  clone the repository `git clone https://github.com/skhome/gradle-less-plugin.git`
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
		force true
		compress true
	    customJs 'http://lesscss.googlecode.com/files/less-1.3.0.min.js'
	}
