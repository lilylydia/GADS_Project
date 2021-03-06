package com.example.aad_project.Screens

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.aad_project.Adapters.SectionsPagerAdapter
import com.example.aad_project.R
import com.example.aad_project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        mBinding.viewPager.adapter = sectionsPagerAdapter

        mBinding.tabs.setupWithViewPager(mBinding.viewPager)

        mBinding.btnSubmit.setOnClickListener {
            startActivity(Intent(this, SubmitActivity::class.java))
        }

    }
}