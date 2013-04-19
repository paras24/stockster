<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="./javascript/jquery.min.js" type="text/javascript"></script>
<script src="./javascript/jquery-ui.js" type="text/javascript"></script>
<script src="./javascript/popup-div.js" type="text/javascript"></script>
<script src="./javascript/index.js" type="text/javascript"></script>
<link rel="stylesheet" href="./stylesheet/jquery-ui.css" />
<link rel="stylesheet" href="./stylesheet/popup-div.css" />
<link rel="stylesheet" href="./stylesheet/index.css" />
<script type="text/javascript">
	
</script>
<title>tag maker</title>
</head>
<body>
<a href="#" class="topopup">Submit new word</a>
<a href="dictionary.jsp">Dictionary</a>

	<div
		style="border: ridge; clear: both; overflow: auto; min-width: 100%; max-width: 100%"
		id="container">
		<h1>Tag processor</h1>
		<div style="float: left">
			tag target : <br> Project : <input type="text" id="project2" /><br>
			<textarea rows="2" cols="20" id="Main_TextBox1"
				style="height: 141px; width: 828px; overflow: auto"></textarea>
			<input type="button" value="process me " id="processme"  /><br>
		</div>
		<div style="float: left;">
			result:
			<div id="Main_TextBox2"
				style="height: 141px; width: 828px; margin-top: 10px; border: ridge; float: right; margin-top: 40px; overflow: auto"></div>
		</div>
	</div>

	content before pop


	<a href="#" class="topopup">Click Here Trigger</a>

	<div id="toPopup">

		<div class="close"></div>
		<span class="ecs_tooltip">Press Esc to close <span
			class="arrow"></span>
		</span>
		<div id="popup_content">
			<!--your content start-->
			<div  id="entryform">
			<table  >
			<tr><td align="center" colspan="2"><h1>Submit entries</h1></td></tr>
			<tbody>
			<tr><td>Project :</td><td><input type="text" id="project" /></td></tr>
			<tr><td> Word :</td><td><input type="text" id="word" /></td></tr>
			<tr><td>URL :</td><td><input type="text" id="url" /></td></tr>
			<tr><td colspan="2" align="center"><input type="button" id="submitEntry" value="submit" style="padding-right: 20px;" src"." /></td></tr>
			</tbody>
			</table>
			</div>
			<div id="submitResult" ></div>
			<!--your content end-->
		</div>
		

	</div>
	<!--toPopup end-->

	<div class="loader"></div>
	<div id="backgroundPopup"></div>
	<!-- testing -->
</body>
</html>