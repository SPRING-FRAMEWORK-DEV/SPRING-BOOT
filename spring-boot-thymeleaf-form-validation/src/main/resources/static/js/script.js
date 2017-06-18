$().ready(function() {

	// form submit

	function toTitleCase(str) {
	    return str.replace(/(?:^|\s)\w/g, function(match) {
	        return match.toUpperCase();
	    });
	}

	function showModal(str)
	{
		$("#modal #message").text(str);
		$("#modal").attr("class","modal fade in").show();
	}
	function showFormModal(formId,str)
	{
		
		$("#"+formId+" #modal #message").text(str);
		$("#"+formId+" #modal").attr("class","modal fade in").show();
	}
	
	$(".close-modal").click(function(){
		$(".modal").attr("class","modal fade").hide();
		$("button[type=submit]").removeAttr("disabled");
	});

	$('#info').hide();
	$('#error').hide();
	
	$("#email").click(function(e)
			{
		console.log("clicked");
		var url = "http://localhost:9999/thymeleaf/html-email"; 
		$.ajax({
			type:"GET",
			url:url,
			success:function(response)
			{
				 showModal(response);
			},
			error:function(response)
			{
				showModal(response);
			}
		});
			});
	
	$("#userRegistrationForm").submit(function(e) {

		var url = "http://localhost:9999/thymeleaf/ajaxFormValidation1"; // the script where you handle the form
		// input.
		var formId=$(this).closest("form").attr('id');
		$("#"+formId+" button[type=submit]").attr("disabled",true);
		
		$.ajax({
			type : "POST",
			url : url,
			data : $("#"+formId).serialize(), // serializes the
			// form's elements.
			success : function(response) {
				 $("#"+formId+" .inline-field-error").text("");  
    				if (response.match("^ERROR")) {
					
					response=response.replace("ERROR:","").trim().replace(/=/g,":");
					response=JSON.parse(response);
					errorInfo = "";
					$("#"+formId).find("*").removeClass("error-fieldBorder");
					errorInfo +="<ul>";
					$.each(response, function(key, value) {
					    errorInfo +="<li>" + toTitleCase(value.fieldName) + " "+ toTitleCase(value.message)+"</l1>";
					    $("#"+formId).find("#"+value.fieldName).addClass("error-fieldBorder");
					$("#"+formId+" #"+value.fieldName+"Error").append("<br/>"+toTitleCase(value.fieldName)+" "+toTitleCase(value.message))
					});
					errorInfo +="</ul>";
					showFormModal(formId,'Please Provide Valid Inputs')
	                 $('#error').html("Please correct following errors: " + errorInfo).show();
				} else {
					$("#"+formId).find("*").removeClass("error-fieldBorder");
					$('#error').hide();
	               // $("#"+formId)[0].reset();
	                showFormModal(formId,'User Added Successfully')
				}
			},
			error:function(e)
			{
				showFormModal(formId,'Error Occured. Please Contact Support')
			}
		});
		e.preventDefault(); // avoid to execute the actual submit of the form.
	});
});
