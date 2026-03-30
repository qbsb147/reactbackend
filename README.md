# Spring Boot Backend Project

## 📌 프로젝트 소개

Spring Boot와 JPA(Hibernate)를 기반으로 구현한 영화 관리 백엔드 애플리케이션입니다.
REST API를 통해 프론트엔드와 데이터를 주고받으며, 회원 관리와 영화 정보 처리 기능을 제공합니다.
Controller-Service-Repository 구조를 적용하여 계층형 아키텍처를 구성했습니다.

---

## 🛠 사용 기술

* Spring Boot
* JPA (Hibernate)
* H2 Database
* REST API
* Lombok

---

## 🏗 주요 기능

### ✔ 회원 기능

* 회원가입 / 로그인
* 회원 정보 조회 및 관리

### ✔ 영화 기능

* 영화 등록 / 조회 / 수정 / 삭제
* 페이징 처리
* 장르 기반 필터링
* Movie - Member - Genre 연관관계 관리

---

## 🎯 담당 역할

* REST API 설계 및 Controller-Service-Repository 구조 구현
* JPA 기반 엔티티 설계 및 영화/회원/장르 연관관계 매핑
* 페이징 및 장르 필터 기능 포함한 비즈니스 로직 구현

---

## 📚 성과 및 배운 점

* 계층형 아키텍처 설계를 통한 서버 구조 이해
* JPA 연관관계 매핑 및 쿼리 처리 경험
* 프론트엔드와 API 연동을 통한 전체 애플리케이션 흐름 이해

---

## 🚀 실행 방법

1. 프로젝트 클론

   ```bash
   git clone [[REPO_URL](https://github.com/qbsb147/reactbackend.git)]
   ```
2. 빌드 및 실행

   ```bash
   ./gradlew bootRun
   ```
3. 서버 실행 후 API 호출 테스트

---

## 🗓 프로젝트 기간

2025.3.22 ~ 2025.3.30

---

## 🔗 참고

* 개인 프로젝트
* GitHub 저장소에 코드 업로드
