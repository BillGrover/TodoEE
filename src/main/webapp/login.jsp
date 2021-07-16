<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log-In</title>
</head>
<body>
<form method="POST" action="" id="loginForm">
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

    <input type="submit" value="Come on! Lemme in!"/>
</form>
<br/>
<!--кнопка перехода на Main Menu-->
<button onclick="window.location.href = 'http://localhost:8080/'">Back to Main Menu</button>
<br/>

<script>
    const form = document.getElementById('loginForm');
    form.addEventListener('submit', sendData);

    function sendData(event) {
        event.preventDefault(); //если этого нет, браузер попытается выполнить action из формы.

        const username = form.querySelector('[name="username"]').value;
        const password = form.querySelector('[name="password"]').value;

        let jsonData = JSON.stringify({
            username: username,
            password: password,
            firstname: null,
            surname: null,
            birthday: null,
            phone: null,
            telegram: null,
            email: null
            }
        )

        //ОТПРАВЛЯЮ POST-ЗАПРОС
        var url = "http://localhost:8080/auth/login";
        let xhr = new XMLHttpRequest();
        xhr.open("POST", url, true);
        xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
        xhr.send(jsonData);
    }
</script>
</body>
</html>
