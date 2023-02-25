package com.mouse.maps.maps.models;

import com.mouse.maps.common.PaginateRequest;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Setter
@Getter
public class GetMapsRequest extends PaginateRequest {

    private Integer userId;

}
