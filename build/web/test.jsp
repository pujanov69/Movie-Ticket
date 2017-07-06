

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
         <c:forEach items="${now_showing_value}" var="items">
            <!-- <img src="<c:out value="uploads/${items.photo}"/>" width="100" height="100">-->
                   
             <img src="uploads/${items.photo}"/> 
                                
               <h1><c:out value="${items.movie_name}"></c:out></h1> 
               </c:forEach>
    </body>
</html>
