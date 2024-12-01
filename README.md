# 📑 Project
- 프로젝트명 : 스마트폰 카메라를 활용한 시험감독 보조 시스템 - "EYESee"

| **관리자**    | **수험자**        |
|-------------|---------------------|
| ![대시보드목업](https://github.com/user-attachments/assets/8110567a-1d4e-4b61-b5fe-4d968f14324d)     | ![모바일](https://github.com/user-attachments/assets/24ee359d-f08c-4bdf-b627-bf3cc1a97223)
  



## 1. 개발 동기 및 목표


### 1) 개발 동기

- **대규모 시험의 감독 어려움**
  - 모든 수험자를 실시간으로 모니터링하는 것은 현실적으로 어려움
  - 특히 대면 시험에서 수험자의 시선과 행동 감시는 필수적이지만 인력과 기술의 한계로 인해 부정행위 감지에 어려움 존재
- **부정행위의 잠재적 위험**
  - 수험자가 시험지 이외의 장소를 주시하거나 부정한 물체를 사용하는 경우 발생
  - 이러한 행동을 실시간으로 감시하고 제어할 필요성 대두
- **공정한 시험 환경 구축 필요**
  - 부정행위를 실시간으로 감지하여 모든 수험자에게 동등한 시험 환경 제공 필요

### 2) 개발 목표

- **실시간 부정행위 감지 시스템 개발**
  - 모바일 카메라와 AI 기반의 시선 추적 및 객체 탐지 기술을 결합
  - 수험자의 시선 및 행동을 모니터링하여 부정행위 발생 시 경고 메시지 발송
- **시험 관리 효율성 증대**
  - 감독관의 부담을 줄이고 다수의 수험자를 효과적으로 관리
- **공정한 평가 구현**
  - 부정행위를 최소화하여 수험자들에게 공정한 시험 기회 제공

## 2. 필요성

- **대면 시험 부정행위 방지 시스템의 부재**
  - 기존 시스템은 비대면 시험에 초점을 맞추어 대면 시험에서는 활용이 제한적
- **기존 부정행위 감지 방식의 한계**
  - 감독관의 직관에 의존하여 감지율이 낮고 일관성이 부족
- **시선 추적 및 객체 탐지 기술의 발전**
  - AI 기술의 발전으로 실시간 감지 및 분석 가능
  - 교육 및 시험 감독 분야에서의 적용으로 부정행위 방지에 기여
- **효율적인 시험 관리 필요**
  - 대규모 시험에서 감독 효율성을 높이고 부정행위를 예방하여 공정성 확보


## 3. 차별점 및 개선점

- **대면 시험 환경에 특화**
  - 기존 시스템은 비대면 시험 환경에 최적화된 반면, 본 시스템은 대면 시험 환경에 맞춰 설계됨
  - 모바일 카메라를 활용해 수험자의 시선을 추적하고, 손이나 책상 위 물체를 감지하는 객체 탐지 기능 제공

- **다양한 부정행위 유형 감지**
  - 시선 추적을 통해 시험지 이외의 장소를 주시하는 행위 감지
  - 객체 탐지로 손이나 책상 위 부정 물체 사용 여부 실시간 감지

- **효율적인 데이터 관리**
  - 경고가 발생할 때에만 영상을 녹화하여 데이터 처리 부담 감소
  - 불필요한 영상 저장을 방지하고 저장소 효율성 극대화

- **실시간 알림 시스템**
  - 부정행위 감지 시 감독관에게 즉각 알림 전송
  - 감독관의 효율적인 개입 지원으로 시험 관리 부담 경감






<br>
<br>

# 🎨 프로젝트 설계

## 1. 플로우차트

![플로우차트](https://github.com/user-attachments/assets/f67e9411-2002-477b-989f-54edeb8c4790)



## 2. ERD
<img width="1258" alt="ERD" src="https://github.com/user-attachments/assets/0a3cb386-eaea-4850-9fdf-2bed08a0b664">



## 3. 개발 환경

| **분류**    | **기술 스택**        |
|-------------|---------------------|
| **AI**      | YOLO v8, MediaPipe  |
| **Frontend**| NEXT.js, Vercel     |
| **Backend** | Spring Boot, MySQL, Redis, AWS RDS, AWS EC2, nginx |

<br>

## 4. 시스템 아키텍처
<img width="912" alt="아키텍쳐" src="https://github.com/user-attachments/assets/e12629fb-eb3a-4d20-83ed-51c8aebed1e0">


<br><br>

# ⚙️ 파트별 핵심 기술 

## 1. AI


## 2. 프론트엔드


## 3. 백엔드


<br><br>

# 🎬 시연 영상
(링크)

<br><br>

# 🛜 접속 링크
- 수험자
  https://eyesee-exam.vercel.app
  
- 관리자
  https://eyesee-admin.vercel.app

<br>

# 🦉 Team
| **이름**            | **학과**         | **학번**     | **역할**                         | **주요 업무**                                   |
|----------------------|------------------|--------------|-----------------------------------|------------------------------------------------|
| [천기정](https://github.com/gi-jeong1000) | 산업시스템공학과 | 2019112471 | AI                                | 객체 탐지 및 시선 추적 AI 개발                  |
| [설현아](https://github.com/hyeona01) | 융합보안학과     | 2022113107 | Frontend                         | UI/UX 설계 및 프론트엔드 개발                  |
| [이종범](https://github.com/JongbeomLee623) | 경영정보학과     | 2019111598 | Backend                          | AWS EC2 & nginx 서버 개발, 백엔드 API 개발     |
| [김호정](https://github.com/HOJEONGKIMM) | 경영정보학과     | 2020111556 | Backend                          | 백엔드 API 개발                                |


## 🧑🏻‍🏫 Mentor

- [김주영 멘토님]

  
<br>

# 🔒 협업 규칙 
## 브랜치 규칙

- **메인 브랜치에서 분기하여 사용**
  - 브랜치 이름 규칙:
    ```html
    frontend/feature/signin
    backend/fix
    ai/feature
    ```

## 커밋 메시지 규칙

- 커밋 메시지 작성 형식:
  ```html
  BE: [feature] dto 구조 변경 #1
  ```