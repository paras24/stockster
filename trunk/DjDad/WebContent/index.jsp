<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="./javascript/jquery.min.js" type="text/javascript"></script>
<script src="./javascript/jquery-ui.js"></script>
<link rel="stylesheet" href="./stylesheet/jquery-ui.css" />
<script type="text/javascript">
	$(function() {
		$('#Main_TextBox1').resizable({
		
			alsoResize:'#Main_TextBox2,#container',
			containment: "parent"
		});
		processTagMaker(false);
		$('#submitEntry').click(function() {
			console.info(1);
			var project = $('#project').val();
			var word = $('#word').val();
			var url = $('#url').val();
			$.ajax({
				type : "GET",
				url : "TagWriter",
				data : {
					'project' : project,
					'word' : word,
					'url' : url
				},
				success : function(data) {
					console.info(data);
					if (data == '1') {
						alert('success');
					} else if (data == '0') {
						alert('fail')
					} else {
						alert(data);
					}
				}
			});
		});

		$('#url').live('blur', function() {
			if (this.value != 'manoj') {
				//$('#submitEntry').attr('display','none'); 
			}
		});

		$('#processme').click(function() {

			processTagMaker(true);

		});

	});

	// process tagging process
	function processTagMaker(flag) {
		var target = $('#Main_TextBox1').val();
		var project = $('#project2').val();
		 
		if(target != "" && project !="" ){
			$.ajax({
				type : "GET",
				url : "TagMaker",
				dataType : "json",
				data : {
					'project' : $('#project2').val(),
					'string' : $('#Main_TextBox1').val()
				},
				beforeSend : function() {
					
					$('#Main_TextBox2').html('<img src="./image/processing.gif"/>');
				},
				success : function(data) {
					
					console.info('after:'+data);
					$.each(data.Messages, function(i, data) {
						console.info(data.word);
						console.info(data.url);
						target = target.replace(data.word,
								'<a href="'+data.url+'" target="_blank">' + data.word + '</a>');
						//replace(data.word,data.word+' xxxx');
						//$('#Main_TextBox2').html(target);

					});
					console.info(target);
					$('#Main_TextBox2').html(target);
				}

			});
		}else if(flag){
			alert('either project or text is empty');
		}
	}
</script>
<title>tag maker</title>
</head>
<body>
	<div style="border: ridge;">
		<h1>Submit entries</h1>
		Project : <input type="text" id="project" /><br> Word : <input
			type="text" id="word" /><br> URL : <input type="text" id="url" />
		<input type="button" id="submitEntry" value="submit"
			style="padding-right: 20px;" />

	</div>


	<div style="border: ridge;  clear: both;overflow: auto; min-width: 100%;max-width: 100%" id="container">
		<h1>Tag processor</h1>
		<div style="float: left">tag target : <br> Project : <input type="text" id="project2" /><br>
		<textarea rows="2" cols="20" id="Main_TextBox1"
			style="height: 141px; width: 828px;overflow: auto"></textarea>
		<input type="button" value="process me " id="processme" /><br></div>
		<div style="float: left;">result:
		<div id="Main_TextBox2"
			style="height: 141px; width: 828px; margin-top: 10px; border: ridge;float: right;margin-top: 40px; overflow: auto" ></div></div>
			

	</div>
	<!-- testing -->
	
</body>
</html>