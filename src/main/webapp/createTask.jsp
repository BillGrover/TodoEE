<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create a task</title>
</head>
<body>

<%--ФОРМА ДЛЯ НОВОЙ ЗАДАЧИ--%>
<form method="POST" action="" id="newTaskForm">
    <div>
        <label>
            Task name:
            <br/>
            <input required type="text" name="taskTitle"/>
        </label>
    </div>
    <br/>
    <div>
        <label>
            Date:
            <br/>
            <input required type="date" name="taskDate"/>
        </label>
    </div>
    <br/>
    <div>
        <label>
            Time:
            <br/>
            <input required type="time" name="taskTime"/>
        </label>
    </div>
    <br/>
    <div>
        <label>
            Task description:
            <br/>
            <textarea rows="4" cols="30" name="taskDescription"
                      style="margin: 0px; width: 450px; height: 304px;"></textarea>
        </label>
    </div>
    <br/>
    <input type="submit" value="OK"/>
</form>

<%--СКРИПТ--%>
<script>
    console.log("Start logging my script");

    //ПОЛУЧАЮ ДАННЫЕ ИЗ ФОРМЫ
    const form = document.getElementById('newTaskForm');
    form.addEventListener('submit', sendData);

    function sendData(event) {
        event.preventDefault(); //если этого нет, браузер попытается выполнить action из формы.

        const title = form.querySelector('[name="taskTitle"]');
        const date = form.querySelector('[name="taskDate"]');
        const time = form.querySelector('[name="taskTime"]');
        const description = form.querySelector('[name="taskDescription"]');

        //ВАРИАНТ: json
        let jsonData = JSON.stringify({
            title: title.value,
            date: date.value,
            time: time.value,
            description: description.value})

        //***********************************************
        //ВАРИАНТ: multipart/form-data
        // let formData = new FormData();
        // formData.append("title", title.value)
        // formData.append("date", date.value)
        // formData.append("description", description.value)
        // var url = "http://localhost:8080/newTask";
        // let xhr = new XMLHttpRequest();
        // xhr.open("POST", url, true);
        // xhr.send(formData);
        //**********************************************

        //ОТПРАВЛЯЮ POST-ЗАПРОС
        var url = "http://localhost:8080/newTask";
        let xhr = new XMLHttpRequest();
        xhr.open("POST", url, true);
        xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
        xhr.send(jsonData);
    }
</script>

</body>
</html>
