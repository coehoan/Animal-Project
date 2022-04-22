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
INSERT INTO Post(board, content, createDate, region, title, type, updateDate, userId, category, recommended, view) VALUES("자유게시판", "냥냥쓰", null, null, "멍멍쓰", null, null, 1, null, 5, 10);
INSERT INTO Post(board, content, createDate, region, title, type, updateDate, userId, category, recommended, view) VALUES("자유게시판", "무엉무엉", null, null, "냐옹냐옹", null, null, 2, null, 5, 10);
INSERT INTO Post(board, content, createDate, region, title, type, updateDate, userId, category, recommended, view) VALUES("자유게시판", "미잉미잉", null, null, "우앙우앙", null, null, 1, null, 5, 10);


-- 유저 지역에 따라서 일치하는 지역순으로 뿌리기
SELECT * FROM Animals am 