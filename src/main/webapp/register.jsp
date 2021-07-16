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
<form method="GET" action="auth/login">
    <input type="submit" value="Log-In"/>
</form>
<br/>
<!--кнопка перехода на Main Menu-->
<button onclick="window.location.href = 'http://localhost:8080/'">Back to Main Menu</button>
<br/>

<%--СКРИПТ--%>
<script>
    const form = document.getElementById('registerForm');
    form.addEventListener('submit', sendData);

    function sendData(event) {
        event.preventDefault(); //если этого нет, браузер попытается выполнить action из формы.

        const username  = form.querySelector('[name="username"]').value;
        const password  = form.querySelector('[name="password"]').value;
        const firstname = form.querySelector('[name="firstname"]').value;
        const surname   = form.querySelector('[name="surname"]').value;
        const birthday  = form.querySelector('[name="birthday"]').value;
        const phone     = form.querySelector('[name="phone"]').value;
        const telegram  = form.querySelector('[name="telegram"]').value;
        const email     = form.querySelector('[name="email"]').value;


        let jsonData = JSON.stringify({
                username:   username,
                password:   password,
                firstname:  firstname   == null ? null : firstname,
                surname:    surname     == null ? null : surname,
                birthday:   birthday    == null ? null : birthday,
                phone:      phone       == null ? null : phone,
                telegram:   telegram    == null ? null : telegram,
                email:      email       == null ? null : email
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
