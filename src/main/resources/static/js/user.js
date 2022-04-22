//로그인
$("#btn-login").click(() => {
    login();
});

//회원가입
$("#btn-join").click(() => {
    join();
});



// ===========================
//로그인
function usernameRemember() {
    let cookies = document.cookie.split("=");
    //console.log(cookies[1]);
    $("#username").val(cookies[1]);
}
usernameRemember();

async function login() {
    let checked = $('#remember').is(':checked');
    let loginDto = {
        username: $("#username").val(),
        password: $("#password").val(),
        remember: checked ? "on" : "off"
    }

    let response = await fetch("/login", {
        method: "POST",
        body: JSON.stringify(loginDto),
        headers: {
            'Content-Type': 'application/json; charset=utf-8'
        },
    });

    let responseParse = await response.json();
    console.log(responseParse);

  if (responseParse.code == 1) {
    //   alert("로그인완료");
      location.href = "/";
  } else {
      alert('아이디 혹은 비밀번호가 틀렸습니다.');
  }
}
//회원가입
async function join() {
    let joinDto = {
        username: $("#username").val(),
        password: $("#password").val(),
        email: $("#email").val(),
        male: $("#male option:selected").val(),
        addrSido: $("#addrSido").val(),
        addrSigungu: $("#addrSigungu").val()
    }

    let response = await fetch("/join", {
        method: "POST",
        body: JSON.stringify(joinDto),
        headers: {
            'Content-Type': 'application/json; charset=utf-8'
        },
    });
    let responseParse = await response.json();
    console.log(responseParse);

    if (responseParse.code == 1) {
        alert("회원가입완료");
        location.href = "/main/loginForm";
    } else {
        alert('회원가입실패');
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
    let sido = $("#addrSido").val();
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

    $("#addrSigungu").empty(); // 시군구가 비어있으면
    $("#addrSigungu").append('<option></option>'); // 옵션 추가
    for (let i = 0; i < sigungu.length; i++) {
        $("#addrSigungu").append('<option>' + sigungu[i] + '</option>');
    }

};

