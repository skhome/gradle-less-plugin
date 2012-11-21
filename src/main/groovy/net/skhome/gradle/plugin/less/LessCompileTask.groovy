package net.skhome.gradle.plugin.less

import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import org.gradle.api.file.FileTree
import org.gradle.api.internal.file.FileResolver
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.util.PatternSet
import org.lesscss.LessCompiler
import org.lesscss.LessSource

/**
 * Gradle task to compile LESS stylesheets to CSS.
 *
 * @author Sascha Krüger
 */
class LessCompileTask extends DefaultTask {

	/**
	 * Contains the directory with the source files.
	 */
	@InputDirectory
	File sourceDir

	/**
	 * Contains the directory with the output files.
	 */
	@OutputDirectory
	File outputDir

	/**
	 * Specifies a pattern for the source files to be included.
	 */
	@Input
	List<String> includes = []

	/**
	 * Specifies a pattern for the source files to be excluded.
	 */
	@Input
	List<String> excludes = []

	/**
	 * Specifies if only to compile the LESS input file in case the
	 * LESS source has been modified (including imports) or if the
	 * output file does not exists. If set to true input files will
	 * always be recompiled.
	 */
	@Input
	boolean force

	/**
	 * Specifies whether you want the compiler to compress the output files.
	 */
	@Input
	boolean compress

	/**
	 * Specifies the encoding of your input files.
	 */
	@Input
	String encoding

	/**
	 * Specifies a custom less JS file
	 */
	@Input
	URL customJs

	private FileResolver fileResolver
	private PatternSet patternSet

	LessCompileTask() {
		fileResolver = getServices().get(FileResolver)
		patternSet = new PatternSet()
	}

	@TaskAction
	def compile() {

		LessCompiler compiler = new LessCompiler()
		compiler.setCompress(getCompress())
		compiler.setEncoding(getEncoding())
		compiler.setCustomJs(getCustomJs())

		patternSet.setIncludes(getIncludes())
		patternSet.setExcludes(getExcludes())

		final FileTree files = fileResolver.resolveFilesAsTree(getSourceDir()).matching(patternSet)
		for (File inputFile : files) {
			final File outputFile = new File(getOutputDir(), inputFile.name.replace('.less', '.css'))
			if (!outputFile.parentFile.exists() && !outputFile.parentFile.mkdirs()) {
				throw new GradleException("Cannot create output directory ${outputFile.parentFile}")
			}

			final LessSource source = new LessSource(inputFile)
			compiler.compile(source, outputFile, getForce())
		}

	}

}
