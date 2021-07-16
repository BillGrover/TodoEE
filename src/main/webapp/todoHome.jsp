<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo Home</title>
</head>
<body>
<!--кнопка перехода на Main Menu-->
<button onclick="window.location.href = 'http://localhost:8080/'">Back to Main Menu</button>
<br/>

<!--кнопка СОЗДАТЬ ЗАДАЧУ-->
<form method="GET" action="createTask">
    <input type="submit" value="Create a task"/>
</form><br/><br/>

<h3>Tasks list:</h3>

</body>
</html>
