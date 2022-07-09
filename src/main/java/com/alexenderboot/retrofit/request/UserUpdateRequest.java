package com.alexenderboot.retrofit.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class UserUpdateRequest {
    private Integer userId;
    private String name;
}
