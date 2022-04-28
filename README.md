# 유기동물, 보호소 조회 서비스
### 사이트 소개 🐈‍⬛
✔️ 전국 약 14만건의 유기동물의 정보를 다운받아 원하는 지역별로 자료를 제공했습니다.<br>
✔️ 전국 약 600여군데의 유기동물 보호소 정보를 제공했습니다.<br>
✔️ 관련 자료를 검색할 수 있고, 별도 블로그를 만들어 입양후기, 지역별로 사용자가 글을 작성할 수 있습니다.<br>
✔️ 블로그 프로그램을 통해 유기동물에 대한 커뮤니티를 구축하고자 했습니다.<br>
✔️ 검색 기능에서 회원가입을 통해 자신이 살고 있는 지역을 기준으로 데이터 결과를 나타내게 하는 서비스를 제공합니다.<br>


### 팀원구성 👥

1. 팀장 최명신
- 프론트엔드 화면 설계, 블로그 서비스 제작
2. 팀원 전가은
- 백엔드 api 다운, 유기동물 조회 서비스 제작
3. 팀원 김재욱
-- 백엔드 api 다운, 보호소 조회 서비스 제작
<br>

### 사용 기술 ⌨️
<img src="https://img.shields.io/badge/-Java-007396"/>  <img src="https://img.shields.io/badge/-Spring-6DB33F"/>  <img src="https://img.shields.io/badge/-Apach%20Tomcat-F8DC75"/> <img src="https://img.shields.io/badge/-MariaDB-071D49"/> 
<img src="https://img.shields.io/badge/-HTML5-E34F26"/> <img src="https://img.shields.io/badge/-CSS-1572B6"/> <img src="https://img.shields.io/badge/-JavaScript-F7DF1E"/> <img src="https://img.shields.io/badge/-JQuery-0769AD"/> 
<img src="https://img.shields.io/badge/-Github-181717"/> <img src="https://img.shields.io/badge/-Git-F05032"/> <img src="https://img.shields.io/badge/-FontAwesome-528DD7"/> <img src="https://img.shields.io/badge/-BootStrap-7952B3"/> 

