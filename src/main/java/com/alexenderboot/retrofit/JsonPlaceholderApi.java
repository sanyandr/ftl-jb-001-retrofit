package com.alexenderboot.retrofit;

import com.alexenderboot.retrofit.request.*;
import com.alexenderboot.retrofit.response.AlbumResponse;
import com.alexenderboot.retrofit.response.CommentResponse;
import com.alexenderboot.retrofit.response.PostResponse;
import com.alexenderboot.retrofit.response.UserResponse;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface JsonPlaceholderApi {
    @GET("/posts")
    Call<List<PostResponse>> posts(@Query("userId") Integer userId);

    @POST("/posts")
    Call<PostResponse> postCreate(@Body PostCreateRequest request);

    @PUT("/posts/{id}")
    Call<PostResponse> postUpdate(@Path ("id") Integer id, @Body PostUpdateRequest request);

    @DELETE("/posts/{id}")
    Call<Void> postDelete(@Path ("id") Integer id);

    @GET("/posts/{id}")
    Call<PostResponse> postWithId(@Path ("id") Integer id);

    @GET("/posts/{id}/comments")
    Call<List<CommentResponse>> postComments(@Path ("id") Integer id);

    @GET("/comments/{id}")
    Call<CommentResponse> postComment(@Path ("id") Integer id);

    @POST("/comments")
    Call<CommentResponse> commentCreate(@Body CommentCreateRequest request);

    @PUT("/comments/{id}")
    Call<CommentResponse> commentUpdate(@Path ("id") Integer id, @Body CommentUpdateRequest request);

    @DELETE("/comments/{id}")
    Call<Void> commentDelete(@Path ("id") Integer id);

    @GET("/users")
    Call<List<UserResponse>> users();

    @GET("/users/{userId}")
    Call<UserResponse> user(@Path ("userId") Integer userId);

    @PUT("/users/{userId}")
    Call<UserResponse> userUpdate(@Path ("userId") Integer userId, @Body UserUpdateRequest request);

    @GET("/albums")
    Call<List<AlbumResponse>> userAlbums();

    @GET("albums/{id}")
    Call<AlbumResponse> userAlbum(@Path ("id") Integer id);

    @POST("/users")
    Call<UserResponse> userCreate(@Body UserCreateRequest request);

    @POST("/albums")
    Call<AlbumResponse> albumCreate(@Body AlbumCreateRequest request);

    @PUT("/albums/{id}")
    Call<AlbumResponse> albumUpdate(@Path ("id") Integer id, @Body AlbumUpdateRequest request);

    @DELETE("/albums/{id}")
    Call<Void> albumDelete(@Path ("id") Integer id);

    @DELETE("/users/{userId}")
    Call<Void> userDelete(@Path ("userId") Integer userId);

    //
}
