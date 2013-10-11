<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="springsec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<link href="<s:url value="/resources/assets/css/ui.jqgrid.css"/>" rel="stylesheet"/>


<script type="text/javascript" language="javascript" src="<s:url value="/resources/assets/js/fancybox/jquery.mousewheel-3.0.4.pack.js"/>"></script>
<script type="text/javascript" language="javascript" src="<s:url value="/resources/assets/js/fancybox/jquery.fancybox-1.3.4.pack.js"/>"></script>	
<script type="text/javascript" language="javascript" src="<s:url value="/resources/assets/js/grid.locale-en.js"/>"></script>
<script type="text/javascript" language="javascript" src="<s:url value="/resources/assets/js/jquery.jqGrid.min.js"/>"></script>


<s:url var = "projectListJSONURL" value="/project/listProject.action"/>
<s:url var = "deleteProjectURL" value="/project/deleteProject.action"/>
<input type="hidden" id="projectListJSONURLHidden" value="${projectListJSONURL}"/>

<input type="hidden" id="deleteProjectURLHidden" value="${deleteProjectURL}"/>
<s:url var="form" value="/project/form"/>
<a href="${form}" id="newProject"></a>
<table id="projectListTable">
</table>
<div id="projectListPager"></div>
<script type="text/javascript">
$(document).ready(function() 
{	
	drawTable();
	$('#newProject').fancybox({				
		 autoDimensions: false,
		 onComplete: function() {
		 	$.fancybox.resize();
		 }
	});
	
});
function drawTable()
{
	
		$("#projectListTable").jqGrid( 
				{
					datatype: function(postdata) {
						gridInitialize();
					},      
					pager:'#projectListPager',
					autowidth: true,				
					rownumbers: true,				
					height:"100%",
					sortname : 'modified',
					sortorder : 'desc',
					colNames:['ID','ProjectName', 'SubProjectName', 'GroupHead','PointOfContact','SupervisorName',""],
					colModel:[
							  {name:'projectId', hidden:true},
							  {name:'projectName' , align:'left', width : 140, searchoptions:{sopt:['cn']}},
					          {name:'subProjectName', align:'center', width : 100,search:false},
					          {name:'groupHeadName', align:'center', width : 100,search:false},
					          {name:'pointOfContact', align:'center', width : 100,search:false},				 
					          {name:'supervisorName', align:'center', width : 100,search:false},
					          {name:'options',index:'options',align:'center', width:60,editable: false,formatter:actionsLinkFormatter,sortable:false}
					          ],
					sortname: 'modified',
					emptyrecords: "No projects found.",
					beforeSelectRow:function(){return false},
					viewrecords: true,				
		            rowNum:10,		            
		            rowList:[10,20,30],
		            grouping:true,
		            groupingView :	{ 
						groupField : ['projectName'], 
						groupColumnShow : [false], 
						groupText : ["<b>{0} - {1} Sub Project(s)</b><a class='ui-pg-div ui-inline-del' onmouseout='jQuery(this).removeClass(&quot;ui-state-hover&quot;);' onmouseover='jQuery(this).addClass(&quot;ui-state-hover&quot;);' onclick='addSubProject(&quot;{0}&quot;)' style='cursor:pointer;float:none;margin-left:5px;display:inline-table;' title='Add Sub Project to {0}'><span align='center' class='ui-icon ui-icon-document'></span></a><a class='ui-pg-div ui-inline-document' onmouseout='jQuery(this).removeClass(&quot;ui-state-hover&quot;);' onmouseover='jQuery(this).addClass(&quot;ui-state-hover&quot;);' title='Delete {0}' onclick='deleteProject(&quot;{0}&quot;)' style='float:none;margin-left:5px;display:inline-table;'><span align='center' class='ui-icon ui-icon-trash'></span></a>"],
						groupCollapse : false, 
						groupOrder: ['asc'],
						groupDataSorted : true 
						},
		            jsonReader : {
		                root: "projectInfoList",
		                total: "totalPages",
		                page:"currentPage",
		                records: "totalDisplayRecords",
		                repeatitems: false,	                
		              },	   
		            search : {
		            	     caption: "Find Project",
		            	     Find: "Find",
		            	     Reset: "Reset",
		            	   }            	   
				});
		
		jQuery("#projectListTable").jqGrid('navGrid',"#projectListPager",{addfunc:newProject,addtitle:'Add Project', searchtitle : "Find Projects", refreshtitle : "Reload View",edit:false,add:true,del:false,search: true, refresh:true});
		$("#projectListTable").css('overflow-x','hidden');
		$("#projectListTable").css('overflow-y','auto');
		$(".ui-pg-selbox").css('width','50');
		$(".ui-pg-selbox").css('height','23');
		$(".ui-pg-input").css('width','15');
		$(".ui-pg-input").css('height','12');
		
		
}

	function gridInitialize() {
		
		var urlValue = $('#projectListJSONURLHidden').val();
		var displayLength=jQuery("#projectListTable").jqGrid("getGridParam","postData").rows;
		var searchString=jQuery("#projectListTable").jqGrid("getGridParam","postData").searchString;
		if(typeof searchString=='undefined') {
			searchString="";						
			}
		var sortColName=jQuery("#projectListTable").jqGrid("getGridParam","postData").sidx;
		var sortOrder=jQuery("#projectListTable").jqGrid("getGridParam","postData").sord;
		var displayStart=(jQuery("#projectListTable").jqGrid("getGridParam","postData").page-1)*displayLength;
		urlValue = urlValue+"?displayLength="+displayLength+"&searchString="+searchString+"&sortColName="+sortColName+"&sortOrder="+sortOrder+"&displayStart="+displayStart;
	jQuery.ajax({
        url: urlValue,			            
        dataType:"json",
        complete: function(json,stat){			            	 
           if(stat=="success")  
           {
         	 var grid = jQuery("#projectListTable")[0];
         	 grid.addJSONData(JSON.parse(json.responseText));
         	 var ids = jQuery("#projectListTable").getDataIDs();
             for(var i=0;i<ids.length;i++)
             { 
                     var cl = ids[i];
                     var data = jQuery("#projectListTable").getRowData(cl);
                     console.log("data>> "+data);
                     var projectName = data['projectName'];		                               
                     var subProjectName = data['subProjectName'];
                     if(subProjectName!="")
                     {
                     	//deletetc = "<span><a href='#' class='ui-icon ui-icon-trash' title='Delete "+testcaseName+"'  onclick='deleteTestcase(&quot;"+groupName+"&quot;,&quot;"+testcaseName+"&quot;);' style='display: inline-table;'>Delete</a></span>";		                                	
                     	var deleteProject = "<a class='ui-pg-div ui-inline-del' onmouseout='jQuery(this).removeClass(&quot;ui-state-hover&quot;);' onmouseover='jQuery(this).addClass(&quot;ui-state-hover&quot;);' onclick='deleteSubProject(&quot;"+projectName+"&quot;,&quot;"+subProjectName+"&quot;);' style='float:left;margin-left:10px;' title='Delete "+subProjectName+"'><span align='center' class='ui-icon ui-icon-trash'></span></a>"
                         //edittc = "<span><a href='#' class='ui-icon ui-icon-pencil' title='Edit "+testcaseName+"' onclick='editTestcase(&quot;"+groupName+"&quot;,&quot;"+testcaseName+"&quot;);' style='display: inline-table;'>Edit</a></span>";
                         var editProject="<a class='ui-pg-div ui-inline-edit' onmouseout='jQuery(this).removeClass(&quot;ui-state-hover&quot;);' onmouseover='jQuery(this).addClass(&quot;ui-state-hover&quot;);' onclick='editSubProject(&quot;"+projectName+"&quot;,&quot;"+subProjectName+"&quot;);' style='cursor:pointer;float:left;margin-left:5px;' title='Edit "+subProjectName+"'><span align='center' class='ui-icon ui-icon-pencil'></span></a>"
                         jQuery("#projectListTable").setRowData(ids[i],{options:editProject+""+deleteProject});	
                     }
             }
           }
        }
     });
	}

	function newProject()
	{
		$('#newProject').trigger("click");		
	}
	
