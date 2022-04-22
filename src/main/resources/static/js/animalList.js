
$("#showDetail").click(() => {
    showDetail();
});

function showDetail() {
    if ($("#detail").css("display") == "none") {
        $("#detail").removeClass("m_div_display_none");
    } else {
        $("#detail").addClass("m_div_display_none");
    }
}

let selectedSido;
let selectedSigungu;
let selectedKind;
let selectedKindOf;
let selectedFirstDate;
let selectedLastDate;

function firstDateSelected(vaule) {
    selectedFirstDate = vaule;
}

function lastDateSelected(vaule) {
    selectedLastDate = vaule;
}

function kindSelected(value) {

    selectedKind = value;

}

function kindOfSelected(value) {
    selectedKindOf = value;
}

function sidoSelected(value) {
    selectedSido = value;
}

function sigunguSelected(value) {
    selectedSigungu = value;
}




function kindOptionChange() {
    // 품종 리스트
    let kindOfcat = ["기타", "노르웨이 숲", "데본 렉스", "러시안 블루", "레그돌", "레그돌-라가머핀", "맹크스", "먼치킨", "메인쿤", "믹스묘", "발리네즈", "버만", "벵갈", "봄베이", "브리티쉬롱헤어", "브리티시 쇼트헤어", "사바나캣", "샤트룩스", "샴 ", "셀커크 렉스", "소말리", "스노우 슈", "스코티시폴드", "스핑크스", "시베리안 포레스트", "싱가퓨라", "아메리칸 쇼트헤어", "아비시니안", "재패니즈밥테일", "터키시 앙고라", "통키니", "페르시안", "페르시안 - 페르시안 친칠라", "하바나 브라운", "하일랜드 폴드", "한국고양이"];
    let kidnOfDog = ["그레이 하운드", "그레이트 덴", "그레이트 피레니즈", "기타", "꼬똥 드 뚤레아", "네오폴리탄 마스티프", "노르포크 테리어", "노리치 테리어", "뉴펀들랜드", "닥스훈트", "달마시안", "댄디 딘몬트 테리어", "도고 까니리오", "도고 아르젠티노", "도고 아르젠티노", "도베르만", "도사", "동경견", "라브라도 리트리버", "라사 압소", "라이카", "래빗", "닥스훈드", "랫 테리어", "레이크랜드 테리어", "로디지안 리즈백", "로트와일러", "마리노이즈", "마스티프", "말라뮤트", "말티즈", "맨체스터테리어", "미니어쳐 닥스훈트", "미니어쳐 불 테리어", "미니어쳐 슈나우저", "미니어쳐 푸들", "미니어쳐 핀셔", "미디엄 푸들", "미텔 스피츠", "믹스견", "바센지", "바셋 하운드", "버니즈 마운틴 독", "베들링턴 테리어", "벨기에 그로넨달", "벨기에 쉽독", "벨기에 테뷰런", "벨지안 셰퍼드 독", "보더 콜리", "보르조이", "보스턴 테리어", "복서", "볼로네즈", "부비에 데 플랑드르", "불 테리어", "불독", "브뤼셀그리펀", "브리타니 스파니엘", "블랙 테리어", "비글", "비숑 프리제", "비어디드 콜리", "비즐라", "빠삐용", "사모예드", "살루키", "삽살개", "샤페이", "세인트 버나드", "센트럴 아시안 오브차카", "셔틀랜드 쉽독", "셰퍼드", "슈나우져", "스코티쉬 테리어", "스코티시 디어하운드", "스태퍼드셔 불 테리어", "스탠다드 푸들", "스피츠", "시바", "시베리안 허스키", "시베리안 라이카", "시잉프랑세즈", "시츄", "시코쿠", "실리햄 테리어", "실키테리어", "아나톨리안 셰퍼드", "아메리칸 불독", "아메리칸 스태퍼드셔 테리어", "아메리칸 아키다", "아메리칸 에스키모", "아메리칸 코카 스파니엘", "아메리칸 핏불 테리어", "아메리칸 불리", "아이리쉬 레드 앤 화이트 세터", "아이리쉬 세터", "아이리쉬 울프 하운드", "아이리쉬 소프트코튼 휘튼테리어", "아키다", "아프간 하운드", "알라스칸 말라뮤트", "에어델 테리어", "오브차카", "오스트랄리안 셰퍼드 독", "오스트랄리안 캐틀 독", "올드 잉글리쉬 불독", "올드 잉글리쉬 쉽독", "와이마라너", "와이어 폭스 테리어", "요크셔 테리어", "웨스트 시베리언 라이카", "웨스트하이랜드화이트테리어", "웰시 코기 카디건", "웰시 코기 펨브로크", "웰시 테리어", "이탈리안 그레이 하운드", "잉글리쉬 세터", "잉글리쉬 스프링거 스파니엘", "잉글리쉬 코카 스파니엘", "잉글리쉬 포인터", "자이언트 슈나우져", "재패니즈 스피츠", "잭 러셀 테리어", "저먼 셰퍼드 독", "저먼 와이어헤어드 포인터", "저먼 포인터", "저먼 헌팅 테리어", "제주개", "제페니즈칭", "진도견", "차우차우", "차이니즈 크레스티드 독", "치와와", "카레리안 베어독", "카이훗", "캐벌리어 킹 찰스 스파니엘", "케니스펜더", "케리 블루 테리어", "케언 테리어", "케인 코르소", "코리아 트라이 하운드", "코리안 마스티프", "코카 스파니엘", "코카 푸", "코카시안오브차카", "콜리", "클라인스피츠", "키슈", "키스 훈드", "토이 맨체스터 테리어", "토이 푸들", "티베탄 마스티프", "파라오 하운드", "파슨 러셀 테리어", "팔렌", "퍼그", "페키니즈", "페터데일테리어", "포메라니안", "포인터", "폭스테리어", "푸들", "풀리", "풍산견", "프레사까나리오", "프렌치 불독", "프렌치 브리타니", "플랫 코티드 리트리버", "플롯하운드", "피레니안 마운틴 독", "필라 브라질레이로", "핏불테리어", "허배너스", "화이트리트리버", "화이트테리어", "휘펫"];
    let kindOfEct = ["기타축종"];

    // 품종 값 불러오기
    let kind = $("#kind").val();
    let kindOf;

    if (kind == "강아지") { // 품종이 강아지면
        kindOf = kidnOfDog; // 강아지 품종 넣기
    } else if (kind == "고양이") {
        kindOf = kindOfcat;
    } else if (kind == "기타") {
        kindOf = kindOfEct;
    } else {
        kindOf = [];
    }

    $("#kind-of").empty(); // 품종이 비어있으면
    $("#kind-of").append('<option></option>'); // 옵션 추가
    for (let i = 0; i < kindOf.length; i++) {
        $("#kind-of").append('<option>' + kindOf[i] + '</option>');
    }
}


