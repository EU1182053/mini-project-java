<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forgot Password Form</title>
</head>
<body>
    <section>
        <h1>Forgot Password Form</h1>
        <!--  in action attribute put path of servlet bydefault is get request -->
        <form action="UserServlet" method="post">
            <!-- text field-->
            <label for="username">User Name: </label>
            <input type="text" name="username"  required>
            
            
            <label for="email">Email Id: </label>
            <input type="text" name="email"  required>
            
            
            <label for="pass">Set New Password: </label>
            <input type="text" name="newPassword" id="pass" pattern="(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}">
      
            <input type="submit" value="Submit">
            <input type="reset">
            <input type="hidden" name="act" value="forgotPassword"> 
        </form>
    </section>
</body>
</html>