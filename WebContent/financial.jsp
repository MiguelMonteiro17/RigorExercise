<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Financial</title>
</head>
<body>
	<h1>Financiamento Mensal</h1>
	<p>Valor do veículo ${financialDto.vehicleValue}</p>
	<p> Duração do financiamento ${financialDto.monthlyDuration} meses</p>
	<p>Mensalidade ${financialDto.monthlyFunding}€</p>
	
	<form action="financialServlet" method="post">
		<p>Nome</p>
		<input type="text" name="clientName">
		<br>
		<p>Contacto: </p>
		<input type="text" name="clientContact">
		<br>
    	<input type="submit" value="Gravar"/>
    </form>
</body>
</html>