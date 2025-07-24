package com.tushar.numberpuzzle

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var btn1: Button
    private  lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btn6: Button
    private lateinit var btn7: Button
    private lateinit var btn8: Button
    private lateinit var btn9: Button
    private lateinit var btnR: Button
    private lateinit var btnOk: Button
    private lateinit var btnHome: Button
    private var btn = ArrayList<Button>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        btnR = findViewById(R.id.btnR)
        btnHome = findViewById(R.id.btnHome)

        btn.add(btn1)
        btn.add(btn2)
        btn.add(btn3)
        btn.add(btn4)
        btn.add(btn5)
        btn.add(btn6)
        btn.add(btn7)
        btn.add(btn8)
        btn.add(btn9)
        btn.add(btnR)
        btn.add(btnHome)

        click(0)
        click(1)
        click(2)
        click(3)
        click(4)
        click(5)
        click(6)
        click(7)
        click(8)
        click(9)
        click(10)
    }

    private fun click(i: Int) {
        btn[i].setOnClickListener {
            if (i == 0) {
                change(0, 1)
                change(0, 3)
                change(0, 1, 2)
                change(0, 3, 6)
            }
            if (i == 1) {
                change(1, 2)
                change(1, 0)
                change(1, 4)
                change(1, 4, 7)
            }
            if (i == 2) {
                change(2, 1)
                change(2, 5)
                change(2, 1, 0)
                change(2, 5, 8)
            }
            if (i == 3) {
                change(3, 0)
                change(3, 4)
                change(3, 6)
                change(3, 4, 5)
            }
            if (i == 4) {
                change(4, 1)
                change(4, 3)
                change(4, 5)
                change(4, 7)
            }
            if (i == 5) {
                change(5, 2)
                change(5, 4)
                change(5, 8)
                change(5, 4, 3)
            }
            if (i == 6) {
                change(6, 3)
                change(6, 7)
                change(6, 3, 0)
                change(6, 7, 8)
            }
            if (i == 7) {
                change(7, 6)
                change(7, 4)
                change(7, 8)
                change(7, 4, 1)
            }
            if (i == 8) {
                change(8, 5)
                change(8, 7)
                change(8, 7, 6)
                change(8, 5, 2)
            }
            if (i == 9) {
                val ab = ArrayList<String>()
                repeat(9) {
                    while (true) {
                        val a = (Math.random() * 9).toInt()
                        if (!ab.contains("$a")) {
                            ab.add("$a")
                            break
                        }
                    }
                }
                ab[ab.indexOf("0")] = ""
                ab.forEachIndexed { index, _ ->
                    btn[index].text = ab[index]
                }
            }
            if (btn[0].text.toString().equals("1") && btn[1].text.toString()
                    .equals("2") && btn[2].text.toString().equals("3") && btn[3].text.toString()
                    .equals("4") && btn[4].text.toString().equals("5") && btn[5].text.toString()
                    .equals("6") && btn[6].text.toString().equals("7") && btn[7].text.toString()
                    .equals("8")
            ) {
                Toast.makeText(this@MainActivity, "You Win", Toast.LENGTH_LONG).show()
                showWinDialog()
            } else {
            }
        }
        btnHome.setOnClickListener {
            // Redirect to the Start/Home page
            val intent = Intent(this, StartPage::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }
    }

    private fun showWinDialog() {
        val dialogView = layoutInflater.inflate(R.layout.win_dialog, null)
        val dialog = AlertDialog.Builder(this).setView(dialogView).setCancelable(false).create()
        dialog.show()
        val btnOk = dialogView.findViewById<Button>(R.id.btnOk)
        val winHome = dialogView.findViewById<Button>(R.id.winHome)
        btnOk.setOnClickListener {
            dialog.dismiss()
            val ab = ArrayList<String>()
            repeat(9) {
                while (true) {
                    val a = (Math.random() * 9).toInt()
                    if (!ab.contains("$a")) {
                        ab.add("$a")
                        break
                    }
                }
            }
            ab[ab.indexOf("0")] = ""
            ab.forEachIndexed { index, _ ->
                btn[index].text = ab[index]
            }
        }

        winHome.setOnClickListener {
            var intent = Intent(this@MainActivity, StartPage::class.java)
            finish()
        }
    }

    private fun change(first: Int, second: Int) {
        if (btn[second].text.toString().isEmpty()) {
            btn[second].text = btn[first].text.toString()
            btn[first].text = ""
        }
    }

    private fun change(first: Int, second: Int, third: Int) {
        if (btn[third].text.toString().isEmpty()) {
            btn[third].text = btn[second].text.toString()
            btn[second].text = btn[first].text.toString()
            btn[first].text = ""
        }

}}