[![Top Langs](https://github-readme-stats.vercel.app/api/top-langs/?username=coehoan&layout=compact)](https://github.com/anuraghazra/github-readme-stats)
<br>

### 사용 라이브러리 🍎
```
- Spring Boot DevTools
- Spring Web
- Spring Data JPA
- Lombok
- MariaDB
- Mustache
- TOAST UI
- Naver Maps Api
```
<br>

### Github 주소 🌳
[https://github.com/coehoan/Animal-Project](https://github.com/coehoan/Animal-Project)<br>
[https://github.com/coehoan/Project-blog-test.git](https://github.com/coehoan/Project-blog-test.git)<br>
[https://github.com/coehoan/Animal-Project-BackEnd.git](https://github.com/coehoan/Animal-Project-BackEnd.git)<br>
[https://github.com/gouthiki90/2022-Animals-webProject.git](https://github.com/gouthiki90/2022-Animals-webProject.git)<br>

### MariaDB 세팅 🦭
```sql
-- 모든 IP로 접근 가능한 유저 생성
CREATE USER 'animal'@'%' IDENTIFIED BY 'password';

-- DB 생성
CREATE DATABASE animaldb;

-- 모든 권한을 줌
GRANT ALL PRIVILEGES ON animaldb.* TO 'animal'@'%';
```

### 데이터 다운로드 ⏬
[유기동물 공공데이터](https://www.data.go.kr/tcs/dss/selectApiDataDetailView.do?publicDataPk=15098931)<br>
[유기동물 보호소 공공데이터](https://www.data.go.kr/tcs/dss/selectApiDataDetailView.do?publicDataPk=15035887)
```
/sido -> 시도코드 다운로드
/sigungu -> 시군구코드 다운로드
/shelter -> 보호소정보 다운로드
/kind -> 동물 종류 다운로드
/animals -> 유기동물 데이터 다운로드
```

## 설계 과정 🧰
<details>
<summary>더보기</summary>
<div markdown="1">
  
### ERD
![ERD](https://user-images.githubusercontent.com/97711652/164983516-ec17bb22-9e93-4303-80f1-53de5b2563ef.png)


### 화면설계
#### 메인페이지
![메인페이지](https://user-images.githubusercontent.com/97711652/164985300-1e07a88a-59f4-47ce-a1de-f857b748a7c0.jpg)
#### 로그인, 회원가입 페이지
![image](https://user-images.githubusercontent.com/97711652/164986027-1ea03be6-b175-4114-b8b5-cad8c9601042.png)

#### 블로그
![블로그메인페이지](https://user-images.githubusercontent.com/97711652/164986070-da9b1a6c-6d10-4e85-abef-a1583268a706.jpg)
![입양후기게시판](https://user-images.githubusercontent.com/97711652/164986080-a5a8faea-523c-4737-b2f7-f19876f6174a.jpg)
![자유게시판](https://user-images.githubusercontent.com/97711652/164986082-f2c2e830-7213-4e29-990d-955107578686.jpg)
![지역별게시판](https://user-images.githubusercontent.com/97711652/164986083-5ae1266e-df12-42c1-9e2f-1d4bf8af45f9.jpg)

#### 유기동물 조회 서비스
![유기동물현황](https://user-images.githubusercontent.com/97711652/164986106-e5ad65a8-4ada-4211-9a12-0f7a40261c81.jpg)

#### 보호소 조회 서비스
![보호소조회](https://user-images.githubusercontent.com/97711652/164986108-5995aaaf-d5f4-4a10-810f-3a3c88a4cce8.jpg)

#### 함께하는이들
![함께하는이들(수의사)](https://user-images.githubusercontent.com/97711652/164986197-ef9d9c0a-58e7-4d9b-9928-a5bcf5369b61.jpg)
![함께하는이들(카라)](https://user-images.githubusercontent.com/97711652/164986199-d1e3431b-8724-40a2-a438-fb264954052b.jpg)
<br>
</div>
</details>



## 테스트코드 🧪
### 유튜브 영상 소스코드 넣기

[https://github.com/gouthiki90/2022-AnimalProject-youtube-test.git](https://github.com/gouthiki90/2022-AnimalProject-youtube-test.git)

### TOAST UI 사용법

[https://github.com/coehoan/Spring-TOASTUI-test.git](https://github.com/coehoan/Spring-TOASTUI-test.git)

### Springboot RestTeplate 공공데이터 다운로드 테스트
[https://github.com/gouthiki90/2020-AnimalProject-dataTest.git](https://github.com/gouthiki90/2020-AnimalProject-dataTest.git)
<br>

## 페이지별 상세 기능 📃
### 블로그
- 블로그 메인페이지에선 각 게시판별 조회수 Top3를 미리 보여줍니다.
- 각 게시판별로 원하는 조건(지역별, 품종별, 종류별)에 따라 상세검색이 가능합니다.
- 최신순, 조회순, 추천순으로 게시판 Sort가 가능합니다.
- 제목, 내용, 작성자별 검색이 가능합니다.

### 유기동물 현황
|유저검색|지역검색|
|---|---|
|![https://github.com/gouthiki90/2022-Animals-webProject/blob/master/%EC%8B%9C%EC%97%B0%EC%98%81%EC%83%81/%EC%9C%A0%EC%A0%80%EA%B2%80%EC%83%89.gif?raw=true](https://github.com/gouthiki90/2022-Animals-webProject/blob/master/%EC%8B%9C%EC%97%B0%EC%98%81%EC%83%81/%EC%9C%A0%EC%A0%80%EA%B2%80%EC%83%89.gif?raw=true)|![https://github.com/gouthiki90/2022-Animals-webProject/blob/master/%EC%8B%9C%EC%97%B0%EC%98%81%EC%83%81/%EC%A7%80%EC%97%AD%EA%B2%80%EC%83%89.gif?raw=true](https://github.com/gouthiki90/2022-Animals-webProject/blob/master/%EC%8B%9C%EC%97%B0%EC%98%81%EC%83%81/%EC%A7%80%EC%97%AD%EA%B2%80%EC%83%89.gif?raw=true)|
|유저검색|지역검색|
|![https://github.com/gouthiki90/2022-Animals-webProject/blob/master/%EC%8B%9C%EC%97%B0%EC%98%81%EC%83%81/%EC%A0%84%EC%B2%B4%EA%B2%80%EC%83%89.gif?raw=true](https://github.com/gouthiki90/2022-Animals-webProject/blob/master/%EC%8B%9C%EC%97%B0%EC%98%81%EC%83%81/%EC%A0%84%EC%B2%B4%EA%B2%80%EC%83%89.gif?raw=true)|![https://github.com/gouthiki90/2022-Animals-webProject/blob/master/%EC%8B%9C%EC%97%B0%EC%98%81%EC%83%81/%EB%82%A0%EC%A7%9C%EA%B2%80%EC%83%89.gif?raw=true](https://github.com/gouthiki90/2022-Animals-webProject/blob/master/%EC%8B%9C%EC%97%B0%EC%98%81%EC%83%81/%EB%82%A0%EC%A7%9C%EA%B2%80%EC%83%89.gif?raw=true)|

- 전국 유기동물 현황 조회가 가능합니다.
- 지역별, 상세 품종별, 시도, 품종, 날짜별로 검색이 가능합니다.
- User의 로그인 세션값을 통해서 User의 지역순으로 전체 검색이 가능합니다.

### 보호소 조회
- 주소를 통한 전체검색기능 사용가능
- 전국 보호소 운영시간, 운영장소 확인 가능

## 시연영상 📹
### 사이트 전체 흐름 및 블로그
[https://youtu.be/vaoJolh4b08](https://youtu.be/vaoJolh4b08)
### 유기동물 조회 서비스
[https://youtu.be/tt1wWs_LowE](https://youtu.be/tt1wWs_LowE)


## 프로젝트 소감 ✨
1. 최명신
- 팀장으로서 인원과 시간분배를 적절히 하지못해 계획했던 기능을 모두 구현하지 못해 아쉬움
- 클라이언트-웹서버-데이터베이스 간 통신의 원리에 대한 개념을 다시 정리하게됨.
- 디버깅을 하면서 어디서 어떤 오류들이 자주 발생하는지 알게 되었으며, 오류의 원인 파악에 걸리는 시간이 줄어듬.
- 팀단위 프로젝트를 하면서 개개인의 실력도 중요하지만 협업과 소통의 중요성을 알게됨.
- 팀단위 프로젝트를 다시 하게되면 기획, 설계 단계부터 완벽하게 하고 코딩을 시작해야 할 것 같다.

2. 전가은
- 검색 기능을 구현하면서 쿼리 설계를 효율적으로 구성하는 게 중요하다는 것을 깨달았습니다.
- 프로그래밍을 하면서 단위 테스트가 중요하다는 것을 알았습니다.
- 사용자 경험에 따라서 어떻게 검색 기능을 구현해야 할지 고민하면서 최선을 다했습니다. 검색 기능이란 것에 수많은 설계와 프로그래밍이 필요하다는 것을 깨달았습니다.
- 쿼리 설계와 디버깅에 능숙하지 못해서 기능 구현을 빠르게 하지 않았음에 아쉬움이 있습니다.
- 오류가 생겨도 끈기를 가지고 디버깅을 하는 것에서 저의 실력이 늘고 있다는 것에 뿌듯함을 느꼈습니다.

3. 김재욱
- 팀원들 실력에 따라가지 못한게 아쉬움만 있습니다.
- 스스로 한다고 몇시간이면 끝날일을 몇십시간을 소모한 것에 후회했습니다.
- 도움을 요청하지 않으려는게 큰 민폐라는걸 알았습니다.
