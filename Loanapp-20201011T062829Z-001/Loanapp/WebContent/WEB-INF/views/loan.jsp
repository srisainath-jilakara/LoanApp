<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loan request</title>
<h2>Welcome to Loan request portal</h2>
<form action="save" method="post">
EnquiryID: <input type="text" name="enquiryId"><br/><br/>
Name: <input type="text" name="userName"><br/><br/>
JobType:  <select name="JobType">
    <option value="SelfEmployed">Self Employed</option>
    <option value="Salaried">Salaried</option>
 </select><br/><br/>
Amount: <input type="text" name="amount"><br/><br/>
Rate:<input type="text" name="rate"><br/><br/>
<input type="submit" value="request">
</form>
</head>
<body>
</body>
</html>