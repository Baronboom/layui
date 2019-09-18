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
    <label class="layui-form-label">客户姓名</label>
    <div class="layui-input-block">
      <input type="text" name="name"  autocomplete="off" placeholder="请输入客户姓名" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item mystyle">
    <label class="layui-form-label">性别</label>
    <div class="layui-input-block">
      <select name="sex" >
      </select>
    </div>
  </div>
   <div class="layui-form-item mystyle">
    <label class="layui-form-label">电话</label>
    <div class="layui-input-block">
      <input type="text" name="tel"  autocomplete="off" placeholder="请输入客户电话" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item mystyle">
    <label class="layui-form-label">QQ</label>
    <div class="layui-input-block">
     <input type="text" name="qq"  autocomplete="off" placeholder="请输入客户QQ" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item mystyle">
    <label class="layui-form-label">邮箱</label>
    <div class="layui-input-block">
      <input type="text" name="email"  autocomplete="off" placeholder="请输入客户邮箱" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item mystyle">
    <label class="layui-form-label">额外信息</label>
    <div class="layui-input-block">
      <input type="text" name="infos"  autocomplete="off" placeholder="请输入客户额外信息" class="layui-input">
    </div>
  </div>
  
   <div class="layui-form-item mystyle">
    <label class="layui-form-label">客户状态</label>
    <div class="layui-input-block">
      <select name="clientstatus" >
      </select>
    </div>
  </div>
   <div class="layui-form-item mystyle">
    <label class="layui-form-label">电话状态</label>
    <div class="layui-input-block">
      <select name="linkstatus" >
      </select>
    </div>
  </div>
   <div class="layui-form-item mystyle">
    <label class="layui-form-label">意向状态</label>
    <div class="layui-input-block">
      <select name="purposestatus" >
      </select>
    </div>
  </div>
   <div class="layui-form-item mystyle">
    <label class="layui-form-label">评估状态</label>
    <div class="layui-input-block">
      <select name="assessstatus" >
      </select>
    </div>
  </div>
   <div class="layui-form-item mystyle">
    <label class="layui-form-label">处理状态</label>
    <div class="layui-input-block">
      <select name="execstatus" >
      </select>
    </div>
  </div>
   <div class="layui-form-item mystyle">
    <label class="layui-form-label">信息状态</label>
    <div class="layui-input-block">
      <select name="status" >
      </select>
    </div>
  </div>
  
   <div class="layui-form-item mystyle">
    <label class="layui-form-label">客户类型</label>
    <div class="layui-input-block">
      <select name="clienttypeid" >
      </select>
    </div>
  </div>
   <div class="layui-form-item mystyle">
    <label class="layui-form-label">创建人</label>
    <div class="layui-input-block">
      <select name="createoperatorid" >
      </select>
    </div>
  </div>
   <div class="layui-form-item mystyle">
    <label class="layui-form-label">信息来源</label>
    <div class="layui-input-block">
      <select name="srcid" >
      </select>
    </div>
  </div>

   <div class="layui-form-item mystyle">
    <label class="layui-form-label">operatorids</label>
    <div class="layui-input-block">
      <input type="text" name="operatorids"  autocomplete="off" placeholder="请输入operatorids" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item mystyle">
    <label class="layui-form-label">回访次数</label>
    <div class="layui-input-block">
      <input type="text" name="count"  autocomplete="off" placeholder="请输入回访次数" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item mystyle">
    <label class="layui-form-label">comments</label>
    <div class="layui-input-block">
      <input type="text" name="comments"  autocomplete="off" placeholder="请输入回访次数" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item mystyle">
    <label class="layui-form-label" for="meeting">创建时间</label>
    <div class="layui-input-block">
		<input  class="mydate" id="meeting" name="createdate" type="date" />
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
	    getarray("getSexs",{},"[name=sex]",json.sex);
		getarray("getStas",{},"[name=status]",json.status);
		getarray("getLinkstatus",{},"[name=linkstatus]",json.linkstatus);
		getarray("getClientstatus",{},"[name=clientstatus]",json.clientstatus);
		getarray("getPurposestatus",{},"[name=purposestatus]",json.purposestatus);
		getarray("getAssessstatus",{},"[name=assessstatus]",json.assessstatus);
		getarray("getExecstatus",{},"[name=execstatus]",json.execstatus);
	    getlist("getClienttype",{},"[name=clienttypeid]",json.clienttypeid);
	    getlist("getOperator",{},"[name=createoperatorid]",json.createoperatorid);
	    getlist("getSrc",{},"[name=srcid]",json.srcid);
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
	getarray("getSexs",{},"[name=sex]",0);
	getarray("getStas",{},"[name=status]",0);
	getarray("getLinkstatus",{},"[name=linkstatus]",0);
	getarray("getClientstatus",{},"[name=clientstatus]",0);
	getarray("getPurposestatus",{},"[name=purposestatus]",0);
	getarray("getAssessstatus",{},"[name=assessstatus]",0);
	getarray("getExecstatus",{},"[name=execstatus]",0);
    getlist("getClienttype",{},"[name=clienttypeid]",0);
    getlist("getOperator",{},"[name=createoperatorid]",0);
    getlist("getSrc",{},"[name=srcid]",0);
	
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