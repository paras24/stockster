<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="springsec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<s:url var="logoutUrl" value="/j_spring_security_logout"></s:url>

 <springsec:authorize access="hasRole('GroupHead')">
 <h4>Hello Group Head ${user.email}</h4>
 </springsec:authorize>
 <springsec:authorize access="hasRole('GroupGuest')">
 <h4>Hello Guest ${user.role.roleName}</h4>
 </springsec:authorize>

<h3><a href="${logoutUrl}">Logout</a></h3>
