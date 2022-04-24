SELECT *
FROM Post;
SELECT *
FROM Animals;
SELECT *
FROM newAnimals;
DROP TABLE newAnimals;
DROP TABLE Animals;
-- 테이블 복제 쿼리
CREATE TABLE temptable;
SELECT *
FROM Animals am,
    newAnimals na
WHERE na.desertionNo = am.desertionNo;
SELECT *
FROM Animals am
WHERE happenDt LIKE "%2022-04-01%"
GROUP BY age,
    careAddr,
    careNm,
    careTel,
    chargeNm,
    colorCd,
    desertionNo,
    filename,
    happenDt,
    happenPlace,
    kindCd,
    neuterYn,
    noticeComment,
    noticeEdt,
    noticeNo,
    noticeSdt,
    officetel,
    orgNm,
    popfile,
    processState,
    sexCd,
    specialMark,
    weight;
-- 중복 제거 쿼리
DELETE A
FROM Animals A
    INNER JOIN (
        SELECT MAX(id) AS id
        FROM Animals
        GROUP BY id,
            age,
            careAddr,
            careNm,
            careTel,
            chargeNm,
            colorCd,
            desertionNo,
            filename,
            happenDt,
            happenPlace,
            kindCd,
            neuterYn,
            noticeComment,
            noticeEdt,
            noticeNo,
            noticeSdt,
            officetel,
            orgNm,
            popfile,
            processState,
            sexCd,
            specialMark,
            weight
        HAVING COUNT(id) > 1
    ) B ON A.id = B.id;
SELECT MAX(id) AS id
FROM Animals
GROUP BY id,
    age,
    careAddr,
    careNm,
    careTel,
    chargeNm,
    colorCd,
    desertionNo,
    filename,
    happenDt,
    happenPlace,
    kindCd,
    neuterYn,
    noticeComment,
    noticeEdt,
    noticeNo,
    noticeSdt,
    officetel,
    orgNm,
    popfile,
    processState,
    sexCd,
    specialMark,
    weight
HAVING COUNT(id) > 1;
-- 지역, 날짜, 품종 검색 쿼리 
SELECT *
FROM Animals am
WHERE KindCd LIKE "%강아지%"
    AND careAddr LIKE "%서울특별시%"
    AND noticeSdt LIKE "%202204015%"
GROUP BY age,
    careAddr,
    careNm,
    careTel,
    chargeNm,
    colorCd,
    desertionNo,
    filename,
    happenDt,
    happenPlace,
    kindCd,
    neuterYn,
    noticeComment,
    noticeEdt,
    noticeNo,
    noticeSdt,
    officetel,
    orgNm,
    popfile,
    processState,
    sexCd,
    specialMark,
    weight DESC;

id          | int(11)      | NO   | PRI | NULL    | auto_increment |
| board       | varchar(30)  | NO   |     | NULL    |                |
| content     | longtext     | NO   |     | NULL    |                |
| createDate  | datetime(6)  | YES  |     | NULL    |                |
| region      | varchar(15)  | YES  |     | NULL    |                |
| title       | varchar(300) | NO   |     | NULL    |                |
| type        | varchar(15)  | YES  |     | NULL    |                |
| updateDate  | datetime(6)  | YES  |     | NULL    |                |
| userId      | int(11)      | YES  | MUL | NULL    |                |
| category    | varchar(15)  | YES  |     | NULL    |                |
| recommended | int(11)      | NO   |     | NULL    |                |
| view

SHOW TABLE Post;
INSERT INTO Post(board, content, createDate, region, title, type, updateDate, userId, category, recommended, view) VALUES("입양후기", "냥냥쓰", null, null, "멍멍쓰", null, null, 1, null, 5, 10);
INSERT INTO Post(board, content, createDate, region, title, type, updateDate, userId, category, recommended, view) VALUES("지역별게시판", "무엉무엉", null, null, "냐옹냐옹", null, null, 2, null, 5, 10);
INSERT INTO Post(board, content, createDate, region, title, type, updateDate, userId, category, recommended, view) VALUES("자유게시판", "미잉미잉", null, null, "우앙우앙", null, null, 1, null, 5, 10);

