<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="../lib/layui/css/layui.css" rel="stylesheet">
<script type="text/javascript" src="../lib/layui/layui.all.js"></script>
<script src="../js/jquery-2.2.4.min.js" ></script>
<script type="text/javascript" src="../js/my.js"></script>
<script type="text/javascript" src="../js/tableSelect.js"></script>
<title>Insert title here</title>
</head>
<body>
<%-- ${param.ids} --%>

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


   <input type="hidden" name="ids" value="${param.ids}"> 
   <div class="layui-form-item mystyle">
    <label class="layui-form-label">处理人</label>
    <div class="layui-input-block">
      <input type="text" name="operatornames" readonly="readonly" value="公共池" autocomplete="off" placeholder="请输入处理人" class="layui-input" id="demo">
   	 <input type="hidden" name="operatorids" value="4">
    </div>
  </div>
  
   <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit="" lay-filter="demo1">保存</button>
    </div>
  </div>
</form>

<script type="text/javascript">
/* var id="${param.id}";
alert(id); */
layui.use('form', function(){
	  var form = layui.form;
	  form.on('submit(demo1)', function(data){
		  /* s */
		  $.post("updateonpl", data.field, function(json) {
			  
			  closeFrame();
			  parent.fresh('demo');
			}, "json");
		    
		    return false;
		  });
});


</script>

</body>
</html>