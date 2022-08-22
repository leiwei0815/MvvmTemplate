package com.mvvm.leiwei.mvvm.item

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifest


fun RecipeExecutor.mvvmItemRecipe(
    moduleTemplateData: ModuleTemplateData,
    mRootPackageName: String,
    mPageName: String,
    mActivityPackageName: String,
    mActivityLayoutName: String,
) {
    val (projectData, srcOut, resOut) = moduleTemplateData
    val ktOrJavaExt = projectData.language.extension

    val mvvmItem = mvvmItemKt(
        mRootPackageName,
        mActivityPackageName.replace("/", ".")+".view",
        mPageName,
        mActivityLayoutName
    )
    // 保存Activity
    save(
        mvvmItem,
        srcOut.resolve("${mActivityPackageName}/view/${mPageName}Item.${ktOrJavaExt}")
    )
    // 保存xml
    save(
        itemXml(mRootPackageName, mActivityPackageName.replace("/", "."), mPageName),
        resOut.resolve("layout/${mActivityLayoutName}.xml") //item_
    )
}