var msg;
var msgInvalidNumberError = "";
var msgNumberLenghtError = "";
var msgTestFieldsNotSet = "";
var invalidMsisdnError = "";

function toggleScheduleSettings() {
	$("#scheduleSettingsDiv").slideToggle(350);
}

String.prototype.format = function() {
	var args = arguments;

	return this.replace(/\{(\d+)\}/g, function() {
		return args[arguments[1]];
	});
};

function changeWorkingTimesSettingsLink() {
	$("#workingTimesSettingsDiv").slideToggle(350);
}

function toggleSMSSettings() {
	$("#smsSettingsDiv").slideToggle(350);
}

function toggleWapPushSettings() {
	$("#wapPushSettingsDiv").slideToggle(350);

}

function defaultActionSettings(defaultAction) {
	if (defaultAction == "SI") {
		$("#signalActionDiv").show();
	} else if (defaultAction == "SL")
		$("#executionActionDiv").show();
}

function toggleActionSettings() {
	var siSelected = $('input[id$="pushType:0"]')[0].checked;
	var slSelected = $('input[id$="pushType:1"]')[0].checked;

	if (slSelected) {
		$("#siIdOptional").hide();
		$("#slParameters").show();
		$("#messageText").prop('disabled', true);
	} else if (siSelected) {
		$("#siIdOptional").show();
		$("#slParameters").hide();
		$("#messageText").prop('disabled', false);
	}
}

function toggleWorkingTimesSettings() {
	$("#workingTimesSettingsDiv").slideToggle(350);
}

function enableScheduleTimeCalendar() {
	if ($('input[id$="jobSchedule:1"]')[0].checked == true) {
		$("#jobScheduleTime").show();
	} else {
		$("#jobScheduleTime").hide();
	}
}

function toggleProgressDetails(jobIndex) {
	$("#progressDetailsDiv_" + jobIndex).toggle();
}

function toggleFilterDetails() {
	$("#filterGroup").slideToggle(350);
}
function toggleCreateNewUser() {
	$("#createNewUser").slideToggle(350);
}
function toggleUpdateExistingUser() {
	$("#updateUser").slideToggle(350);
}
function toggleResetUserPassword() {
	$("#resetUserPassword").slideToggle(350);
}
function toggleActDeactUser() {
	$("#actDeactUser").slideToggle(350);
}
function toggleRemoveUser() {
	$("#removeUser").slideToggle(350);
}
function toggleAccountGrid(){
	$("#accountGrid").slideToggle(350);
}

function clearElements(el) {
	// variable declaration
	var x, y, z, type = null, object = [];
	// collect form elements
	object[0] = document.getElementById(el).getElementsByTagName('input');
	object[1] = document.getElementById(el).getElementsByTagName('textarea');
	object[2] = document.getElementById(el).getElementsByTagName('select');
	// loop through found form elements
	for (x = 0; x < object.length; x++) {
		for (y = 0; y < object[x].length; y++) {
			// define element type
			type = object[x][y].type;
			switch (type) {
			case 'text':
			case 'textarea':
			case 'password':
				object[x][y].value = '';
				break;
			case 'radio':
			case 'checkbox':
				object[x][y].checked = '';
				break;
			case 'select-one':
				object[x][y].options[0].selected = true;
				break;
			case 'select-multiple':
				for (z = 0; z < object[x][y].options.length; z++) {
					object[x][y].options[z].selected = false;
				}
				break;
			} // end switch
		} // end for y
	} // end for x
}

function Focus(objname, waterMarkText) {
	obj = document.getElementById(objname);
	if (obj.value == waterMarkText) {
		obj.value = "";
		obj.className = "NormalTextBox";
		if (obj.value == "User ID" || obj.value == "" || obj.value == null) {
			obj.style.color = "black";
		}
	}
}

function Blur(objname, waterMarkText) {
	obj = document.getElementById(objname);
	if (obj.value == "") {
		obj.value = waterMarkText;
		if (objname != "txtPwd") {
			obj.className = "WaterMarkedTextBox";
		} else {
			obj.className = "WaterMarkedTextBoxPSW";
		}
	} else {
		obj.className = "NormalTextBox";
	}

	if (obj.value == "User ID" || obj.value == "" || obj.value == null) {
		obj.style.color = "gray";
	}
}

