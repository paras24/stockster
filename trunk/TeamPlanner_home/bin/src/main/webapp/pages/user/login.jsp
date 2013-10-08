<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head></head>
<body>
<h1>EEJ2BodyContent</h1>
 <c:if test="${not empty param.error}">
 <table>
								<tr>
								<td colspan="2">
	      					<font color="red">Your login attempt was not successful, try again.<br/>Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.</font>
	      					</td>
	      					</tr>
	      					</table>
	      					</c:if>
<s:form action="/j_spring_security_check">
	<s:textfield name="j_username" label="Username"/>
	<s:password name="j_password" label="Password"/>
	<s:submit/>
</s:form>
 
</body>
</html>