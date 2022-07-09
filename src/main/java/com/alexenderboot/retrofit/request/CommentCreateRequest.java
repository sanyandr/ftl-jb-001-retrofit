package com.alexenderboot.retrofit.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Builder
public class CommentCreateRequest {
    private Integer postId;
    private Integer id;
    private String name;
    private String email;
    private String body;
}
