<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello World Java EE</title>
</head>
<body>
    <h1>Hello JSP and Servlet!</h1>
    <form action="helloServlet" method="post">
    Enter your name: <input type="text" name="yourName" size="20">
    <input type="submit" value="Call Servlet" />
    </form>
    <br>
    <h1>Financiamento</h1>
    <form action="financialServlet" method="get">
    <p>Tipo de financiamento:</p>
    <input type="text" name="financialType" size="20">
    <br>
    <p>Valor da viatura:</p>
    <input type="text" name="vehicleValue">
    <br>
    <p>Dura��o:</p> <input type="text" name="financialDuration">
    <br>
    <br>
    <input type="submit" value="Calcular Financiamento"/>
    </form>
</body>
</html>