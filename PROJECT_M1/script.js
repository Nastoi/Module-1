var default_content="";

$(document).ready(function(){

	checkURL();
	$('ul li a').click(function (e){
			checkURL(this.hash);
	});

	//filling in the default content
	default_content = $('#pageContent').html();


	setInterval("checkURL()",250);

});

var lasturl="";

function checkURL(hash)
{
	if(!hash) hash=window.location.hash;

	if(hash != lasturl)
	{
		lasturl=hash;
		// FIX - if we've used the history buttons to return to the homepage,
		// fill the pageContent with the default_content
		if(hash=="")
		$('#pageContent').html(default_content);

		else{
		 if(hash=="#Courses")
		 	loadCourses();
		 else if(hash=="#details")
			 loadDetails(str);
		 else
		   loadPage(hash);
		}
	}
}


/*function loadDetails(selectedCourse)
{
	$('#pageContent').html(selectedCourse);
	var jsonURL="courses.json";


$.getJSON(jsonURL, function (json)
{
	var myCourse =json.courses.filter(function (el)
	{
		return (el.name === selectedCourse);
	}
);
    
	var courseDetail =  " <br><br>\
    <ul class=\"breadcrumb\">\
  <a href=\"Home.html\" id=\"A\">Home</a>\
<a href=\"#courses\" id=\"A\">Courses</a>\
  <a id=\"A\" style=\"color:black;\">" + selectedCourse +   "</a>\
</ul>\<div class=\"courseDetails\"><table class=\"courseDetails\">"
		$.each(myCourse, function()
	{
            
		courseDetail += '<tr>\
		<td>'+ '<br>'+ '<br>' + this.name + ' <br> <img src= ' + this.imgPath + '>'+'</td>\
			<td>' + '<br>' + '<br>' + this.desc + ' </td>\
			</tr>';
			
	});
	
courseDetail +='</table></div>'
   $('#pageContent').html(courseDetail);
   $('#loading').css('visibility','hidden');
  });
}*/


function loadPage(url)
{
	url=url.replace('#','');

	$('#loading').css('visibility','visible');

	$.ajax({
		
		type: "POST",
		url: "load_page.jsp",
		data: 'page='+url,
		dataType: "html",
		success: function(msg){

			if(parseInt(msg)!=0)
			{
				$('#pageContent').html(msg);
				$('#loading').css('visibility','hidden');
			}
		}

	});
    
}




function FnameValidate() {
  var Firstname = document.forms["myForm"]["Fname"].value;
  
    
  if (Firstname == "") {
    document.getElementById("FnameError").innerHTML=("Name required");
      return false;
      document.getElementById("Fname").focus();
  }else if (!Firstname == "" && !Firstname.match(/^[a-zA-Z]+$/)){
      document.getElementById("FnameError").innerHTML=("Only letters is allowed");
      return false;
      document.getElementById("Fname").focus();
  }else{
      document.getElementById("FnameError").innerHTML=("");
  }
}
    
 function LnameValidate(){
     var Lastname = document.forms["myForm"]["Lname"].value;
    if (Lastname == "") {
    document.getElementById("LnameError").innerHTML=("Name is required");
         return false;
        document.getElementById("Lname").focus();
   
  }else if (!Lastname == "" && !Lastname.match(/^[a-zA-Z]+$/)){
      document.getElementById("LnameError").innerHTML=("Only letters is allowed");
      return false;
      document.getElementById("Lname").focus();
  }else{
      document.getElementById("LnameError").innerHTML=("");
  }
}
            
       
    function AddressValidate() {
  var Address = document.forms["myForm"]["Address"].value;
  if (Address == "") {
    document.getElementById("AddressError").innerHTML=("Address required");
      return false;
      document.getElementById("Address").focus();
  }else{
      document.getElementById("AddressError").innerHTML=("");
  }
}
    
        function TelValidate(){
        var Tel = document.forms["myForm"]["Tel"].value;
            if (Tel == "") {
    document.getElementById("TelError").innerHTML=("Tel is required");
    return false;
    document.getElementById("Tel").focus();
  }else if (!Tel == "" && !Tel.match(/^[0-9]*$/)){
      document.getElementById("TelError").innerHTML=("Invalid Tel. Numbers only.");
      return false;
      document.getElementById("Tel").focus();
  }else{
      document.getElementById("TelError").innerHTML=("");
  }
    }
    
                 
       function validateForm(){
    var Firstname = document.forms["myForm"]["Fname"].value;
    var Lastname = document.forms["myForm"]["Lname"].value;
    var Gender = document.forms["myForm"]["Gender"].value;
    var Address = document.forms["myForm"]["Address"].value;

    
    if (Firstname == "") {
    document.getElementById("FnameError").innerHTML=("Name required");
    document.getElementById("Fname").focus();
    return false;
  }else if(!Firstname == "" && !Firstname.match(/^[a-zA-Z]+$/)){
      document.getElementById("FnameError").innerHTML=("Only letters is allowed");
      return false;
  } 
    if (Lastname == "") {
    document.getElementById("LnameError").innerHTML=("Name is required");
    document.getElementById("Lname").focus();
    return false;
  }else if (!Lastname == "" && !Lastname.match(/^[a-zA-Z]+$/)){
      document.getElementById("LnameError").innerHTML=("Only letters is allowed");
      return false;
  }
    if (Address == "") {
    document.getElementById("AddressError").innerHTML=("Address required");
    document.getElementById("Address").focus();
    return false;
  }else{
      document.getElementById("AddressError").innerHTML=("");
  };
    if (Gender == "") {
    document.getElementById("GenderError").innerHTML=("Gender is required");
    return false;
  }
    if (Tel == "") {
    document.getElementById("TelError").innerHTML=("Tel is required");
    document.getElementById("Tel").focus();
    return false;
  }else if (!Tel == "" && !Tel.match(/^[0-9]*$/)){
      document.getElementById("TelError").innerHTML=("Invalid Tel. Numbers only.");
      return false;
  }
   
}