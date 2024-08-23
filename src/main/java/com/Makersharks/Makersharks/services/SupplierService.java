package com.Makersharks.Makersharks.services;

import com.Makersharks.Makersharks.Models.Supplier;
import com.Makersharks.Makersharks.domain.ManufacturingProcesses;
import com.Makersharks.Makersharks.domain.NatureOfBusiness;
import com.Makersharks.Makersharks.payload.SupplierDto;
import com.Makersharks.Makersharks.responce.SupplierResponce;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface SupplierService {

    SupplierDto createSupplier(SupplierDto supplierDto);
    SupplierDto updateSupplier(SupplierDto supplierDto,Long id);
    void deleteSupplier(Long id);
    List<SupplierDto>getAllSupplier();
    SupplierDto getSupplierById(Long id);
    SupplierResponce findSuppliers(String location, NatureOfBusiness natureOfBusiness, ManufacturingProcesses manufacturingProcess, Integer PageNumber, Integer PageSize, String sortBy, String sortDir);
    List<SupplierDto> findByCompanyNameSupplier(String companyName);
    List<SupplierDto> findByWebsiteSupplier(String website);

}
