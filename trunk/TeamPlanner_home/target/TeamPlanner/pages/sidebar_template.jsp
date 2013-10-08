<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title><tiles:insertAttribute name="title"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    	
    <link href="<s:url value="/resources/assets/css/jquery-ui-1.9.2.custom.min.css"/>" rel="stylesheet"/>
	<link id="callCss" href="<s:url value="/resources/assets/css/bootstrap.min.css"/>" rel="stylesheet" media="screen"/>
	<link href="<s:url value="/resources/assets/css/base.css"/>" rel="stylesheet" media="screen"/>
	<link href="<s:url value="/resources/assets/css/bootstrap-responsive.min.css"/>" rel="stylesheet"/>
	<link href="<s:url value="/resources/assets/css/font-awesome.css"/>" rel="stylesheet" type="text/css"/>
	<link href="<s:url value="/resources/assets/js/google-code-prettify/prettify.css"/>" rel="stylesheet"/>
	
	<script type="text/javascript" language="javascript" src="<s:url value="/resources/assets/js/jquery-1.8.2.js"/>"></script>
<script type="text/javascript" language="javascript" src="<s:url value="/resources/assets/js/jquery-ui-1.9.2.custom.min.js"/>"></script>
	<script type="text/javascript" language="javascript" src="<s:url value="/resources/assets/js/bootstrap.min.js"/>"></script>
	<script type="text/javascript" language="javascript" src="<s:url value="/resources/assets/js/google-code-prettify/prettify.js"/>"></script>
	<script type="text/javascript" language="javascript" src="<s:url value="/resources/assets/js/bootshop.js"/>"></script>
	
	
	
	
	<style type="text/css" id="enject"></style>
  </head>
<body>
<tiles:insertAttribute name="header" />
<div id="mainBody">
	<div class="container">
	<div class="row">
	<tiles:insertAttribute name="sidebar"/>
	<div class="span10">
			<div class="well" style="min-height: 650px;">
		<tiles:insertAttribute name="body"/>
		</div>
	</div>
</div>
</div>
</div>
<!-- MainBody End ============================= -->
<!-- Footer ================================================================== -->
	<tiles:insertAttribute name="footer"/>
<!-- Placed at the end of the document so the pages load faster ============================================= -->
<script type="text/javascript" language="javascript" src="<s:url value="/resources/assets/js/jquery.lightbox-0.5.js"/>"></script>
	

</body>
</html>