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

http://localhost:8080

## API Endpoints

# This project provides the following REST API endpoints:

### 1. Get All Suppliers

- **Endpoint:** `GET /user/get`
- **URL:** `http://localhost:8080/user/get`
- **Description:** Retrieves a list of all suppliers.

### 2. Get Supplier by ID

- **Endpoint:** `GET /user/get/{id}`
- **URL Example:** `http://localhost:8080/user/get/1`
- **Description:** Retrieves the supplier with the specified ID.

### 3. Get Supplier by Query Parameters

- **Endpoint:** `GET /user/api/supplier`
- **URL Example:** `http://localhost:8080/user/api/supplier?location=london&natureOfBusiness=LARGE_SCALE&manufacturingProcesses=CASTING&pageNumber=2&pageSize=2&sortBy=supplierId&sortDir=asc`

- **Description:** Retrieves suppliers based on query parameters like location, nature of business, manufacturing processes, pagination, and sorting.

- **Query Parameters:**
- `location`: Filter by supplier location (e.g., `london`).
- `natureOfBusiness`: Filter by the nature of the business (e.g., `LARGE_SCALE`).
- `manufacturingProcesses`: Filter by manufacturing processes (e.g., `CASTING`).
- `pageNumber`: Pagination - specify the page number (e.g., `2`).
- `pageSize`: Pagination - specify the number of records per page (e.g., `2`).
- `sortBy`: Field to sort the results by (e.g., `supplierId`).
- `sortDir`: Sort direction - `asc` for ascending, `desc` for descending (e.g., `asc`).

### 4. Create a Supplier

- **Endpoint:** `POST /user/create/supplier`
- **URL:** `http://localhost:8080/user/create/supplier`
- **Description:** Creates a new supplier with the provided details.

### 5. Update Supplier by ID

- **Endpoint:** `PUT /user/update/supplier/{id}`
- **URL Example:** `http://localhost:8080/user/update/supplier/1`
- **Description:** Updates the details of the supplier with the specified ID.

### 6. Delete Supplier by ID

- **Endpoint:** `DELETE /user/delete/supplier/{id}`
- **URL Example:** `http://localhost:8080/user/delete/supplier/12`
- **Description:** Deletes the supplier with the specified ID.

### Notes:
- Make sure the application is running on `localhost:8080` before testing the endpoints.
- You can test the APIs using tools like Postman, cURL, or directly from your web browser for GET requests.


## Example API Responses

Below are sample responses for each of the API endpoints:

### 1. Get All Suppliers

- **Endpoint:** `GET /user/get`
- **URL:** `http://localhost:8080/user/get`
- **Sample Response:**
    ```json
    [
        {
            "supplierId": 1,
            "companyName": "TechPrint Solutions",
            "website": "http://www.techprintsolutions.com",
            "location": "jaipur",
            "natureOfBusiness": "SMALL_SCALE",
            "manufacturingProcesses": "CASTING"
        },
        {
            "supplierId": 2,
            "companyName": "3D Innovations",
            "website": "http://www.3dinnovations.com",
            "location": "jaipur",
            "natureOfBusiness": "LARGE_SCALE",
            "manufacturingProcesses": "THREE_D_PRINTING"
        },
        {
            "supplierId": 3,
            "companyName": "TechPrint Solutions",
            "website": "techprintsolutions.com",
            "location": "siker",
            "natureOfBusiness": "MEDIUM_SCALE",
            "manufacturingProcesses": "COATING"
        },
        {
            "supplierId": 4,
            "companyName": "EcoManufacturing",
            "website": "ecomanufacturing.com",
            "location": "Austin",
            "natureOfBusiness": "LARGE_SCALE",
            "manufacturingProcesses": "CASTING"
        },
        {
            "supplierId": 5,
            "companyName": "UrbanMould",
            "website": "urbanmould.com",
            "location": "Delhi",
            "natureOfBusiness": "MEDIUM_SCALE",
            "manufacturingProcesses": "MOULDING"
        }
    ]
    ```

### 2. Get Supplier by ID

- **Endpoint:** `GET /user/get/{id}`
- **URL Example:** `http://localhost:8080/user/get/1`
- **Sample Response:**
    ```json
    {
        "supplierId": 1,
        "companyName": "TechPrint Solutions",
        "website": "http://www.techprintsolutions.com",
        "location": "jaipur",
        "natureOfBusiness": "SMALL_SCALE",
        "manufacturingProcesses": "CASTING"
    }
    ```

### 3. Get Supplier by Query Parameters with Pagination

- **Endpoint:** `GET /user/api/supplier`
- **URL Example:** http://localhost:8080/user/api/supplier?location=london&natureOfBusiness=LARGE_SCALE&manufacturingProcesses=CASTING&pageNumber=2&pageSize=2&sortBy=supplierId&sortDir=asc

  - **Sample Response:**
  ```json
  {
      "content": [
          {
              "supplierId": 94,
              "companyName": "Rahul Ltd.",
              "website": "Rahul.com",
              "location": "London",
              "natureOfBusiness": "LARGE_SCALE",
              "manufacturingProcesses": "CASTING"
          },
          {
              "supplierId": 95,
              "companyName": "Ram Ltd.",
              "website": "Ram.com",
              "location": "London",
              "natureOfBusiness": "LARGE_SCALE",
              "manufacturingProcesses": "CASTING"
          }
      ],
      "pageNumber": 2,
      "pageSize": 2,
      "totalElements": 8,
      "totalPages": 4,
      "lastPage": false
  }
  ```

### 4. Create a Supplier

- **Endpoint:** `POST /user/create/supplier`
- **URL:** `http://localhost:8080/user/create/supplier`
- **Sample Response:**
  ```json
  {
      "supplierDto": {
          "supplierId": null,
          "companyName": "Mam Solutions",
          "website": "http://www.mam.com",
          "location": "jaipur",
          "natureOfBusiness": "MEDIUM_SCALE",
          "manufacturingProcesses": "THREE_D_PRINTING"
      },
      "message": "Supplier Successfully Created!"
  }
  ```

### 5. Update Supplier by ID

- **Endpoint:** `PUT /user/update/supplier/{id}`
- **URL Example:** `http://localhost:8080/user/update/supplier/1`
- **Sample Response:**
  ```json
  {
      "message": "Supplier Successfully Updated",
      "status": true
  }
  ```

### 6. Delete Supplier by ID

- **Endpoint:** `DELETE /user/delete/supplier/{id}`
- **URL Example:** `http://localhost:8080/user/delete/supplier/12`
- **Sample Response:**
  ```json
  {
      "message": "Supplier Successfully Deleted",
      "status": true
  }
  ```



