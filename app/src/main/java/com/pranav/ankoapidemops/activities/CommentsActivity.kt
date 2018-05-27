package com.pranav.ankoapidemops.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.pranav.ankoapidemops.R
import com.pranav.ankoapidemops.R.id.rvCommentsList
import com.pranav.ankoapidemops.adapters.CommentAdapter
import com.pranav.ankoapidemops.api.API
import com.pranav.ankoapidemops.models.Comment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



import kotlinx.android.synthetic.main.activity_comments.*

class CommentsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments)

        val commentAdapter= CommentAdapter(this, ArrayList<Comment>())
        rvCommentsList.layoutManager=LinearLayoutManager(this)
        rvCommentsList.adapter=commentAdapter



        API.getInstance().commentsAPI.getCommentsByPostId(intent.getIntExtra("postId", 0))
                .enqueue(object : Callback<ArrayList<Comment>>{
                    override fun onFailure(call : Call<ArrayList<Comment>>?, t:Throwable?){

                    }

                    override fun onResponse(call: Call<ArrayList<Comment>>?, response: Response<ArrayList<Comment>>?) {
                        commentAdapter.updateComments(response!!.body()!!)
                    }
                })
    }

}