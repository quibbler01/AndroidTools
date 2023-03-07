package com.quibbler.toolstest.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.quibbler.androidtools.framework.SystemPropertiesClassName
import com.quibbler.androidtools.framework.getProperty
import com.quibbler.androidtools.framework.setProperty
import com.quibbler.toolstest.databinding.ActivityTestSystemPropertiesUtilsBinding
import java.lang.reflect.Method

class TestSystemPropertiesUtilsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTestSystemPropertiesUtilsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestSystemPropertiesUtilsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.get.setOnClickListener {
            val pro = getProperty("selinux.restorecon_recursive", "null")
            binding.console.append("$pro \n")
        }

        binding.set.setOnClickListener {
            setProperty(TestSystemPropertiesUtilsActivity::javaClass.name, TestSystemPropertiesUtilsActivity::javaClass.name)
        }
    }

}