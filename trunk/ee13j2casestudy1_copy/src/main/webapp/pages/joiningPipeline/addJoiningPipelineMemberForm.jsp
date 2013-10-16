<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>  
<%--     <%@ taglib prefix="sx" uri="/struts-dojo-tags" %>  --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css" />
<title>Add JP Member</title>
<script>
  $(function() {
    $( "#datepicker" ).datepicker();
  });
  
  function validate()
  {
	  validated = true;
	  
	 if(document.getElementById('textName').value == null || document.getElementById('textName').value == ''){
		  validated = false;
		  document.getElementById("textName").style.borderColor="#FF0000";

	 }
	 else{
		 document.getElementById("textName").style.borderColor="#CCCCCC";
	 }
	 
	 if(document.getElementById('textGrade').value == null || document.getElementById('textGrade').value == ''){
		  validated = false;
		  document.getElementById("textGrade").style.borderColor="#FF0000";
	 } 
	 else{
		 document.getElementById("textGrade").style.borderColor="#CCCCCC";
	 }
	  
	  return validated;
  }
  </script>
</head>
<body>
<s:form action="addJoiningPipelineMember" onsubmit="return validate()"  >
		<s:textfield name="joiningPipelineMemberInfo.jpmemberName" label="Name" id='textName'/> <s:label><font  color="red" id="lblName"></font></s:label>
		<s:textfield name="joiningPipelineMemberInfo.grade" label="Level" id='textGrade'/> <s:label><font  color="red" id="lblGrade"></font></s:label>
		<s:textfield name="joiningPipelineMemberInfo.experience" label="Experience" /> <s:label id="lblExp" value=""/>
		<s:textfield name="joiningPipelineMemberInfo.supervisorName" label="Supervisor Name" /> <s:label id="lblSupervisor" value=""/>
		<s:textfield name="joiningPipelineMemberInfo.status" label="Status" /> <s:label id="lblStatus" value=""/>
		<s:textfield name="joiningPipelineMemberInfo.keySkills" label="Key Skills" /> <s:label id="lblKeyskills" value=""/>
		<s:textfield name="joiningPipelineMemberInfo.dateOfJoining" id="datepicker" label="Joining Date" /> <s:label id="lblDate" value=""/>	
<s:submit />
</s:form>
</body>
</html>