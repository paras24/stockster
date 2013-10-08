function validateForm()
{
	var quesSearch = $('#username').val();
	if(quesSearch == ""){ 
		$("#div1").fadeIn();
		return false;
	}
}