function RegionOptionChange() {

    // 시군구들 옵션에 넣을 값
    let seoulSigungu = ["관악구", "광진구", "구로구", "금천구", "노원구", "도봉구", "동대문구", "동작구", "마포구", "서대문구", "서초구", "성동구", "성북구", "송파구", "양천구", "영등포구", "용산구", "은평구", "종로구", "중구", "중랑구"];
    let busanSigungu = ["동구", "동래구", "부산진구", "북구", "사상구", "사하구", "서구", "수영구", "연제구", "영도구", "중구", "해운대구"];
    let deaguSigungu = ["남구", "달서구", "달성군", "동구", "북구", "서구", "수성구", "중구"];
    let incheonSigungu = ["강화군", "계양구", "남동구", "동구", "미추홀구", "부평구", "서구", "연수구", "옹진군", "중구"];
    let gwangjuSigungu = ["광산구", "남구", "동구", "북구", "서구"];
    let deajeonSigungu = ["대덕구", "동구", "서구", "유성구", "중구"];
    let ulsanSigungu = ["남구", "동구", "북구", "울주군", "중구"];
    let gyeongiSigungu = ["동두천시", "부천시", "성남시", "수원시", "시흥시", "안산시", "안성시", "안양시", "양주시", "양평군", "여주시", "연천군", "오산시", "용인시", "용인시", "기흥구", "의왕시", "의정부시", "이천시", "파주시", "평택시", "포천시", "하남시", "화성시"];
    let gangwonSigungu = ["강릉시", "고성군", "동해시", "삼척시", "속초시", "양구군", "양양군", "영월군", "원주시", "인제군", "정선군", "철원군", "춘천시", "태백시", "평창군", "홍천군", "화천군", "횡성군"];
    let choongbookSigungu = ["괴산군", "단양군", "보은군", "영동군", "옥천군", "음성군", "제천시", "증평군", "진천군", "청주시", "충주시"];
    let choongnamSigungu = ["계룡시", "공주시", "금산군", "논산시", "당진시", "보령시", "부여군", "서산시", "서천군", "아산시", "연기군", "예산군", "천안시", "청양군", "태안군", "홍성군"];
    let jeonbookSigungu = ["고창군", "군산시", "김제시", "남원시", "무주군", "부안군", "순창군", "완주군", "익산시", "임실군", "장수군", "전주시", "정읍시", "진안군"];
    let jeonamSigungu = ["영광군", "영암군", "완도군", "장성군", "장흥군", "진도군", "함평군", "해남군", "화순군"];
    let gyeongbookSigungu = ["김천시", "문경시", "봉화군", "상주시", "성주군", "안동시", "영덕군", "영양군", "영주시", "영천시", "예천군", "울릉군", "울진군", "의성군", "청도군", "청송군", "칠곡군", "포항시"];
    let gyeongsangSigungu = ["거제시", "거창군", "경상남도", "고성군", "김해시", "남해군", "밀양시", "사천시", "산청군", "양산시", "의령군", "진주시", "창녕군", "창원 마산합포회원구", "창원 의창성산구", "창원 진해구", "통영시", "하동군", "함안군", "함양군", "합천군"];
    let jejuSigungu = ["서귀포시", "제주시", "제주특별자치도"];

    // 시도 값
    let sido = $("#sido").val();
    console.log(sido);
    // 시군구 변수에 값을 넣음
    let sigungu;

    // 시도에 따라서 시군구 값 넣기
    if (sido == "서울특별시") {
        sigungu = seoulSigungu;
    } else if (sido == "부산광역시") {
        sigungu = busanSigungu;
    } else if (sido == "대구광역시") {
        sigungu = deaguSigungu;
    } else if (sido == "인천광역시") {
        sigungu = incheonSigungu;
    } else if (sido == "광주광역시") {
        sigungu = gwangjuSigungu;
    } else if (sido == "대구광역시") {
        sigungu = deaguSigungu;
    } else if (sido == "울산광역시") {
        sigungu = ulsanSigungu;
    } else if (sido == "경기도") {
        sigungu = gyeongiSigungu;
    } else if (sido == "강원도") {
        sigungu = gangwonSigungu;
    } else if (sido == "충청북도") {
        sigungu = choongbookSigungu;
    } else if (sido == "충청남도") {
        sigungu = choongnamSigungu;
    } else if (sido == "전라남도") {
        sigungu = jeonamSigungu;
    } else if (sido == "전라북도") {
        sigungu = jeonbookSigungu;
    } else if (sido == "경상남도") {
        sigungu = gyeongsangSigungu;
    } else if (sido == "경상북도") {
        sigungu = gyeongbookSigungu;
    } else if (sido == "제주특별자치도") {
        sigungu = jejuSigungu;
    } else {
        sigungu = [];
    }

    $("#sigungu").empty(); // 시군구가 비어있으면
    $("#sigungu").append('<option></option>'); // 옵션 추가
    for (let i = 0; i < sigungu.length; i++) {
        $("#sigungu").append('<option>' + sigungu[i] + '</option>');
    }

};

