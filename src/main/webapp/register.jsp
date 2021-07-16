<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form method="POST" action="" id="registerForm">
    <div>
        <label>
            Your username (required!):
            <br/>
            <input required type="text" name="username"/>
        </label>
    </div>
    <br/>

    <div>
        <label>
            Your password (required!):
            <br/>
            <input required type="text" name="password"/>
        </label>
    </div>
    <br/>

    <div>
        <label>
            Your firstname:
            <br/>
            <input type="text" name="firstname"/>
        </label>
    </div>
    <br/>

    <div>
        <label>
            Your surname:
            <br/>
            <input type="text" name="surname"/>
        </label>
    </div>
    <br/>

    <div>
        <label>
            Your Birthday:
            <br/>
            <input type="date" name="birthday"/>
        </label>
    </div>
    <br/>

    <div>
        <label>
            Your email:
            <br/>
            <input required type="email" name="email"/>
        </label>
    </div>
    <br/>

    <div>
        <label>
            Your phone:
            <br/>
            <input type="text" name="phone"/>
        </label>
    </div>
    <br/>

    <div>
        <label>
            Your telegram (@telegramName):
            <br/>
            <input type="text" name="telegram"/>
        </label>
    </div>
    <br/>

    <input type="submit" value="REGISTER ME ALREADY!"/>
</form>
<br/>
<!--кнопка перехода на страницу логина-->
<form method="GET" action="login">
    <input type="submit" value="Log-In"/>
</form>

<%--СКРИПТ--%>
<script>
    const form = document.getElementById('registerForm');
    form.addEventListener('submit', sendData);

    function sendData(event) {
        event.preventDefault(); //если этого нет, браузер попытается выполнить action из формы.

        const firstname = form.querySelector('[name="firstname"]');
        const surname = form.querySelector('[name="surname"]');
        const username = form.querySelector('[name="username"]');
        const birthday = form.querySelector('[name="birthday"]');
        const phone = form.querySelector('[name="phone"]');
        const telegram = form.querySelector('[name="telegram"]');
        const email = form.querySelector('[name="email"]');
        const password = form.querySelector('[name="password"]');

        let jsonData = JSON.stringify({
                username: username.value,
                firstname: firstname.value,
                surname: surname.value,
                birthday: birthday.value,
                phone: phone.value,
                telegram: telegram.value,
                email: email.value,
                password: password.value
            }
        )

        //ОТПРАВЛЯЮ POST-ЗАПРОС
        var url = "http://localhost:8080/register";
        let xhr = new XMLHttpRequest();
        xhr.open("POST", url, true);
        xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
        xhr.send(jsonData);
    }
</script>
</body>
</html>
