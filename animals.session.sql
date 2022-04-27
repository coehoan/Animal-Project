SELECT * FROM Sido;
SELECT * FROM Sigungu;
SELECT * FROM Shelter;
SELECT * FROM Animals;

DROP TABLE Shelter;
DROP TABLE Sido;
DROP TABLE Sigungu;

SELECT sg.id, sg.uprCd, sg.orgCd, sg.orgdownNm FROM Sido sd
INNER JOIN Sigungu sg ON sd.orgCd = sg.uprCd;

SELECT * FROM Sido sd
INNER JOIN Sigungu sg ON sd.orgCd = sg.orgCd
WHERE sd.id=1;

SELECT * FROM Sido WHERE orgCd;

SELECT * FROM Sido WHERE orgCd;

INSERT IGNORE INTO `Post` (`id`, `board`, `content`, `createDate`, `region`, `title`, `type`, `category`, `updateDate`, `userId`) VALUES
    (1, 'adopt', '<p>내용</p>', '2022-04-17 20:12:33.050029', 'seoul', '입양후기/서울', 'dog', NULL, '2022-04-17 20:12:33.050029', 1),
    (2, 'adopt', '<p>내용</p>', '2022-04-17 20:12:44.046224', 'busan', '입양후기/부산', NULL, NULL, '2022-04-17 20:12:44.046224', 1),
    (3, 'region', '<p>내용</p>', '2022-04-17 20:12:56.316327', 'seoul', '지역/서울', NULL, 'ask', '2022-04-17 20:12:56.316327', 1),
    (4, 'region', '<p>내용</p>', '2022-04-17 20:13:15.825428', 'busan', '지역/부산', NULL, 'ask', '2022-04-17 20:13:15.825428', 1),
    (5, 'free', '<p>내용</p>', '2022-04-17 20:13:25.125766', NULL, '자유', NULL, NULL, '2022-04-17 20:13:25.125766', 1),
    (6, 'adopt', '<p>후기후기</p>', '2022-04-18 14:29:30.429082', 'busan', '입양후기/부산/고양이', 'cat', NULL, '2022-04-18 14:29:30.429082', 1),
    (8, 'adopt', '<p>입양후기</p>', '2022-04-18 19:47:53.900869', 'busan', '입양후기', 'dog', NULL, '2022-04-18 19:47:53.900869', 1),
    (9, 'adopt', '<p>입양후기</p>', '2022-04-18 19:48:00.172400', 'daegu', '입양후기', 'cat', NULL, '2022-04-18 19:48:00.172400', 1),
    (10, 'adopt', '<p>입양후기</p>', '2022-04-18 19:48:07.703189', 'seoul', '입양후기', 'dog', NULL, '2022-04-18 19:48:07.703189', 1);

SELECT * FROM Animals am GROUP BY age, careAddr, careNm, careTel, chargeNm, colorCd, desertionNo, filename, happenDt, happenPlace, kindCd, neuterYn, noticeComment, noticeEdt, noticeNo, noticeSdt, officetel, orgNm, popfile, processState, sexCd, specialMark, weight HAVING am.orgNm = :addrSido :addrSigungu ORDER BY am.orgNm = :addrSido :addrSigungu UNION ALL SELECT * FROM Animals GROUP BY age, careAddr, careNm, careTel, chargeNm, colorCd, desertionNo, filename, happenDt, happenPlace, kindCd, neuterYn, noticeComment, noticeEdt, noticeNo, noticeSdt, officetel, orgNm, popfile, processState, sexCd, specialMark, weight DECS;

SELECT * FROM Animals am WHERE am.orgNm = "경기도 " + "안성시" GROUP BY age, careAddr, careNm, careTel, chargeNm, colorCd, desertionNo, filename, happenDt, happenPlace, kindCd, neuterYn, noticeComment, noticeEdt, noticeNo, noticeSdt, officetel, orgNm, popfile, processState, sexCd, specialMark, weight HAVING am.orgNm = "경기도 안성시" ORDER BY am.orgNm = "경기도 안성시";