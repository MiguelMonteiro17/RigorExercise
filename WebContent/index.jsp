<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello World Java EE</title>
</head>
<body>
    <h1>Financiamento</h1>
    <form action="financialServlet" method="get">
    <label for="financialType">Tipo de financiamento:</label>
    <Select name="financialType">
    	<option value="Interno">Interno</option>
    	<option value="Externo">Externo</option>
    </Select>
    
    <p>Valor da viatura: <input type="text" name="vehicleValue"></p>
   
    <p>Duração:  <input type="text" name="financialDuration"></p>

    <input type="submit" value="Calcular Financiamento"/>
    </form>
</body>
</html>