<%-- 
    Document   : book_session
    Created on : 16 Jun 2026, 3:52:04 PM
    Author     : MP2-4
--%>
<%@ include file="header.html"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Book Session</h1>
        <form id="Booking" action="BookSessionServlet.java" method="post"
              <fieldset>
            <legend>Put your info  </legend>
            
            <label for="Name">Name </label>
            <input type="Student Name" id="studet_name" name:"studet_name" size="15"><br/>
            
            <label for="Branch">Branch Location </label>
            <input type="Branch location" id="branch_location" name:"branch_location" size="15"><br/>
            
            <label for="Lessontype">Lesson type</label>
            <input type="lesson_type" id="lesson_type" name:"lesson_type" size="15"><br/>
                   
            <input type="submit" id="btnSubmit" value="Submit">
            </fieldset>
        </form>
        <%@ include file="dynamicfooter.jsp" %>
    </body>
</html>
