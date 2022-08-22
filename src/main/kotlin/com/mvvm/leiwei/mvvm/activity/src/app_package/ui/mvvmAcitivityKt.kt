
package com.mvvm.leiwei.mvvm.activity.src.app_package.ui

fun mvvmActivityKt(
    mRootPackageName:String?,
    mActivityPackageName:String,
    mPageName:String,
    mActivityLayoutName:String,
    mLayoutName:String,
)="""
package ${mRootPackageName}.${mActivityPackageName}.view


import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.music.common.TzDBActivity
import com.music.common.impl.DefaultAppBar
import com.music.common.impl.viewModels
import $mRootPackageName.R
import ${mRootPackageName}.${mActivityPackageName}.model.${mPageName}ViewModel
import $mRootPackageName.databinding.Activity${mPageName}Binding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@Route(path = "")
class ${mPageName}Activity : TzDBActivity<${mPageName}ViewModel,${mActivityLayoutName}Binding>() {

  override val mViewModel: ${mPageName}ViewModel by viewModels()
  
  override fun bindLayoutId(): Int = R.layout.${mLayoutName}

    override fun initData() {
        mViewModel.initData()
    }

    override val topBarView: View? by lazy {
        DefaultAppBar(this).createAppBar(contentView as ViewGroup).apply {
            //不需要AppBar可以移除
        }.build()
    }

    override fun initView(view: View) {
        mDataBinding?.apply {
            model = mViewModel
        }

    }
 }   
"""
