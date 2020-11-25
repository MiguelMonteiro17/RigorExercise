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
	<p>Valor do veículo ${financialDto.getVehicleValue()}</p>
	<p> Duração do financiamento ${financialDto.getMonthlyDuration()} meses</p>
	<p>Mensalidade ${financialDto.getMonthlyFunding()}€</p>
	
	<form action="financialServlet" method="post">
		<p>Nome <input type="text" name="clientName"></p>
		
		<p>Contacto: <input type="text" name="clientContact"></p>
		
    	<input type="submit" value="Gravar"/>
    </form>
</body>
</html>