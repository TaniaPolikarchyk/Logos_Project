<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Students Page</title>
</head>
<body>
	<h3>Person list</h3>
	<c:if test="${!empty students}">
		<table>
			<tr>
				<th width="100">Student ID</th>
				<th width="200">First name</th>
				<th width="200">Last name</th>
				<th width="200">Year</th>
				<th width="200">Course</th>
			</tr>
			<c:forEach items="${students}" var="s">
				<tr>
					<td align="center">${s.id}</td>
					<td align="center">${s.firstName}</td>
					<td align="center">${s.lastName}</td>
					<td align="center">${s.yearOfBirth}</td>
					<td align="center">${s.course}</td>
					<td align="center"><a
						href="<c:url value ='/authors/remove/${a.id}'/>">Delete</a></td>
					<td align="center"><a
						href="<c:url value ='/authors/edit/${a.id}'/>">Edit</a></td>
				</tr>
			</c:forEach>
		</table>

		<!-- <button method="GET" action="/SpringMVC/addStudent">Sort</button> -->
		<form action="submit">
			<label style="width: 150px">First name</label> <input
				value="${students[0].firstName}" /> <br> <label
				style="width: 150px">Last name</label> <input
				value="${students[0].lastName}" /> <br> <label
				style="width: 150px">Year</label> <input
				value="${students[0].yearOfBirth}" /> <br> <label
				style="width: 150px">Course</label> <input
				value="${students[0].course}" /> <br>
			<div>
				<button type="submit">Save</button>
				<button>Cancel</button>
			</div>

		</form>


	</c:if>


	<c:url var="addStudent" value="/students/add" />

	<form:form action="${addStudent}" commandName="stud">
		<table>
			<%-- <tr>

				<td><form:label path="id">Id :
					</form:label></td>
				<td><form:input path="id" readonly="true" size="8"
						disabled="true" /> <form:hidden path="id" /></td>
			</tr> --%>

			<tr>

				<td><form:label path="firstName">First name:
</form:label></td>
				<td><form:input path="firstName" /></td>
			</tr>

			<tr>

				<td><form:label path="lastName">Last name:
</form:label></td>
				<td><form:input path="lastName" /></td>
			</tr>
<%-- 
			<tr>

				<td><form:label path="studentAge"> Age:
</form:label></td>
				<td><form:input path="studentAge" /></td>
			</tr> --%>

			<tr>

				<td><form:label path="course">Course:
 </form:label></td>
				<td><form:input path="course" /></td>
			</tr>

			<tr>

				<td colspan="2" align="center"><input type="submit"
					value="Add Student" /></td>
			</tr>

		</table>
	</form:form>
</body>
</html>