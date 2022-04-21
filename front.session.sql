SELECT *
FROM Post;
SELECT *
FROM Animals;
SELECT *
FROM newAnimals;
CREATE TABLE temptable;
SELECT *
FROM Animals am,
    newAnimals na
WHERE na.desertionNo = am.desertionNo;
SELECT *
FROM Animals am,
    newAnimals na
WHERE am.desertionNo = na.desertionNo;
SELECT desertionNo,
    COUNT(*) as cnt
FROM Animals
GROUP BY desertionNo
WHERE desertionNo;
DELETE am
FROM newAnimals am
    JOIN Animals na ON am.desertionNo = na.desertionNo
WHERE am.desertionNo;
DELETE newAnimals
FROM Animals am,
    newAnimals na
WHERE na.desertionNo = am.desertionNo;
SELECT desertionNo,
    COUNT(*) as cnt
FROM Animals
GROUP BY desertionNo;
DELETE am
FROM Animals am
    INNER JOIN (
        SELECT desertionNo,
            COUNT(*) as cnt
        FROM Animals
        GROUP BY desertionNo
    ) ct ON am.desertionNo = ct.desertionNo;
DROP TABLE newAnimals;
DROP TABLE Animals;

SELECT *
FROM Animals am
WHERE careAddr LIKE "%서울특별시%"
    AND careAddr LIKE "%마포구%"
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


SELECT *,
    COUNT(id)
FROM Animals
GROUP BY careAddr,
    YEAR,
    MONTH
HAVING COUNT(id) > 1;
SELECT id,
    MAX(id),
    COUNT(id)
FROM Animals
GROUP BY careAddr
HAVING COUNT(ID) > 1;

DELETE A
FROM Animals A
    INNER JOIN (
        SELECT MAX(id) AS id
        FROM Animals
        GROUP BY id, age,
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
GROUP BY id, age,
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