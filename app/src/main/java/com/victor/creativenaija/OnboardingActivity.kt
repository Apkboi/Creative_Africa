package com.victor.creativenaija

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import androidx.viewpager.widget.ViewPager
import com.victor.creativenaija.adapters.ViewPagerAdapter
import com.victor.creativenaija.databinding.ActivityOnboardingBinding

class OnboardingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityOnboardingBinding
        binding = ActivityOnboardingBinding.inflate(LayoutInflater.from(this))
        val view = binding.root
        setContentView(view)

        val pager = findViewById<ViewPager>(R.id.pager)
        pager.adapter = ViewPagerAdapter(this)



        binding.txtIndicaor1.setText(Html.fromHtml("&#8226;"))
        binding.txtIndicaor2.setText(Html.fromHtml("&#8226;"))
        binding.txtIndicaor3.setText(Html.fromHtml("&#8226;"))
        pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            @SuppressLint("ResourceAsColor")
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                if (position == 0) {
                   binding.txtIndicaor1.setTextColor(resources.getColor(R.color.white))

                } else {
                    binding.txtIndicaor1.setTextColor(resources.getColor(R.color.sandyBrown))
                }
                if (position == 1) {
                    binding.txtIndicaor2.setTextColor(resources.getColor(R.color.white))

                } else {
                    binding.txtIndicaor2.setTextColor(resources.getColor(R.color.sandyBrown))
                }
                if (position == 2) {

                    binding.txtIndicaor3.setTextColor(resources.getColor(R.color.white))
                } else {
                    binding.txtIndicaor3.setTextColor(resources.getColor(R.color.sandyBrown))
                }

            }

            override fun onPageSelected(position: Int) {

            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })

        binding.txtSignUp.setOnClickListener {startActivity(Intent(this,LoginActivity::class.java))
            finish()  }
        binding.btnLogin.setOnClickListener { startActivity(Intent(this,MainActivity::class.java))
        finish()}
    }
}