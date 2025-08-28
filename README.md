# ⚽ EPL Stats  
A full-stack web application that provides statistics on English Premier League players. Built with **Spring Boot**, **React**, and **PostgreSQL**, this project showcases a scalable architecture with modern tooling and deployment on **AWS** and **Vercel**.  

![Java](https://img.shields.io/badge/Java-17-orange)  
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.0-brightgreen)  
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue)  
![React](https://img.shields.io/badge/React-18-61DAFB)  
![Docker](https://img.shields.io/badge/Docker-Desktop-blue)  
![AWS](https://img.shields.io/badge/AWS-Deployed-yellow)  
![Vercel](https://img.shields.io/badge/Vercel-Deployed-black)  

---

## 🚀 Features
- REST API for EPL player and team statistics  
- PostgreSQL relational database with normalized schema  
- Image storage for team logos via **Cloudinary**  
- Frontend with **React + TailwindCSS** for responsive UI  
- Integration tests with **Testcontainers**  
- CI/CD with GitHub Actions  
- Deployment:
  - Backend → **AWS EC2 (Dockerized Spring Boot)**  
  - Frontend → **Vercel**  

---

## 🛠 Tech Stack
- **Backend**: Java 17, Spring Boot, JPA/Hibernate, Testcontainers  
- **Database**: PostgreSQL  
- **Frontend**: React.js, TailwindCSS  
- **Infrastructure**: Docker, AWS (EC2, RDS), Vercel  
- **Others**: Cloudinary (image hosting), GitHub Actions (CI/CD)  

---

## 📂 Project Structure
```
epl-stats/
│── backend/                # Spring Boot API
│   ├── src/main/java/…     # Source code
│   ├── src/test/java/…     # Integration + unit tests
│   └── Dockerfile
│
│── frontend/               # React + Tailwind app
│   ├── public/
│   ├── src/
│   └── package.json
│
│── docker-compose.yml      # Local dev setup
│── README.md
```

---

## ⚙️ Setup & Installation  

### 1. Clone the repo
```bash
git clone https://github.com/your-username/epl-stats.git
cd epl-stats
```

### 2. Backend Setup
```bash
cd backend
./mvnw clean install
```

Environment variables (set in `.env` or system):
```ini
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/pl_data
SPRING_DATASOURCE_USERNAME=your_db_username
SPRING_DATASOURCE_PASSWORD=your_password
```

Run locally:
```bash
./mvnw spring-boot:run
```

### 3. Frontend Setup
```bash
cd frontend
npm install
npm run dev
```

---

## 🌐 Deployment
- **Backend**: Dockerized Spring Boot deployed on AWS EC2, database hosted on AWS RDS (PostgreSQL).
- **Frontend**: Deployed on Vercel, connected to backend API.

---

## 📖 API Endpoints (Example)
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/players` | Get all players |
| GET | `/api/teams` | Get all teams |
| GET | `/api/players/{id}` | Get player by ID |
| POST | `/api/players` | Add new player (admin) |

---

## 🧪 Testing
Unit + integration tests with JUnit 5 and Testcontainers.

Run tests:
```bash
./mvnw test
```

---

## 📜 License
This project is licensed under the MIT License.

---

⚡ **Built with passion for football and software engineering.**
