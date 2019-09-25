<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="java.util.*,java.text.*"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<link href="../lib/layui/css/layui.css" rel="stylesheet">
<script type="text/javascript" src="../lib/layui/layui.all.js"></script>
<script src="../js/jquery-2.2.4.min.js" ></script>
<script type="text/javascript" src="../js/my.js"></script>
<script type="text/javascript" src="../js/tableSelect.js"></script>

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

<%
//Date是Jdk中的日期对象，可以精确到秒，这里取到当前的日期
Date date = new Date();
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//最后一步，利用格式化对象格式化日期对象，返回格式化的时间字符串
String formatDate=sdf.format(date);
%>

<form class="layui-form" lay-filter="myform">
<c:if test="${param.id==null}">
</c:if>
<c:if test="${param.id!=null}">
<input type="hidden" name="id" > 
</c:if>

   <div class="layui-form-item mystyle">
    <label class="layui-form-label">合同名称</label>
    <div class="layui-input-block">
      <input type="text" name="name"  autocomplete="off" placeholder="请输入合同名称" class="layui-input">
    </div>
  </div>

   <div class="layui-form-item mystyle">
    <label class="layui-form-label">客户姓名</label>
    <div class="layui-input-block">
      <select name="clientid" >
      </select>
    </div>
  </div>
  
<!--   <div class="layui-form-item mystyle mystyle">
    <label class="layui-form-label" for="meeting">创建日期</label>
    <div class="layui-input-block">
		<input  class="mydate" id="meeting" name="createdate" type="date" />
    </div>
  </div> -->
  
  <div class="layui-form-item mystyle mystyle">
    <label class="layui-form-label" for="meeting">业绩日期</label>
    <div class="layui-input-block">
		<input  class="mydate" id="meeting" name="compdate" type="date" />
    </div>
  </div>
  <div class="layui-form-item mystyle mystyle">
    <label class="layui-form-label" for="meeting">合同日期</label>
    <div class="layui-input-block">
		<input  class="mydate" id="meeting" name="orderdate" type="date" />
    </div>
  </div>
  <div class="layui-form-item mystyle mystyle">
    <label class="layui-form-label" for="meeting">开始日期</label>
    <div class="layui-input-block">
		<input  class="mydate" id="meeting" name="startdate" type="date" />
    </div>
  </div>
  <div class="layui-form-item mystyle mystyle">
    <label class="layui-form-label" for="meeting">截至日期</label>
    <div class="layui-input-block">
		<input  class="mydate" id="meeting" name="enddate" type="date" />
    </div>
  </div>
  
   <div class="layui-form-item mystyle">
    <label class="layui-form-label">合同条款</label>
    <div class="layui-input-block">
      <input type="text" name="info"  autocomplete="off" placeholder="请输入合同条款" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item mystyle">
    <label class="layui-form-label">files</label>
    <div class="layui-input-block">
      <input type="text" name="files"  autocomplete="off" placeholder="请输入files" class="layui-input">
    </div>
  </div>
  
    <div class="layui-form-item mystyle">
    <label class="layui-form-label">业绩人员</label>
    <div class="layui-input-block">
     <!--  <input type="text" name="compoperatorids"  autocomplete="off" placeholder="请输入业绩人员" class="layui-input"> -->
      <input type="text" name="compoperatornames" readonly="readonly" autocomplete="off" placeholder="请输入业绩人员" class="layui-input" id="demo">
      <input type="hidden" name="compoperatorids">
    </div>
  </div>
  
   <div class="layui-form-item mystyle">
    <label class="layui-form-label">权重</label>
    <div class="layui-input-block">
      <input type="text" name="compweight"  autocomplete="off" placeholder="请输入权重" class="layui-input">
    </div>
  </div>
  
  <!-- <div class="layui-form-item mystyle">
    <label class="layui-form-label">销售员姓名</label>
    <div class="layui-input-block">
      <select name="operatorid" >
      </select>
    </div>
  </div> -->
  
  <div class="layui-form-item mystyle">
    <label class="layui-form-label">客户状态</label>
    <div class="layui-input-block">
      <select name="status" >
      </select>
    </div>
  </div>
  
    <div class="layui-form-item mystyle">
    <label class="layui-form-label">金额</label>
    <div class="layui-input-block">
      <input type="text" name="amount"  autocomplete="off" placeholder="请输入金额" class="layui-input" oninput="value=value.replace(/[^\d]/g,'')">
    </div>
  </div>
  
  <div class="layui-form-item mystyle">
    <label class="layui-form-label">comments</label>
    <div class="layui-input-block">
      <input type="text" name="comments"  autocomplete="off" placeholder="请输入comments" class="layui-input">
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
	    getlist("getClient",{},"[name=clientid]",json.clientid);
	    getlist("getOperator",{},"[name=operatorid]",json.operatorid);
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
    getlist("getClient",{},"[name=clientid]",0);
    getlist("getOperator",{},"[name=operatorid]",0);
	
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

var tableSelect = layui.tableSelect;
tableSelect.render({
	elem: '#demo',	//定义输入框input对象 必填
	checkedKey: 'id', //表格的唯一建值，非常重要，影响到选中状态 必填
	searchKey: 'txt',	//搜索输入框的name值 默认keyword
	searchPlaceholder: '关键词搜索',	//搜索输入框的提示文字 默认关键词搜索
	table: {	//定义表格参数，与LAYUI的TABLE模块一致，只是无需再定义表格elem
		url:'../Operator/index',
		cols: [[
			{type: 'checkbox', fixed: 'left'},
		{
			field : 'id',
			title : 'ID',
			width : 100,
		},{
			field : 'name',
			title : '用户名',
			width : 100
		}]],
		parseData : function(res) {
			return {
				"code" : res.code, //解析接口状态
				"msg" : res.msg,//解析提示文本
				"count" : res.count,//解析数据长度
				"data" : res.list//解析数据列表
			}
		} 
	},
	done: function (elem, data) {
	//选择完后的回调，包含2个返回值 elem:返回之前input对象；data:表格返回的选中的数据 []
	//拿到data[]后 就按照业务需求做想做的事情啦~比如加个隐藏域放ID...
		var NEWJSON = []
		var NEWJSON1 = []
		layui.each(data.data, function (index, item) {
			NEWJSON.push(item.name)
			NEWJSON1.push(item.id)
			})
		elem.val(NEWJSON.join(","))
		$("[name=compoperatorids]").val(NEWJSON1.join(","));
	}
	
	
})
</script>
</body>
</html>