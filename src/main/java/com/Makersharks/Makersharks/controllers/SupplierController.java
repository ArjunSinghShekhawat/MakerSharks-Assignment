package com.Makersharks.Makersharks.controllers;
import com.Makersharks.Makersharks.Models.Supplier;
import com.Makersharks.Makersharks.config.AppConstant;
import com.Makersharks.Makersharks.domain.ManufacturingProcesses;
import com.Makersharks.Makersharks.domain.NatureOfBusiness;
import com.Makersharks.Makersharks.payload.SupplierDto;
import com.Makersharks.Makersharks.repositories.SupplierRepository;
import com.Makersharks.Makersharks.responce.ResponceApi;
import com.Makersharks.Makersharks.responce.SupplierCreateResponce;
import com.Makersharks.Makersharks.responce.SupplierResponce;
import com.Makersharks.Makersharks.services.SupplierService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private ModelMapper modelMapper;

    //this api is used for create supplier object in the database
    @PostMapping("/create/supplier")
    public ResponseEntity<SupplierCreateResponce>createSupplier(@Valid @RequestBody SupplierDto supplierDto){

        //check supplier already exists or not if exists then return already exists response

        List<SupplierDto> supplierDto1 = this.supplierService.findByWebsiteSupplier(supplierDto.getWebsite());
        List<SupplierDto> supplierDto2 = this.supplierService.findByWebsiteSupplier(supplierDto.getCompanyName());

        SupplierCreateResponce supplierCreateResponce = new SupplierCreateResponce();

        if(!supplierDto1.isEmpty() || !supplierDto2.isEmpty()){

            supplierCreateResponce.setSupplierDto(supplierDto);
            supplierCreateResponce.setMessage("Supplier User Already Preset !");
            return new ResponseEntity<>(supplierCreateResponce,HttpStatus.ALREADY_REPORTED);
        }
        //if supplier is not exists then save supplier in database

        SupplierDto savedSupplierDto = this.supplierService.createSupplier(supplierDto);
        supplierCreateResponce.setMessage("Supplier Successfully Created !");
        supplierCreateResponce.setSupplierDto(supplierDto);

        return new ResponseEntity<>(supplierCreateResponce, HttpStatus.CREATED);
    }

    //this api is used to update the supplier information by using the id of the supplier.

    @PutMapping("/update/supplier/{supplierId}")
    public ResponseEntity<SupplierDto>createSupplier(@Valid @RequestBody SupplierDto supplierDto,@PathVariable Long supplierId){

        SupplierDto updatedSupplierDto = this.supplierService.updateSupplier(supplierDto,supplierId);
        return new ResponseEntity<>(updatedSupplierDto, HttpStatus.OK);
    }

    //this api is used for delete the supplier data in the database
    @DeleteMapping("/delete/supplier/{supplierId}")
    public ResponseEntity<ResponceApi>deleteSupplier(@PathVariable Long supplierId){

        this.supplierService.deleteSupplier(supplierId);
        return new ResponseEntity<>(new ResponceApi("Supplier Successfully Delete",true), HttpStatus.OK);
    }

    //this api is used for given all supplier data
    @GetMapping("/get")
    public ResponseEntity<List<SupplierDto>>getAllSuppliers(){
        List<SupplierDto>allSupplier =  this.supplierService.getAllSupplier();
        return new ResponseEntity<>(allSupplier, HttpStatus.OK);
    }

    //this api is used for given supplier data by using id
    @GetMapping("/get/{supplierId}")
    public ResponseEntity<SupplierDto>getByIdSuppliers(@PathVariable Long supplierId ){
        SupplierDto supplier =  this.supplierService.getSupplierById(supplierId);
        return new ResponseEntity<>(supplier, HttpStatus.OK);
    }

    //THIS API IS THE MAIN API USED FOR FETCH SUPPLIER DAT FROM THE DATABASE BY USING CUSTOM QUERY LIKE SPECIFIC LOCATION,manufacturingProcesses
    //natureOfBusiness AND ALDO IMPLEMENT PAGINATION

    /*
    http://localhost:8080/user/api/supplier?location=london&natureOfBusiness=LARGE_SCALE&manufacturingProcesses=CASTING&pageNumber=2&pageSize=2&sortBy=supplierId&sortDir=asc
    */

    @GetMapping("/api/supplier")
    public ResponseEntity<SupplierResponce> getQueryData(
            @RequestParam(value = "location", defaultValue = AppConstant.LOCATION, required = false) String location,
            @RequestParam(value = "natureOfBusiness", defaultValue = "LARGE_SCALE", required = false) String natureOfBusiness,
            @RequestParam(value = "manufacturingProcesses", defaultValue = "COATING", required = false) String manufacturingProcesses,
            @RequestParam(value = "pageNumber", defaultValue = AppConstant.PAGE_NO, required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = AppConstant.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstant.SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstant.SORT_DIR, required = false) String sortDir) {

        NatureOfBusiness natureOfBusinessEnum;
        ManufacturingProcesses manufacturingProcessesEnum;
        try {
            natureOfBusinessEnum = NatureOfBusiness.valueOf(natureOfBusiness.toUpperCase());
        } catch (IllegalArgumentException e) {
            natureOfBusinessEnum = NatureOfBusiness.LARGE_SCALE; // default value or handle error
        }

        try {
            manufacturingProcessesEnum = ManufacturingProcesses.valueOf(manufacturingProcesses.toUpperCase());
        } catch (IllegalArgumentException e) {
            manufacturingProcessesEnum = ManufacturingProcesses.COATING; // default value or handle error
        }

        SupplierResponce supplierResponce = this.supplierService.findSuppliers(
                location,
                natureOfBusinessEnum,
                manufacturingProcessesEnum,
                pageNumber,
                pageSize,
                sortBy,
                sortDir
        );

        return new ResponseEntity<>(supplierResponce, HttpStatus.OK);
    }
}
