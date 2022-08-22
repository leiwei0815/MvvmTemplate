package com.mvvm.leiwei.mvvm.common.viewmodel

fun mvvmViewModelKt(
    mRootPackageName:String,
    mActivityPackageName:String,
    mPageName:String
) = """
package ${mRootPackageName}.${mActivityPackageName}.model
 
 
import com.music.common.TzViewModel
import ${mRootPackageName}.${mActivityPackageName}.repository.${mPageName}Repository

class ${mPageName}ViewModel : TzViewModel() {

    private val m${mPageName}Repository by lazy { ${mPageName}Repository() }

    fun initData() {
        complete()
    }

}
"""
