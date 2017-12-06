// jQuery $('document').ready(); function 
$('document').ready(function(){

	$(".settings-modal").click(function() {
	    $(this).modal();
	});    

	
	$('.sidebar .nav > li  ul > li.active').parent().css('display','block')
	

	
}); 


//SIDEBAR TOGGLE
$(function() {
	$(".toggle-sidebar").click(function () {
	  $('body').toggleClass("show-sidebar");
	});

	var contentMinHeight 	= $('.sidebar .wrapper').height();
	var frameMinHeight 		= $( document ).height();

	$('.frame').css('min-height', frameMinHeight);
	$('.content').css('min-height', contentMinHeight);
});

// Sidebar dropdown
$('.sidebar .nav > li  a.dropdown ').click(function(e){
		e.preventDefault();
		$(this).next('ul').slideToggle();
})

// PANELS

// panel close
$('.panel-close').click(function(e){
	e.preventDefault();
	$(this).parent().parent().parent().parent().fadeOut();
});

$('.panel-minimize').click(function(e){
	e.preventDefault();
	var $target = $(this).parent().parent().parent().next('.panel-body');
	if($target.is(':visible')) $('i',$(this)).removeClass('icon-chevron-up').addClass('icon-chevron-down');
	else 					   $('i',$(this)).removeClass('icon-chevron-down').addClass('icon-chevron-up');
	$target.slideToggle();
});
$('.panel-settings').click(function(e){
	e.preventDefault();
	$('#myModal').modal('show');
});

//Todo Table
	$('.todo-table .finish-task').change(function(){
		if($(this).is(':checked'))
		{
			$(this).parent().parent().addClass('finish');
		}
		else
		{
			$(this).parent().parent().removeClass('finish');
		}
	});

	$('.todo-table .btn-delete').click(function(){
		confirm('Are you sure to delete this item?');
		$(this).parent().parent().fadeOut();
	});
	function setOptions(selectID, text) {
	    $("#" + selectID + " option").filter(function () {
	        return $(this).val() == text;
	    }).prop('selected', true);

	}
