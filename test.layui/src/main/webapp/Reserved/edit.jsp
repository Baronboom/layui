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
.mydate{
height: 36px;
width: 198px;
border: 1px solid rgba(220,220,220);
}
.mystyle{
display: inline-block;
position: left;
}
.mydate{
height: 36px;
width: 198px;
border: 1px solid rgba(220,220,220);
}
</style>


<form class="layui-form" lay-filter="myform">
<c:if test="${param.id==null}">
</c:if>
<c:if test="${param.id!=null}">
<input type="hidden" name="id" > 
</c:if>

   <div class="layui-form-item mystyle">
    <label class="layui-form-label">客户姓名</label>
    <div class="layui-input-block">
     <select name="clientid" >
      </select>
    </div>
  </div>
   <div class="layui-form-item mystyle">
    <label class="layui-form-label">回访名称</label>
    <div class="layui-input-block">
     <select name="revisitid" >
      </select>
    </div>
  </div>
  
  <div class="layui-form-item mystyle">
    <label class="layui-form-label" for="meeting">预约时间</label>
    <div class="layui-input-block">
		<input  class="mydate" id="meeting" name="date" type="date" />
    </div>
  </div>
  
  
   <div class="layui-form-item mystyle">
    <label class="layui-form-label">预约处理人</label>
    <div class="layui-input-block">
     <select name="execoperatorid" >
      </select>
    </div>
  </div>
  
  <div class="layui-form-item mystyle">
    <label class="layui-form-label">类型</label>
    <div class="layui-input-block">
      <select name="type" >
      </select>
    </div>
  </div>
  <div class="layui-form-item mystyle">
    <label class="layui-form-label">状态</label>
    <div class="layui-input-block">
      <select name="status" >
      </select>
    </div>
  </div>
  <div class="layui-form-item mystyle">
    <label class="layui-form-label">执行状态</label>
    <div class="layui-input-block">
      <select name="execstatsu" >
      </select>
    </div>
  </div>
  
  <div class="layui-form-item mystyle">
    <label class="layui-form-label">结果</label>
    <div class="layui-input-block">
       <input type="text" name="result"  autocomplete="off" placeholder="请输入result" class="layui-input">
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
		render('myform', json);
		 /* s */
	    getarray("getStas",{},"[name=status]",json.status);
		getarray("getTypes",{},"[name=type]",json.type);
		getarray("getExecstatsus",{},"[name=execstatsu]",json.execstatsu);
		
	    getlist("getClient",{},"[name=clientid]",json.clientid);
	    getlist("getRevisit",{},"[name=revisitid]",json.revisitid);
	    getlist("getExecoperator",{},"[name=execoperatorid]",json.execoperatorid);
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
	getarray("getTypes",{},"[name=type]",0);
	getarray("getExecstatsus",{},"[name=execstatsu]",0);
	
	 getlist("getClient",{},"[name=clientid]",0);
	 getlist("getRevisit",{},"[name=revisitid]",0);
	 getlist("getExecoperator",{},"[name=execoperatorid]",0);
	
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