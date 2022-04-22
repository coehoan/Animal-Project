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