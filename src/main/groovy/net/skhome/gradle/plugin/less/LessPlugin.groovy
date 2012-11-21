package net.skhome.gradle.plugin.less

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.BasePlugin

/**
 * A Gradle plugin that will use the LESS compiler to compile LESS stylesheets to CSS.
 *
 * @author Sascha Krüger
 */
class LessPlugin implements Plugin<Project> {

    static final String EXTENSION_NAME = "less"
	static final String COMPILE_TASK_NAME = "compileLESS"

    private Project project
    private LessPluginExtension extension

    void apply(final Project project) {
        this.project = project
	    assertDependencies()
        createExtension()
	    createCompileTask()
    }

	private void assertDependencies() {
		project.plugins.apply(BasePlugin)
	}

    private void createExtension() {
        extension = project.extensions.create(EXTENSION_NAME, LessPluginExtension, project)
    }

	private void createCompileTask() {
		project.tasks.add(COMPILE_TASK_NAME, LessCompileTask)
		project.tasks.findByName(BasePlugin.ASSEMBLE_TASK_NAME).dependsOn(COMPILE_TASK_NAME);

		project.tasks.withType(LessCompileTask) { LessCompileTask task ->
			configureCompileTask(task)
		}
	}

	private void configureCompileTask(final LessCompileTask task) {
		task.conventionMapping.with {
			sourceDir = { extension.sourceDir }
			outputDir = { extension.outputDir }
			includes = { extension.includes }
			excludes = { extension.excludes }
			force = { extension.force }
			compress = { extension.compress }
			encoding = { extension.encoding }
			customJs = { extension.customJs }
		}
	}

}
