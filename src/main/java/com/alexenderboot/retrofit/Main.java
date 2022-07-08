package com.alexenderboot.retrofit;

import com.alexenderboot.retrofit.request.PostCreateRequest;
import com.alexenderboot.retrofit.request.PostUpdateRequest;
import com.alexenderboot.retrofit.response.AlbumResponse;
import com.alexenderboot.retrofit.response.CommentResponse;
import com.alexenderboot.retrofit.response.PostResponse;
import com.alexenderboot.retrofit.response.UserResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Start");
        JsonPlaceholderApi api = JsonPlaceholderService.getInstance().getJSONApi();

        System.out.println("---------POSTS---------");
        List<PostResponse> posts = api.posts(null).execute().body();
        posts = api.posts(1).execute().body();
        System.out.println(posts.toString());

        System.out.println("---------POSTS CREATE---------");
        PostResponse postCreate = api.postCreate(PostCreateRequest.builder()
                        .userId(3)
                        .title("New post")
                        .body("News")
                        .build()
                        ).execute().body();
        System.out.println(postCreate);

        System.out.println("---------POSTS UPDATE---------");
        PostResponse postUpdate = api.postUpdate(1, PostUpdateRequest.builder()
                        .id(1)
                        .userId(3)
                        .title("New post")
                        .body("News")
                        .build()
                        ).execute().body();
        System.out.println(postUpdate);

        System.out.println("---------POSTS DELETE---------");
        Boolean postDelete = api.postDelete(1).execute().isSuccessful();
        System.out.println(postDelete);

        System.out.println("---------POST WITH ID---------");
        PostResponse postWithId = api.postWithId(1).execute().body();
        System.out.println(postWithId);

        System.out.println("---------POST COMMENTS---------");
        List<CommentResponse> postComments = api.postComments(1).execute().body();
        System.out.println(postComments);

        System.out.println("---------USERS---------");
        List<UserResponse> users = api.users().execute().body();
        System.out.println(users);

        System.out.println("---------ALBUMS---------");
        List<AlbumResponse> albums = api.userAlbums(1).execute().body();
        System.out.println(albums);

        Call<List<CommentResponse>> commentsCall = api.postComments(1);
        Response<List<CommentResponse>> commentsCallResponse = commentsCall.execute();
        if (commentsCallResponse.isSuccessful() && commentsCallResponse.code() == 200){
            List<CommentResponse> responses = commentsCallResponse.body();
        }
        else {
            if (commentsCallResponse.code() == 400) {
                String error = commentsCallResponse.errorBody().string();
            }
            else if (commentsCallResponse.code() == 500) {
                String error = commentsCallResponse.errorBody().string();
            }
            else if (commentsCallResponse.code() == 403) {
                String error = commentsCallResponse.errorBody().string();
            }
        }

        for (int i = 0; i < 100; i++) {
            api.postComments(1).enqueue(new Callback<List<CommentResponse>>() {
                public void onResponse(Call<List<CommentResponse>> call, Response<List<CommentResponse>> response) {
                    List<CommentResponse> commentAsyncResponse = response.body();
                }

                public void onFailure(Call<List<CommentResponse>> call, Throwable throwable) {
                    throwable.printStackTrace();
                }
            });
        }
        System.out.println("passed");
    }
}
