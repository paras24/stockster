<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="springsec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<link href="<s:url value="/resources/assets/css/ui.jqgrid.css"/>" rel="stylesheet"/>

<link rel="stylesheet" href="<s:url value="/resources/assets/js/fancybox/jquery.fancybox-1.3.4.css"/>" media="screen" type="text/css" />
<script type="text/javascript" language="javascript" src="<s:url value="/resources/assets/js/fancybox/jquery.mousewheel-3.0.4.pack.js"/>"></script>
<script type="text/javascript" language="javascript" src="<s:url value="/resources/assets/js/fancybox/jquery.fancybox-1.3.4.pack.js"/>"></script>	
<script type="text/javascript" language="javascript" src="<s:url value="/resources/assets/js/grid.locale-en.js"/>"></script>
<script type="text/javascript" language="javascript" src="<s:url value="/resources/assets/js/jquery.jqGrid.min.js"/>"></script>


<s:url var = "teamJSONURL" value="/reports/teamListJson.action"/>
<s:url var = "deleteTeamMemberURL" value="/team/delete.action"/>
<input type="hidden" id="teamJSONURLHidden" value="${teamJSONURL}"/>

<input type="hidden" id="deleteTeamMemberURL" value="${deleteTeamMemberURL}"/>
<s:url var="form" value="/user/form"/>
<a href="${form}" id="newUser"></a>

<div id="tabs">
	<ul>
		<li><a href="#teamTable">Status Wise Summary</a></li>
		<li><a href="#projectRequirementsTable">Project Requirements</a></li>
		<li><a href="#effortSpentSummaryTable">Effort Spent Summary</a></li>
	</ul>
	<table id="teamTable"></table>
	<div id="teamPager"></div>
	<table id="projectRequirementsTable"></table>
	<div id="projectRequirementsPager"></div>
	<table id="effortSpentSummaryTable"></table>
	<div id="effortSpentSummaryPager"></div>
</div>

<script type="text/javascript">
$(document).ready(function() 
{	
	$("#tabs").tabs();
	drawTeamTable();
});
function drawTeamTable()
{
		$("#teamTable").jqGrid( 
				{
					datatype: function(postdata) {
						gridInitialize();
					}, 
					//pager:'#teamPager',					
					autowidth: true,				
					rownumbers: false,				
					height:"100%",
					colNames:['Status','Status Wise Summary'],
					colModel:[
							  {name:'status',hidden:true},
							  {name:'teamMemberName' , align:'left', searchoptions:{sopt:['cn']}},							  
					          ],
					emptyrecords: "No Status found.",
					beforeSelectRow:function(){return false},
					viewrecords: true,				
		            grouping:true,
		            //caption:"Status Wise Summary",
		            groupingView :	{ 
						groupField : ['status'],
						groupColumnShow : [false], 
						groupText : ["<b>{0} - {1} Member(s)</b>"],
						groupCollapse : true, 
						},
		            jsonReader : {
		                root: "teamMembers",
		                total: "totalPages",
		                page:"currentPage",
		                records: "totalDisplayRecords",
		                repeatitems: false,	                
		              },	   
		            search : {
		            	     caption: "Find Member",
		            	     Find: "Find",
		            	     Reset: "Reset",
		            	   },
				});
		
		//jQuery("#teamTable").jqGrid('navGrid',"#teamPager",{addfunc:newMember,addtitle:'Add Member', searchtitle : "Find Users", refreshtitle : "Reload View",edit:false,add:true,del:false,search: true, refresh:true});		
		$("#teamTable").css('overflow-x','hidden');
		$("#teamTable").css('overflow-y','auto');
		$(".ui-pg-selbox").css('width','50');
		$(".ui-pg-selbox").css('height','23');
		$(".ui-pg-input").css('width','15');
		$(".ui-pg-input").css('height','12');				
}




	function gridInitialize() 
	{
		var urlValue = $('#teamJSONURLHidden').val();
		var displayLength=jQuery("#teamTable").jqGrid("getGridParam","postData").rows;
		var searchString=jQuery("#teamTable").jqGrid("getGridParam","postData").searchString;
		if(typeof searchString=='undefined') 
		{
			searchString="";						
		}
		var sortColName=jQuery("#teamTable").jqGrid("getGridParam","postData").sidx;
		var sortOrder=jQuery("#teamTable").jqGrid("getGridParam","postData").sord;
		var displayStart=(jQuery("#teamTable").jqGrid("getGridParam","postData").page-1)*displayLength;
		urlValue = urlValue+"?displayLength="+displayLength+"&searchString="+searchString+"&sortColName="+sortColName+"&sortOrder="+sortOrder+"&displayStart="+displayStart;
		jQuery.ajax({
        url: urlValue,			            
        dataType:"json",
        complete: function(json,stat)
        {			            	 
           if(stat=="success")  
           {
         	 var grid = jQuery("#teamTable")[0];
         	 var memberInfo = JSON.parse(json.responseText);
         	 grid.addJSONData(memberInfo);         	 
           }
        }
     	});
	}
	
	
	function newMember()
	{
				
	}
	
