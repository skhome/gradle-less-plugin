package net.skhome.gradle.plugin.less

import org.gradle.api.Project
import org.junit.Before
import org.junit.Test
import org.gradle.testfixtures.ProjectBuilder

class LessPluginExtensionTest {

    private Project project

    private LessPluginExtension extension

    @Before
    void prepare() {
	    project = ProjectBuilder.builder().build()
        extension = new LessPluginExtension(project)
    }

    @Test
    void shouldProvideSourceDirectoryProperty() {

        // when
        extension.sourceDir = project.file('web/less')

        // then
        assert extension.sourceDir == project.file('web/less')
    }

    @Test
    void shouldProvideSourceDirectoryConvenience() {

        // when
        extension.sourceDir 'web/less'

        // then
        assert extension.sourceDir instanceof File
        assert extension.sourceDir == project.file('web/less')
    }

    @Test
    void shouldProvideSourceDirectoryDefault() {
        assert extension.sourceDir
    }

    @Test
    void shouldProvideOutputDirectoryProperty() {

        // when
        extension.outputDir = project.file('web/css')

        // then
        assert extension.outputDir == project.file('web/css')
    }

    @Test
    void shouldProvideOutputDirectoryConvenience() {

        // when
        extension.outputDir 'web/css'

        // then
        assert extension.outputDir instanceof File
        assert extension.outputDir == project.file('web/css')
    }

    @Test
    void shouldProvideOutputDirectoryDefault() {
        assert extension.outputDir
    }

    @Test
    void shouldProvideIncludesProperty() {

        // when
        extension.includes = ['*.less']

        // then
        assert extension.includes == ['*.less']
    }

    @Test
    void shouldProvideIncludesConvenience() {

        // when
        extension.includes 'styles.less', 'animation.less'

        // then
        assert extension.includes == ['styles.less', 'animation.less']
    }

    @Test
    void shouldProvideIncludeDirectoryDefault() {
        assert extension.includes
    }

    @Test
    void shouldProvideExcludesProperty() {

        // when
        extension.excludes = ['foo.less']

        // then
        assert extension.excludes == ['foo.less']
    }

    @Test
    void shouldProvideExcludesConvenience() {

        // when
        extension.excludes 'foo.less', 'bar.less'

        // then
        assert extension.excludes == ['foo.less', 'bar.less']
    }

    @Test
    void shouldProvideExcludeDirectoryDefault() {
        assert extension.excludes.isEmpty()
    }

	@Test
	void shouldProvideForceProperty() {

		// when
		extension.force = true

		// then
		assert extension.force
	}

	@Test
	void shouldProvideForceConvenience() {

		// when
		extension.force true

		// then
		assert extension.force
	}

	@Test
	void shouldProvideForceDefault() {
		assert !extension.force
	}

	@Test
	void shouldProvideCompressProperty() {

		// when
		extension.compress = true

		// then
		assert extension.compress
	}

	@Test
	void shouldProvideCompressConvenience() {

		// when
		extension.compress true

		// then
		assert extension.compress
	}

	@Test
	void shouldProvideCompressDefault() {
		assert !extension.compress
	}

	@Test
	void shouldProvideEncodingProperty() {

		// when
		extension.encoding = 'UTF-8'

		// then
		assert extension.encoding == 'UTF-8'
	}

	@Test
	void shouldProvideEncodingConvenience() {

		// when
		extension.encoding 'UTF-8'

		// then
		assert extension.encoding == 'UTF-8'
	}

	@Test
	void shouldProvideEncodingDefault() {
		assert extension.encoding
	}

	@Test
	void shouldProvideCustomJsProperty() {

		// assume
		final String url = 'http://server/less.js'

		// when
		extension.customJs = new URL(url)

		// then
		assert extension.customJs.toString() == url
	}

	@Test
	void shouldProvideCustomJsConvenience() {

		// assume
		final String url = 'http://server/less.js'

		// when
		extension.customJs url

		// then
		assert extension.customJs.toString() == url
	}

}
