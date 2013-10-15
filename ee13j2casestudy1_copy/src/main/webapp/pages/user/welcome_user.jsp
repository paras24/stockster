<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="springsec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<link href="<s:url value="/resources/assets/css/ui.jqgrid.css"/>" rel="stylesheet"/>

<link rel="stylesheet" href="<s:url value="/resources/assets/js/fancybox/jquery.fancybox-1.3.4.css"/>" media="screen" type="text/css" />
<script type="text/javascript" language="javascript" src="<s:url value="/resources/assets/js/fancybox/jquery.mousewheel-3.0.4.pack.js"/>"></script>
<script type="text/javascript" language="javascript" src="<s:url value="/resources/assets/js/fancybox/jquery.fancybox-1.3.4.pack.js"/>"></script>	
<script type="text/javascript" language="javascript" src="<s:url value="/resources/assets/js/grid.locale-en.js"/>"></script>
<script type="text/javascript" language="javascript" src="<s:url value="/resources/assets/js/jquery.jqGrid.min.js"/>"></script>


<s:url var = "userListJSONURL" value="/user/userListJson.action"/>
<s:url var = "deleteUserURL" value="/user/delete.action"/>
<input type="hidden" id="userListJSONURLHidden" value="${userListJSONURL}"/>

<input type="hidden" id="deleteUserURLHidden" value="${deleteUserURL}"/>
<s:url var="form" value="/user/form"/>
<a href="${form}" id="newUser"></a>
<table id="userListTable">
</table>
<div id="userListPager"></div>
<script type="text/javascript">
$(document).ready(function() 
{	
	drawTable();
	$('#newUser').fancybox({				
		 autoDimensions: false,
		 onComplete: function() {
		 	$.fancybox.resize();
		 }
	});
	
});
function drawTable()
{
	
	var grid=$("#userListTable").jqGrid( 
				{
					datatype: function(postdata) {
						gridInitialize();
					},      
					pager:'#userListPager',
					autowidth: true,				
					rownumbers: true,				
					height:"100%",
					sortname : 'modified',
					sortorder : 'desc',
					colNames:['ID','Name', 'Date Created', 'Last Modified',''],
					colModel:[
							  {name:'userID', hidden:true},
							  {name:'email' , align:'left', width : 140, searchoptions:{sopt:['cn']}},
					          {name:'created', align:'center', width : 100, formatter: convertTimeStampToDate,search:false},
					          {name:'modified', align:'center', width : 100, formatter: convertTimeStampToDate,search:false},
					      	  {name:'options',index:'options',align:'center',width:70,editable: false,formatter:actionsLinkFormatter,search:false, sortable:false},				          
					          ],
					sortname: 'modified',
					emptyrecords: "No users found.",
					beforeSelectRow:function(){return false},
					viewrecords: true,				
		            rowNum:10,		            
		            rowList:[10,20,30],		            
		            jsonReader : {
		                root: "users",
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
		 
		jQuery("#userListTable").jqGrid('navGrid',"#userListPager",{addfunc:newUser,addtitle:'Add User', searchtitle : "Find Users", refreshtitle : "Reload View",edit:false,add:true,del:false,search: true, refresh:true},{},{},{},{beforeShowSearch: function($form)
			{
			$('#searchmodfbox_'+grid[0].id).width(700);
			var dlgDiv = $('#searchmodfbox_'+grid[0].id);
			var parentDiv = dlgDiv.parent(); // div#gbox_list
            var dlgWidth = dlgDiv.width();
            var parentWidth = parentDiv.width();
            var dlgHeight = dlgDiv.height();
            var parentHeight = parentDiv.height();
            //dlgDiv[0].style.top = Math.round((parentHeight-dlgHeight)/2) + "px";
            dlgDiv[0].style.top = "450px";
            dlgDiv[0].style.left = Math.round((parentWidth-dlgWidth)/2 +120) + "px";
			return true;
		} });		
		$("#userListTable").css('overflow-x','hidden');
		$("#userListTable").css('overflow-y','auto');
		$(".ui-pg-selbox").css('width','50');
		$(".ui-pg-selbox").css('height','23');
		$(".ui-pg-input").css('width','15');
		$(".ui-pg-input").css('height','12');
		
		
}

	function gridInitialize() {
		
		var urlValue = $('#userListJSONURLHidden').val();
		var displayLength=jQuery("#userListTable").jqGrid("getGridParam","postData").rows;
		var searchString=jQuery("#userListTable").jqGrid("getGridParam","postData").searchString;
		if(typeof searchString=='undefined') {
			searchString="";						
			}
		var sortColName=jQuery("#userListTable").jqGrid("getGridParam","postData").sidx;
		var sortOrder=jQuery("#userListTable").jqGrid("getGridParam","postData").sord;
		var displayStart=(jQuery("#userListTable").jqGrid("getGridParam","postData").page-1)*displayLength;
		urlValue = urlValue+"?displayLength="+displayLength+"&searchString="+searchString+"&sortColName="+sortColName+"&sortOrder="+sortOrder+"&displayStart="+displayStart;
	jQuery.ajax({
        url: urlValue,			            
        dataType:"json",
        complete: function(json,stat){			            	 
           if(stat=="success")  {
         	  var grid = jQuery("#userListTable")[0];
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
	var userID = rowObject['userID'];
	var email = rowObject['email'];
	var userActions = 
	/* "<a class='ui-pg-div ui-inline-edit' onmouseout='jQuery(this).removeClass(&quot;ui-state-hover&quot;);' onmouseover='jQuery(this).addClass(&quot;ui-state-hover&quot;);' onclick='editUser(&quot;"+userID+"&quot;);'style='cursor:pointer; display: inline-table; float: none; ' title='Edit "+email+"'><span align='center' class='ui-icon ui-icon-pencil'></span></a>"+ */
	"<a class='ui-pg-div ui-inline-del' onmouseout='jQuery(this).removeClass(&quot;ui-state-hover&quot;);' onmouseover='jQuery(this).addClass(&quot;ui-state-hover&quot;);' onclick='deleteUser(&quot;"+userID+"&quot;);'style='display: inline-table; float: none; margin-left: 10px;' title='Delete "+email+"'><span align='center' class='ui-icon ui-icon-trash'></span></a>";
	return userActions ;
}

function deleteUser(userID)	
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
					var urlvalue = $("#deleteUserURLHidden").val()+"?userID="+userID;
					var val = $.ajax( {
						type : "POST",
						url : urlvalue,		
						dataType : "json",
						async : false,
						success : function(result) 
						{
							$("#userListTable").trigger("reloadGrid");						
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
