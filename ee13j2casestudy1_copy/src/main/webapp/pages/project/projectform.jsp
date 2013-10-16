<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="springsec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:url var="projectUpdateURL" value="/project/addProject"/>
<input type="hidden" id="projectUpdateURLHiddenID" value="${projectUpdateURL}"/>
<s:form id="newProjectForm" theme="bootstrap" cssClass="form-horizontal">
<s:actionerror theme="bootstrap"/>
     	<s:textfield name="projectName" label="ProjectName" />
		<s:textfield name="subProjectName" label="SubProjectName" />
		<s:textfield name="groupHeadName" label="GroupHeadName" />
		<s:textfield name="pointOfContact" label="PointOfContact" />
		<s:textfield name="supervisorName" label="SupervisorName" />
		<input type="button" id="submitProjectForm" cssClass="btn" value="Save"/>
<%-- <s:submit /> --%>
</s:form>

<script type="text/javascript">

$(document).ready(function() 
{	
	$("#submitProjectForm").click(function()
	{
	var urlvalue = $("#projectUpdateURLHiddenID").val();
	var str = $("#newProjectForm").serialize();
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
					$("#projectListTable").trigger("reloadGrid");
				}
			}
		});
	});
			
});

</script>





