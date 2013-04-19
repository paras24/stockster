<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="./javascript/jquery.min.js" type="text/javascript"></script>
<style type="text/css">

        
        #test{
            
          
            height: 5px;
            background-color: #ddd;
            border-
        }
        
      
        
        #drag{
            
           
            height: 5px;
            background-color: #444;
            
        }
</style>
<script type="text/javascript">
$(document).ready(function(){
    $('#drag').on('mousedown', function(e){
        var $dragable = $('#test'),
            startHeight = $dragable.height(),
            pY = e.pageY;
        
        $(document).on('mouseup', function(e){
            $(document).off('mouseup').off('mousemove');
        });
        $(document).on('mousemove', function(me){
            var my = (me.pageY - pY);
            //var my = (me.pageY - pY);
            
            $dragable.css({
                 left: my / 2,
                 height: startHeight + my,
                //top: my
            });
        });
                
    });
});

</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

        <div id="test">
    
        </div>
        <div id="drag">
        
        </div>
   
</body>
</html>