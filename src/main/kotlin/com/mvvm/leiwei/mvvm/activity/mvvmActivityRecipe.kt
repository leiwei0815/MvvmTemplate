package com.mvvm.leiwei.mvvm.activity

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifest
import com.mvvm.leiwei.mvvm.activity.src.app_package.ui.mvvmActivityKt
import com.mvvm.leiwei.mvvm.activity.src.app_package.ui.mvvmFragmentKt
import com.mvvm.leiwei.mvvm.activity.src.app_package.ui.mvvmLazyFragmentKt
import com.mvvm.leiwei.mvvm.common.repository.mvvmRepositoryKt
import com.mvvm.leiwei.mvvm.common.res.layout.mvvmXml
import com.mvvm.leiwei.mvvm.common.viewmodel.mvvmViewModelKt

fun RecipeExecutor.mvvmActivityRecipe(
    moduleTemplateData: ModuleTemplateData,
    mRootPackageName: String,
    mPageName: String,
    mIsActivity: Boolean,
    mActivityLayoutName: String,
    mIsGenerateActivityLayout: Boolean,
    mActivityPackageName: String,
    mIsUseHilt: Boolean,
    mIsFragment: Boolean,
    mIsLazyFragment: Boolean,
    mFragmentLayoutName: String,
    mIsGenerateFragmentLayout: Boolean,
    mFragmentPackageName: String
) {
    val (projectData, srcOut, resOut) = moduleTemplateData
    val ktOrJavaExt = projectData.language.extension

    if (mIsActivity) {
        //清单文件配置
        generateManifest(
            moduleData = moduleTemplateData,
            activityClass = "${mPageName}Activity",
            packageName = "${mRootPackageName}.${mActivityPackageName.replace("/", ".")}",
            isLauncher = false,
            hasNoActionBar = false,
            generateActivityTitle = false
        )

        //layout xml 文件名生成binding名
        var transActivityBinding = StringBuilder()
        mActivityLayoutName.split("_").onEach {
            var s = it.capitalize()
            transActivityBinding.append(s)
        }

        val mvvmActivity = mvvmActivityKt(
            mRootPackageName,
            mActivityPackageName.replace("/", "."),
            mPageName,
            transActivityBinding.toString(),
            mActivityLayoutName
        )
        // 保存Activity
        save(
            mvvmActivity,
            srcOut.resolve("${mActivityPackageName}/view/${mPageName}Activity.${ktOrJavaExt}")
        )
        if (mIsGenerateActivityLayout) {
            // 保存xml
            save(
                mvvmXml(mRootPackageName,mActivityPackageName.replace("/", ".")+".model", mPageName),
                resOut.resolve("layout/${mActivityLayoutName}.xml")
            )
        }
        // 保存viewmodel
        save(
            mvvmViewModelKt(mRootPackageName, mActivityPackageName.replace("/", "."), mPageName),
            srcOut.resolve("${mActivityPackageName}/model/${mPageName}ViewModel.${ktOrJavaExt}")
        )
        // 保存repository
        save(
            mvvmRepositoryKt(mRootPackageName, mActivityPackageName.replace("/", ".")+".repository", mPageName),
            srcOut.resolve("${mActivityPackageName}/repository/${mPageName}Repository.${ktOrJavaExt}")
        )
    } else if (mIsFragment) {

        //layout xml 文件名生成binding名
        var transFragmentBinding = StringBuilder()
        mFragmentLayoutName.split("_").onEach {
            var s = it.capitalize()
            transFragmentBinding.append(s)
        }

        val mvvmFragment: String = if (mIsLazyFragment) {

            mvvmLazyFragmentKt(
                mRootPackageName,
                mFragmentPackageName.replace("/", ".")+".view",
                mPageName,
                transFragmentBinding.toString()
            )
        } else {
            mvvmFragmentKt(
                mRootPackageName,
                mFragmentPackageName.replace("/", "."),
                mPageName,
                transFragmentBinding.toString(),
                mFragmentLayoutName
            )
        }

        // 保存Fragment
        save(
            mvvmFragment,
            srcOut.resolve("${mFragmentPackageName}/view/${mPageName}Fragment.${ktOrJavaExt}")
        )
        if (mIsGenerateFragmentLayout) {
            // 保存xml
            save(
                mvvmXml(mRootPackageName,  mFragmentPackageName.replace("/", ".")+".model", mPageName),
                resOut.resolve("layout/${mFragmentLayoutName}.xml")
            )
        }
        // 保存viewmodel
        save(
            mvvmViewModelKt(mRootPackageName, mFragmentPackageName.replace("/", "."), mPageName),
            srcOut.resolve("${mFragmentPackageName}/model/${mPageName}ViewModel.${ktOrJavaExt}")
        )
        // 保存repository
        save(
            mvvmRepositoryKt(mRootPackageName, mFragmentPackageName.replace("/", ".")+".repository", mPageName),
            srcOut.resolve("${mFragmentPackageName}/repository/${mPageName}Repository.${ktOrJavaExt}")
        )
    }
}