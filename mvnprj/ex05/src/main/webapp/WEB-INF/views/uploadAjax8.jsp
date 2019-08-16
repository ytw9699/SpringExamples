<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<style>
.uploadResult {
	width: 100%;
	background-color: gray;
}

.uploadResult ul {
	display: flex;
	flex-flow: row;
	justify-content: center;
	align-items: center;
}

.uploadResult ul li {
	list-style: none;
	padding: 10px;
}

.uploadResult ul li img {
	width: 100px;
}
.bigPictureWrapper {
  position: absolute;
  display: none;
  justify-content: center;
  align-items: center;
  top:0%;
  width:50%;    
  height:50%;   
  background-color: #000; 
  z-index: 100;
  opacity: 0.6;
}

.bigPicture {
  position: relative;
  display:flex;
  justify-content: center;
  align-items: center;
}
.bigPicture img{
	width: 600px;
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
	  .animate({width:'100%', height: '100%'}, 500);//0.5초만에 나타남

}
	
	$(".bigPictureWrapper").on("click", function(e){
		  $(".bigPicture").animate({width:'0%', height: '0%'}, 500);//0.5초후 사라짐
		  setTimeout(() => {//ie에서는 동작안함
		    $(this).hide();   
		  }, 500);//0.5초후 사라짐
		});
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
			     // 브라우저에서 GET 방식으로 첨부파일의 이름을 사용할 때에 경로나 파일 이름에 한글 혹은 공백 등의 문자가 들어가면 문제가 발생할 수 있으므로 JavaScript의
					// encodeURIComponet() 함수를 이용해서 URI에 문제가 없는  문자열로 인코딩 처리 //크롬과 대의 경우 서로 다르게 처리되어서 첨부파일에 문제가 있을 수 있기 때문
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