function actionsLinkFormatter(cellvalue, options, rowObject)
{
	var projectId = rowObject['projectId'];
	var projectName = rowObject['projectName'];
	var userActions = 
	/* "<a class='ui-pg-div ui-inline-edit' onmouseout='jQuery(this).removeClass(&quot;ui-state-hover&quot;);' onmouseover='jQuery(this).addClass(&quot;ui-state-hover&quot;);' onclick='editUser(&quot;"+userID+"&quot;);'style='cursor:pointer; display: inline-table; float: none; ' title='Edit "+email+"'><span align='center' class='ui-icon ui-icon-pencil'></span></a>"+ */
	"<a class='ui-pg-div ui-inline-del' onmouseout='jQuery(this).removeClass(&quot;ui-state-hover&quot;);' onmouseover='jQuery(this).addClass(&quot;ui-state-hover&quot;);' onclick='deleteProject(&quot;"+projectId+"&quot;);'style='display: inline-table; float: none; margin-left: 10px;' title='Delete "+projectName+"'><span align='center' class='ui-icon ui-icon-trash'></span></a>";
	return userActions ;
}

function deleteProject(projectId)	
{
		var $dialog = $('<div></div>')
		.html("Are you sure you want to delete the project?")
		.dialog({
			autoOpen: false,
			title: 'Team Planner',
			resizable: false,
			height:140,
			modal: true,
			buttons: {
				"Delete": function() {
					var urlvalue = $("#deleteProjectURLHidden").val()+"?userID="+userID;
					var val = $.ajax( {
						type : "POST",
						url : urlvalue,		
						dataType : "json",
						async : false,
						success : function(result) 
						{
							$("#projectListTable").trigger("reloadGrid");						
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
