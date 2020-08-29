function subscribe(courseId){

	if(confirm('确实要订阅该课程吗?')){
		
		var form = document.createElement("form");   
		form.method = 'post';
		form.action = '/student/subscribe';

		var newElement = document.createElement("input");
	    newElement.setAttribute("name","courseId");
	    newElement.setAttribute("type","hidden");
	    newElement.setAttribute("value",courseId);
	    form.appendChild(newElement);

	    document.body.appendChild(form);
	    form.submit();
		
	}

};


function unsubscribe(courseId){
	

	if(confirm('确实要该课程取消订阅吗?')){
		
		var form = document.createElement("form");   
		form.method = 'post';
		form.action = '/student/unsubscribe';

		var newElement = document.createElement("input");
	    newElement.setAttribute("name","courseId");
	    newElement.setAttribute("type","hidden");
	    newElement.setAttribute("value",courseId);
	    form.appendChild(newElement);

	    document.body.appendChild(form);
	    form.submit();
		
	}
	
	
	
}
