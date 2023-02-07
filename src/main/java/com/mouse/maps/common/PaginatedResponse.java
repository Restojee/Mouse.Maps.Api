package com.mouse.maps.common;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
public class PaginatedResponse<T> {

    private Collection<T> records;

    private Integer pageNumber;

    private Integer pageSize;

    private Integer totalRecordsCount ;
}
