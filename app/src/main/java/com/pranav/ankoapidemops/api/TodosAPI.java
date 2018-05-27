package com.pranav.ankoapidemops.api;

import android.support.annotation.Nullable;

import com.pranav.ankoapidemops.models.Todo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TodosAPI {

    @GET("/todos")
    Call<ArrayList<Todo>> getTodos(
            @Nullable
            @Query("userId") Integer userId
    );
}
