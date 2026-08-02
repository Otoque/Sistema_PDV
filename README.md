# POS System - Full Stack

A Point of Sale (POS) system developed with a focus on layered architecture, separation of concerns, and efficient integration between front-end and back-end.

---

## 🛠️ Technologies Used

### Back-end
* **Java 21** / **Spring Boot**
* **Spring Data JPA** / **Hibernate**
* **PostgreSQL** (Hosted via **Supabase**)
* **Maven**

### Front-end
* **React.js** (Vite)
* **Axios** (HTTP Client)
* **React Router DOM**
* **CSS3** (Flexbox, Responsive Layout)

---

## 🚀 Mapped & In-Development Features

* **Authentication & Security:** Login interface integrated with access control.
* **Customer Search:** Query customers by SSN/CPF with validation and dynamic UI updates.
* **Customer Persistence:** Registration and storage of new customers in the database using DTOs.
* **POS Interface:** Responsive side panel for visual operation management.

---

## 🏛️ Architecture & Best Practices

* **DTO Pattern (Data Transfer Object):** Applied on the back-end to decouple JPA domain entities from the presentation layer, ensuring secure data transfer.
* **REST Standardization:** Endpoints structured with appropriate HTTP verbs (`GET`, `POST`) and status codes via `ResponseEntity` (`200 OK`, `201 Created`, `404 Not Found`).
* **CORS Handling:** Managed with `@CrossOrigin` in Spring Boot to handle secure requests from the React client application.
* **State Management:** React hooks (`useState`) used for managing loading states and handling UI errors seamlessly.

---

## 📋 Prerequisites

To run this project locally, ensure you have the following installed:

* **Java JDK 17+**
* **Node.js** (v18+)
* **Git**

---

## 🔧 How to Run the Project

### 1. Clone the Repositories

```bash
# Clone the Back-end repository
git clone [https://github.com/Otoque/Sistema_PDV.git](https://github.com/Otoque/Sistema_PDV.git)

# Clone the Front-end repository
git clone [https://github.com/Otoque/Sistema_PDV.git](https://github.com/Otoque/Sistema_PDV.git)
```

### 2. Configure and Run the Back-end (Spring Boot)

1. Open the Java project folder in your terminal.
2. Verify the PostgreSQL database configuration in `application.properties` (or `application.yml`):
   ```properties
   spring.datasource.url=jdbc:postgresql://<YOUR_SUPABASE_URL>:5432/postgres
   spring.datasource.username=<YOUR_USERNAME>
   spring.datasource.password=<YOUR_PASSWORD>
   spring.jpa.hibernate.ddl-auto=update
   ```
3. Run the application via terminal or your IDE (VS Code / IntelliJ):
   ```bash
   mvn spring-boot:run
   ```
   *The API will run by default at `http://localhost:8080`.*

### 3. Configure and Run the Front-end (React)

1. Navigate to the React project directory:
   ```bash
   cd system_pdv
   ```
2. Install dependencies:
   ```bash
   npm install
   ```
3. Start the development server:
   ```bash
   npm run dev
   ```
   *The front-end will be accessible at `http://localhost:5173`.*

---

## 📌 Main API Endpoints

| Method | Route | Description |
|---|---|---|
| `GET` | `/client/{cpf}` | Fetch a specific customer by SSN/CPF |
| `POST` | `/client` | Register a new customer in the system |

---

## ✒️ Author

Developed by **Nicolas Tavares da Silva**.
