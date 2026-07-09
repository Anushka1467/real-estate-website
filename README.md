#  Real Estate Listing Website

A full-stack Real Estate Listing Website built using **Spring Boot**, **Thymeleaf**, **MongoDB**, and **Spring Security**. The application allows users to browse, search, filter, and manage property listings with a clean and responsive user interface.

##  Features

###  User Authentication
- User Registration
- User Login
- Secure Password Encryption (BCrypt)
- Spring Security Authentication
- Role-Based Access (ROLE_USER)

###  Property Management
- Add New Property
- View All Properties
- View Property Details
- Update Property
- Delete Property

###  Search & Filter
- Search properties by Title or City
- Filter properties by Property Type
- Responsive property cards

###  Ratings & Reviews
- Add reviews for properties
- Give ratings (1–5 stars)
- View customer reviews
- Average rating calculation
- Review count

###  User Interface
- Modern Responsive Design
- Home Page Hero Section
- Feature Cards
- About Section
- Responsive Navigation Bar

## 🛠 Tech Stack

### Backend
- Java 21
- Spring Boot
- Spring MVC
- Spring Security
- Spring Data MongoDB

### Frontend
- HTML5
- CSS3
- Thymeleaf
- Font Awesome

### Database
- MongoDB

### Build Tool
- Maven

### Version Control
- Git
- GitHub

 ## 📂 Project Structure

```
src
└── main
    ├── java
    │   └── com
    │       └── realestate
    │           └── listing
    │               ├── config
    │               ├── controller
    │               ├── model
    │               ├── repository
    │               ├── security
    │               ├── service
    │               └── service
    │                   └── impl
    └── resources
        ├── static
        └── templates
```


##  Application Modules

- Home Page
- Login
- Registration
- Property Listing
- Property Details
- Add Property
- Edit Property
- Search & Filter
- Ratings & Reviews

##  Installation

### Clone Repository

```bash
git clone https://github.com/Anushka1467/real-estate-listing-website.git
```

### Navigate to Project

```bash
cd real-estate-listing-website
```

### Configure MongoDB

Update your `application.properties` file.

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/realestate
```

### Run the Application

```bash
mvn spring-boot:run
```

or

```bash
./mvnw spring-boot:run
```

---

##  Access the Application

http://localhost:8080

---

##  Database Collections

The application uses the following MongoDB collections:

- users
- properties
- reviews

---

##  Security

- Passwords are encrypted using BCrypt.
- Spring Security handles authentication.
- New users are automatically assigned the `ROLE_USER` role.
