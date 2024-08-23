package com.Makersharks.Makersharks.repositories;

import com.Makersharks.Makersharks.Models.Supplier;
import com.Makersharks.Makersharks.domain.NatureOfBusiness;
import com.Makersharks.Makersharks.domain.ManufacturingProcesses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    Page<Supplier> findByLocationAndNatureOfBusinessAndManufacturingProcesses(
            String location,
            NatureOfBusiness natureOfBusiness,
            ManufacturingProcesses manufacturingProcesses,
            Pageable pageable);
    List<Supplier> findByCompanyName(String companyName);
    List<Supplier> findByWebsite(String website);
}
