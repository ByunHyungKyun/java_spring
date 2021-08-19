var formData ="";
var formData2 ="";


function picture_go(){
   formData = new FormData($('form[role="imageForm"]')[0]);
   //alert("file choice");
   
   var form = $('form[role="imageForm"]');
   var picture = form.find('[name=pictureFile]')[0];
   
   //업로드 확인변수 초기화
   form.find('[name="checkUpload"]').val(0);
   var fileFormat=
      picture.value.substr(picture.value.lastIndexOf(".")+1).toUpperCase();
      
   //이미지 확장자 jpg 확인
   if(!(fileFormat=="JPG" || fileFormat=="JPEG")){
      alert("이미지는 jpg/jpeg 형식만 가능합니다.");
      picture.value="";      
      return;
   } 
   
   //이미지 파일 용량 체크
   if(picture.files[0].size>1024*1024*1){
      alert("사진 용량은 1MB 이하만 가능합니다.");
      return;
   };
   
   document.getElementById('inputFileName').value=picture.files[0].name;
   

   if (picture.files && picture.files[0]) {
      var reader = new FileReader();
       reader.onload = function (e) {
           $('div#pictureView')
              .css({'background-image':'url('+e.target.result+')',
                 'background-position':'center',
                 'background-size':'cover',
                 'background-repeat':'no-repeat'
                 });
        }
      reader.readAsDataURL(picture.files[0]);
      
   }
} 

function picture_go2(){
	
	formData2 = new FormData($('form[role="imageForm2"]')[0]);
	   
	   var form = $('form[role="imageForm2"]');
	   var picture = form.find('[name=pictureFile2]')[0];
	   
	   //업로드 확인변수 초기화
	   form.find('[name="checkUpload2"]').val(0);
	   var fileFormat=
	      picture.value.substr(picture.value.lastIndexOf(".")+1).toUpperCase();
	      
	   //이미지 확장자 jpg 확인
	   if(!(fileFormat=="JPG" || fileFormat=="JPEG")){
	      alert("이미지는 jpg/jpeg 형식만 가능합니다.");
	      picture.value="";      
	      return;
	   } 
	   
	   document.getElementById('inputFileName2').value=picture.files[0].name;
	   

	   if (picture.files && picture.files[0]) {
	      var reader = new FileReader();
	       reader.onload = function (e) {
	           $('div#pictureView2')
	              .css({'background-image':'url('+e.target.result+')',
	                 'background-position':'center',
	                 'background-size':'cover',
	                 'background-repeat':'no-repeat'
	                 });
	        }
	      reader.readAsDataURL(picture.files[0]);
	      
	   }
	}



function upload_go(){
   if($('input[name="pictureFile"]').val()==""){
      alert("사진을 선택하세요.");
      $('input[name="pictureFile"]').click();
      return;
   };   
   
   
   if($('input[name="checkUpload"]').val()==1){
      alert("이미업로드 된 사진입니다.");
      return;
      
   }
   
   
   $.ajax({
      url:"/member/picture.do",
      data:formData,
      type:'post',
      processData:false,
      contentType:false,
      success:function(data){
         //업로드 확인변수 세팅
         $('input[name="checkUpload"]').val(1);
         
         //저장된 파일명 저장.
         $('input#oldFile').val(data); // 변경시 삭제될 파일명
         $('form[role="form"]  input[name="picture"]').val(data);
         
         alert("사진이 업로드 되었습니다.");
         
         
      },
      error:function(error){
         alert("현재 사진 업로드가 불가합니다.\n 관리자에게 연락바랍니다.");
      }
   });
}


function upload_go2(){
	   if($('input[name="pictureFile2"]').val()==""){
	      alert("사진을 선택하세요.");
	      $('input[name="pictureFile2"]').click();
	      return;
	   };   
	   
	   
	   if($('input[name="checkUpload2"]').val()==1){
	      alert("이미업로드 된 사진입니다.");
	      return;
	      
	   }
	   
	   
	   $.ajax({
	      url:"/member/picture2.do",
	      data:formData2,
	      type:'post',
	      processData:false,
	      contentType:false,
	      success:function(data){
	         //업로드 확인변수 세팅
	         $('input[name="checkUpload2"]').val(1);
	         
	         //저장된 파일명 저장.
	         $('input#oldFile2').val(data); // 변경시 삭제될 파일명
	         $('form[role="form"]  input[name="picture2"]').val(data);
	         
	         alert("사진이 업로드 되었습니다.");
	         
	         
	      },
	      error:function(error){
	         alert("현재 사진 업로드가 불가합니다.\n 관리자에게 연락바랍니다.");
	      }
	   });
	}


/*------------------아이디 체크*/



function regist_go(){
	
   var form = $('form[role="form"]');
   form.submit();
}

















