package com.petroll.baseclasses

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.petroll.R
import com.petroll.databinding.ActivityBaseBinding

open class BaseActivity : AppCompatActivity() {

    lateinit var baseBinding : ActivityBaseBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        baseBinding = ActivityBaseBinding.inflate(layoutInflater)
        super.setContentView(baseBinding.root)
    }

    override fun setContentView(layoutResID: Int) {
        layoutInflater.inflate(layoutResID, baseBinding.content)
    }
}