function setInputFieldsOfTest() {
	var content = $("#messageText").val();
	var url = $("#url").val();
	var senderId = $("#senderId").val();
	var validityTime = $("#validityTime").val();
	var pushType = $("#pushType :checked").val();
	var signalAction = $("#signalAction :checked").val();
	var executionAction = $("#executionAction :checked").val();
	var siId = $("#siId").val();
	var siCreatedDate = $("#siCreatedDate input[type=text]").val();
	var siExpiredDate = $("#siExpiredDate input[type=text]").val();
	var messageType = $("#messageType").val();

	$("#testContent").val(content);
	$("#messageContent").val(content);
	$("#testUrl").val(url);
	$("#messageUrl").val(url);
	$("#testSenderId").val(senderId);
	$("#messageSenderId").text(senderId);
	$("#testValidityTime").val(validityTime);
	$("#testPushType").val(pushType);
	$("#messagePushType").text(pushType);
	$("#testSignalAction").val(signalAction);
	$("#testExecutionAction").val(executionAction);
	$("#testSiId").val(siId);
	$("#testSiCreatedDate").val(siCreatedDate);
	$("#testSiExpiredDate").val(siExpiredDate);
	$("#testType").val(messageType);
}

function reloadPage(delay) {
	if (delay != null && delay != undefined && delay > 0) {
		setTimeout(function() {
			window.location = window.location;
		}, delay);
	} else {
		window.location = window.location;
	}
}

