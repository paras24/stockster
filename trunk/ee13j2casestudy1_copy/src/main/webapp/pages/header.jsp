<%@taglib prefix="springsec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div id="header">
<div class="container">
 <div id="welcomeLine" class="row">
	<div class="span6"><%-- Welcome!<strong> ${user.email}</strong> --%></div>
	<div class="span6">
	<div class="pull-right">
		
	</div>
	</div>
</div>
<!-- Navbar ================================================== -->
<div id="logoArea" class="navbar">
<a id="smallScreen" data-target="#topMenu" data-toggle="collapse" class="btn btn-navbar">
	<span class="icon-bar"></span>
	<span class="icon-bar"></span>
	<span class="icon-bar"></span>
</a>
  <div class="navbar-inner">
   <!-- <a class="brand" href="index.html"><img src="assets/img/logo_impetus.png" alt="Impetus"/></a>-->
		<div class="nav pull-left page-header">
	<!--  <li class=""><a href="special_offer.html">Team View</a></li>
	 <li class=""><a href="normal.html">Project</a></li> -->
	 <h1>Team Planner</h1>
	 </div>
    <ul id="topMenu" class="nav pull-right">
	<!--  <li class=""><a href="special_offer.html">Team View</a></li>
	 <li class=""><a href="normal.html">Project</a></li> -->
	 <li class=""><a href="contact.html">Welcome!<strong> ${user.email}</strong></a></li>
	 <li class="">
	 <a href="<s:url value="/j_spring_security_logout"></s:url>" role="button" data-toggle="modal" style="padding-right:0"><span class="btn btn-success">Log out</span></a>
	<!--<div id="login" class="modal hide fade in" tabindex="-1" role="dialog" aria-labelledby="login" aria-hidden="false" >
		  <div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
			<h3>Login Block</h3>
		  </div>
		  <div class="modal-body">
			<form class="form-horizontal loginFrm">
			  <div class="control-group">								
				<input type="text" id="inputEmail" placeholder="Email">
			  </div>
			  <div class="control-group">
				<input type="password" id="inputPassword" placeholder="Password">
			  </div>
			  <div class="control-group">
				<label class="checkbox">
				<input type="checkbox"> Remember me
				</label>
			  </div>
			</form>		
			<button type="submit" class="btn btn-success">Sign in</button>
			<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
		  </div>
	</div>-->
	</li>
    </ul>
  </div>
</div>
</div>
</div>