INSERT IGNORE INTO `post` (`id`, `board`, `content`, `createDate`, `region`, `title`, `type`, `category`, `updateDate`, `userId`) VALUES
    (1, 'adopt', '<p>내용</p>', '2022-04-17 20:12:33.050029', 'seoul', '입양후기/서울', 'dog', NULL, '2022-04-17 20:12:33.050029', 1),
    (2, 'adopt', '<p>내용</p>', '2022-04-17 20:12:44.046224', 'busan', '입양후기/부산', NULL, NULL, '2022-04-17 20:12:44.046224', 1),
    (3, 'region', '<p>내용</p>', '2022-04-17 20:12:56.316327', 'seoul', '지역/서울', NULL, 'ask', '2022-04-17 20:12:56.316327', 1),
    (4, 'region', '<p>내용</p>', '2022-04-17 20:13:15.825428', 'busan', '지역/부산', NULL, 'ask', '2022-04-17 20:13:15.825428', 1),
    (5, 'free', '<p>내용</p>', '2022-04-17 20:13:25.125766', NULL, '자유', NULL, NULL, '2022-04-17 20:13:25.125766', 1),
    (6, 'adopt', '<p>후기후기</p>', '2022-04-18 14:29:30.429082', 'busan', '입양후기/부산/고양이', 'cat', NULL, '2022-04-18 14:29:30.429082', 1),
    (8, 'adopt', '<p>입양후기</p>', '2022-04-18 19:47:53.900869', 'busan', '입양후기', 'dog', NULL, '2022-04-18 19:47:53.900869', 1),
    (9, 'adopt', '<p>입양후기</p>', '2022-04-18 19:48:00.172400', 'daegu', '입양후기', 'cat', NULL, '2022-04-18 19:48:00.172400', 1),
    (10, 'adopt', '<p>입양후기</p>', '2022-04-18 19:48:07.703189', 'seoul', '입양후기', 'dog', NULL, '2022-04-18 19:48:07.703189', 1);

SELECT addr FROM User;

-- 유저 지역에 따라서 일치하는 지역순으로 뿌리기
DROP TABLE User;
DROP TABLE Post;

SELECT * FROM Animals am;

SELECT addrSido, addrSigungu FROM User
WHERE addrSido AND addrSigungu;

SELECT * FROM User;

SELECT * FROM Animals am WHERE KindCd LIKE %:keywordOfkind% AND KindCd LIKE %:keywordOfkindOf% AND careAddr LIKE %:keywordOfSido% AND careAddr LIKE %:keywordOfSigungu% AND noticeSdt LIKE %:keywordOfirstDate% AND noticeSdt LIKE %:keywordOflastDate% GROUP BY age, careAddr, careNm, careTel, chargeNm, colorCd,desertionNo,filename,happenDt,happenPlace,kindCd,neuterYn,noticeComment,noticeEdt,noticeNo,noticeSdt,officetel,orgNm,popfile,processState,sexCd,specialMark,weight DESC

UNION ALL

SELECT *
FROM Animals am
WHERE orgNm in (
    SELECT id AND addrSido + addrSigungu FROM User
    WHERE id = 1 AND addrSido + addrSigungu = am.orgNm
)
GROUP BY age,
    careAddr,
    careNm,
    careTel,
    chargeNm,
    colorCd,
    desertionNo,
    filename,
    happenDt,
    happenPlace,
    kindCd,
    neuterYn,
    noticeComment,
    noticeEdt,
    noticeNo,
    noticeSdt,
    officetel,
    orgNm,
    popfile,
    processState,
    sexCd,
    specialMark,
    weight
    DESC;



SELECT * FROM Animals am WHERE orgNm in (SELECT id AND addrSido + addrSigungu FROM User WHERE id = 1 AND addrSido + addrSigungu = am.orgNm) GROUP BY age, careAddr, careNm, careTel, chargeNm, colorCd, desertionNo, filename, happenDt, happenPlace, kindCd, neuterYn, noticeComment, noticeEdt, noticeNo, noticeSdt, officetel, orgNm, popfile, processState, sexCd, specialMark, weight DESC;

SELECT * FROM Animals am WHERE orgNm in (SELECT id AND addrSido + addrSigungu FROM User WHERE id = 1 AND addrSido + addrSigungu = am.orgNm);

SELECT * FROM Animals am WHERE KindCd LIKE "%강아지%"AND KindCd LIKE "%믹스견%" GROUP BY age,careAddr,careNm,careTel,chargeNm,colorCd,desertionNo,filename,happenDt,happenPlace,kindCd,neuterYn,noticeComment,noticeEdt,noticeNo,noticeSdt,officetel,orgNm,popfile,processState,sexCd,specialMark,weight DESC UNION ALL SELECT * FROM Animals am WHERE orgNm in (SELECT id AND addrSido + addrSigungu FROM User WHERE id = :id AND addrSido + addrSigungu = am.orgNm) GROUP BY age, careAddr, careNm, careTel, chargeNm, colorCd, desertionNo, filename, happenDt, happenPlace, kindCd, neuterYn, noticeComment, noticeEdt, noticeNo, noticeSdt, officetel, orgNm, popfile, processState, sexCd, specialMark, weight DESC;

SELECT * FROM Animals;

