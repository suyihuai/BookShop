/**
 * 
 */
var flag1 = false;
var flag2 = false;
function vilidate(name){
	if(flag1&&flag2){
		document.getElementById("form1").submit();
	}
}
function nameCheck(name){
	var n = name.value;
	if(n&&n!=" "){
		flag1=true;
		document.getElementById("font1").color = "green";
		document.getElementById("font1").innerHTML = "√";
	}else{
		flag1=false;
		document.getElementById("font1").color = "red";
		document.getElementById("font1").innerHTML = "图书名不能为空";
	}
}
function priceCheck(price){
	var n = price.value;
	if(n&&n!=" "){
		flag2=true;
		document.getElementById("font2").color = "green";
		document.getElementById("font2").innerHTML = "√";
	}else{
		flag2=false;
		document.getElementById("font2").color = "red";
		document.getElementById("font2").innerHTML = "价格不能为空";
	}
}