function setFieldsOfConfirmPage() {
	var name = $("#jobName").val();
	var categoryName = $("#categoryName_input").val();
	var content = replaceSpecialChars($("#messageText").val(),CHAR_REPLACEMENTS);
	var content_excel = null;
	if ($("#messageText_excel") != null && $("#messageText_excel") != undefined) {
		content_excel = replaceSpecialChars($("#messageText_excel").val(),CHAR_REPLACEMENTS);
	}
	var url = $("#url").val();
	var priority = $("#priority :checked").val();
	var lineCount;
	if(jobType=="quickSms"){
		lineCount = $("#quickSmsLineCount").val();
	}else{
		lineCount = $("#fileLineCount").val();
	}
	var testSenderId = $("#senderId").val();
	var validityTime = $("#validityTime").val();
	var pushType = $("#pushType :checked").val();
	var signalAction = $("#signalAction :checked").val();
	var executionAction = $("#executionAction :checked").val();
	var siId = $("#siId").val();
	var siCreatedDate = $("#siCreatedDate input[type=text]").val();
	var siExpiredDate = $("#siExpiredDate input[type=text]").val();
	var scheduleDate = $("#jobScheduleTime input[type=text]").val();
	var messageType = $("#messageType").val();
	var scheduled = $("#jobSchedule :checked").val();
	var weekendAllowed = $('input[id$="weekendAllowed"]')[0].checked;
	var outWorkAllowed = $('input[id$="outWorkAllowed"]')[0].checked;
	var flash = null;
	var concatMessageCount = parseInt($('#concatMessageCount').val());
	if ($('input[id$="flash"]')[0] != undefined && $('input[id$="flash"]')[0] != null) {
		flash = $('input[id$="flash"]')[0].checked;
	}

	// labels
	if (elementExists("confirmLineCount")) {
		$("#confirmLineCount").text(lineCount);
	}
	if (elementExists("confirmName")) {
		$("#confirmName").text(name);
	}
	if (elementExists("confirmCategoryName")) {
		$("#confirmCategoryName").text(categoryName);
	}
	if (elementExists("confirmContent")) {
		if (content != null && content != undefined) {
			$("#confirmContent").text(content);
		} else if (content_excel != null && content_excel != undefined) {
			$("#confirmContent").text(content_excel);
		}
	}
	if (elementExists("confirmUrl")) {
		$("#confirmUrl").text(url);
	}
	if (elementExists("confirmPriority")) {
		if(priority=="1"){
			$("#confirmPriority").text(priorityLow);
		}else if(priority=="2"){
			$("#confirmPriority").text(priorityMedium);
		}else if(priority =="3"){
			$("#confirmPriority").text(priorityHigh);
		}else if(priority =="4"){
			$("#confirmPriority").text(priorityVeryHigh);
		}
	}
	if (elementExists("confirmSenderId")) {
		$("#confirmSenderId").text(testSenderId);
	}
	if (elementExists("confirmValidityTime")) {
		$("#confirmValidityTime").text(validityTime + " " + hour);
	}
	if (elementExists("confirmPushType")) {
		$("#confirmPushType").text(pushType);
	}
	if (elementExists("confirmSignalAction")) {
		$("#confirmSignalAction").text(signalAction);
		if (selectedPushType == 'SL') {
			$("#confimSignalAction_label").parent().parent().hide();
		} else {
			$("#confimSignalAction_label").parent().parent().show();
		}
	}
	if (elementExists("confirmExecutionAction")) {
		$("#confirmExecutionAction").text(executionAction);
		if (selectedPushType == 'SI') {
			$("#confimExecutionAction_label").parent().parent().hide();
		} else {
			$("#confimExecutionAction_label").parent().parent().show();
		}
	}

	if (elementExists("confirmSiId")) {
		$("#confirmSiId").text(siId);
		if (selectedPushType == 'SL' || siId == '' || siId == null) {
			$("#confirmSiId_label").parent().parent().hide();
		} else {
			$("#confirmSiId_label").parent().parent().show();
		}
	}

	if (elementExists("confirmSiCreatedDate")) {
		$("#confirmSiCreatedDate").text(siCreatedDate);
		if (selectedPushType == 'SL' || siCreatedDate == ''
				|| siCreatedDate == null) {
			$("#confirmSiCreateDate_label").parent().parent().hide();
		} else {
			$("#confirmSiCreateDate_label").parent().parent().show();
		}
	}

	if (elementExists("confirmSiExpiredDate")) {
		$("#confirmSiExpiredDate").text(siExpiredDate);
		if (selectedPushType == 'SL' || siExpiredDate == ''
				|| siExpiredDate == null) {
			$("#confirmSiExpireDate_label").parent().parent().hide();
		} else {
			$("#confirmSiExpireDate_label").parent().parent().show();
		}
	}

	if (elementExists("confirmScheduleTime")) {
		$("#confirmScheduleTime").text(scheduleDate);
		if (scheduleDate == '' || scheduleDate == null) {
			$("#confirmScheduleTime_label").parent().parent().hide();
		} else {
			$("#confirmScheduleTime_label").parent().parent().show();
		}
	}
	if (elementExists("confirmOutWorkAllowed")) {
		var input;
		if (outWorkAllowed) {
			input = $("#yesInput").val();
		} else {
			input = $("#noInput").val();
		}
		$("#confirmOutWorkAllowed").text(input);
	}

	if (elementExists("confirmWeekendAllowed")) {
		var input;
		if (weekendAllowed) {
			input = $("#yesInput").val();
		} else {
			input = $("#noInput").val();
		}
		$("#confirmWeekendAllowed").text(input);
	}
	

	if (elementExists("confirmFlash")) {
		var input;
		if (flash) {
			input = $("#yesInput").val();
		} else {
			input = $("#noInput").val();
		}
		$("#confirmFlash").text(input);
	}

	// hiddens
	if (elementExists("confirmLineCount_h")) {
		$("#confirmLineCount_h").val(lineCount);
	}
	if (elementExists("confirmName_h")) {
		$("#confirmName_h").val(name);
	}
	if (elementExists("confirmCategoryName_h")) {
		$("#confirmCategoryName_h").val(categoryName);
	}
	if (elementExists("confirmContent_h")) {
		if (content != null && content != undefined) {
			$("#confirmContent_h").val(content);
		} else if (content_excel != null && content_excel != undefined) {
			$("#confirmContent_h").val(content_excel);
		}
	}
	if (elementExists("confirmUrl_h")) {
		$("#confirmUrl_h").val(url);
	}
	if (elementExists("confirmPriority_h")) {
		$("#confirmPriority_h").val(priority);
	}
	if (elementExists("confirmSenderId_h")) {
		$("#confirmSenderId_h").val(testSenderId);
	}
	if (elementExists("confirmValidityTime_h")) {
		$("#confirmValidityTime_h").val(validityTime);
		$("#validityTimeInMins").val(parseInt(validityTime)*60);
	}
	if (elementExists("confirmPushType_h")) {
		$("#confirmPushType_h").val(pushType);
	}
	if (elementExists("confirmSignalAction_h")) {
		$("#confirmSignalAction_h").val(signalAction);
	}
	if (elementExists("confirmExecutionAction_h")) {
		$("#confirmExecutionAction_h").val(executionAction);
	}
	if (elementExists("confirmSiId_h")) {
		$("#confirmSiId_h").val(siId);
	}
	if (elementExists("confirmSiCreatedDate_h")) {
		$("#confirmSiCreatedDate_h").val(siCreatedDate);
	}
	if (elementExists("confirmSiExpiredDate_h")) {
		$("#confirmSiExpiredDate_h").val(siExpiredDate);
	}
	if (elementExists("confirmMessageType_h")) {
		$("#confirmMessageType_h").val(messageType);
	}
	if (elementExists("confirmScheduleTime_h")) {
		$("#confirmScheduleTime_h").val(scheduleDate);
	}
	if (elementExists("confirmJobSchedule_h")) {
		$("#confirmJobSchedule_h").val(scheduled);
	}
	if (elementExists("confirmOutWorkAllowed_h")) {
		$("#confirmOutWorkAllowed_h").val(outWorkAllowed);
	}
	if (elementExists("confirmWeekendAllowed_h")) {
		$("#confirmWeekendAllowed_h").val(weekendAllowed);
	}
	if (elementExists("confirmFlash_h")) {
		$("#confirmFlash_h").val(flash);
	}
	if (elementExists("confirmSMSCount")) {
		$("#confirmSMSCount").text(concatMessageCount*lineCount);
	}
}

