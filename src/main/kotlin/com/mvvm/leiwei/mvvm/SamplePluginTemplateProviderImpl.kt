package com.mvvm.leiwei.mvvm
import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import com.mvvm.leiwei.mvvm.activity.mvvmActivityTemplate
import com.mvvm.leiwei.mvvm.item.mvvmItemTemplate

class SamplePluginTemplateProviderImpl : WizardTemplateProvider() {
    override fun getTemplates(): List<Template> = listOf(
        mvvmActivityTemplate,
        mvvmItemTemplate
    )
}