//스프링한테 옵션 선택한 값 오브젝트로 fetch 요청하기

$("#btn-search").click(() => {
    toRegion(selectedSido, selectedSigungu);

});

$("#btn-search").click(() => {
    toDay(selectedFirstDate, selectedLastDate);

});

$("#btn-search").click(() => {
    toKind(selectedKind, selectedKindOf);

});

$("#btn-search").click(() => {
    toRegionSido(selectedSido);

});

$("#btn-search").click(() => {
    toKindOnly(selectedKind);

});

$("#btn-search").click(() => {
    toDayFirst(selectedFirstDate);

});







// Ajax 함수

async function toRegion(selectedSido, selectedSigungu) { // 지역 검색

    if ($("#sido").val() && $("sigungu").val() != null) {
        let response = await fetch(`/search/animals/region?sido=${selectedSido}&sigungu=${selectedSigungu}`);
        console.log(selectedSido, selectedSigungu);
        console.log(response);

        let reseponseParse = await response.json();
        console.log(reseponseParse);

        if (reseponseParse.code == 1) {
            alert("검색 성공");
            $("#region").empty();
            for (regionList of reseponseParse.data) { // data 크기만큼
                $("#region").append(regionRender(regionList)); // append
                $("#region").append(detailRender(regionList));
            }



        } else {
            alert("검색 실패");
        }

        //return selectedSido, selectedSigungu;
    }
}

