## 유기동물 및 보호소 조회 프로젝트 백엔드
### 사용 라이브러리
- Spring Boot DevTools
- Spring Web
- Spring Data JPA
- Lombok
- MariaDB
- Mustache

### Git 주소
```https://github.com/coehoan/Animal-Project-BackEnd```

### mariaDB 세팅
```sql
-- 모든 IP로 접근 가능한 유저 생성
CREATE USER 'animal'@'%' IDENTIFIED BY 'password';

-- DB 생성
CREATE DATABASE animaldb;

-- 모든 권한을 줌
GRANT ALL PRIVILEGES ON animaldb.* TO 'animal'@'%';
```

### 유기동물 API 코드 모음
#### 시도 코드
```txt
부산광역시 시도 코드 : 6260000
대구광역시 시도 코드 : 6270000
인천광역시 시도 코드 : 6280000
광주광역시 시도 코드 : 6290000
세종특별자치시 시도 코드 : 5690000
대전광역시 시도 코드 : 6300000
울산광역시 시도 코드 : 6310000
경기도 시도 코드 : 6410000
강원도 시도 코드 : 6420000
충청북도 시도 코드 : 6430000
충청남도 시도 코드 : 6440000
전라북도 시도 코드 : 6450000
전라남도 시도 코드 : 6460000
경상북도 시도 코드 : 6470000
경상남도 시도 코드 : 6480000
제주특별자치도 시도 코드 : 6500000
```

