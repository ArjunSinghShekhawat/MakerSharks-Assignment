package com.Makersharks.Makersharks.responce;

import com.Makersharks.Makersharks.Models.Supplier;
import com.Makersharks.Makersharks.payload.SupplierDto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SupplierCreateResponce {

    private SupplierDto supplierDto;
    private String message;

}