async function toAll(selectedSido, selectedSigungu, selectedKind, selectedKindOf, selectedFirstDate, selectedLastDate) { // 지역 검색

    if ($("#sido").val() && $("sigungu").val() && $("#kind").val() && $("#kind-of").val() && $("#firstdate").val() && $("#last-date").val() != null) {
        let response = await fetch(`/search/animals/all?sido=${selectedSido}&sigungu=${selectedSigungu}&kind=${selectedKind}&kindOf=${selectedKindOf}&firstdate=${selectedFirstDate}&lastdate=${selectedLastDate}`);
        console.log(selectedSido, selectedSigungu, selectedKind, selectedKindOf, selectedFirstDate, selectedLastDate);
        console.log(response);

        let reseponseParse = await response.json();
        console.log(reseponseParse);

        if (reseponseParse.code == 1) {
            alert("검색 성공");
            $("#region").empty();
            for (regionList of reseponseParse.data) { // data 크기만큼
                $("#region").append(regionRender(regionList)); // append
                $("#region").append(detailRender(regionList));
            }

        } else {
            alert("검색 실패");
        }

        //return selectedSido, selectedSigungu;
    }
}



async function toRegionSido(selectedSido) { // 지역 시도 검색

    if ($("#sido").val() !== null) {
        let response = await fetch(`/search/animals/region-sido?sido=${selectedSido}`);
        console.log(selectedSido);
        console.log(response);

        let reseponseParse = await response.json();
        console.log(reseponseParse);

        if (reseponseParse.code == 1) {
            alert("검색 성공");
            $("#region").empty();
            for (regionList of reseponseParse.data) { // data 크기만큼
                $("#region").append(regionRender(regionList)); // append
                $("#region").append(detailRender(regionList));
            }



        } else {
            alert("검색 실패");
        }

        //return selectedSido, selectedSigungu;
    }

}

async function toKind(selectedKind, selectedKindOf) { // 품종 검색

    if ($("#kind").val() && $("#kind-of").val() != null) {
        let response = await fetch(`/search/animals/kind?kind=${selectedKind}&kindOf=${selectedKindOf}`);
        console.log(selectedKind, selectedKindOf);
        console.log(response);

        let reseponseParse = await response.json();
        console.log(reseponseParse);

        if (reseponseParse.code == 1) {
            alert("검색 성공");
            $("#region").empty();
            for (kindList of reseponseParse.data) { // data 크기만큼
                $("#region").append(kindRender(kindList)); // append
            }



        } else {
            alert("검색 실패");
        }

        //return selectedSido, selectedSigungu;
    }

}

async function toKindOnly(selectedKind) { // 품종만 검색

    if ($("#kind").val() != null) {
        let response = await fetch(`/search/animals/kind-only?kind=${selectedKind}`);
        console.log(selectedKind);
        console.log(response);

        let reseponseParse = await response.json();
        console.log(reseponseParse);

        if (reseponseParse.code == 1) {
            alert("검색 성공");
            $("#region").empty();
            for (kindList of reseponseParse.data) { // data 크기만큼
                $("#region").append(kindRender(kindList)); // append
            }



        } else {
            alert("검색 실패");
        }

        //return selectedSido, selectedSigungu;
    }

}

