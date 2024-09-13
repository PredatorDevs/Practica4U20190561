package com.example.practica4u20190561

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var toolbar:Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        toolbar = findViewById(R.id.toolbar)
        toolbar?.setTitle(R.string.app_name)
        toolbar?.setTitleTextColor(Color.WHITE)

        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_bar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.nav_camara -> {
                Toast.makeText(this, "Abriendo camara", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.nav_compartir -> {
                Toast.makeText(this, "Compartiendo datos", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.nav_ajustes -> {
                val intent = Intent(this, AjustesActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.nav_salir -> {
                finish()
                return true
            }

            else -> false
        }
    }
}