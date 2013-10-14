<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="springsec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:url var="userUpdateURL" value="/user/update"/>
<input type="hidden" id="userUpdateURLHiddenID" value="${userUpdateURL}"/>
<s:form id="userform" theme="bootstrap" cssClass="form-horizontal">
<s:actionerror theme="bootstrap"/>
<s:textfield name="username" label="Username"/>
<s:password name="password" label="Password"/>
<input type="button" id="submitUserForm" cssClass="btn" value="Save"/>
</s:form>
<script type="text/javascript">

$(document).ready(function() 
{	
	$("#submitUserForm").click(function()
	{
	var urlvalue = $("#userUpdateURLHiddenID").val();
	var str = $("#userform").serialize();
	var val = $.ajax({
		type : "POST",
		url : urlvalue,
		data : str,
		dataType : "html",
		async : false,
		success : function(result)
			{
				if (parseInt(result.search("errorMessage"))!=-1) 
				{
					$("#fancybox-content").html(result);
					$.fancybox.resize();
				}
				else
				{
					$.fancybox.close();
					$("#userListTable").trigger("reloadGrid");
				}
			}
		});
	});
			
});

</script>





