package com.alexenderboot.retrofit;

import com.alexenderboot.retrofit.request.*;
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

        System.out.println("---------POST COMMENT---------");
        CommentResponse postComment = api.postComment(1).execute().body();
        System.out.println(postComment);

        System.out.println("---------COMMENT CREATE---------");
        CommentResponse commentCreate = api.commentCreate(CommentCreateRequest.builder()
                .postId(2)
                .name("V.I.Lenin")
                .body("nothing matter")
                .build()
        ).execute().body();
        System.out.println(commentCreate);

        System.out.println("---------COMMENT DELETE---------");
        Boolean commentDelete = api.commentDelete(1).execute().isSuccessful();
        System.out.println(commentDelete);

        System.out.println("---------USERS---------");
        List<UserResponse> users = api.users().execute().body();
        System.out.println(users);

        System.out.println("---------USER---------");
        UserResponse user = api.user(1).execute().body();
        System.out.println(user);

        System.out.println("---------USER CREATE---------");
        UserResponse userCreate = api.userCreate(UserCreateRequest.builder()
                .userId(2)
                .name("V.I.Lenin")
                .build()
        ).execute().body();
        System.out.println(userCreate);

        System.out.println("---------COMMENT UPDATE---------");
        CommentResponse commentUpdate = api.commentUpdate(2, CommentUpdateRequest.builder()
                .userId(2)
                .body("nothing again")
                .build()
        ).execute().body();
        System.out.println(commentUpdate);

        System.out.println("---------USER UPDATE---------");
        UserResponse userUpdate = api.userUpdate(2, UserUpdateRequest.builder()
                .name("VIHUHOL")
                .build()
        ).execute().body();
        System.out.println(userUpdate);

        System.out.println("---------USER DELETE---------");
        Boolean userDelete = api.userDelete(1).execute().isSuccessful();
        System.out.println(userDelete);

        System.out.println("---------ALBUMS---------");
        List<AlbumResponse> albums = api.userAlbums().execute().body();
        System.out.println(albums);

        System.out.println("---------ALBUM 1---------");

        AlbumResponse album = api.userAlbum(1).execute().body();
        System.out.println(album);

        System.out.println("---------ALBUM CREATE---------");
        AlbumResponse albumCreate = api.albumCreate(AlbumCreateRequest.builder()
                .title("New album")
                .build()
        ).execute().body();
        System.out.println(albumCreate);

        System.out.println("---------ALBUMS UPDATE---------");
        AlbumResponse albumUpdate = api.albumUpdate(1, AlbumUpdateRequest.builder()
                .userId(3)
                .title("New album update")
                .build()
        ).execute().body();
        System.out.println(albumUpdate);

        System.out.println("---------ALBUM DELETE---------");
        Boolean albumDelete = api.albumDelete(1).execute().isSuccessful();
        System.out.println(albumDelete);

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
