
SELECT * FROM Shelter WHERE careNm LIKE "%대구%";
SELECT * FROM KindDto;

SELECT * FROM Sido;
SELECT * FROM Sigungu;


SELECT kindCd FROM KindDto;

-- 시군구랑 시도 LEFT OUTER JOIN
-- 보호소도 LEFT OUTER JOIN
SELECT st.careRegNo, sg.uprCd, si.orgCd 
FROM Sigungu sg
LEFT OUTER JOIN Sido si ON sg.uprCd = si.orgCd
LEFT OUTER JOIN Shelter st ON sg.id = st.id;

SELECT sg.id, sg.orgCd, sg.orgdownNm, sg.uprCd, si.orgdownNm
FROM Sigungu sg
LEFT OUTER JOIN Sido si ON sg.uprCd = si.orgCd;

SELECT st.id, st.careNm, st.careRegNo
FROM Sigungu sg
LEFT OUTER JOIN Shelter st ON sg.id = st.id;

SELECT * FROM Sigungu sg
LEFT OUTER JOIN Sido sd ON sg.uprCd = sd.orgCd;

SELECT * FROM KindDto WHERE kindCd;

DROP TABLE Shelter;

DROP TABLE Animals;

