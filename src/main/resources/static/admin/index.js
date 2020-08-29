function editUser(userId){

	location.href="/admin/editUser?userId=" + userId;

};


function delUser(userId){
	

	if(confirm('确实要删除吗?')){
		
		var form = document.createElement("form");   
		form.method = 'post';
		form.action = '/admin/delUser';

		var newElement = document.createElement("input");
	    newElement.setAttribute("name","userId");
	    newElement.setAttribute("type","hidden");
	    newElement.setAttribute("value",userId);
	    form.appendChild(newElement);

	    document.body.appendChild(form);
	    form.submit();
		
	}
	
	
	
}
