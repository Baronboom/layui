<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<link href="../lib/layui/css/layui.css" rel="stylesheet">
<script type="text/javascript" src="../lib/layui/layui.all.js"></script>
<script src="../js/jquery-2.2.4.min.js" ></script>
<script type="text/javascript" src="../js/my.js"></script>

<title></title>
</head>
<body>
<style>
.layui-input{width:200px;}

</style>


<form class="layui-form" lay-filter="myform">
<c:if test="${param.id==null}">
</c:if>
<c:if test="${param.id!=null}">
<input type="hidden" name="id" > 
</c:if>

   <div class="layui-form-item">
    <label class="layui-form-label">客户姓名</label>
    <div class="layui-input-block">
      <input type="text" name="cmid"  autocomplete="off" placeholder="请输入姓名" class="layui-input">
    </div>
  </div>
  
   <div class="layui-form-item">
    <label class="layui-form-label">通话内容</label>
    <div class="layui-input-block">
      <input type="text" name="info"  autocomplete="off" placeholder="请输入姓名" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">客户状态</label>
    <div class="layui-input-block">
      <select name="status" >
      </select>
    </div>
  </div>

  <div class="layui-form-item mystyle">
    <label class="layui-form-label" for="meeting">通话日期</label>
    <div class="layui-input-block">
		<input  class="mydate"  name="date" type="date" />
    </div>
  </div>
  
  <div class="layui-form-item mystyle">
    <label class="layui-form-label" for="meeting">预约时间</label>
    <div class="layui-input-block">
		<input  class="mydate"  name="nextdate" type="date" />
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">销售员姓名</label>
    <div class="layui-input-block">
      <input type="text" name="smid"  autocomplete="off" placeholder="请输入姓名" class="layui-input">
    </div>
  </div>
  
   <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit="" lay-filter="demo1">保存</button>
    </div>
  </div>
</form>
<!-- layui.use(['form',], function(){ -->
<script type="text/javascript">


var id="${param.id}";
function init(){
	 /* s */
	$.post("edit",{id:id}, function(json) {
		alert(json.smid);
		alert(json.cmid);
		render('myform', json);
		 /* s */
	    getarray("getStas",{},"[name=status]",json.status);
	    getlist("getSellman",{},"[name=smid]",json.smid);
	    getlist("getCus",{},"[name=cmid]",json.cmid);
	},"json");
	
}
if(id.length>0){
	init();
	layui.use('form', function(){
		  var form = layui.form;
		  form.on('submit(demo1)', function(data){
			  /* s */
			  $.post("update", data.field, function(json) {
				  
				  closeFrame();
				  parent.fresh('demo');
				}, "json");
			    
			    return false;
			  });
	});
}else{
	 /* s */
	getarray("getStas",{},"[name=status]",0);
    getlist("getSellman",{},"[name=smid]",0);
    getlist("getCus",{},"[name=cmid]",0);
	
	layui.use('form', function(){
		  var form = layui.form;
		  form.on('submit(demo1)', function(data){
			 /* s */
			  $.post("insert", data.field, function(json) {
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