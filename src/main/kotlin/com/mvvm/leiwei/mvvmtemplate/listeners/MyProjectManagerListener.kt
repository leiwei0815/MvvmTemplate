package com.mvvm.leiwei.mvvmtemplate.listeners

import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManagerListener
import com.mvvm.leiwei.mvvmtemplate.services.MyProjectService

internal class MyProjectManagerListener : ProjectManagerListener {

   companion object {
        var projectInstance: Project? = null
    }

    override fun projectOpened(project: Project) {
        projectInstance = project
        project.getService(MyProjectService::class.java)
    }

    override fun projectClosing(project: Project) {
        projectInstance = null
        super.projectClosing(project)
    }
}
