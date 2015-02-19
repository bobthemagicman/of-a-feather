$(".btn-facebook.register").click(function() {
	$.ajax({
        url: "/ofAFeather/connect/facebook",
        type: "POST",
		success: function(data) {
            debugger;
        },
		error: function(data1, data2, data3) {
			debugger;
		}
 	}); 
});