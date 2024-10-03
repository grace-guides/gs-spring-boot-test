package grace.guides

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class HelloControllerSpec extends Specification implements ControllerUnitTest<HelloController> {

    def setup() {
        mockController(HelloController)
    }

    def cleanup() {
    }

    void "Hello"() {
        when:
            controller.index()
        then:"Hello World"
            view == '/hello/index.gsp'
            response.text == 'Hello, World'
    }
}
