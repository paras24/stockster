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
<s:form action="addTeamMember" theme="bootstrap" cssClass="form-horizontal">
<s:actionerror theme="bootstrap"/>
		<s:textfield name="teamMemberName" label="Name" />
		<s:textfield name="grade" label="Level" />
		<s:textfield name="experience" label="Experience" />
		<s:textfield name="supervisor" label="Supervisor Name" />
		<s:textfield name="status" label="Status" />
		<s:textarea name="keySkills" label="Key Skills"/>
		<s:textarea name="remarks" label="Remarks"/>
		
<s:submit />
</s:form>
</body>
</html>
