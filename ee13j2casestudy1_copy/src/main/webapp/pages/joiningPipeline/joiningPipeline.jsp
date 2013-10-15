<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="springsec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<link href="<s:url value="/resources/assets/css/ui.jqgrid.css"/>" rel="stylesheet"/>

<link rel="stylesheet" href="<s:url value="/resources/assets/js/fancybox/jquery.fancybox-1.3.4.css"/>" media="screen" type="text/css" />
<script type="text/javascript" language="javascript" src="<s:url value="/resources/assets/js/fancybox/jquery.mousewheel-3.0.4.pack.js"/>"></script>
<script type="text/javascript" language="javascript" src="<s:url value="/resources/assets/js/fancybox/jquery.fancybox-1.3.4.pack.js"/>"></script>	
<script type="text/javascript" language="javascript" src="<s:url value="/resources/assets/js/grid.locale-en.js"/>"></script>
<script type="text/javascript" language="javascript" src="<s:url value="/resources/assets/js/jquery.jqGrid.min.js"/>"></script>


<s:url var = "jPMemberInfoListJSONURL" value="/joiningPipeline/jPMemberListJson.action"/>
<s:url var = "deleteJPMemberURL" value="/joiningPipeline/deleteJPMember.action"/>
<s:url var = "editJPMemberURL" value="/joiningPipeline/editJPMemberForm.action"/>
<input type="hidden" id="jPMemberInfoListJSONURLHidden" value="${jPMemberInfoListJSONURL}"/>
<input type="hidden" id="deleteJPMemberURLHidden" value="${deleteJPMemberURL}"/>
<input type="hidden" id="editJPMemberURLHidden" value="${editJPMemberURL}"/>
<s:url value="/joiningPipeline/showJoiningPipelineMemberForm.action" var="addJoiningPipelineMemberFormURL" />
<s:a href="%{addJoiningPipelineMemberFormURL}">Add JP Member</s:a>

<s:form action="" name="mainform" ></s:form>

<table id="jPMemberListTable">
</table>
<div id="jPMemberListPager"></div>
<script type="text/javascript">
$(document).ready(function() 
{	
	drawTable();
	/* $('#newJPMember').fancybox({				
		 autoDimensions: false,
		 onComplete: function() {
		 	$.fancybox.resize();
		 }
	}); */
	
});
function drawTable()
{
	
		$("#jPMemberListTable").jqGrid( 
				{
					datatype: function(postdata) {
						gridInitialize();
					},      
					pager:'#jPMemberListPager',
					autowidth: true,				
					rownumbers: true,				
					height:"100%",
					sortname : 'modified',
					sortorder : 'desc',
					colNames:['ID','Name', 'Grade', 'Experience','KeySkills','Date Created', 'Last Modified',''],
					colModel:[
							  {name:'jpmemberID', hidden:true},
							  {name:'jpmemberName' , align:'left', width : 140, searchoptions:{sopt:['cn']}},
					          {name:'grade', align:'center', width : 100, searchoptions:{sopt:['cn']}},
					          {name:'experience', align:'center', width : 100, searchoptions:{sopt:['cn']}},
					      	  {name:'keySkills',index:'options',align:'center',width:70, searchoptions:{sopt:['cn']}},	
					      	  {name:'created', align:'center', width : 100, formatter: convertTimeStampToDate,search:false},
					          {name:'modified', align:'center', width : 100, formatter: convertTimeStampToDate,search:false},
					      	  {name:'options',index:'options',align:'center',width:70,editable: false,formatter:actionsLinkFormatter,search:false, sortable:false},				          
					          ],
					sortname: 'modified',
					emptyrecords: "No members found.",
					beforeSelectRow:function(){return false},
					viewrecords: true,				
		            rowNum:10,		            
		            rowList:[10,20,30],
		            jsonReader : {
		                root: "joiningPipelineMemberInfoList",
		                total: "totalPages",
		                page:"currentPage",
		                records: "totalDisplayRecords",
		                repeatitems: false,	                
		              },	   
		            search : {
		            	     caption: "Find JP Member",
		            	     Find: "Find",
		            	     Reset: "Reset",
		            	   }
				});
		
		jQuery("#jPMemberListTable").jqGrid('navGrid',"#jPMemberListPager",{addtitle:'Add JP Member', searchtitle : "Find JP Member", refreshtitle : "Reload View",edit:false,add:false,del:false,search:true,refresh:true});
		$("#jPMemberListTable").css('overflow-x','hidden');
		$("#jPMemberListTable").css('overflow-y','auto');
		$(".ui-pg-selbox").css('width','50');
		$(".ui-pg-selbox").css('height','23');
		$(".ui-pg-input").css('width','15');
		$(".ui-pg-input").css('height','12');
		
		
}

	function gridInitialize() {
		
		var urlValue = $('#jPMemberInfoListJSONURLHidden').val();
		var displayLength=jQuery("#jPMemberListTable").jqGrid("getGridParam","postData").rows;
		var searchString=jQuery("#jPMemberListTable").jqGrid("getGridParam","postData").searchString;
		if(typeof searchString=='undefined') {
			searchString="";						
			}
		var sortColName=jQuery("#jPMemberListTable").jqGrid("getGridParam","postData").sidx;
		var sortOrder=jQuery("#jPMemberListTable").jqGrid("getGridParam","postData").sord;
		var displayStart=(jQuery("#jPMemberListTable").jqGrid("getGridParam","postData").page-1)*displayLength;
		urlValue = urlValue+"?displayLength="+displayLength+"&searchString="+searchString+"&sortColName="+sortColName+"&sortOrder="+sortOrder+"&displayStart="+displayStart;
	jQuery.ajax({
        url: urlValue,			            
        dataType:"json",
        complete: function(json,stat){			            	 
           if(stat=="success")  {
         	  var grid = jQuery("#jPMemberListTable")[0];
              grid.addJSONData(JSON.parse(json.responseText));              
           }
        }
     });
	}

	function newJPMember()
	{
			
	}
	
