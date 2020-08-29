function editCourse(courseId){

	location.href="/teacher/editCourse?courseId=" + courseId;

};


function delCourse(courseId){
	

	if(confirm('确实要删除吗?')){
		
		var form = document.createElement("form");   
		form.method = 'post';
		form.action = '/teacher/delCourse';

		var newElement = document.createElement("input");
	    newElement.setAttribute("name","courseId");
	    newElement.setAttribute("type","hidden");
	    newElement.setAttribute("value",courseId);
	    form.appendChild(newElement);

	    document.body.appendChild(form);
	    form.submit();
		
	}
	
	
	
}
