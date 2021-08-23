package com.victor.creativenaija

import android.content.Intent
import android.os.Bundle
import android.provider.SyncStateContract
import android.view.LayoutInflater
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.switchmaterial.SwitchMaterial
import com.victor.creativenaija.databinding.ActivityProfileBinding
import com.victor.creativenaija.utils.Constants

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var binding: ActivityProfileBinding? = null
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(LayoutInflater.from(this))
        val view = binding.root
        setContentView(view)


        binding.btnSwitchMode.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { compoundButton, isCheked ->
            if (isCheked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                if ( AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }

            }
        })
        binding.cardAccount.setOnClickListener {
            startActivity(Intent(this, AccountActivity::class.java))
        }

        binding.btnFund.setOnClickListener {
            startActivityForResult(Intent(this,FundWalletActivity::class.java),Constants.JOIN_REQUEST_CODE)
        }
    }
}