async function toDay(selectedFirstDate, selectedLastDate) { // 날짜 검색

    if ($("#first-date").val() && $("#last-date").val() != null) {
        let response = await fetch(`/search/animals/day?firstdate=${selectedFirstDate}&lastdate=${selectedLastDate}`)
        console.log(selectedFirstDate, selectedLastDate);
        console.log(response);

        let reseponseParse = await response.json();
        console.log(reseponseParse);

        if (reseponseParse.code == 1) {
            alert("검색 성공");
            $("#region").empty();
            for (dayList of reseponseParse.data) { // data 크기만큼
                $("#region").append(dayRender(dayList)); // append
            }
        } else {
            alert("검색 실패");
        }
    }
}

async function toDayFirst(selectedFirstDate) { // 날짜 검색

    if ($("#first-date").val() != null) {
        let response = await fetch(`/search/animals/day?firstdate=${selectedFirstDate}`)
        console.log(selectedFirstDate);
        console.log(response);

        let reseponseParse = await response.json();
        console.log(reseponseParse);

        if (reseponseParse.code == 1) {
            alert("검색 성공");
            $("#region").empty();
            for (dayList of reseponseParse.data) { // data 크기만큼
                $("#region").append(dayRender(dayList)); // append
            }
        } else {
            alert("검색 실패");
        }
    }
}

function kindRender(kindList) {
    return `<tr>
                <th scope="row" style="vertical-align: middle;">${kindList.id}</th>
                <td style="vertical-align: middle;">${kindList.kindCd}</td>
                <td width="110"><img src="${kindList.filename}" width="100" height="100"></td>
                <td style="vertical-align: middle;">${kindList.happenPlace}</td>
                <td style="vertical-align: middle;">${kindList.sexCd}</td>
                <td style="vertical-align: middle;">${kindList.age}</td>
                <td style="vertical-align: middle;">
                    ${kindList.processState}</td>
                <td style="vertical-align: middle;" width="100">
                    <button id="showDetail" class="m_button"">자세히</button>
                </td>
            </tr>`;
}

function dayRender(dayList) {
    return `<tr>
                <th scope="row" style="vertical-align: middle;">${dayList.id}</th>
                <td style="vertical-align: middle;">${dayList.kindCd}</td>
                <td width="110"><img src="${dayList.filename}" width="100" height="100"></td>
                <td style="vertical-align: middle;">${dayList.happenPlace}</td>
                <td style="vertical-align: middle;">${dayList.sexCd}</td>
                <td style="vertical-align: middle;">${dayList.age}</td>
                <td style="vertical-align: middle;">
                    ${dayList.processState}</td>
                <td style="vertical-align: middle;" width="100">
                    <button id="showDetail" class="m_button"">자세히</button>
                </td>
            </tr>`;
}


function regionRender(regionList) {
    console.log(regionList.id);
    return `<tr>
                <th scope="row" style="vertical-align: middle;">${regionList.id}</th>
                <td style="vertical-align: middle;">${regionList.kindCd}</td>
                <td width="110"><img src="${regionList.filename}" width="100" height="100"></td>
                <td style="vertical-align: middle;">${regionList.happenPlace}</td>
                <td style="vertical-align: middle;">${regionList.sexCd}</td>
                <td style="vertical-align: middle;">${regionList.age}</td>
                <td style="vertical-align: middle;">
                    ${regionList.processState}</td>
                <td style="vertical-align: middle;" width="100">
                    <button id="showDetail" class="m_button"">자세히</button>
                </td>
            </tr>`;
}

function detailRender(regionList) {
    return `<tr>
                <td colspan="9" id="detail" class="m_div_display_none">
                    <div class="m_sub_content">
                        #체중:${regionList.weight}
                        #색상:${regionList.colorCd}
                        #중성화여부:${regionList.neuterYn}
                        #보호소이름:${regionList.careNm}
                        #보호소전화번호:${regionList.careTel}
                        #보호장소:${regionList.careAddr}
                        #관활기관:${regionList.orgNm}
                        #담당자:${regionList.chargeNm}
                        #담당자연락처:${regionList.officetel}
                    </div>
                </td>
            </tr>`;
}

toRegion("");

