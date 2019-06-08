<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

	<div class='uploadDiv'>
		<input type='file' name='uploadFile' multiple>
	</div>

	<button id='uploadBtn'>Upload</button>

	<script src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous"></script>

<script>
		 $(document).ready(function(){
	 
		///////////////////////////////////////// 
		 var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
		 var maxSize = 5242880; //5MB

		function checkExtension(fileName, fileSize) {

			if (fileSize >= maxSize) {
				alert("파일 사이즈가 5MB를 초과하였습니다.");
				return false;
			}

			if (regex.test(fileName)) {
				alert("해당 확장자 파일은 업로드할 수 없습니다.");
				return false;
			}
			return true;
		}
		///////////////////////////////////////// 
		
		 $("#uploadBtn").on("click", function(e){

		 var formData = new FormData();
		
		 var inputFile = $("input[name='uploadFile']");
		
		 var files = inputFile[0].files;
		
		 	console.log(files);
		
		 //add filedate to formdata
		 for(var i = 0; i < files.length; i++){
			
			 if (!checkExtension(files[i].name, files[i].size)) {
					return false;
			}
			 
		 formData.append("uploadFile", files[i]);
		
		 }

		 $.ajax({
				 url: '/uploadAjaxAction5',
				 processData: false,//반드시 false
				 contentType: false,//반드시 false
				 data: formData,
				 type: 'POST',
				 success: function(result){
					 alert("업로드를 완료 하였습니다.");
					 }
				 });
			 });  //ajax
		///////////////////////////////////////// 
		
		 });
</script>
</body>
</html>
