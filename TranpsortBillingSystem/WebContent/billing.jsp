<%@ page import="java.sql.*"%>  

<%
String s=request.getParameter("val");  
if(s==null || s.trim().equals("")){  
out.print("Please enter id");  
}else{  
int vehiclenumber=Integer.parseInt(s);  
out.print(vehiclenumber);  
try{  
Class.forName("org.postgresql.Driver"); 
Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransportManagementSystem",
        "postgres", "pratik@123");  
PreparedStatement ps=con.prepareStatement("select * from vehicle where vehiclenumber=?");  
ps.setInt(1,vehiclenumber);  
ResultSet rs=ps.executeQuery();  
while(rs.next()){  
out.print(rs.getInt(1)+" "+rs.getString(2));  
}  
con.close();  
}catch(Exception e){e.printStackTrace();}  
}  
%>  

<div class="main">
	<h4>
		Welcome 
		<span> <%
 		String email1 = (String) session.getAttribute("email");
 		out.print(email1);
 		%>
		</span>
	</h4>
</div>
<div class="row">
	<div class="column">
		<img src="RESOURCE/IMG/logo.png">
	</div>

	<div class="column">
			<form name="billings">
		<input type="text" name="bill" onkeyup="sendInfo()">
	</form>
	<span id="pat"> </span>
	</div>
	
</div>
<script>  
var request;  
function sendInfo()  
{  
var v=document.billings.bill.value;  
var url="billing.jsp?val="+v;  

if(window.XMLHttpRequest){  
request=new XMLHttpRequest();  
}  
else if(window.ActiveXObject){  
request=new ActiveXObject("Microsoft.XMLHTTP");  
}  
  
try{  
request.onreadystatechange=getInfo;  
request.open("GET",url,true);  
request.send();  
}catch(e){alert("Unable to connect to server");}  
}  
  
function getInfo(){  
if(request.readyState==4){  
var val=request.responseText;  
document.getElementById('pat').innerHTML=val;  
}  
}  
  
</script> 
