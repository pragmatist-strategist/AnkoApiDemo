package com.pranav.ankoapidemops

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.pranav.ankoapidemops.activities.PostsActivity
import com.pranav.ankoapidemops.activities.TodosActivity
import com.pranav.ankoapidemops.activities.UsersActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPosts.setOnClickListener({
            startActivity(Intent(this@MainActivity, PostsActivity::class.java))
        })

        btnUsers.setOnClickListener({
            startActivity(Intent(this@MainActivity, UsersActivity::class.java))
        })

        btnTodos.setOnClickListener({
            startActivity(Intent(this@MainActivity, TodosActivity::class.java))
        })


    }
}
