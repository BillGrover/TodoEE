<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Todo List EE</title>
</head>
<body>
<h1><%= "Welcome to MELMAC 2" %>
</h1>
<br/>
<h3>This is Melmac №2. And here you can use the following services:</h3>
<br/>
<h4>Organise your business with POWERFUL ULTRA MODERN todo-list application</h4>
<br/>

<!--кнопка перехода на страницу регистрации-->
<form method="GET" action="register">
    <input type="submit" value="Free registration!"/>
</form>
<br/>
<!--кнопка перехода на страницу логина-->
<form method="GET" action="auth/login">
    <input type="submit" value="Log-In"/>
</form>
<br/>
<!--кнопка перехода на страницу логаута-->
<form method="GET" action="auth/logout">
    <input type="submit" value="Log-Out"/>
</form>
<br/>
<!--кнопка перехода на тудушку-->
<form method="GET" action="todo">
    <input type="submit" value="Visit Todo-List App"/>
</form><br/>

</body>
</html>