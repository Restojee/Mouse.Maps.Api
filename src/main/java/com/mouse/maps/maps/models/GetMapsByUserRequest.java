package com.mouse.maps.maps.models;

import com.mouse.maps.common.PaginateRequest;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetMapsByUserRequest extends PaginateRequest {

    private Integer userId;

}
