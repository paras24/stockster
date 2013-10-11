<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="springsec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:url var="userUpdateURL" value="/user/update"/>
<input type="hidden" id="userUpdateURLHiddenID" value="${userUpdateURL}"/>
<s:actionerror theme="bootstrap"/>
<s:form action="addProject" id="newProject" theme="bootstrap" cssClass="form-horizontal">
     	<s:textfield name="projectInfo.projectName" label="ProjectName" />
		<s:textfield name="projectInfo.subProjectName" label="SubProjectName" />
		<s:textfield name="projectInfo.groupHeadName" label="GroupHeadName" />
		<s:textfield name="projectInfo.pointOfContact" label="PointOfContact" />
		<s:textfield name="projectInfo.supervisorName" label="SupervisorName" />
<input type="button" id="submitProjectForm" cssClass="btn" value="Save"/>
</s:form>
<script type="text/javascript">

$(document).ready(function() 
{	
	$("submitProjectForm").click(function()
	{
	var urlvalue = $("#userUpdateURLHiddenID").val();
	var str = $("#newProject").serialize();
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
					$("##projectListTable").trigger("reloadGrid");
				}
			}
		});
	});
			
});

</script>





