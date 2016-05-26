
$(function(){
	var $pwd_conf_input = $('#password_confirm');
	
	/*$('form').on('onchange', '#password_confirm', function(){
		alert('change');
	});*/
	$('#password_confirm').on('change', function(){
		var $this = $(this);
		var pwd_conf = $this.val(), pwd = $('#password').val();
		if(pwd_conf!=null && pwd_conf!=''){
			if(pwd_conf!==pwd){
				alert('两次密码不一致！')
			}
		}
	});
});

function validatePassword(){
	var $pwd_input = $('#password');
	var $pwd_conf_input = $('#password_confirm');
	
	
}