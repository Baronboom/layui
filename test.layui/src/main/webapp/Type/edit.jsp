<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<link href="../layui/css/layui.css" rel="stylesheet">
<script type="text/javascript" src="../layui/layui.all.js"></script>
<script src="../js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="../js/my.js"></script>

<title></title>
</head>
<body>
<style>
.layui-input{width:200px;}
</style>


<form class="layui-form" lay-filter="myform">
  <div class="layui-form-item">
    <label class="layui-form-label">名称</label>
    <div class="layui-input-block">
      <input type="text" name="name"  autocomplete="off" placeholder="请输入标题" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit="" lay-filter="demo1">保存</button>
    </div>
  </div>
</form>
<script type="text/javascript">


var id="${param.id}";
function init(){
	$.post("edit/"+id,{_method:"GET"}, function(json) {
		render('myform', json);
		getlist("getTypes", {_method:"GET"}, "[name=typeid]", json.typeid);
	},"json");
	
}
if(id.length>0){
	init();
	layui.use('form', function(){
		  var form = layui.form;
		  form.on('submit(demo1)', function(data){
			  var s = ""+id;
			  data.field._method="PUT";
			  $.post(s, data.field, function(json) {
				  closeFrame();
				  parent.fresh('demo');
				}, "json");
			    
			    return false;
			  });
	});
}else{
	
	layui.use('form', function(){
		  var form = layui.form;
		  form.on('submit(demo1)', function(data){
			 /* layui默认发送请求的方式是post 
			 data.field._method="POST"; 
			 上面这行代码可省略 */
			 
			 // 下面代码里的insert/，是与控制层里的@PostMapping("insert")对应
			 $.post("insert/", data.field, function(json) {
				  closeFrame();
				  parent.fresh('demo');
				}, "json");
			    
			    return false;
			  });
	});
}

</script>
</body>
</html>