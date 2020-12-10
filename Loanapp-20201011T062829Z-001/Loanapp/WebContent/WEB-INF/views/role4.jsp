<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Auditing Portal</title>
</head>
<body>
<form action="role4">
<div align="center">
            <h1>Customer Request List</h1>
            <table border="1">
                <th>Enquiry ID</th>
                <th>Customer Name</th>
                <th>JobType</th>
                <th>Amount</th>
                <th>Interest rate</th>
                <th>Status</th>
                <th>Action</th>
                <c:forEach items="${listCustomer}" var="m">
		    <tr>
		        <td>${m.getEnquiryId()}</td>
		        <td>${m.getCustomer_name()}</td>
		        <td>${m.getJobType()}</td>
		        <td>${m.getAmount()}</td>
		        <td>${m.getInterest_rate()}</td>
		        <td>${m.getStatus() }</td>
		         <c:if test="${m.getStatus() eq 'Y' }">
       <td>Sactioned</td>
    </c:if>							
           <c:if test="${m.getStatus() eq 'N' }">
       <td> <a href="accept?id=${m.getEnquiryId()}">Saction</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="reject?id=${m.getEnquiryId()}">Reject</a>
                        </td>
    </c:if>    
		    </tr>
				</c:forEach>
         
                        
            </table>
        </div>
</form>
</body>
</html>