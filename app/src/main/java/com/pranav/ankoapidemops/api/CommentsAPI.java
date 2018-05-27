package com.pranav.ankoapidemops.api;

import com.pranav.ankoapidemops.models.Comment;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CommentsAPI {
    @GET("/comments")
    Call<ArrayList<Comment>> getComments();

    @GET("/comments")
    Call<ArrayList<Comment>> getCommentsByPostId(
            @Query("postsId") int postId
    );
}
