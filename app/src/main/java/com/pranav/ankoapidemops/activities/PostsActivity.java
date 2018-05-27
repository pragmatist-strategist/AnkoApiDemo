package com.pranav.ankoapidemops.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.pranav.ankoapidemops.R;
import com.pranav.ankoapidemops.adapters.PostAdapter;
import com.pranav.ankoapidemops.api.API;
import com.pranav.ankoapidemops.api.PostsAPI;
import com.pranav.ankoapidemops.interfaces.OnItemClickListener;
import com.pranav.ankoapidemops.models.Post;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsActivity extends AppCompatActivity {
    public static final String TAG = "Post Activity";
RecyclerView rvPostsList;
PostAdapter postAdapter;

@Override
    protected void onCreate(Bundle savedInstanceSate){
    super.onCreate(savedInstanceSate);
    setContentView(R.layout.activity_posts);

    rvPostsList=findViewById(R.id.rvPostsList);
    rvPostsList.setLayoutManager(new LinearLayoutManager(this));
    postAdapter=new PostAdapter(this, new ArrayList<Post>());
    rvPostsList.setAdapter(postAdapter);
    postAdapter.setOnItemClickListener(new OnItemClickListener(){
        @Override
        public void onItemClick(int itemId, View view) {
            Intent i=new Intent(PostsActivity.this, CommentsActivity.class);
        i.putExtra("postId", itemId);
        startActivity(i);
        }
    });

    PostsAPI postsAPI= API.getInstance().getPostsAPI();
    Callback<ArrayList<Post>> postCallback=new Callback<ArrayList<Post>>() {
        @Override
        public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
            Log.d(TAG, "onResponse: ");
            postAdapter.updatePosts(response.body());
        }

        @Override
        public void onFailure(Call<ArrayList<Post>> call, Throwable t) {

        }

    };
    int userIdRecieved = getIntent().getIntExtra("userId", -1);
    if(userIdRecieved!= -1){
        postsAPI.getPostsByUserId(userIdRecieved).enqueue(postCallback);
    }else{
        postsAPI.getPosts().enqueue(postCallback);
    }
}
}
