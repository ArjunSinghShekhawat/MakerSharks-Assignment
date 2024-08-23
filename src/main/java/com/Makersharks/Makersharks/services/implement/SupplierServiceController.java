package com.Makersharks.Makersharks.services.implement;
import com.Makersharks.Makersharks.Models.Supplier;
import com.Makersharks.Makersharks.domain.ManufacturingProcesses;
import com.Makersharks.Makersharks.domain.NatureOfBusiness;
import com.Makersharks.Makersharks.exceptions.ResourceNotFoundException;
import com.Makersharks.Makersharks.payload.SupplierDto;
import com.Makersharks.Makersharks.repositories.SupplierRepository;
import com.Makersharks.Makersharks.responce.SupplierResponce;
import com.Makersharks.Makersharks.services.SupplierService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierServiceController implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SupplierDto createSupplier(SupplierDto supplierDto) {

        Supplier supplier = modelMapper.map(supplierDto,Supplier.class);
        Supplier savedSupplier  = this.supplierRepository.save(supplier);

        return this.modelMapper.map(savedSupplier,SupplierDto.class);
    }

    @Override
    public SupplierDto updateSupplier(SupplierDto supplierDto, Long id) {
        Supplier supplier = this.supplierRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Supplier","id",id));

        supplier.setCompanyName(supplierDto.getCompanyName());
        supplier.setLocation((supplierDto.getLocation()));
        supplier.setWebsite(supplierDto.getWebsite());
        supplier.setManufacturingProcesses(supplierDto.getManufacturingProcesses());
        supplier.setNatureOfBusiness(supplierDto.getNatureOfBusiness());

       Supplier savedSupplier =  this.supplierRepository.save(supplier);

       return modelMapper.map(savedSupplier,SupplierDto.class);
    }

    @Override
    public void deleteSupplier(Long id) {
        Supplier supplier = this.supplierRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Supplier","id",id));
        this.supplierRepository.delete(supplier);
    }

    @Override
    public List<SupplierDto> getAllSupplier() {
        List<Supplier>supplierList = this.supplierRepository.findAll();
        return supplierList.stream().map((supplier)->modelMapper.map(supplier,SupplierDto.class)).collect(Collectors.toList());
    }

    @Override
    public SupplierDto getSupplierById(Long id) {
        Supplier supplier = this.supplierRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Supplier","id",id));
        return modelMapper.map(supplier,SupplierDto.class);
    }

    @Override
    public SupplierResponce findSuppliers(String location, NatureOfBusiness natureOfBusiness, ManufacturingProcesses manufacturingProcess, Integer PageNumber, Integer PageSize, String sortBy, String sortDir) {
        Sort sort = (sortDir.equalsIgnoreCase("asc")?(Sort.by(sortBy).ascending()):(Sort.by(sortBy).descending()));
        Pageable pageable = (Pageable) PageRequest.of(PageNumber,PageSize,sort);

        Page<Supplier> allSupplierPages = this.supplierRepository.findByLocationAndNatureOfBusinessAndManufacturingProcesses(location,natureOfBusiness,manufacturingProcess,pageable);
        List<Supplier> allSupplierPagesContent = allSupplierPages.getContent();

        List<SupplierDto>allSupplierDtos = allSupplierPagesContent.stream().map((supplier)->modelMapper.map(supplier,SupplierDto.class)).collect(Collectors.toList());


        SupplierResponce supplierResponce = new SupplierResponce();
        supplierResponce.setContent(allSupplierDtos);
        supplierResponce.setPageNumber(allSupplierPages.getNumber());
        supplierResponce.setPageSize(allSupplierPages.getSize());
        supplierResponce.setTotalElements(allSupplierPages.getTotalElements());
        supplierResponce.setTotalPages(allSupplierPages.getTotalPages());
        supplierResponce.setLastPage(allSupplierPages.isLast());



        return  supplierResponce;
    }

    @Override
    public List<SupplierDto> findByCompanyNameSupplier(String companyName) {
        List<Supplier> allSupplier = this.supplierRepository.findByCompanyName(companyName);
        return allSupplier.stream().map((supplier)->modelMapper.map(supplier,SupplierDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<SupplierDto> findByWebsiteSupplier(String website) {
        List<Supplier> allSupplier = this.supplierRepository.findByWebsite(website);
        return allSupplier.stream().map(supplier -> modelMapper.map(supplier,SupplierDto.class)).collect(Collectors.toList());
    }

}
