<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 图片标签 start -->
	<img src="GetLoginCard" />
	<!-- 图片标签 end -->
	<script type="text/javascript" src="js/jquery-1.11.2.min.js"> </script>
	<!-- 定时器在不断访问result结果  start-->
	<script type="text/javascript" >
		window.onload=function(){
			var timer = setInterval(function(){
				$.ajax({
					type:"post",
					url:"Verify",
					success:function(data){
						eval(data);
						if(obj.result){
							alert("扫码登录成功");
							clearInterval(timer);
						}
					}
				})
			}, 1000); //定时器的刷新时间
		}
	</script>
	<!-- 定时器在不断访问result结果  end -->
</body>
</html>