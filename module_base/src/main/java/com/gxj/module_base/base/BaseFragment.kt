package com.gxj.module_base.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseFragment : Fragment() {

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        Log.e("gxj : ${this::class.java.simpleName}", "setUserVisibleHint : $isVisibleToUser")
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.e("gxj : ${this::class.java.simpleName}", "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("gxj : ${this::class.java.simpleName}", "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("gxj : ${this::class.java.simpleName}", "onCreateView")
        val view = inflater.inflate(getLayoutId(), container, false)
        return if (view == null) {
            view
        } else {
            super.onCreateView(inflater, container, savedInstanceState)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("gxj : ${this::class.java.simpleName}", "onViewCreated")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.e("gxj : ${this::class.java.simpleName}", "onActivityCreated")
        initView()
    }

    override fun onStart() {
        super.onStart()
        Log.e("gxj : ${this::class.java.simpleName}", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("gxj : ${this::class.java.simpleName}", "onResume")
    }
    

    override fun onPause() {
        super.onPause()
        Log.e("gxj : ${this::class.java.simpleName}", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("gxj : ${this::class.java.simpleName}", "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("gxj : ${this::class.java.simpleName}", "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("gxj : ${this::class.java.simpleName}", "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("gxj : ${this::class.java.simpleName}", "onDetach")
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        Log.e("gxj : ${this::class.java.simpleName}", "onHiddenChanged")
    }


    abstract fun getLayoutId(): Int

    abstract fun initView()
}