package com.Makersharks.Makersharks.responce;

import com.Makersharks.Makersharks.payload.SupplierDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SupplierResponce {

    private List<SupplierDto> content;
    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private  boolean lastPage;
}
