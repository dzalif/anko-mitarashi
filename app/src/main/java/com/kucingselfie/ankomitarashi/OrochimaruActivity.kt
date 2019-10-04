package com.kucingselfie.ankomitarashi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.jetbrains.anko.*

class OrochimaruActivity : AppCompatActivity() {

    private var name: String = ""
    lateinit var nameTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            padding = dip(16)
            nameTextView = textView()
        }

        val intent = intent
        @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
        name = intent.getStringExtra("name")
        nameTextView.text = name
    }
}