function actionsLinkFormatter(cellvalue, options, rowObject)
{
	var memberID = rowObject['memberID'];
	var teamMemberName = rowObject['teamMemberName'];
	var userActions = 
	"<a class='ui-pg-div ui-inline-edit' onmouseout='jQuery(this).removeClass(&quot;ui-state-hover&quot;);' onmouseover='jQuery(this).addClass(&quot;ui-state-hover&quot;);' onclick='editUser(&quot;"+memberID+"&quot;);'style='cursor:pointer; display: inline-table; float: none; ' title='Edit "+teamMemberName+"'><span align='center' class='ui-icon ui-icon-pencil'></span></a>"+
	"<a class='ui-pg-div ui-inline-del' onmouseout='jQuery(this).removeClass(&quot;ui-state-hover&quot;);' onmouseover='jQuery(this).addClass(&quot;ui-state-hover&quot;);' onclick='deleteUser(&quot;"+memberID+"&quot;);'style='display: inline-table; float: none; margin-left: 10px;' title='Delete "+teamMemberName+"'><span align='center' class='ui-icon ui-icon-trash'></span></a>";
	return userActions ;
}

function deleteMember(memberID)	
{
		var $dialog = $('<div></div>')
		.html("Are you sure you want to delete the Member?")
		.dialog({
			autoOpen: false,
			title: 'Team Planner',
			resizable: false,
			height:140,
			modal: true,
			buttons: {
				"Delete": function() {
					var urlvalue = $("#deleteMemberURLHidden").val()+"?memberID="+memberID;
					var val = $.ajax( {
						type : "POST",
						url : urlvalue,		
						dataType : "json",
						async : false,
						success : function(result) 
						{
							$("#teamTable").trigger("reloadGrid");						
						}
					});	
					$( this ).dialog( "close" );
				},
				Cancel: function() {
					$( this ).dialog( "close" );
				}
			}
		});
		$dialog.dialog('open');
}

function convertTimeStampToDate(cellvalue, options, rowObject) 
{					
	var pubDate = new Date(cellvalue);
	var hours=pubDate.getHours();
	var meridian="AM";
	if (hours > 12) {
		meridian = "PM";
		hours = hours - 12;
	}
    if (hours == 12) 
		meridian = "PM";
    if (hours < 10 && hours>0)
		hours = "0" + hours;
    if (hours==0) {
		hours=12;	
	    meridian = "AM";
		}
	var date=pubDate.getDate();
	if (date < 10)
		date="0"+date;
	var month=pubDate.getMonth()+1;
	if (month < 10)
		month="0"+month;
	var min=pubDate.getMinutes();
	if (min < 10)
		min="0"+min;
	var formattedDate = month+'-'+date+'-'+pubDate.getFullYear()+' '+hours+':'+min+' '+meridian;//weekday[pubDate.getDay()] + ' '+ monthname[pubDate.getMonth()] + ' '+ pubDate.getDate() + ', ' + pubDate.getFullYear()+' '+pubDate.toLocaleTimeString();				 				  							
	return formattedDate;
}

</script>				
