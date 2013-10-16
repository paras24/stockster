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
<%-- <s:url var = "deleteopportunityURL" value="/opportunity/delete.action"/> --%>
<input type="hidden" id="opportunityListJSONURLHidden" value="${opportunityListJSONURL}"/>

<%-- <input type="hidden" id="deleteopportunityURLHidden" value="${deleteopportunityURL}"/>
<s:url var="form" value="/opportunity/form"/>
<a href="${form}" id="newopportunity"></a> --%>
<table id="opportunityListTable">
</table>
<div id="opportunityListPager"></div>
<script type="text/javascript">
$(document).ready(function() 
{	
	drawTable();
	/* $('#newopportunity').fancybox({				
		 autoDimensions: false,
		 onComplete: function() {
		 	$.fancybox.resize();
		 }
	}); */
	
});
function drawTable()
{
	/* debugger; */
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
					colNames:['ID','Project','Sub Project', 'Contact', 'Requested on','People required','Location','Start on','Duration','Type','Status','Action'],
					//'Project'
					colModel:[
							  {name:'opportunityID', hidden:true},
							  {name:'projectName' , align:'center', width : 140, searchoptions:{sopt:['cn']}},
					          {name:'subProjectname', align:'center', width : 100,search:false},
					          {name:'pointOfContact', align:'center', width : 100,search:false},
					          {name:'requestDate', align:'center', width : 150, formatter: convertTimeStampToDate,search:false},
					          {name:'requirement', align:'center', width : 100,search:false},
					          {name:'location', align:'center', width : 100,search:false},
					          {name:'startdate', align:'center', width : 150, formatter: convertTimeStampToDate,search:false},
					          {name:'duration', align:'center', width : 100,search:false},
					          {name:'type', align:'center', width : 100,search:false},
					          {name:'status', align:'center', width : 100,search:false},
					      	  {name:'options',index:'options',align:'center',width:70,editable: false,formatter:actionsLinkFormatter,search:false, sortable:false},			          
					          ],
					sortname: 'modified',
					emptyrecords: "No opportunitys found.",
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
		            	     caption: "Find opportunity",
		            	     Find: "Find",
		            	     Reset: "Reset",
		            	   }
				});
		
		jQuery("#opportunityListTable").jqGrid('navGrid',"#opportunityListPager",{addfunc:newopportunity,addtitle:'Add opportunity', searchtitle : "Find opportunitys", refreshtitle : "Reload View",edit:false,add:true,del:false,search: true, refresh:true});
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
		var searchString=jQuery("#opportunityListTable").jqGrid("getGridParam","postData").searchString;
		if(typeof searchString=='undefined') {
			searchString="";						
			}
		var sortColName=jQuery("#opportunityListTable").jqGrid("getGridParam","postData").sidx;
		var sortOrder=jQuery("#opportunityListTable").jqGrid("getGridParam","postData").sord;
		var displayStart=(jQuery("#opportunityListTable").jqGrid("getGridParam","postData").page-1)*displayLength;
		urlValue = urlValue+"?displayLength="+displayLength+"&searchString="+searchString+"&sortColName="+sortColName+"&sortOrder="+sortOrder+"&displayStart="+displayStart;
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

	function newopportunity()
	{
		$('#newopportunity').trigger("click");		
	}
	
function actionsLinkFormatter(cellvalue, options, rowObject)
{
	var opportunityID = rowObject['opportunityID'];
	var email = rowObject['email'];
	var opportunityActions = 
	/* "<a class='ui-pg-div ui-inline-edit' onmouseout='jQuery(this).removeClass(&quot;ui-state-hover&quot;);' onmouseover='jQuery(this).addClass(&quot;ui-state-hover&quot;);' onclick='editopportunity(&quot;"+opportunityID+"&quot;);'style='cursor:pointer; display: inline-table; float: none; ' title='Edit "+email+"'><span align='center' class='ui-icon ui-icon-pencil'></span></a>"+ */
	"<a class='ui-pg-div ui-inline-del' onmouseout='jQuery(this).removeClass(&quot;ui-state-hover&quot;);' onmouseover='jQuery(this).addClass(&quot;ui-state-hover&quot;);' onclick='deleteopportunity(&quot;"+opportunityID+"&quot;);'style='display: inline-table; float: none; margin-left: 10px;' title='Delete "+email+"'><span align='center' class='ui-icon ui-icon-trash'></span></a>";
	return opportunityActions ;
}

function deleteopportunity(opportunityID)	
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
					var urlvalue = $("#deleteopportunityURLHidden").val()+"?opportunityID="+opportunityID;
					var val = $.ajax( {
						type : "POST",
						url : urlvalue,		
						dataType : "json",
						async : false,
						success : function(result) 
						{
							$("#opportunityListTable").trigger("reloadGrid");						
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
