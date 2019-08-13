<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.sql.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    
<head>
    
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><title>Project</title>
    <meta name="keywords" content="HTML,CSS,NET,JavaScript,ABC,programs,programmings,Coding,Education,Computer,IT,Studies,Academy,Further studies,learn,upgrade skills,skill">
    

    <link rel="stylesheet" type="text/css" href="Project.css" />
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
    <script type="text/javascript" src="script.js"></script>
    
  


</head>
<body>
<br>
    
 <form name="myForm" onsubmit="return validateForm()" novalidate method="post" action="Register.jsp">
       
        <h1 class="Head">Registration Form</h1>
        
     <br>
     <br>
        
        <div class="form-group">
<label class="registerLabel" for="Fname">FirstName<font style="color:red">*</font> </label><br>
    <input class="registerInput" id="Fname" name="Fname" autofocus  placeholder="FirstName" required onfocusout="FnameValidate()">
           <p class="error" id="FnameError"></p>
        </div>
        <br>
        <div class="form-group" >
<label class="registerLabel" for="Lname">LastName</label><br>
    <input class="registerInput" id="Lname" name="Lname" placeholder="LastName" required onfocusout="LnameValidate()" >
           <p class="error" id="LnameError"></p>
        </div>
     
            <br>      
        <div class="form-group">
<label class="registerLabel" for="gender">Gender</label><br>
            
        <input type="radio" name="Gender" value="male" id="Gender">Male &nbsp;
        <input type="radio" name="Gender" value="female" id="Gender"> Female
            <br>
           
        <p class="error" id="GenderError"></p>
     </div>
     
          <br>             
     <div class="form-group">
<label class="registerLabel" for="Address">Residential Address<font style="color:red">*</font></label><br>
         <textarea class="registerInput" name="Address" type="text" id="Address" required onfocusout="AddressValidate()" style="resize:none"></textarea>
         <p class="error" id="AddressError"></p>
        </div>
     <br>                       
          <div class="form-group">
<label class="registerLabel" for="Tel">Phone Number<font style="color:red">*</font></label><br>
        <input class="registerInput" type="Tel" id="Tel" name="Tel"  placeholder="Tel" maxlength="11" required onfocusout="TelValidate()">
              <p class="error" id="TelError"></p>
            </div>
          <br>                  
    <div class="form-group">
<label class="registerLabel" for="Course">Course Applying<font style="color:red">*</font></label><br>
        <select id="Course" name="Course" onfocusout="CourseValidate()" required>
            <%
            try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_registration","root","Nastoi95.");
            Statement stmt=con.createStatement();
            String sql = "SELECT * FROM courses";
            ResultSet rs = stmt.executeQuery(sql);
               while(rs.next()){
%>
                
<option value="<%=rs.getString("Course_Name") %>"><%=rs.getString("Course_Name") %></option>
                
    <%
                     }   
       con.close();
       
       }
        catch(Exception ex){
        throw ex;
        }
   
%>
        </select>
        <p class="error" id="CourseError"></p>
        
    </div>
          
             <br>                         
     <div class="form-group">
         <button type="submit" id="submit" style="margin-top: 10px; outline: none;">Submit</button>
            
<button type="reset" id="clear" style="margin-top: 10px; outline: none;">Clear</button>     
    </div>
</form>
</body>
</html>







