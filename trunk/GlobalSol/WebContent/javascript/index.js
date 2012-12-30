
function resetTabs(){
    $("#content > div").hide(); //Hide all content
    $("#tabs a").attr("id",""); //Reset id's      
}

var myUrl = window.location.href; //get URL
var myUrlTab = myUrl.substring(myUrl.indexOf("#")); // For mywebsite.com/tabs.html#tab2, myUrlTab = #tab2     
var myUrlTabName = myUrlTab.substring(0,4); // For the above example, myUrlTabName = #tab


$(function(){
	
	//initial loading of contents
	$('#content').load('pages/home.jsp',function(responseText, textStatus, XMLHttpRequest){
    	if(textStatus == 'error'){
    		$('#maindiv #content').append(responseText);
    	}
    });
	
	
	 $("#content > div").hide(); // Initially hide all content
	    $("#tabs li:first a").attr("id","current"); // Activate first tab
	    $("#content > div:first").fadeIn(); // Show first tab content
	    
	    $("#tabs a").on("click",function(e) {
	    	 
	        e.preventDefault();
	        if ($(this).attr("id") == "current"){ //detection for current tab
	         return       
	        }
	        else{             
	        resetTabs();
	        $(this).attr("id","current"); // Activate this
	        /* $($(this).attr('name')).fadeIn(); */ // Show content for current tab
	       
	        $('#content').load('pages/'+($(this).attr('name'))+'.jsp',function(responseText, textStatus, XMLHttpRequest){
	        	
	        	if(textStatus == 'error'){
	        		$('#maindiv #content').empty().append(responseText);
	        	}
	        });
	        }
	    });

	    for (i = 1; i <= $("#tabs li").length; i++) {
	      if (myUrlTab == myUrlTabName + i) {
	          resetTabs();
	          $("a[name='"+myUrlTab+"']").attr("id","current"); // Activate url tab
	                
	      }
	    }
	    
	    
	    $(window).scroll(function () {
	    		//after window scroll fire it will add define pixel added to that element.
				set = $(document).scrollTop()+"px";
				//this is the jQuery animate function to fixed the div position after scrolling.
				$('#floatingleft').animate({top:set},{duration:890,queue:false});
			});
	//footer dynamics
	    $('#footer').load('pages/footer.jsp');
	   
});