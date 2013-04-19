$(function() {
		$('#Main_TextBox1').resizable({
		
			alsoResize:'#Main_TextBox2,#container',
			containment: "parent"
		});
		processTagMaker(false);
		$('#submitEntry').click(function() {
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
					var result;
					if (data == '1') {
						result = 'success';
					} else if (data == '0') {
						result = 'fail';
					} else {
						result = data;
					}
					
					$('#submitResult').html(result).slideDown();
					setTimeout(function() { $('#submitResult').slideUp(1000); }, 2000 );
					
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