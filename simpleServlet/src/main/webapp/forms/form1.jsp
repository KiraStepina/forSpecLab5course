<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>First registration page</title>
</head>

<body>
<h1>First registration page</h1>
<form action = "../simple" method = "POST">
    <table border = "0">

        <tr>
            <td><b>Name</b></td>
            <td><input type = "text" name = "name"
                       value = "" size = "70"/></td>
        </tr>
        <tr>
            <td colspan = "2"><input type = "submit" value = "Next"/></td>
        </tr>
    </table>
</form>
</body>
</html>
