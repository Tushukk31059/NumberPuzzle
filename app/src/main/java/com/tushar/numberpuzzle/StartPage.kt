package com.tushar.numberpuzzle

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class StartPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_start_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val play: ImageButton = findViewById(R.id.play)
        play.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val share: ImageButton = findViewById(R.id.share)
        share.setOnClickListener {
            shareApp()
        }

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                showExitDialog()
            }
        })
    }

    private fun shareApp() {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_TEXT,"https://github.com/Tushukk31059/NumberPuzzle/releases")
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Share Number Puzzle App")
        startActivity(Intent.createChooser(shareIntent, "Share via"))
    }





private fun showExitDialog() {
    val dialog = AlertDialog.Builder(this, R.style.ExitDialog)
        .setMessage("Are you sure you want to exit?")
        .setCancelable(false)
        .setPositiveButton("Yes") { _, _ ->
            finish()  // Or moveTaskToBack(true) if you want to keep the app in background
        }
        .setNegativeButton("No") { dialog, _ ->
            dialog.dismiss()
        }
        .create()

    dialog.show()
    dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(ContextCompat.getColor(this, R.color.black))
    dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(ContextCompat.getColor(this, R.color.black))
}}