/**
 * Created by Administrator on 2017/2/15.
 */
/**
 * 页头检索
 */
function homeSearch() {
    var headContent = $("#headContent").val();
    window.open("/homepage/search?headContent=" + headContent);
}

/**
 * 注册弹框
 */
function showModalRegist() {
    $('#registWindow').modal({
        keyboard: true
    });
}

/**
 * 登录弹框
 */
function showModalLogin() {
    $('#loginWindow').modal({
        keyboard: true
    });
}

/**
 * 注册
 */
function regist() {
    var userName = $("#userName").val();
    var password = $("#password").val();
    var email = $("#email").val();
    var name = $("#name").val();

    $.ajax({
            url: "/user/regist",
            async: false,
            data: {userName: userName, password: password, email: email, name: name},
            dataType: "json",
            success: function (data) {
                alert(data);
            },
            error: function () {
            },
            timeout: function () {
            }
        }
    );
}

/**
 * 登录
 */
function login() {
    var loginUserName = $("#loginUserName").val();
    var loginPassword = $("#loginPassword").val();

    $.ajax({
            url: "/user/login",
            async: false,
            data: {loginUserName: loginUserName, loginPassword: loginPassword},
            dataType: "json",
            success: function (data) {
                alert(data);
            },
            error: function () {
            },
            timeout: function () {
            }
        }
    );
}

