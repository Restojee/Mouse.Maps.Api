package com.mouse.maps.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaginateRequest {

    private Integer page = 0;

    private Integer size = 10;
}
