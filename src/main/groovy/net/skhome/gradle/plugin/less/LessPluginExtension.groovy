package net.skhome.gradle.plugin.less

import org.gradle.api.Project

/**
 * Provides configuration options for the LESS plugin.
 *
 * @author Sascha Krüger
 *
 * @see LessPlugin
 */
class LessPluginExtension {

    private final Project project

    LessPluginExtension(final Project project) {
        this.project = project
    }

    /**
     * Contains the directory with the source files. (defaults to 'src/main/webapp/less')
     *
     * Example: sourceDir = file('web/less')
     */
    File sourceDir = project.file('src/main/webapp/less')

    /**
     * Convenience method for setting the source directory.
     *
     * Example: sourceDir 'web/less'
     */
    void sourceDir(final String dir) {
        this.sourceDir = project.file(dir);
    }

    /**
     * Contains the directory with the output files. (defaults to 'build/webapp/css')
     *
     * Example: outputDir = files('web/css')
     */
    File outputDir = project.file("src/main/webapp/css")

    /**
     * Convenience method for setting the output directory.
     *
     * Example: outputDir 'web/css'
     */
    void outputDir(final String dir) {
        this.outputDir = project.file(dir);
    }

    /**
     * Specifies a pattern for the source files to be included. (defaults to '** / *.less')
     *
     * Example: includes = ['styles.less']
     */
    List<String> includes = ['**/*.less']

    /**
     * Convenience method for setting includes.
     *
     * Example: includes 'styles.less', 'animation.less'
     */
    void includes(final String... pattern) {
        this.includes.clear();
        this.includes.addAll(pattern);
    }

    /**
     * Specifies a pattern for the source files to be excluded.
     *
     * Example: excludes = ['reset.less']
     */
    List<String> excludes = []

    /**
     * Convenience method for setting excludes.
     *
     * Example: excludes 'foo.less', 'bar.less'
     */
    void excludes(final String... pattern) {
        this.excludes.clear();
        this.excludes.addAll(pattern);
    }

    /**
     * Specifies if only to compile the LESS input file in case the
     * LESS source has been modified (including imports) or if the
     * output file does not exists. If set to true input files will
     * always be recompiled. (defaults to false)
     *
     * Example: force = true
     */
    boolean force = false

	/**
	 * Convenience method for setting force.
	 *
	 * Example: force true
	 */
	void force(final boolean force) {
		this.force = force;
	}

	/**
	 * Specifies whether you want the compiler to compress the output files. (defaults to false)
	 *
	 * Example: compress = true
	 */
	boolean compress = false

	/**
	 * Convenience method for setting compress.
	 *
	 * Example: compress true
	 */
	void compress(final boolean compress) {
		this.compress = compress
	}

	/**
	 * Specifies the encoding of your input files. (defaults to 'UTF-8')
	 *
	 * Example: encoding = 'ISO-8859-1'
	 */
	String encoding = 'UTF-8'

	/**
	 * Convenience method for setting the encoding.
	 *
	 * Example: encoding 'ISO-8859-1'
	 */
	void encoding(final String encoding) {
		this.encoding = encoding
	}

	/**
	 * Specifies a custom JS for the less compiler.
	 *
	 * Example: customJs = new URL('http://lesscss.googlecode.com/files/less-1.3.0.min.js')
	 */
	URL customJs

	/**
	 * Convenience method for setting a custom JS.
	 *
	 * Example: customJs 'http://lesscss.googlecode.com/files/less-1.3.0.min.js'
	 */
	void customJs(final String customJs) {
		this.customJs = new URL(customJs)
	}

}