function actionsLinkFormatter(cellvalue, options, rowObject)
{
	var jpmemberID = rowObject['jpmemberID'];
	var jpmemberName = rowObject['jpmemberName'];
	var userActions = 
		"<a class='ui-pg-div ui-inline-edit' onmouseout='jQuery(this).removeClass(&quot;ui-state-hover&quot;);' onmouseover='jQuery(this).addClass(&quot;ui-state-hover&quot;);' onclick='editJPMember(&quot;"+jpmemberID+"&quot;);'style='cursor:pointer; display: inline-table; float: none; ' title='Edit "+jpmemberName+"'><span align='center' class='ui-icon ui-icon-pencil'></span></a>"+
		//"<a class='ui-pg-div ui-inline-edit' onmouseout='jQuery(this).removeClass(&quot;ui-state-hover&quot;);' onmouseover='jQuery(this).addClass(&quot;ui-state-hover&quot;);' 'href="%{editJPMemberURL}"' style='cursor:pointer; display: inline-table; float: none; ' title='Edit "+jpmemberName+"'><span align='center' class='ui-icon ui-icon-pencil'></span></a>"+
		"<a class='ui-pg-div ui-inline-del' onmouseout='jQuery(this).removeClass(&quot;ui-state-hover&quot;);' onmouseover='jQuery(this).addClass(&quot;ui-state-hover&quot;);' onclick='deleteJPMember(&quot;"+jpmemberID+"&quot;);'style='display: inline-table; float: none; margin-left: 10px;' title='Delete "+jpmemberName+"'><span align='center' class='ui-icon ui-icon-trash'></span></a>";
	return userActions;		
}

/* function editJPMember(jpmemberID)
{
	var urlvalue=$("#editJPMemberURLHidden").val()+"?jpmemberID="+jpmemberID;
	alert(urlvalue);
	//window.location.href = urlvalue;
	 var val = $.ajax( {
		type : "POST",
		url : urlvalue,		
		dataType : "json",
		async : false,
		success : function(result)
		{			
			window.location.href = url;
		}	 	
		// success : function(result) 
		//{
		//	$("#jPMemberListTable").trigger("reloadGrid");						
		//} 
	});	 
	} */
	

function editJPMember(jpmemberID)
{
		var urlvalue=$("#editJPMemberURLHidden").val()+"?jpmemberID="+jpmemberID;
		document.forms['mainform'].action = urlvalue;
		document.forms['mainform'].submit();

}
	
function deleteJPMember(jpmemberID)	
{
		var $dialog = $('<div></div>')
		.html("Are you sure?")
		.dialog({
			autoOpen: false,
			title: 'Team Planner',
			resizable: false,
			height:140,
			modal: true,
			buttons: {
				"Delete": function() {
					var urlvalue = $("#deleteJPMemberURLHidden").val()+"?jpmemberID="+jpmemberID;
					var val = $.ajax( {
						type : "POST",
						url : urlvalue,		
						dataType : "json",
						async : false,
						success : function(result) 
						{
							$("#jPMemberListTable").trigger("reloadGrid");						
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
