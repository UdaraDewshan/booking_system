<div align="center">

  <h1>📅 Interview Booking System</h1>
  
  <p>
    A modern, full-stack scheduling application that simplifies the interview process. Built with <strong>Spring Boot</strong> and <strong>Angular</strong>.
  </p>

<p>
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java" />
  <img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white" alt="Spring Boot" />
  <img src="https://img.shields.io/badge/Angular-DD0031?style=for-the-badge&logo=angular&logoColor=white" alt="Angular" />
  <img src="https://img.shields.io/badge/Tailwind_CSS-38B2AC?style=for-the-badge&logo=tailwind-css&logoColor=white" alt="Tailwind CSS" />
  <img src="https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white" alt="MySQL" />
</p>

</div>

---

## 🚀 Overview

The **Interview Booking System** is designed to streamline the scheduling of candidate interviews. It features a robust backend to handle time conflicts and logic, paired with a clean, responsive, and user-friendly calendar interface.

### 📸 Screenshots
> *(Add your frontend calendar view screenshot here)*
> `![Calendar View](link-to-your-image.png)`

---

## ✨ Key Features

### 🛡️ Backend (Core Logic)
- **Conflict Detection:** Prevents interviewers from being double-booked for overlapping time slots.
- **Time Validation:** Strict validation ensures no bookings can be made in the past.
- **DTO Pattern:** Clean data transfer using `ModelMapper` to prevent infinite recursion and hide sensitive entities.
- **Email Simulation:** Logs simulated email notifications upon successful booking.

### 🎨 Frontend (UI/UX)
- **Interactive Calendar Grid:** A visually appealing, card-based calendar view.
- **Smart Modals:** Intuitive popups for booking slots.
- **Dynamic Status Badges:** Color-coded badges (Available, Booked, Confirmed).
- **Graceful Error Handling:** Backend validation errors are displayed nicely to the user.

---

## 🗄️ Database Architecture (ERD)

```mermaid
erDiagram
    INTERVIEWER ||--o{ INTERVIEW_SLOT : creates
    CANDIDATE ||--o{ BOOKING : makes
    INTERVIEW_SLOT ||--o| BOOKING : has

    INTERVIEWER {
        Long id PK
        String name
        String email
        String specialization
    }
    CANDIDATE {
        Long id PK
        String userName
        String email
        String contactNo
    }
    INTERVIEW_SLOT {
        Long id PK
        LocalDateTime startTime
        LocalDateTime endTime
        String status
        Long interviewer_id FK
    }
    BOOKING {
        Long id PK
        LocalDateTime bookedAt
        Long candidate_id FK
        Long slot_id FK
    }
