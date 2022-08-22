package com.mvvm.leiwei.mvvm.item

import com.android.tools.idea.wizard.template.WizardUiContext
import com.android.tools.idea.wizard.template.template
import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import com.intellij.ui.layout.checkBoxFollowedBySpinner
import java.lang.StringBuilder

/**
 * 模版界面配置
 */
val mvvmItemTemplate
    get() = template {
//        revision = 1
        name = "Item Template"
        description = "一键创建 所需要的Item"
        minApi = MIN_API
        minApi = MIN_API
        category = Category.Other
        formFactor = FormFactor.Mobile
        screens = listOf(
            WizardUiContext.ActivityGallery,
            WizardUiContext.MenuEntry,
            WizardUiContext.NewProject,
            WizardUiContext.NewModule
        )


        val mRootPackageName = stringParameter {
            name = "Root Package Name"
            constraints = listOf(Constraint.PACKAGE)
            default = "com.music.main"
            visible = { !isNewModule }
            help = "默认包名为项目的包名,可根据自己需要填写"
        }

        val mPageName = stringParameter {
            name = "Create Page Name"
            constraints = listOf(Constraint.UNIQUE, Constraint.NONEMPTY)
            default = "Item"
            help = "需要生成页面的名字,不需要再写 名字后缀:Item,会自动生成,以及对应文件名后缀"
        }


        val mActivityLayoutName = stringParameter {
            name = "Item Layout Name"
            default = "item_item"
            constraints = listOf(Constraint.LAYOUT, Constraint.NONEMPTY)
            suggest = { "item_"+ createLayoutName(mPageName.value) } //.toLowerCase()
        }


        val mActivityPackageName = stringParameter {
            name = "item Package Name"
            constraints = listOf(Constraint.NONEMPTY)
            default = "ui"
            help = "item 将被输出到此包下,使用二级目录请使用/ ,PS:ui/test,请认真核实此包名是否是你需要输出的目标包名 (基于 Root Package Name )"
        }


        widgets(
            PackageNameWidget(mRootPackageName),
            TextFieldWidget(mPageName),
            TextFieldWidget(mActivityLayoutName),
            TextFieldWidget(mActivityPackageName),
        )

        recipe = { data: TemplateData ->
            mvvmItemRecipe(
                data as ModuleTemplateData,
                mRootPackageName.value,
                mPageName.value,
                mActivityPackageName.value,
                mActivityLayoutName.value,
            )
        }

    }

fun createLayoutName(className: String): String {
    val array = className.toCharArray()
    val string = StringBuilder()
    array.forEach {
        if (it.isUpperCase()) {
            //第一个首字母大写的话 不加下划线
            if (string.isNotEmpty()) {
                string.append("_")
            }
            string.append(it.toLowerCase())
        } else {
            string.append(it)
        }
    }
    return string.toString()
}
