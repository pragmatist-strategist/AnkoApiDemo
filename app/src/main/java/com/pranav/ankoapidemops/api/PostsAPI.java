package com.pranav.ankoapidemops.api;

import com.pranav.ankoapidemops.models.Comment;
import com.pranav.ankoapidemops.models.Post;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PostsAPI {

    @GET("/posts")
    Call<ArrayList<Post>> getPosts();

    @GET("/posts/{id}")
    Call<Post> getPostById(
            @Path("id") int id
    );
    @GET("/posts")
    Call<ArrayList<Post>> getPostsByUserId(
            @Query("userId") int userId
    );

    interface CommentsAPI{
        @GET("/posts/{postId}/comments")
        Call<ArrayList<Comment>> getCommentsOfPostId(
                @Path("postId") int postId
        );
    }
}
