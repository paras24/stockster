<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="javascript/jquery.min.js" type="text/javascript"></script>
<script type='text/javascript'>

$(function()
	{
		$.ajax
			({
					type : "GET",
					url : "ClientReader",
					dataType : "json",
					success : function(data) {
						if (data.Messages.length) {
							alert(1);
							$.each(data.Messages, function(i, data) {
								
								var msg_data = "<div id='msg"+data.id+"'>"
										+ data.name + "</div>";
								$(msg_data).appendTo("#content");
							});
						} else {
							$("#content").html("No Results");
						}
					}
				});
				$('#UpdateButton').click(function() {
					// Previous Post
				});
				return false;
			});
</script>
<title>Insert title here</title>
</head>
<body>
	<div id='content' >
	</div>
</body>
</html>