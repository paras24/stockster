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
<s:url var = "deleteJPMemberURL" value="/joiningPipeline/delete.action"/>
<input type="hidden" id="jPMemberInfoListJSONURLHidden" value="${jPMemberInfoListJSONURL}"/>

<input type="hidden" id="deleteJPMemberURLHidden" value="${deleteJPMemberURL}"/>
<s:url var="form" value="/user/form"/>
<a href="${form}" id="newUser"></a>
<table id="jPMemberListTable">
</table>
<div id="jPMemberListPager"></div>
<script type="text/javascript">
$(document).ready(function() 
{	
	drawTable();
	
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
							  {name:'jPmemberID', hidden:true},
							  {name:'jPmemberName' , align:'left', width : 140, searchoptions:{sopt:['cn']}},
					          {name:'Grade', align:'center', width : 100},
					          {name:'experience', align:'center', width : 100},
					      	  {name:'keySkills',index:'options',align:'center',width:70},	
					      	  {name:'created', align:'center', formatter: convertTimeStampToDate,search:false},
					          {name:'modified', align:'center', formatter: convertTimeStampToDate,search:false},
					      	  {name:'options',index:'options',align:'center',width:70,editable: false,formatter:actionsLinkFormatter,search:false, sortable:false},				          
					          ],
					sortname: 'modified',
					emptyrecords: "No members found.",
					beforeSelectRow:function(){return false},
					viewrecords: true,				
		            rowNum:10,		            
		            rowList:[10,20,30],
		            jsonReader : {
		                root: "jPMemberInfoList",
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
		
		jQuery("#jPMemberListTable").jqGrid('navGrid',"#jPMemberListPager",{addfunc:newUser,addtitle:'Add JP Member', searchtitle : "Find JP Members", refreshtitle : "Reload View",edit:false,add:true,del:false,search: true, refresh:true});
		$("#jPMemberListTable").css('overflow-x','hidden');
		$("#jPMemberListTable").css('overflow-y','auto');
		$(".ui-pg-selbox").css('width','50');
		$(".ui-pg-selbox").css('height','23');
		$(".ui-pg-input").css('width','15');
		$(".ui-pg-input").css('height','12');
		
		
}

	function gridInitialize() {
		
		var urlValue = $('#jPMemberListJSONURLHidden').val();
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

	function newUser()
	{
		$('#newUser').trigger("click");		
	}
	
function actionsLinkFormatter(cellvalue, options, rowObject)
{
	var userID = rowObject['jPmemberID'];
	var email = rowObject['jPmemberName'];
	var jPMemberActions = 
	/* "<a class='ui-pg-div ui-inline-edit' onmouseout='jQuery(this).removeClass(&quot;ui-state-hover&quot;);' onmouseover='jQuery(this).addClass(&quot;ui-state-hover&quot;);' onclick='editUser(&quot;"+userID+"&quot;);'style='cursor:pointer; display: inline-table; float: none; ' title='Edit "+email+"'><span align='center' class='ui-icon ui-icon-pencil'></span></a>"+ */
	"<a class='ui-pg-div ui-inline-del' onmouseout='jQuery(this).removeClass(&quot;ui-state-hover&quot;);' onmouseover='jQuery(this).addClass(&quot;ui-state-hover&quot;);' onclick='deleteUser(&quot;"+jPmemberID+"&quot;);'style='display: inline-table; float: none; margin-left: 10px;' title='Delete "+jPmemberName+"'><span align='center' class='ui-icon ui-icon-trash'></span></a>";
	return jPMemberActions ;
}

function deleteJPMember(jPmemberID)	
{
		var $dialog = $('<div></div>')
		.html("Are you sure you want to delete the member?")
		.dialog({
			autoOpen: false,
			title: 'Team Planner',
			resizable: false,
			height:140,
			modal: true,
			buttons: {
				"Delete": function() {
					var urlvalue = $("#deleteJPMemberURLHidden").val()+"?jPmemberID="+jPmemberID;
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