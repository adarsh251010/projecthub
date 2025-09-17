# ProjectHub — Full‑Stack Portfolio + Blog

## 📖 About ProjectHub
ProjectHub is a full‑stack personal **portfolio and blogging** platform I built to practice and showcase my skills in **Java Spring Boot** (backend) and **React** (frontend). It includes authentication (JWT), CRUD for Projects & Blog posts, public APIs for the site, and an Admin UI to manage content.

---

## 🧩 Tech Stack
- **Backend:** Java 11, Spring Boot 2.7, Spring Security (JWT), Spring Data JPA, H2/MySQL
- **Frontend:** React 18, Vite, Material UI, Axios, React Router
- **DevOps:** Docker, Docker Compose (optional), GitHub‑ready

---

## 🗂️ Project Structure
```
projecthub/
├─ backend/        # Spring Boot API (Java 11)
└─ frontend/       # React + Vite + MUI
```

---

## 🚀 Quick Start (Dev, no Docker)
### Backend
```bash
cd backend
# Run with H2 in‑memory DB
./mvnw spring-boot:run    # (or) mvn spring-boot:run
# App: http://localhost:8080
# H2 console: http://localhost:8080/h2  (JDBC URL: jdbc:h2:mem:projecthub)
```
Default seed user (in `data.sql`):
- **email:** `admin@projecthub.dev`
- **password:** `admin123`

### Frontend
```bash
cd frontend
npm install
npm run dev
# App: http://localhost:5173
# Configure API base if needed via .env: VITE_API_BASE=http://localhost:8080/api
```

---

## 🔐 API Overview (Selected)
- `POST /api/auth/register` — register
- `POST /api/auth/login` — login → `{ token }`
- `GET  /api/public/projects` — public list
- `POST /api/projects` — create (JWT)
- `GET  /api/public/posts` — public blog
- `POST /api/posts` — create (JWT)

Import Postman collection easily by reading these routes; auth uses `Authorization: Bearer <token>`.

---

## 🛢️ Switch to MySQL (optional)
1. Install MySQL and create DB `projecthub`.
2. Update `backend/src/main/resources/application-mysql.properties` with username/password.
3. Run backend with MySQL profile:
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=mysql
```

---

## 🐳 Docker (optional)
A minimal Docker Compose is included to run MySQL + backend + frontend (you can expand as needed).

```bash
docker compose up --build
```

---

## 🧪 Sample Data
Seeded via `data.sql` — one project and one blog post are preloaded.

---

## 📸 Screens (optional)
- Home — intro and quick links
- Projects — grid of projects (public)
- Blog — list of posts (public)
- Admin — login + create project (JWT)

---

## 📝 License
MIT — use freely in your portfolio.
