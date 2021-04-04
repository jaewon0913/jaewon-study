$("#loginBtn").on('click', function(){
   if($("#loginBtn").hasClass('disabled-btn')){
       alert("recaptcha 인증 후 진행이 가능합니다.");
   } else {
       var memberId = $("#loginId").val();
       var memberPw = $("#loginPw").val();
       var recaptcha = $("#g-recaptcha-response").val();

       $.ajax({
           type: "get",
           contentType: "application/json",
           url: "/spring/recaptcha/login",
           data: {
               memberId : memberId,
               memberPw : memberPw,
               recaptcha : recaptcha
           },
           dataType: "JSON",
           success: function(data){

               if(data.status == true){
                   location.href = "/spring/recaptcha/after?memberId="+data.member.memberId +"&memberPw=" + data.member.memberPw;
               } else {
                   alert(data.errMsg);
               }
           },
           error: function(err){
               alert("에러" + err.toString());
           }
       });

   }
});