function trim(stringToTrim) {
	return stringToTrim.replace(/^\s+|\s+$/g, "");
}

function elementExists(id) {
	var elm = document.getElementById(id);
	if (elm == null || elm == undefined) {
		return false;
	} else {
		return true;
	}
}

function msisdnRuleCheck(maxNumber) {
	var length_check = true;
	var digit_check = true;
	var prefix_check = true;
	var errorMessage1 = "";
	var errorMessage2 = "";
	var msisdns = $("#testMsisdn").val();
	var msisdnList = new Array();
	msisdnList = msisdns.split(",");
	for ( var i = 0; i < msisdnList.length; ++i) {
		if (msisdnList[i].length != 11) {
			length_check = false;
		}
		if (isNaN(msisdnList[i])) {
			digit_check = false;
		}
		if (msisdnList[i].substr(0, 2) != "05") {
			prefix_check = false;
		}
	}
	if (msisdnList.length > maxNumber) {
		errorMessage1 = msgNumberLenghtError.format(maxNumber);
	}
	if (!digit_check || !length_check || !prefix_check) {
		errorMessage2 = msgInvalidNumberError;
	}
	if (errorMessage1 != "") {
		alert(errorMessage1);
	}
	if (errorMessage2 != "") {
		alert(errorMessage2);
	}
	return (errorMessage1 == "" && errorMessage2 == "");
}

function checkFields() {
	var content = $("#messageText").val();
	var url = $("#url").val();
	var messageType = $("#messageType").val();
	if (content == null || content == "" || url == null || url == "") {
		if (messageType != 1) {
			alert(msgTestFieldsNotSet);
			return false;
		}
	}
	return true;
}
function msisdnFileValidity() {
	var msisdnFileValidity = $("#msisdnFileValidity").val();
	alert(msisdnFileValidity);
	if (msisdnFileValidity == 'true') {
		return true;
	}
	return false;
}

function openDropDownMenu(id) {
	$('#' + id).removeClass('hideDropDownList');
}

function closeDropDownMenu(id) {
	$('#' + id).addClass('hideDropDownList');
}

function msisdnRuleCheckForTrace() {
	var length_check = true;
	var digit_check = true;
	var prefix_check = true;
	var msisdn = $("#msisdn").val();
	var msisdnErrorMessage = "";
	if (msisdn.length != 0) {
		// if (msisdn.length != 11) {
		// length_check = false;
		// }
		if (isNaN(msisdn)) {
			digit_check = false;
		}
		if (msisdn.substr(0, 2) != "05") {
			prefix_check = false;
		}
	}
	if (!digit_check || !length_check || !prefix_check) {
		msisdnErrorMessage = invalidMsisdnError;
	}
	if (msisdnErrorMessage != "") {
		alert(msisdnErrorMessage);
	}

	return (msisdnErrorMessage == "");
}

function addCommasToNumber(nStr)
{
	nStr += '';
	x = nStr.split('.');
	x1 = x[0];
	x2 = x.length > 1 ? '.' + x[1] : '';
	var rgx = /(\d+)(\d{3})/;
	while (rgx.test(x1)) {
		x1 = x1.replace(rgx, '$1' + ',' + '$2');
	}
	return x1 + x2;
}

