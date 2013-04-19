<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="./javascript/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		getDictionary();
		$('#filter').live(
				'click',
				function(){
					getDictionary();
				});

	});
	
	function getDictionary(){
		var word = $('#word_input').val();
		var project = $('#project_input').val();
		$.ajax({
			type : "GET",
			url : "Dictionary",
			dataType : "json",
			data : {
				'word' : word,
				'project':project
			},
			beforeSend : function() {

				/* gif process */
				console.info('before:');
			},
			success : function(data) {
				$('#result_table').html("");
				if(data.Messages.length != 0){
					$('#result_table').append('<tr  style="text-align:center;font-size:30px"> <td colspan="3">Results</td></tr>');
					$('#result_table').append('<tr style="font-size:30px; text-align:center"><td>Project</td><td>Word</td><td>Url</td></tr>');
				}else{
					$('#result_table').append('<tr  style="text-align:center;font-size:30px"> <td colspan="3">No result found</td></tr>');
				}
				$.each(data.Messages, function(i, data) {
					console.info( data.project+" "+data.word+" "+data.url);
					$('#result_table').append('<tr ><td style="width:200px; text-align:center">'+data.project+'</td><td style="width:200px; text-align:center">'+data.word+'</td><td style="width:200px; text-align:center">'+data.url+'</td></tr>');
					
					
				});
				
				
			}

		});

	}
</script>
<style type="text/css">
body {
	padding-bottom: 200px;
}

#container {
	margin: 20px 0 0 100px;
	box-shadow: gray .1em .1em .1em .1em;
	width: 70%;
	min-height: auto;
	overflow: auto;
	clear: both;
}

#filter_div {
	margin-left: 40%;
}

#word_input, #project_input {
	height: 25px;
	width: 300px;
	
}

#filter {
	height: 25px;
	font-weight: bolder;
}
</style>
<title>Tag maker's 'Dictionary</title>
</head>
<body>
	<div id="container">
		<div id="filter_div">
		<table>
		<tr><td align="right">Project :</td><td><input id="project_input" type="text" /></td></tr>
		<tr><td align="right"> word :</td><td><input id="word_input" type="text" /></td></tr>
		<tr ><td colspan="2" align="center"><input
				type="button" id="filter" value="filter" /></td></tr>
		</table>
		</div>
		<div style="box-shadow:gray .4em .4em .4em .4em;margin:100px 0 100px 400px; width: 600px">
		<table id="result_table"   border="1">
		</table>
		</div>
		
	<table>
	
	</table>
	</div>

</body>
</html>