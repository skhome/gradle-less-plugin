package net.skhome.gradle.plugin.less

import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.plugins.BasePlugin
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Before
import org.junit.Test

class LessPluginTest {

	private Project project

	private LessPlugin plugin

	@Before
	void prepare() {
		project = ProjectBuilder.builder().build()
		plugin = new LessPlugin()
	}

	@Test
	void shouldApplyBasePlugin() {

		// when
		plugin.apply(project)

		// then
		assert project.plugins.findPlugin(BasePlugin)
	}

	@Test
	void shouldRegisterExtension() {

		// when
		plugin.apply(project)

		// then
		assert project.extensions.getByName(LessPlugin.EXTENSION_NAME) instanceof LessPluginExtension
	}

	@Test
	void shouldRegisterCompileTask() {

		// when
		plugin.apply(project)

		// then
		final Task compileTask = project.tasks.findByName(LessPlugin.COMPILE_TASK_NAME)
		assert compileTask
	}

	@Test
	void shouldIntegrateCompileTaskInDependencyGraph() {

		// when
		plugin.apply(project)

		// then
		final Task compileTask = project.tasks.findByName(BasePlugin.ASSEMBLE_TASK_NAME)
		assert compileTask.dependsOn.contains(LessPlugin.COMPILE_TASK_NAME)
	}

	@Test
	void shouldConfigureSourceDirWithExtension() {

		// assume
		final source = 'web/less'

		// given
		plugin.apply(project)

		// when
		project.less {
			sourceDir source
		}

		// then
		final LessCompileTask compileTask = project.tasks.findByName(LessPlugin.COMPILE_TASK_NAME) as LessCompileTask
		assert compileTask.sourceDir == project.file(source)
	}

	@Test
	void shouldConfigureOutputDirWithExtension() {

		// assume
		final String target = 'web/css'

		// given
		plugin.apply(project)

		// when
		project.less {
			outputDir target
		}

		// then
		final LessCompileTask compileTask = project.tasks.findByName(LessPlugin.COMPILE_TASK_NAME) as LessCompileTask
		assert compileTask.outputDir == project.file(target)
	}

	@Test
	void shouldConfigureIncludesWithExtension() {

		// assume
		final String pattern = 'styles.less'

		// given
		plugin.apply(project)

		// when
		project.less {
			includes pattern
		}

		// then
		final LessCompileTask compileTask = project.tasks.findByName(LessPlugin.COMPILE_TASK_NAME) as LessCompileTask
		assert compileTask.includes == [pattern]
	}

	@Test
	void shouldConfigureExcludesWithExtension() {

		// assume
		final String pattern = 'styles.less'

		// given
		plugin.apply(project)

		// when
		project.less {
			excludes pattern
		}

		// then
		final LessCompileTask compileTask = project.tasks.findByName(LessPlugin.COMPILE_TASK_NAME) as LessCompileTask
		assert compileTask.excludes == [pattern]
	}

	@Test
	void shouldConfigureForceWithExtension() {

		// assume
		final boolean option = true

		// given
		plugin.apply(project)

		// when
		project.less {
			force = option
		}

		// then
		final LessCompileTask compileTask = project.tasks.findByName(LessPlugin.COMPILE_TASK_NAME) as LessCompileTask
		assert compileTask.force == option
	}

	@Test
	void shouldConfigureCompressWithExtension() {

		// assume
		final boolean option = true

		// given
		plugin.apply(project)

		// when
		project.less {
			compress = option
		}

		// then
		final LessCompileTask compileTask = project.tasks.findByName(LessPlugin.COMPILE_TASK_NAME) as LessCompileTask
		assert compileTask.compress == option
	}

	@Test
	void shouldConfigureEncodingWithExtension() {

		// assume
		final String name = 'ISO-8859-1'

		// given
		plugin.apply(project)

		// when
		project.less {
			encoding = name
		}

		// then
		final LessCompileTask compileTask = project.tasks.findByName(LessPlugin.COMPILE_TASK_NAME) as LessCompileTask
		assert compileTask.encoding == name
	}


}