function disableKeyPress(e){
     var key;     
     if(window.event)
          key = window.event.keyCode; //IE
     else
          key = e.which; //firefox     

     return (key != 13);
}

function setGroupIds(){
	var main = $("#mainGroup_h").val();
	var sub = $("#subGroup_h").val();
	$("#changeGroup").val(main);
	$("#changeSubGroup").val(sub);
}

function setUserProfile(){
	var profile = $("#userProfile_h").val();
	var profile2 =$("#selectProfile").val();
	$("#selectProfile").val(profile);
}

function chooseAction(){ 
//	if($("#usrMngActionName").val()=='update') {
//		$("#createUserButton2")[0].disabled=true;
//	}else{ 
//		$("#updateUserButton2")[0].disabled=true;
//	}
}	


/* FUNCTIONS FOR CALCULATING MAX CHARS LENGTH IN A MESSAGE*/
function isAllCharsAscii(str) {
	var strLen = str.length;
	var i;
	for (i = 0; i < strLen; ++i) {
		if (str.charCodeAt(i) > 127) {
			return false;	
		}
	}

	return true;
}

function replaceSpecialChars(str, replaceStr) {
	if (str == null || str == undefined) {
		return str;
	}
	var replaceTable = parseCharReplacementTable(replaceStr);
	var tableLen = replaceTable.length;
	var replacedStr = "";

	for (var i = 0; i < str.length; i++) {
		var charCode = str.charCodeAt(i);			
		var nextChar = str.charAt(i);
		for (var j = 0; j < tableLen; ++j) {
			var tableChar = replaceTable[j][0];
			if (tableChar.charCodeAt(0) == charCode) {
				nextChar = replaceTable[j][1];
				break;
			}
		}
		replacedStr = replacedStr + nextChar;
	}

	return replacedStr;
}

function parseCharReplacementTable(replaceStr) {
	var replaceCouples = replaceStr.split(";");
	var coupleCount = replaceCouples.length;
	
	var replaceTable = new Array(coupleCount);
	for (var i = 0; i < coupleCount; ++i) {
		var couple = replaceCouples[i].split("-");
		replaceTable[i] = new Array(2);
		var toReplace = couple[0].trim();
		if (toReplace.indexOf("u") == 0) {
			toReplace = toReplace.substring(1);
		}
		
		replaceTable[i][0] = String.fromCharCode(parseInt(toReplace,16));
		
		var replacer = couple[1].trim();
		if (replacer.length == 1) {
			replaceTable[i][1] = replacer;
		} else if (replacer.length > 1) {
			if (replacer.indexOf("u") == 0) {
				replacer = replacer.substring(1);
			}	
			replaceTable[i][1] = String.fromCharCode(parseInt(replacer,16));
		}
	}
	
	return replaceTable;
}

function getMaxMessageLength(jt, msg) {
	// Perform char replacement if it is enabled.
	var text = msg != null ? msg : "";
	if (REPLACE_ON) {
		if(jobType !='wappush'&& jobType !='bookmark'){
			text = replaceSpecialChars(text, CHAR_REPLACEMENTS);
		}
	}
	
	if (TYPE_SMS == getMessageType(jt)) {
		if (checkAllCharsInDefaultAlphabet(text)) {
			if (DEFAULT_CHARSET === CHARSET_SINGLE_SHIFT_TR && hasSstrLetters(text)) {
				if (MAX_CONCAT_SMS == 1) { // Concat not supported.
					return MAX_CHARS_SSTR;
				} else if (MAX_CONCAT_SMS > 1) { // Concat supported
					return MAX_CHARS_CONCAT_SSTR * MAX_CONCAT_SMS;
				}
			} else {
				if (MAX_CONCAT_SMS == 1) { // Concat not supported.
					return MAX_CHARS_7BIT;
				} else if (MAX_CONCAT_SMS > 1) { // Concat supported
					return MAX_CHARS_CONCAT_7BIT * MAX_CONCAT_SMS;
				}
			}
		} else { // Text contains some out-alphabet chars.
			if (MAX_CONCAT_SMS == 1) { // Concat not supported.
				return MAX_CHARS_16BIT;
			} else if (MAX_CONCAT_SMS > 1) {// Concat supported
				return MAX_CHARS_CONCAT_16BIT * MAX_CONCAT_SMS;
			}
		}
	} else if (TYPE_WAPPUSH == getMessageType(jt)) {
		if (MAX_CONCAT_WAPPUSH == 1) { // Concat not supported.
			return MAX_CHARS_WAPPUSH;
		} else if (MAX_CONCAT_WAPPUSH == 2) {
			return (MAX_CHARS_WAPPUSH +(MAX_CHARS_CONCAT_2ND_WAPPUSH * (MAX_CONCAT_WAPPUSH-1)));
		} else if (MAX_CONCAT_WAPPUSH > 2) {// Concat supported
			return (MAX_CHARS_WAPPUSH + MAX_CHARS_CONCAT_2ND_WAPPUSH + (MAX_CHARS_CONCAT_3RD_WAPPUSH * (MAX_CONCAT_WAPPUSH-2)));
		}
	} else if (TYPE_BOOKMARK == getMessageType(jt)) {

		if (MAX_CONCAT_BOOKMARK == 1) { // Concat not supported.
			return MAX_CHARS_BOOKMARK;
		} else if (MAX_CONCAT_BOOKMARK == 2) {
			return (MAX_CHARS_BOOKMARK +(MAX_CHARS_CONCAT_2ND_BOOKMARK * (MAX_CONCAT_BOOKMARK-1)));
		} else if (MAX_CONCAT_BOOKMARK > 2) {// Concat supported
			return (MAX_CHARS_BOOKMARK + MAX_CHARS_CONCAT_2ND_BOOKMARK + (MAX_CHARS_CONCAT_3RD_BOOKMARK * (MAX_CONCAT_BOOKMARK-2)));
		}

	}

	return MAX_CHARS_7BIT;
}

