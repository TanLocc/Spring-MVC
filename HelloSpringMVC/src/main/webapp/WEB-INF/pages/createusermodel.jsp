<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>

 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" 	 
	  href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">  
<title>Add User Form</title>  
</head>  
<body>  
<p style="color: red;">${errorString}</p>  
<a href="adduser.jsp">View All Records</a><br/>  
  
<h1>Add New User</h1>  
<div align="center"> 
<form:form method="POST"  action="${pageContext.request.contextPath}/user/createmodel" commandName="user" enctype="multipart/form-data" style="width:600px;margin: 0px auto;" >
 
   <!-- Vertical -->                                                             
    <h4>Nhập thông tin new user</h4>
    <div class = "col-4" align="left" >
     <div>
      <form:label  path="avatar">avatar</form:label>
      <form:input type="file" path="avatar"  id="avatar"/>
       
     </div>
     
     <div>
      <form:label  path="username">Username</form:label>
      <form:input type="text" path="username"    />
     </div>
     <div>
      <form:label  path="phone">Phone</form:label>
      <form:input path="phone" type="tel"   />
     </div>
     <div>
      <form:label  path="mail">Email</form:label>
      <form:input path="mail" type="email" />
     </div>
     <div>
      <form:label  path="address">Address</form:label>
      <form:input path="address" type="text"   />
     </div>
     <div>	 
	  <form:label path="password">Password</form:label>
      <form:input path="password" type="password"   />
     </div>  
     
     
     <form:select path="role">
      <option value="USER">USER</option>
      <option value="ADMIN">ADMIN</option> 
     </form:select>
	  <button type="submit" value="upload" class="btn btn-primary">AddUser</button>
      
   </div>
   <span> Quay lại user list thì bấm vào<a class="link" href="Admin.jsp"> đây </a>.</span>
   
 
</form:form>   
</div> 
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</body>  
</html> 