SELECT * FROM Animals am WHERE KindCd LIKE "%강아지%" AND KindCd LIKE "%믹스견%" GROUP BY age,careAddr,careNm,careTel,chargeNm,colorCd,desertionNo,filename,happenDt,happenPlace,kindCd,neuterYn,noticeComment,noticeEdt,noticeNo,noticeSdt,officetel,orgNm,popfile,processState,sexCd,specialMark,weight DESC;

SELECT * FROM Animals am WHERE KindCd LIKE "%개%" AND KindCd LIKE "%믹스견%" AND careAddr LIKE "%전라북도%" AND careAddr LIKE "%고창군%" AND noticeSdt LIKE "20220421" AND noticeSdt LIKE "20220421" GROUP BY age, careAddr, careNm, careTel, chargeNm, colorCd,desertionNo,filename,happenDt,happenPlace,kindCd,neuterYn,noticeComment,noticeEdt,noticeNo,noticeSdt,officetel,orgNm,popfile,processState,sexCd,specialMark,weight DESC;

SELECT * FROM Animals am WHERE orgNm in (SELECT id AND addrSido + addrSigungu FROM User WHERE id = 1 AND addrSido + addrSigungu = am.orgNm) GROUP BY age, careAddr, careNm, careTel, chargeNm, colorCd, desertionNo, filename, happenDt, happenPlace, kindCd, neuterYn, noticeComment, noticeEdt, noticeNo, noticeSdt, officetel, orgNm, popfile, processState, sexCd, specialMark, weight DESC;


SELECT * FROM User;

-- 유저 지역검색

SELECT *
FROM Animals am 
WHERE orgNm IN
(
SELECT id AND addrSido FROM User
WHERE id = 1 AND addrSido LIKE "서울특별시" = am.orgNm
)
GROUP BY age, careAddr, careNm, careTel, chargeNm, colorCd, desertionNo, filename, happenDt, happenPlace, kindCd, neuterYn, noticeComment,
    noticeEdt, noticeNo, noticeSdt, officetel, orgNm, popfile, processState, sexCd, specialMark, weight
ORDER BY case when orgNm = '서울특별시' then 1
ELSE 2 END;

SELECT * 
FROM Animals am 
WHERE orgNm IN
(
SELECT id AND addrSido + addrSigungu FROM User
WHERE id = 1 AND addrSido + addrSigungu = am.orgNm
)
GROUP BY age, careAddr, careNm, careTel, chargeNm, colorCd, desertionNo, filename, happenDt, happenPlace, kindCd, neuterYn, noticeComment,
    noticeEdt, noticeNo, noticeSdt, officetel, orgNm, popfile, processState, sexCd, specialMark, weight
ORDER BY case when am.orgNm = '서울특별시' then 1
ELSE 2 END;

SELECT * FROM Animals am WHERE orgNm IN (SELECT id AND addrSido + addrSigungu FROM User WHERE id = 1 AND addrSido + addrSigungu = am.orgNm) GROUP BY age, careAddr, careNm, careTel, chargeNm, colorCd, desertionNo, filename, happenDt, happenPlace, kindCd, neuterYn, noticeComment, noticeEdt, noticeNo, noticeSdt, officetel, orgNm, popfile, processState, sexCd, specialMark, weight ORDER BY case when am.orgNm = '서울특별시' + '마포구' then 1 ELSE 1 END;

SELECT id, addrSido, addrSigungu FROM User
WHERE id = 1 OR addrSido OR addrSigungu;

(
SELECT addrSido, addrSigungu FROM User
WHERE id = 1 OR addrSido OR addrSigungu
) um;


SELECT *
FROM Animals am
GROUP BY age, careAddr, careNm, careTel, chargeNm, colorCd, desertionNo, filename, happenDt, happenPlace, kindCd, neuterYn, noticeComment,
    noticeEdt, noticeNo, noticeSdt, officetel, orgNm, popfile, processState, sexCd, specialMark, weight
HAVING am.orgNm = "부산광역시 해운대구"

UNION ALL

SELECT * FROM Animals
GROUP BY age, careAddr, careNm, careTel, chargeNm, colorCd, desertionNo, filename, happenDt, happenPlace, kindCd, neuterYn, noticeComment,
    noticeEdt, noticeNo, noticeSdt, officetel, orgNm, popfile, processState, sexCd, specialMark, weight;

FROM Animals
GROUP BY age, careAddr, careNm, careTel, chargeNm, colorCd, desertionNo, filename, happenDt, happenPlace, kindCd, neuterYn, noticeComment,
    noticeEdt, noticeNo, noticeSdt, officetel, orgNm, popfile, processState, sexCd, specialMark, weight;
ORDER BY case when am.orgNm = "서울특별시 마포구" then 1
ELSE 2 END;


SELECT id AND addrSido + addrSigungu FROM User
WHERE id = 1 AND addrSido + addrSigungu = 0;