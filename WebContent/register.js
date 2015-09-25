/**
 * 
 */
var flag1 = false;
var flag2 = false;
var flag3 = false;
	function chechName(name){
		var n = name.value;
		if(n&&n!=" "){
			flag2=true;
			document.getElementById("font2").color = "green";
			document.getElementById("font2").innerHTML = "√";
		}else{
			flag2=false;
			document.getElementById("font2").color = "red";
			document.getElementById("font2").innerHTML = "用户名不能为空";
		}
	}
	function chechP(pwd){
		var p = pwd.value;
		if(p){
			flag3=true;
			document.getElementById("font3").color = "green";
			document.getElementById("font3").innerHTML = "√";
		}else{
			flag3=false;
			document.getElementById("font3").color = "red";
			document.getElementById("font3").innerHTML = "密码不能为空";
		}
	}
	function chechPwd(pwd2){
		var pwd1 = document.getElementById("pwd1").value;
		var pwd = pwd2.value;
		if(pwd1 != pwd){
			flag1 = false;
			document.getElementById("font1").color = "red";
			document.getElementById("font1").innerHTML = "输入密码不一致";
		}else{
			flag1 = true;
			document.getElementById("font1").color = "green";
			document.getElementById("font1").innerHTML = "√";
		}
		
	}
	function vilidatePwd() {
		if(flag1&&flag2&&flag3){
			document.getElementById("form1").submit();
		}else{
			
		}
	}