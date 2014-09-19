var Preferences = Preferences || {};

(function(P) {
	prefs.page = {
		formErrorProcessors: {
			userCommandErrorProcessor: { 
				process: function() {
					
				}
			}, 
			
			searchSettingsErrorProcessor: {
				process: function() {
					
				}
			}, 
			
			accountFormErrorProcessor:  {
				process: function() {
					
				}
			}
		}, 
		
		init: function() {
			this.initUserCommandForm();
			this.initSearchSettingsForm();
			this.initAccountForm();
			this.initSliders();
			
			//add listener to forms for onChagne to ungray button after save
			$(':submit').each(function() {
				var that = this;
				var form = $(that).parents('form:first');
				$(form).change(function(){
					if($(that).hasClass('disabled')) {
						$(that).removeClass('disabled');
						$(that).text('Save Changes');
					}
				})
			});
		},
	
		preSubmit: function() {
			//grey out form
			//start spinner
		},
		
		postSubmit: function(form) {
			//stop spinner
			
		},
		
		processSuccessResponse: function(response, statusText, xhr, form) {
			var that = this;
			debugger;
			
			if(response.hasOwnProperty("asyncStatus") && response.asyncStatus == SUCCESS)
			{
				that.successResponse();
			} else {
				var formName = form.attr('name');
				var formErrorProcessor = that.formErrorProcessors[formName];
				that.softErrorResponse(response, formErrorProcessor);
			}
			
		},
		
		successResponse: function() {
			var that = this; 
			that.postSubmit();
		},
		
		hardErrorResponse: function() {
			var that = this;

			//stop spinner
			//display error message "problem communicating w/ the server, please try again later"
			
		},
		
		softErrorResponse: function(response, formErrorProcessor) {
			var that = this;
			formErrorProcessor();
			that.postSubmit();
		},
		
		initUserCommandForm: function () {
			var that = this;
			
			var actionURL = $('#userCommand').attr('action');
			$("#userCommand").ajaxForm({
				url: actionURL, 
				type: 'POST',
				error: that.hardErrorResponse,
				success: that.processSuccessResponse, 
				beforeSubmit: that.preSubmit
			});	
		},
		
		initSearchSettingsForm: function () {
			var that = this;
			
			var actionURL = $('#userCommand').attr('action');
			$("#userCommand").ajaxForm({
				url: actionURL, 
				type: 'POST',
				error: that.hardErrorResponse,
				success: that.processResponse, 
				beforeSubmit: that.preSubmit
			});	
		},
		
		initAccountForm: function () {
			var that = this;
			
			var actionURL = $('#userCommand').attr('action');
			$("#userCommand").ajaxForm({
				url: actionURL, 
				type: 'POST',
				error: that.hardErrorResponse,
				success: that.processResponse, 
				beforeSubmit: that.preSubmit
			});	
		},
		
		initSliders: function() {
			
		}
	};
})(Preferences);
	
$(document).ready(function() {
	  Preferences.page.init();
});