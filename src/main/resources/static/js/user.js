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
      alert("로그인완료");
      location.href = "/";
  } else {
      alert('로그인실패');
  }
}
//회원가입
async function join() {
    let joinDto = {
        username: $("#username").val(),
        password: $("#password").val(),
        email: $("#email").val(),
        male: $("#male option:selected").val(),
        addr: $("#addr").val()
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
        location.href = "loginForm";
    } else {
        alert('회원가입실패');
    }
}

