package com.mvvm.leiwei.mvvmtemplate.services

import com.intellij.openapi.project.Project
import com.mvvm.leiwei.mvvmtemplate.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
