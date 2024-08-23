package com.Makersharks.Makersharks.payload;
import com.Makersharks.Makersharks.domain.ManufacturingProcesses;
import com.Makersharks.Makersharks.domain.NatureOfBusiness;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SupplierDto {

    private Long supplierId;

    @NotEmpty(message = "Company name is required")
    private String companyName;

    @NotBlank(message = "website is required")
    private String website;

    @NotBlank(message = "Location is required")
    private String location;

    @NotNull(message = "Nature of business is required.")
    private NatureOfBusiness natureOfBusiness;

    @NotNull(message = "Nature of business is required.")
    private ManufacturingProcesses manufacturingProcesses;

}
