
package com.mvvm.leiwei.mvvm.item

fun mvvmItemKt(
    mRootPackageName:String?,
    mActivityPackageName:String,
    mPageName:String,
    mLayoutName:String,
)="""
package ${mRootPackageName}.${mActivityPackageName}

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import $mRootPackageName.R
import com.music.common.dazzle.Item

class ${mPageName}Item : Item<${mPageName}Model>() {

    override fun itemCreate(context: Context, parent: ViewGroup): View {
        return LayoutInflater.from(context).inflate(R.layout.${mLayoutName}, parent, false)
    }

    override fun itemBuild(item: View?, index: Int, data: ${mPageName}Model) {

    }

}

class ${mPageName}Model(

)
"""
