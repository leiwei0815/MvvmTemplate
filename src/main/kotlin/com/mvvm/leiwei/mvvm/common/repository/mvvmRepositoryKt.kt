package com.mvvm.leiwei.mvvm.common.repository

fun mvvmRepositoryKt(
    mRootPackageName:String,
    mActivityPackageName:String,
    mPageName:String
) = """
package ${mRootPackageName}.${mActivityPackageName}

import com.music.common.log.TzLogApi
import com.music.common.network.TzNetworkApi


class ${mPageName}Repository : TzNetworkApi, TzLogApi {

}

"""
