var loadingDV = '<div id="LoadingDiv"> \
    <div id="fountainG"> \
        <div id="fountainG_1" class="fountainG"> </div> \
        <div id="fountainG_2" class="fountainG"> </div> \
        <div id="fountainG_3" class="fountainG"> </div> \
        <div id="fountainG_4" class="fountainG"> </div> \
        <div id="fountainG_5" class="fountainG"> </div> \
        <div id="fountainG_6" class="fountainG"> </div> \
        <div id="fountainG_7" class="fountainG"> </div> \
        <div id="fountainG_8" class="fountainG"> </div> \
    </div> \
</div>';

(function($) {
	$.fn.serializeForm = function() {
		var o = {};
		var a = this.serializeArray();
		$.each(a, function() {
			if (o[this.name] !== undefined) {
				if (!o[this.name].push) {
					o[this.name] = [ o[this.name] ];
				}
				o[this.name].push(this.value || '');
			} else {
				o[this.name] = this.value || '';
			}
		});
		return o;
	};
})(jQuery);

function jsonForm() {
	$('form').submit(function(event) {
		var formObj = $('#' + this.id);
		processFrom(formObj);
		event.preventDefault();
	});
}

function processFrom(formObj) {
	if (formObj.length == 0) {
		return;
	}
	var serObj = formObj.serializeForm();
	var formGroup = formObj.find('.form-group');
	formGroup.each(function() {
		var elem = $(this);
		elem.removeClass('has-error');
		elem.find('.help-block').remove();
	});
	serObj.formType = formObj.data("form-type");
	serObj.formExtra = formObj.data("form-extra");
	return serObj;
}

function addAjaxWait(){
	if ($('#LoadingDiv').length < 1) {
		$('body').prepend(loadingDV);
	}
}

function removeAjaxWait(){
	$('#LoadingDiv').remove();
}

function sendToServer(url, dataStr) {
	$.ajax({
		url : url,
		type : "POST",
		data : dataStr,
		beforeSend : function() {
			if ($('#LoadingDiv').length < 1) {
				$('body').prepend(loadingDV);
			}
		},
		success : function(data, textStatus, jqXHR) {
			$('#LoadingDiv').remove();
			if (data.redirect == true){
				window.location.href = data.redirectPage;
			} else {
				switch (data.contentType) {
				case "STRING":
					processStringFromServer(data);
					break;

				case "PAGE_CONTENT":
					processPageContentFromServer(data);
					break;

				case "JAVASCRIPT":
					processJavaScriptFromServer(data);
					break;
				}
			}
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert("Failed to connect to the server. Please contact to administrator.");
			$('#LoadingDiv').remove();
		}
	});
}

// BootstrapDialog.show({
// message: 'Hi Apple!',
// buttons: [{
// label: 'Button 1'
// }, {
// label: 'Button 2',
// cssClass: 'btn-primary',
// action: function(){
// alert('Hi Orange!');
// }
// }, {
// icon: 'glyphicon glyphicon-ban-circle',
// label: 'Button 3',
// cssClass: 'btn-warning'
// }, {
// label: 'Close',
// action: function(dialogItself){
// dialogItself.close();
// }
// }]
// });
//
//
// BootstrapDialog.show({
// title: 'Default Title',
// message: 'Click buttons below.',
// draggable: true
// buttons: [{
// label: 'Message 1',
// action: function(dialog) {
// dialog.setMessage('Message 1');
// }
// }, {
// label: 'Message 2',
// action: function(dialog) {
// dialog.setMessage('Message 2');
// }
// }]
// });

function processPageContentFromServer(data){
	$('#page-content').html(data.content);
}

function processStringFromServer(data) {
	if (data.showResultDialog){
		var $dialogType = BootstrapDialog.TYPE_DEFAULT;
		if (data.status == 'SUCCESS') {
			$dialogType = BootstrapDialog.TYPE_SUCCESS;
		} else if (data.status == 'INFO') {
			$dialogType = BootstrapDialog.TYPE_INFO;
		} else if (data.status == 'WARNING') {
			$dialogType = BootstrapDialog.TYPE_WARNING;
		} else if (data.status == 'ERROR') {
			$dialogType = BootstrapDialog.TYPE_DANGER;
		}

		BootstrapDialog.alert({
			title : data.title,
			message : data.content,
			draggable : true,
			type : $dialogType, // <-- Default value is BootstrapDialog.TYPE_PRIMARY
			closable : true, // <-- Default value is true
			buttonLabel : 'Close', // <-- Default value is 'OK',
			callback : function(result) {
//				if (data.status != 'ERROR') {
//					$('.modal').modal('hide');
//				}
			}
		});
	}
}

function processJavaScriptFromServer(data) {
	eval(data.contentScript);
	processStringFromServer(data);
}

function processFromX(formObj) {
	var serObj = formObj.serializeForm();
	var dataStr = JSON.stringify(serObj);
	alert(dataStr);
	var fromActionUrl = formObj.action;

	$.ajax({
		url : fromActionUrl,
		type : "POST",
		data : dataStr,
		beforeSend : function() {
			if ($('#LoadingDiv').length < 1) {
				$('body').prepend(loadingDV);
			}
		},
		success : function(data, textStatus, jqXHR) {
			alert(data);
			alert(data.content);
			$('#LoadingDiv').remove();
			// data: return data from server
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert("failed");
			$('#LoadingDiv').remove();
			// if fails
		}
	});
}

function loadValue(oldCom,newCom){
	var value = $('#' + oldCom).val();
	if (value){
		$('#' + newCom).val(value);
	}
}


function handleCompletefunc(xhr, status, args) {
    if(args.validationFailed) {
        alert("Validation Failed");
    } else {
        alert("Save:" + args.saved);
        alert("FirstName: " + args.user.firstname + ", Lastname: " + args.user.lastname);
    }
}

function confirmMe(a){
	return confirm(a);
}