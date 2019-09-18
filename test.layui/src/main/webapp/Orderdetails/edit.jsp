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
</style>


<form class="layui-form" lay-filter="myform">
<c:if test="${param.id==null}">
</c:if>
<c:if test="${param.id!=null}">
<input type="hidden" name="id" > 
</c:if>

  <div class="layui-form-item mystyle">
    <label class="layui-form-label">合同名称</label>
    <div class="layui-input-block">
      <select name="orderid" >
      </select>
    </div>
  </div>
  <div class="layui-form-item mystyle">
    <label class="layui-form-label">产品名称</label>
    <div class="layui-input-block">
      <select name="productid" >
      </select>
    </div>
  </div>
	
   <div class="layui-form-item mystyle">
    <label class="layui-form-label">数量</label>
    <div class="layui-input-block">
      <input type="text" name="count"  autocomplete="off" placeholder="请输入数量" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item mystyle">
    <label class="layui-form-label">金额</label>
    <div class="layui-input-block">
      <input type="text" name="amount"  autocomplete="off" placeholder="请输入金额" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item mystyle">
    <label class="layui-form-label">折扣</label>
    <div class="layui-input-block">
      <input type="text" name="desc"  autocomplete="off" placeholder="请输入折扣" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item mystyle">
    <label class="layui-form-label">评论</label>
    <div class="layui-input-block">
      <input type="text" name="comments"  autocomplete="off" placeholder="请输入评论" class="layui-input">
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
	    getlist("getProduct",{},"[name=productid]",json.productid);
	    getlist("getOrder",{},"[name=orderid]",json.orderid);
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
    getlist("getProduct",{},"[name=productid]",0);
    getlist("getOrder",{},"[name=orderid]",0);
	
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