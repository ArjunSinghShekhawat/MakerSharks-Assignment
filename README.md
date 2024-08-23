# MakerSharks Assignment
 
## Supplier Table

| Field                   | Type    |
|-------------------------|---------|
| supplierId              | Integer |
| companyName             | varchar |
| website                 | varchar |
| location                | varchar |
| natureOfBusiness        | varchar |
| manufacturingProcesses  | varchar |

                                  
# Project Structure:

└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── MakerSharks
    │   │           └── MakerSharks
    │   │               ├── config
    │   │               │   └── AppConstant.java
    │   │               ├── controllers
    │   │               │   └── SupplierController.java
    │   │               ├── domain
    │   │               │   ├── ManufacturingProcesses.java
    │   │               │   └── NatureOfBusiness.java
    │   │               ├── exception
    │   │               │   ├── GlobalException.java
    │   │               │   └── ResourceNotFoundException.java
    │   │               ├── model
    │   │               │   └── Supplier.java
    │   │               ├── payload
    │   │               │   └── SupplierDto.java
    │   │               ├── repository
    │   │               │   └── SupplierRepository.java
    │   │               ├── request
    │   │               │   └── SupplierRequest.java
    │   │               ├── response
    │   │               │   ├── ResponseApi.java
    │   │               │   ├── SupplierCreateResponse.java
    │   │               │   └── SupplierResponse.java
    │   │               ├── service
    │   │               │   ├── implement
    │   │               │   │   └── SupplierServiceImpl.java
    │   │               │   └── SupplierService.java
    │   └── resources
    │       ├── static
    │       ├── templates
    │       └── application.properties
    └── test
        └── java
            └── com
                └── MakerSharks
                    └── MakerSharks
                        ├── controllers
                        ├── service
                        └── repository
