<%@page import="java.sql.*"%>
<%@page import="com.aswd.m1.Student" %> 
<% 
try{
            Student student = new Student();
            student.firstName = request.getParameter("Fname");
            student.lastName = request.getParameter("Lname");
            student.gender = request.getParameter("Gender");
            student.setAddress (request.getParameter("Address"));
            student.setTel (request.getParameter("Tel"));
            student.course = request.getParameter("Course");
   
           
           
            
            if (student.insert()){
            String url = request.getContextPath() + "/ThankYou.html"; 
            response.setStatus(301);
            response.setHeader("Location", url);
            response.setHeader("Connection", "close");
             }

        }
        catch(Exception ex){
        out.println(ex);
        }
   
%>


