<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta  http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"	 
	  href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
<title>UserList </title>
</head>
<body>
<h1 style ="color:blue">This is Admin's page</h1>

<div style="padding: 5px;">
 
   <a href="${pageContext.request.contextPath}/home">Home</a>
   |
   <a href="${pageContext.request.contextPath}/UserList">User List</a>
  
</div>  

 <h3>User List</h3>
 
    <p style="color: red;">${errorString}</p>
 <div class=" container-fluid w-75">
    <table class="table table-striped table-bordered table-hover"  cellpadding="5" cellspacing="1" >
      <thead class="thead-light">
       <tr>
          <th>ID</th>
          <th>USERNAME</th>
          <th>Avatar</th>
          <th>MAIL</th>
          <th>Phone</th>
          <th>Address</th>
          <th>PASSWORD</th>
          <th>ROLE</th>
          <th>EDIT</th>
          <th>DELETE</th>
       </tr>
      </thead>
      <tbody> 
       <c:forEach items="${userList}" var="user" >
        
          <tr>
             <td>${user.id}</td>
             <td>${user.username}</td>
             <td>
             <img width="100" height="100" src="${pageContext.request.contextPath}/user/getUserPhoto?id=${user.id}">
					
             </td>             
             <td>${user.mail}</td>
             <td>${user.phone}</td>
             <td>${user.address}</td>
             <td>${user.password}</td>
             <td>${user.role}</td>
             <td>
                <a href="edit?id=${user.id}">Edit</a>
             </td>
             <td>
                <a href="delete?id=${user.id}">Delete</a>
             </td>
          </tr>
       </c:forEach>
       </tbody>
    </table>
    </div>
    <span><a style="coler: green" href="${pageContext.request.contextPath}/user/create">AddNew</a></span>
    <span><a style="coler: red" href="${pageContext.request.contextPath}/logout">LogOut</a></span>
</body>
</html>