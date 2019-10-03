document.getElementById("nationality").style.display="none"
document.getElementById("N").style.display="none"
document.getElementById("F").style.display="none"
document.getElementById("S").style.display="none"
for(var i =0;i<document.getElementsByName('Nationality').length;i++)
{
document.getElementsByName('Nationality')[i].style.display="none";
}
document.getElementById("fee").style.display="none"
for(var i =0;i<document.getElementsByName('fee').length;i++)
{
document.getElementsByName('fee')[i].style.display="none";
}

document.getElementById("Subsidry").style.display="none";
document.getElementById("Subsidry-S").style.display="none";
for(var i =0;i<document.getElementsByName('Subsidry-S').length;i++)
{
document.getElementsByName('Subsidry-S')[i].style.display="none";
}
document.getElementById("Subsidry-C").style.display="none";
for(var i =0;i<document.getElementsByName('Subsidry-C').length;i++)
{
document.getElementsByName('Subsidry-C')[i].style.display="none";
}
var age;
document.getElementById("Age").onchange=function() {
age=parseInt(document.getElementById("Age").value)
if(age>18)
{
document.getElementById("nationality").style.display="block";
document.getElementById("N").style.display="block";
for(var i =0;i<document.getElementsByName('Nationality').length;i++)
{
document.getElementsByName('Nationality')[i].style.display="inline";
}
}
}

var nationality;
var fee;

document.getElementById("Foriegner").onchange=function(){
nationality=document.getElementById("Foriegner").value;
document.getElementById("fee").style.display="block"
document.getElementById("F").style.display="block"
for(var i =0;i<document.getElementsByName('fee').length;i++)
{
document.getElementsByName('fee')[i].style.display="inline";
}
}

document.getElementById("PR").onchange=function(){
nationality=document.getElementById("PR").value;
document.getElementById("fee").style.display="block"
document.getElementById("F").style.display="block"
for(var i =0;i<document.getElementsByName('fee').length;i++)
{
document.getElementsByName('fee')[i].style.display="inline";
}
}

document.getElementById("Citizen").onchange=function(){
nationality=document.getElementById("Citizen").value;
document.getElementById("fee").style.display="block"
document.getElementById("F").style.display="block"
for(var i =0;i<document.getElementsByName('fee').length;i++)
{
document.getElementsByName('fee')[i].style.display="inline";
}
}

document.getElementById("Self").onchange=function(){
fee=document.getElementById("Self").value;
if(age>=40 && nationality=="Citizen")
{	document.getElementById("S").style.display="block";
	document.getElementById("Subsidry").style.display="block";
	document.getElementById("Subsidry-S").style.display="block";
	for(var i =0;i<document.getElementsByName('Subsidry-S').length;i++)
	{
		document.getElementsByName('Subsidry-S')[i].style.display="inline";
	}
	for(var i =0;i<document.getElementsByName('Subsidry-C').length;i++)
	{
		document.getElementsByName('Subsidry-C')[i].style.display="none";
	}
}
}

document.getElementById("CS").onchange=function(){
fee=document.getElementById("CS").value;
if(age>=40 && nationality=="Citizen")
{
	document.getElementById("S").style.display="block";
	document.getElementById("Subsidry").style.display="block";
	document.getElementById("Subsidry-C").style.display="block";
	for(var i =0;i<document.getElementsByName('Subsidry-S').length;i++)
	{
		document.getElementsByName('Subsidry-S')[i].style.display="none";
	}
	for(var i =0;i<document.getElementsByName('Subsidry-C').length;i++)
	{
		document.getElementsByName('Subsidry-C')[i].style.display="inline";
	}
}
}