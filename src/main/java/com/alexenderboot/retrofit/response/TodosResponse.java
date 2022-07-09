package com.alexenderboot.retrofit.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class TodosResponse {
    private Integer userId;
    private Integer id;
    private String title;
    private Boolean completed;
}
