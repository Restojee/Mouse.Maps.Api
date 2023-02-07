package com.mouse.maps.common;

import lombok.val;
import org.springframework.data.domain.PageRequest;

import java.util.Collection;

public class Paginate {
    public static PageRequest getPageRequest(PaginateRequest request) {
        return PageRequest.of(
            request.getPage(),
            request.getSize()
        );
    }

    public static <T> PaginatedResponse<T> getPaginatedResponse(
        Integer totalRecordsCount,
        Integer pageSize,
        Integer pageNumber,
        Collection<T> records
    ) {
        val paginatedResponse = new PaginatedResponse<T>();
        paginatedResponse.setRecords(records);
        paginatedResponse.setPageNumber(pageNumber);
        paginatedResponse.setTotalRecordsCount(totalRecordsCount);
        paginatedResponse.setPageSize(pageSize);

        return paginatedResponse;
    }
}
