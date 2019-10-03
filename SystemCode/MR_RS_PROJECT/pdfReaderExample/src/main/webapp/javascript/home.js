document.getElementById("Evaluate").style.display='none';
document.getElementById("file").onchange=function() {
var a=document.getElementById("file").files[0].name.substr(document.getElementById("file").files[0].name.lastIndexOf('.')+1)
if(a == "pdf" || a=="doc" || a=="docx") {
document.getElementById("file").hidden=true;
document.getElementById("files").style.display='none';
document.getElementById("filename").innerHTML = document.getElementById("file").files[0].name;
document.getElementById("Evaluate").hidden=false;
document.getElementById("Evaluate").style.display='block'
}
else {
alert("File Uploaded not supported");
}

}
