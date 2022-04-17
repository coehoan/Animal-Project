SELECT * FROM Sido;
SELECT * FROM Sigungu;
SELECT * FROM Shelter;

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