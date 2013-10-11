<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:form action="addTeamMember" >
		<s:textfield name="teamMemberInfo.teamMemberName" label="Name" />
		<s:textfield name="teamMemberInfo.grade" label="Level" />
		<s:textfield name="teamMemberInfo.experirnce" label="Experirnce" />
		<s:textfield name="teamMemberInfo.groupHeadName" label="GroupHeadName" />
		<s:textfield name="teamMemberInfo.status" label="Status" />
		
<s:submit />
</s:form>
</body>
</html>