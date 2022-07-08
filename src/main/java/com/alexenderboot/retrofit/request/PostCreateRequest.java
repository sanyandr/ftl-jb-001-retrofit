package com.alexenderboot.retrofit.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@Builder
public class PostCreateRequest {
        private Integer userId;
        private String title;
        private String body;
}
