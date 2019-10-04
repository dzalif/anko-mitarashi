package com.kucingselfie.ankomitarashi

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import org.jetbrains.anko.*
import org.jetbrains.anko.design.snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)
    }

    class MainActivityUI : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            verticalLayout {
                padding = dip(16)
                val name = editText {
                    hint = "Hi, write your name please"
                }

                //Button
                button("Say Hello") {
                    backgroundColor = ContextCompat.getColor(context, R.color.colorAccent)
                    textColor = Color.WHITE
                    setOnClickListener { toast("Hello, ${name.text}") }
                }.lparams(width = matchParent) {
                    topMargin = dip(5)
                }

                //Alert
                button("Show Alert") {
                    backgroundColor = ContextCompat.getColor(context, R.color.colorAccent)
                    textColor = Color.WHITE
                    setOnClickListener {
                        alert("Hello, ${name.text}") {
                            yesButton { toast("Oh..")}
                            noButton { }
                        }.show()
                    }
                }.lparams(width = matchParent) {
                    topMargin = dip(5)
                }

                //Button Selector
                button("Show Selector") {
                    backgroundColor = ContextCompat.getColor(context, R.color.colorAccent)
                    textColor = Color.WHITE

                    setOnClickListener {
                        val club = listOf("Barcelona", "Real Madrid", "Bayern Munchen", "Liverpool")
                        selector("Hello, ${name.text}! What's football club do you love?", club) { _, i ->
                            toast("So you love ${club[i]}, right?")
                        }
                    }
                }.lparams(width = matchParent) { topMargin = dip(5) }

                //Button Snackbar
                button("Show Snackbar") {
                    backgroundColor = ContextCompat.getColor(context, R.color.colorAccent)
                    textColor = Color.WHITE
                    setOnClickListener {
                        snackbar("Hello, ${name.text}!")
                    }
                }.lparams(width = matchParent) { topMargin = dip(5)}

                //Intent Activity
                button("Go to Orochimaru Activity") {
                    backgroundColor = ContextCompat.getColor(context, R.color.colorAccent)
                    textColor = Color.WHITE
                    setOnClickListener {
                        startActivity<OrochimaruActivity>("name" to "${name.text}")
                    }
                }.lparams(width = matchParent){
                    topMargin = dip(5)
                }


            }
        }
    }
}
