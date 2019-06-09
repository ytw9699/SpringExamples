<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
.bigPictureWrapper {
  position: absolute;
  display: none;
  justify-content: center;
  align-items: center;
  top:0%;
  width:100%;
  height:100%;
  background-color: gray; 
  z-index: 100;
}

.bigPicture {
  position: relative;
  display:flex;
  justify-content: center;
  align-items: center;
}
</style>
</head>
<body>

	<div class='bigPictureWrapper'>
	  <div class='bigPicture'>
	  </div>
	</div>

	<div class='uploadDiv'>
		<input type='file' name='uploadFile' multiple>
	</div>
	
	<div class='uploadResult'>
		<ul></ul>
	</div>
	

	<button id='uploadBtn'>Upload</button>

	<script src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous"></script>

<script>

function showImage(fileCallPath){
	  
	  //alert(fileCallPath);
	
	  $(".bigPictureWrapper").css("display","flex").show();
	  
	  $(".bigPicture")
	  .html("<img src='/display?fileName="+fileCallPath+"'>")
	  .animate({width:'100%', height: '100%'}, 1000);

	}
	
///////////////////////////////////////// 

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
		
		var cloneObj = $(".uploadDiv").clone();//인풋타입 복사해두기
		
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
				 url: '/uploadAjaxAction8',
				 processData: false,//반드시 false
				 contentType: false,//반드시 false
				 data: formData,
				 type: 'POST',
				 dataType : 'json',//결과타입 json
				 success: function(result){
					 
					 /* console.log("result");
					 console.log(result); */
					 
					 alert("업로드를 완료 하였습니다.");
					 
					 showUploadedFile(result);
					 
					 //alert(cloneObj.html()); 
					 
					 $(".uploadDiv").html(cloneObj.html());//초기화
					 
					 }
				 });
			 });  //ajax 
			 
			 
	///////////////////////////////////////// 
		var uploadResult = $(".uploadResult ul");
		 
	function showUploadedFile(result){
			   
	   var str = "";
	    
	   $(result).each(function(i, obj){
	     
	     if(!obj.image){//일반파일경우
	       
	       var fileCallPath =  encodeURIComponent( obj.uploadPath+"/"+ obj.uuid +"_"+obj.fileName);
	       
	       str += "<li><a href='/download?fileName="+fileCallPath+"'><img src='/resources/img/attach.png'>"+obj.fileName+"</a></li>"
	     }else{
	       
	       var fileCallPath =  encodeURIComponent( obj.uploadPath+ "/s_"+obj.uuid +"_"+obj.fileName);
	       
	       var originPath = obj.uploadPath+ "\\"+obj.uuid +"_"+obj.fileName;
	       
	       //console.log(originPath);
	       
	       originPath = originPath.replace(new RegExp(/\\/g),"/");//  "\"를 "/"로 바꾼것
	       
	       //console.log(originPath);
	       
	       str += "<li><a href=\"javascript:showImage(\'"+originPath+"\')\"><img src='/display?fileName="+fileCallPath+"'></a>"+obj.fileName+"</li>";
	     }
	   });
	   
	   uploadResult.append(str);
	 }
	///////////////////////////////////////// 
		 });
</script>
</body>
</html>
