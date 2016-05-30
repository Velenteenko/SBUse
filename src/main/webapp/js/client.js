	$('#get_point').click(function() {
		$.ajax({
			type:"GET",
			cache: false,
			url:'/getRandomData',
			data:"",
			success: function(response) {
				var html = "";
				$.each(response.data, function(i) {
					html = html + response.data[i] + "<br/>";
				});
				
				$('#container').html(html);
			}
		});
	});


	$('#post_point').click(function() {
		if(!$('#data').val()) {
			alert("Enter your data!");
		}
		else {
			$.ajax({
				type:"POST",
				cache: false,
				url:'/persist',
				data: 
					{
					'data': $('#data').val()
					},
				success: function(response) {
					$('#get_point').click();
				}
			});
		}
	});	

