
package com.mvvm.leiwei.mvvm.activity.src.app_package.ui

fun mvvmFragmentKt(
    mRootPackageName:String?,
    mActivityPackageName:String,
    mPageName:String,
    mActivityLayoutName:String,
    mLayoutName:String,
)="""
package ${mRootPackageName}.${mActivityPackageName}.view
 
import android.view.View
import com.music.common.TzDBFragment
import com.music.common.impl.viewModels
import com.music.common.route.RouterPath 
import com.alibaba.android.arouter.facade.annotation.Route

import $mRootPackageName.R
import ${mRootPackageName}.${mActivityPackageName}.model.${mPageName}ViewModel
import $mRootPackageName.databinding.Fragment${mPageName}Binding
import dagger.hilt.android.AndroidEntryPoint

 @AndroidEntryPoint
 @Route(path = "")
class ${mPageName}Fragment : TzDBFragment<${mPageName}ViewModel,${mActivityLayoutName}Binding>() {
  
  override val mViewModel: ${mPageName}ViewModel by viewModels()
  
  override fun bindLayoutId(): Int = R.layout.${mLayoutName}

    override fun initData() {
        mViewModel.initData()
    }

    override val topBarView: View? = null

    override fun initView(view: View) {
        mDataBinding?.apply {
            model = mViewModel
        }

    }
}
"""
