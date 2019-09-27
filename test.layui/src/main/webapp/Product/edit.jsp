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
<script type="text/javascript" src="../js/mysmall.js"></script>

<title></title>
</head>
<body>
<style>
.layui-input{width:200px;}
</style>


<form class="layui-form" lay-filter="myform">
<c:if test="${param.id==null}">
<!-- <input type="hidden" name="cmd" value="insert"> -->
</c:if>
<c:if test="${param.id!=null}">
<!-- <input type="hidden" name="cmd" value="update">-->
<input type="hidden" name="id" > 
</c:if>
  <div class="layui-form-item">
    <label class="layui-form-label">产品名称</label>
    <div class="layui-input-block">
      <input type="text" name="name" lay-verify="required" autocomplete="off" placeholder="请输入标题" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">金额</label>
    <div class="layui-input-block">
      <!-- <input type="text" name="amount"  autocomplete="off" placeholder="请输入标题" class="layui-input"> -->
      <!-- <input type="text" name="amount" class="inp" value="0" onkeyup="if(event.keyCode !=37 && event.keyCode != 39){if (!/^[\d]+$/ig.test(this.value)){this.value='';}}"/> -->
     <input type="text" class="layui-input" lay-verify="required" placeholder="请输入金额" name="amount" oninput="inputnum(this)">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">产品描述</label>
    <div class="layui-input-block">
      <input type="text" name="info" lay-verify="required" autocomplete="off" placeholder="请输入标题" class="layui-input">
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

function inputnum(obj,val){
    obj.value = obj.value.replace(/[^\d.]/g,""); //清除"数字"和"."以外的字符
    obj.value = obj.value.replace(/^\./g,""); //验证第一个字符是数字
    obj.value = obj.value.replace(/\.{2,}/g,""); //只保留第一个, 清除多余的
    obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
    obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3'); //只能输入两个小数
}

var id="${param.id}";
function init(){
	 /* s */
	$.post("edit",{id:id}, function(json) {
		render('myform', json);
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