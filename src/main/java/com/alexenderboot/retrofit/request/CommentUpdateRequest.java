package com.alexenderboot.retrofit.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Builder
public class CommentUpdateRequest {
        private Integer id;
        private Integer userId;
        private String body;
}
