package com.victor.creativenaija

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.victor.creativenaija.databinding.ActivityAccountBinding

class AccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityAccountBinding
        binding = ActivityAccountBinding.inflate(LayoutInflater.from(this))
        val view = binding.root
        setContentView(view)


        binding.btnMale.setOnClickListener(View.OnClickListener {
//            edtNote.setText("Documents Include personnal files of certificates that can easilty be Hand Held.")
            if (binding.btnFemale.isChecked()) {
                binding.btnMale.toggle()
                binding.btnFemale.setChecked(false)
//                documentType = "Document"
            } else {
                binding.btnMale.toggle()
            }
        })
        binding.btnFemale.setOnClickListener(View.OnClickListener {
//            edtNote.setText("Parcel Include Psckages that are Larger in size which consume more Spaces than Documents")
            if (binding.btnMale.isChecked()) {
                binding.btnFemale.toggle()
                binding.btnMale.setChecked(false)
//                documentType = "Parcel"
            } else {
                binding.btnFemale.toggle()
            }
        })
    }
}