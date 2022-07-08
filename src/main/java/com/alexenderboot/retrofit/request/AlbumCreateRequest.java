package com.alexenderboot.retrofit.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AlbumCreateRequest {
    private Integer userId;
    private Integer id;
    private String title;
}
