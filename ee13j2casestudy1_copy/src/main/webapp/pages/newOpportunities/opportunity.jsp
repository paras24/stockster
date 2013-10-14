<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="springsec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<link href="<s:url value="/resources/assets/css/ui.jqgrid.css"/>" rel="stylesheet"/>

<link rel="stylesheet" href="<s:url value="/resources/assets/js/fancybox/jquery.fancybox-1.3.4.css"/>" media="screen" type="text/css" />
<script type="text/javascript" language="javascript" src="<s:url value="/resources/assets/js/fancybox/jquery.mousewheel-3.0.4.pack.js"/>"></script>
<script type="text/javascript" language="javascript" src="<s:url value="/resources/assets/js/fancybox/jquery.fancybox-1.3.4.pack.js"/>"></script>	
<script type="text/javascript" language="javascript" src="<s:url value="/resources/assets/js/grid.locale-en.js"/>"></script>
<script type="text/javascript" language="javascript" src="<s:url value="/resources/assets/js/jquery.jqGrid.min.js"/>"></script>


<s:url var = "opportunityListJSONURL" value="/opportunity/opportunityListJson.action"/>
<input type="hidden" id="opportunityListJSONURLHidden" value="${opportunityListJSONURL}"/>

<table id="opportunityListTable">
</table>
<div id="opportunityListPager"></div>
<script type="text/javascript">
$(document).ready(function() 
{	
	drawTable();
	/* $('#newUser').fancybox({
		 autoDimensions: false,
		 onComplete: function() {
		 	$.fancybox.resize();
		 }
	}); */
	
});
function drawTable()
{
	
		$("#opportunityListTable").jqGrid( 
				{
					datatype: function(postdata) {
						gridInitialize();
					},      
					pager:'#opportunityListPager',
					autowidth: true,				
					rownumbers: true,				
					height:"100%",
					sortname : 'modified',
					sortorder : 'desc',
					colNames:['Project','Sub Project', 'Location', 'Point of Contact','Request Date','Start Date','Duration','People Required','Type','Status'],
					colModel:[
							  {name:'project.projectName'},
							  {name:'subprojectName' , align:'left', width : 140},
					          {name:'location.locName', align:'center', width : 100},
					          {name:'contactPoint.memberName', align:'center', width : 100},
					          {name:'requestDate', align:'center', width : 100},
					          {name:'startDateOfResources', align:'center', width : 100},
					          {name:'durationUpto', align:'center', width : 100},
					          {name:'peopleRequiredCount', align:'center', width : 100},
					          {name:'requirementType', align:'center', width : 100},
					          {name:'requirementStatus', align:'center', width : 100},
					      	 ],
					sortname: 'modified',
					emptyrecords: "No users found.",
					beforeSelectRow:function(){return false},
					viewrecords: true,				
		            rowNum:10,		            
		            rowList:[10,20,30],
		            jsonReader : {
		                root: "opportunities",
		                total: "totalPages",
		                page:"currentPage",
		                records: "totalDisplayRecords",
		                repeatitems: false,	                
		              },	   
		            search : {
		            	     caption: "Find User",
		            	     Find: "Find",
		            	     Reset: "Reset",
		            	   }
				});
		
		jQuery("#opportunityListTable").jqGrid('navGrid',"#userListPager",{addfunc:newUser,addtitle:'Add User', searchtitle : "Find Users", refreshtitle : "Reload View",edit:false,add:true,del:false,search: true, refresh:true});
		$("#opportunityListTable").css('overflow-x','hidden');
		$("#opportunityListTable").css('overflow-y','auto');
		$(".ui-pg-selbox").css('width','50');
		$(".ui-pg-selbox").css('height','23');
		$(".ui-pg-input").css('width','15');
		$(".ui-pg-input").css('height','12');
		
		
}

	function gridInitialize() {
		
		var urlValue = $('#opportunityListJSONURLHidden').val();
		var displayLength=jQuery("#opportunityListTable").jqGrid("getGridParam","postData").rows;
		/* var searchString=jQuery("#opportunityListTable").jqGrid("getGridParam","postData").searchString; */
		/* if(typeof searchString=='undefined') {
			searchString="";						
			} */
		var sortColName=jQuery("#opportunityListTable").jqGrid("getGridParam","postData").sidx;
		var sortOrder=jQuery("#opportunityListTable").jqGrid("getGridParam","postData").sord;
		var displayStart=(jQuery("#opportunityListTable").jqGrid("getGridParam","postData").page-1)*displayLength;
		urlValue = urlValue+"?displayLength="+displayLength+"&sortColName="+sortColName+"&sortOrder="+sortOrder+"&displayStart="+displayStart;
	jQuery.ajax({
        url: urlValue,			            
        dataType:"json",
        complete: function(json,stat){			            	 
           if(stat=="success")  {
         	  var grid = jQuery("#opportunityListTable")[0];
              grid.addJSONData(JSON.parse(json.responseText));
           }
        }
     });
	}

	
function actionsLinkFormatter(cellvalue, options, rowObject)
{
	var userID = rowObject['userID'];
	var email = rowObject['email'];
	var userActions = 
	/* "<a class='ui-pg-div ui-inline-edit' onmouseout='jQuery(this).removeClass(&quot;ui-state-hover&quot;);' onmouseover='jQuery(this).addClass(&quot;ui-state-hover&quot;);' onclick='editUser(&quot;"+userID+"&quot;);'style='cursor:pointer; display: inline-table; float: none; ' title='Edit "+email+"'><span align='center' class='ui-icon ui-icon-pencil'></span></a>"+ */
	"<a class='ui-pg-div ui-inline-del' onmouseout='jQuery(this).removeClass(&quot;ui-state-hover&quot;);' onmouseover='jQuery(this).addClass(&quot;ui-state-hover&quot;);' onclick='deleteUser(&quot;"+userID+"&quot;);'style='display: inline-table; float: none; margin-left: 10px;' title='Delete "+email+"'><span align='center' class='ui-icon ui-icon-trash'></span></a>";
	return userActions ;
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