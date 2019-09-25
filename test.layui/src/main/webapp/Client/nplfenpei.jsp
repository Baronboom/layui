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
      <input type="text" name="operatornames" readonly="readonly"  autocomplete="off" placeholder="请输入处理人" class="layui-input" id="demo">
   	 <input type="hidden" name="operatorids">
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


var tableSelect = layui.tableSelect;
tableSelect.render({
	elem: '#demo',	//定义输入框input对象 必填
	checkedKey: 'id', //表格的唯一建值，非常重要，影响到选中状态 必填
	searchKey: 'txt',	//搜索输入框的name值 默认keyword
	searchPlaceholder: '关键词搜索',	//搜索输入框的提示文字 默认关键词搜索
	table: {	//定义表格参数，与LAYUI的TABLE模块一致，只是无需再定义表格elem
		url:'../Operator/newpublicindex',
		cols: [[
			{type: 'checkbox', fixed: 'left'},
		/* {
			field : 'id',
			title : 'ID',
			width : 100,
		}, */{
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