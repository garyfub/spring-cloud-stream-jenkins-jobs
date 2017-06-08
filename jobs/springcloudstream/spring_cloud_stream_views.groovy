package springcloudstream

import org.springframework.jenkins.common.view.DashboardViewBuilder
import javaposse.jobdsl.dsl.DslFactory

DslFactory dsl = this

new DashboardViewBuilder(this).buildDashboard()

dsl.listView('Seeds') {
    jobs {
        regex('.*-seed')
    }
    columns defaultColumns()
}

dsl.nestedView('SpringCloudStream') {
    views {
        listView('CI') {
            jobs {
                regex('spring-cloud-stream.*-ci')
            }
            columns defaultColumns()
        }
        listView('Spring Cloud Stream') {
            jobs {
                regex('spring-cloud-stream.*')
            }
            columns defaultColumns()
        }
    }
}

private Closure defaultColumns() {
    return {
        status()
        name()
        lastSuccess()
        lastFailure()
        lastBuildConsole()
        buildButton()
    }
}