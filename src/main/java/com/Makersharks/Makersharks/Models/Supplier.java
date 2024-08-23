package com.Makersharks.Makersharks.Models;

import com.Makersharks.Makersharks.domain.ManufacturingProcesses;
import com.Makersharks.Makersharks.domain.NatureOfBusiness;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplierId;

    @Column(name = "company_name",unique = true,nullable = false)
    private String companyName;

    @Column(name = "website",nullable = false,unique = true)
    private String website;

    @Column(name = "location",nullable = false)
    private String location;

    @Column(name = "nature_of_business",nullable = false)
    private NatureOfBusiness natureOfBusiness;

    @Column(name = "manufacturing_process",nullable = false)
    private ManufacturingProcesses manufacturingProcesses;

}
