var obj;
function myFunction(courses){
obj=courses.value;
console.log(obj)
o = document.getElementById(obj);
parent=o.parentElement;
for(i=0;i<parent.childElementCount;i++) {
	parent.children[i].style.display='none';
}
o.style.display="inline-block";
o.parentElement.style.display="block";
}