function hasSstrLetters(text) {
	for (var i = 0; i < text.length; i++) {
		if (EXTENSION_SINGLE_SHIFT_TR_LETTERS.indexOf(text.charCodeAt(i)) > 0) {
			return true;
		}
	}
	
	return false;
}

function checkAllCharsInDefaultAlphabet(text) {
	if (CHARSET_ASCII == DEFAULT_CHARSET) {
		for (var i = 0; i < text.length; ++i) {
			if (text.charCodeAt(i) > 127) {
				return false;	
			}
		}	
	} else if (CHARSET_GSM7 == DEFAULT_CHARSET) {
		for (var i = 0; i < text.length; ++i) {
			if (ALPHABET_GSM7.indexOf(text.charCodeAt(i)) < 0) {
				return false;	
			}
		}	
	} else if (CHARSET_GSM7_WITH_EXTENSION == DEFAULT_CHARSET) {
		for (var i = 0; i < text.length; ++i) {
			if (ALPHABET_GSM7_WITH_EXTENSION.indexOf(text.charCodeAt(i)) < 0) {
				return false;	
			}
		}	
	} else if (CHARSET_SINGLE_SHIFT_TR == DEFAULT_CHARSET) {
		for (var i = 0; i < text.length; ++i) {
			if (ALPHABET_GSM7_WITH_SINGLE_SHIFT_TR.indexOf(text.charCodeAt(i)) < 0) {
				return false;	
			}
		}	
	}
	return true;
}

/*********************************************************************/

PrimeFaces.locales['tr'] = {
	    closeText: 'Kapat',
	    prevText: 'geri',
	    nextText: 'ileri',
	    currentText: 'Bugün',
	    monthNames: ['Ocak','Şubat','Mart','Nisan','Mayıs','Haziran','Temmuz','Ağustos','Eylül','Ekim','Kasım','Aralık'],
	    monthNamesShort: ['Oca','Şub','Mar','Nis','May','Haz', 'Tem','Ağu','Eyl','Eki','Kas','Ara'],
	    dayNames: ['Pazar','Pazartesi','Salı','Çarşamba','Perşembe','Cuma','Cumartesi'],
	    dayNamesShort: ['Pz','Pt','Sa','Ça','Pe','Cu','Ct'],
	    dayNamesMin: ['Pz','Pt','Sa','Ça','Pe','Cu','Ct'],
	    weekHeader: 'Hf',
	    firstDay: 1,
	    isRTL: false,
	    showMonthAfterYear: false,
	    yearSuffix: '',
	    timeOnlyTitle: 'Zaman Seçiniz',
	    timeText: 'Zaman',
	    hourText: 'Saat',
	    minuteText: 'Dakika',
	    secondText: 'Saniye',
	    ampm: false,
	    month: 'Ay',
	    week: 'Hafta',
	    day: 'Gün',
	    allDayText : 'Tüm Gün'
	}