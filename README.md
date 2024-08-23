# MakerSharks Assignment
 
## Database Information Supplier Table

| Field                   | Type    |
|-------------------------|---------|
| supplierId              | Integer |
| companyName             | varchar |
| website                 | varchar |
| location                | varchar |
| natureOfBusiness        | varchar |
| manufacturingProcesses  | varchar |

                                  
# Project Structure:

```
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
```


## How to Run the Project

To run this project, follow these steps:

### Prerequisites

Ensure that you have the following installed:

- [Java 17+](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [MySQL](https://dev.mysql.com/downloads/) 

### Steps to Run

1. **Clone the Repository**  
   Clone this project to your local machine:
   ```bash
   https://github.com/ArjunSinghShekhawat/MakerSharks-Assignment.git
   
   cd project-name
### Configure the Database

# properties
Update the application.properties file in the src/main/resources directory with your database configuration:
```
spring.datasource.url=jdbc:mysql://localhost:3306/your-database-name
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.jpa.hibernate.ddl-auto=update
```

### Build the Project
```
mvn clean install
```

### Run the Project
```
mvn spring-boot:run
```
### Access the Application
````
http://localhost:8080

