<!DOCTYPE html>
<html lang="en">
  <head>
  <%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <meta charset="utf-8">
    <title>Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="impetus.com">
<script type="text/javascript" language="javascript" src="<s:url value="/resources/assets/js/jquery-1.9.0.min.js"/>"></script>    
	<!-- Bootstrap style  --> 
    <link href="<s:url value="/resources/assets/css/bootstrap.min.css"/>" rel="stylesheet"/>
	<link href="<s:url value="/resources/assets/css/mainstyle.css"/>" rel="stylesheet"/>
	<!-- Bootstrap style responsive -->
	<link href="<s:url value="/resources/assets/css/bootstrap-responsive.min.css"/>" rel="stylesheet"/>
  </head>
<body>
<div class="wrapper">
	<div class="comingsoonBlk">
	<h2>Login</h2>
	<br class="clr">
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
			<span style="color:black;margin-left: -299px;">User Name:</span><span class="email" > <input name="j_username" type="email" placeholder="User Name"></span>
			<span style="color:black; margin-left: -295px;margin-top: 64px;float:left;">Password:</span><span class="email" ><input type="password" placeholder="Password" name="j_password"></span>
			<!--<span class="subscribe"><button class="btn btn-warning pull-right" type="submit">Login</button></span>-->
			<br class="clr">
			<div class="socialMedia"><button class="subscribe btn btn-warning" type="submit">Login</button>
			<br class="clr">
		</s:form>
		<!--<a href="#" data-placement="top" data-original-title="Find us on via facebook"><img style="width:45px" src="assets/img/facebook.png" alt="facebook" title="facebook"></a>
		<a href="#" data-placement="top" data-original-title="Find us on via twitter"><img style="width:45px" src="assets/img/twitter.png" alt="twitter" title="twitter"></a>
		<a href="#" data-placement="top" data-original-title="Find us on via youtube"><img style="width:45px" src="assets/img/youtube.png" alt="youtube" title="youtube"></a> -->
	</div>
		<!--<p>Forgot your password?</p>-->
	</div>
</div>
<div class="copyright">&copy; 2013 Imp<span style="color:#008000;" >e</span>tus Technologies, Inc. All Rights Reserved.</div>
</body>
</html>

