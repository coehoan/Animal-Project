SELECT * FROM SidoDto;
SELECT * FROM SigunguDto;

SELECT sg.id, sg.uprCd, sg.orgCd, sg.orgdownNm FROM SidoDto sd
INNER JOIN SigunguDto sg ON sd.orgCd = sg.orgdownNm;