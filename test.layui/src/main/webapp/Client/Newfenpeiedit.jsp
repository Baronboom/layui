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


<form class="layui-form" lay-filter="myform">
<c:if test="${param.id==null}">
</c:if>
<c:if test="${param.id!=null}">
<input type="hidden" name="id" > 
</c:if>

   <!-- <div class="layui-form-item mystyle">
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
    <input class="layui-input" name="tel" autocomplete="off" type="text" placeholder="请输入客户电话" oninput="value=value.replace(/[^\d]/g,'')" maxlength=11></input>
    </div>
  </div> -->
   <div class="layui-form-item mystyle">
    <label class="layui-form-label">QQ</label>
    <div class="layui-input-block">
     <!-- <input type="text" name="qq"  autocomplete="off" placeholder="请输入客户QQ" class="layui-input"> -->
     <input type="text" name="qq" class="layui-input" readonly="readonly" autocomplete="off" placeholder="请输入客户QQ"  oninput="value=value.replace(/[^\d]/g,'')"/>
    </div>
  </div>
   <div class="layui-form-item mystyle">
    <label class="layui-form-label">邮箱</label>
    <div class="layui-input-block">
      <!-- <input type="text" name="email"  autocomplete="off" placeholder="请输入客户邮箱" class="layui-input"> -->
   	<input type="email" name="email" readonly="readonly" autocomplete="off" placeholder="请输入客户邮箱" class="layui-input" />
    </div>
  </div>
   <!-- <div class="layui-form-item mystyle">
    <label class="layui-form-label">额外信息</label>
    <div class="layui-input-block">
      <input type="text" name="infos"  autocomplete="off" placeholder="请输入客户额外信息" class="layui-input">
    </div>
  </div> -->
  
   <div class="layui-form-item mystyle">
    <label class="layui-form-label">客户状态</label>
    <div class="layui-input-block">
      <select name="clientstatus" disabled="disabled" >
      </select>
    </div>
  </div>
   <div class="layui-form-item mystyle">
    <label class="layui-form-label">电话状态</label>
    <div class="layui-input-block">
      <select name="linkstatus" disabled="disabled">
      </select>
    </div>
  </div>
   <div class="layui-form-item mystyle">
    <label class="layui-form-label">意向状态</label>
    <div class="layui-input-block">
      <select name="purposestatus" disabled="disabled">
      </select>
    </div>
  </div>
   <div class="layui-form-item mystyle">
    <label class="layui-form-label">评估状态</label>
    <div class="layui-input-block">
      <select name="assessstatus" disabled="disabled">
      </select>
    </div>
  </div>
   <div class="layui-form-item mystyle">
    <label class="layui-form-label">处理状态</label>
    <div class="layui-input-block">
      <select name="execstatus" disabled="disabled">
      </select>
    </div>
  </div>
   <div class="layui-form-item mystyle">
    <label class="layui-form-label">信息状态</label>
    <div class="layui-input-block">
      <select name="status" disabled="disabled">
      </select>
    </div>
  </div>
  
   <div class="layui-form-item mystyle">
    <label class="layui-form-label">客户类型</label>
    <div class="layui-input-block">
      <select name="clienttypeid" disabled="disabled">
      </select>
    </div>
  </div>
  
    <div class="layui-form-item mystyle">
    <label class="layui-form-label">创建人</label>
    <div class="layui-input-block">
      <select name="createoperatorid" disabled="disabled">
      </select>
    </div>
  </div>
  
   <div class="layui-form-item mystyle">
    <label class="layui-form-label">信息来源</label>
    <div class="layui-input-block">
      <select name="srcid" disabled="disabled">
      </select>
    </div>
  </div>

   <!-- <div class="layui-form-item mystyle">
    <label class="layui-form-label">处理人</label>
    <div class="layui-input-block">
      <input type="text" name="operatornames" readonly="readonly"  autocomplete="off" placeholder="请输入处理人" class="layui-input" id="demo">
   	 <input type="hidden" name="operatorids">
    </div>
  </div>
   <div class="layui-form-item mystyle">
    <label class="layui-form-label">回访次数</label>
    <div class="layui-input-block">
      <input type="text" name="count"  autocomplete="off" placeholder="请输入回访次数" class="layui-input">
   <input type="text" name="count" autocomplete="off" placeholder="请输入回访次数" class="layui-input" oninput="value=value.replace(/[^\d]/g,'')"/>
    </div>
  </div> -->
  <!-- <div class="layui-form-item mystyle">
    <label class="layui-form-label">comments</label>
    <div class="layui-input-block">
      <input type="text" name="comments"  autocomplete="off" placeholder="comments" class="layui-input">
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
  </div> -->
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
		$("[name=operatorids]").val(NEWJSON1.join(","));
	}
	
	
})

</script>
</body>
</html>