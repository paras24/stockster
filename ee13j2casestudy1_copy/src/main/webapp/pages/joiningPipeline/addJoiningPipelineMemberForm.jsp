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
  </script>
</head>
<body>
<s:form action="addJoiningPipelineMember" >
		<s:textfield name="joiningPipelineMemberInfo.jpmemberName" label="Name" required="true"/>
		<s:textfield name="joiningPipelineMemberInfo.grade" label="Level" />
		<s:textfield name="joiningPipelineMemberInfo.experience" label="Experience" />
		<s:textfield name="joiningPipelineMemberInfo.supervisorName" label="Supervisor Name" />
		<s:textfield name="joiningPipelineMemberInfo.status" label="Status" />
		<s:textfield name="joiningPipelineMemberInfo.keySkills" label="Key Skills" />
		<s:textfield name="joiningPipelineMemberInfo.dateOfJoining" id="datepicker" label="Joining Date" />
		
<s:submit />
</s:form>
</body>
</html>