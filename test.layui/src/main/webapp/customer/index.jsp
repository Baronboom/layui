<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<link href="../lib/layui/css/layui.css" rel="stylesheet">
<script type="text/javascript" src="../lib/layui/layui.all.js"></script>
<script src="../js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="../js/my.js"></script>
<title></title>
<style type="text/css">
.input {
	font-size: 16px;
	width: 200px;
	height: 30px;
	margin-top: -10px;
	margin-right: 10px;
	width: 200px;
}

.layui-form-select {
	width: 200px;
}
</style>
</head>
<body>
	<table id="demo" lay-filter="test"></table>
	
	<script type="text/html" id="barDemo">
		<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>
		<!--自增索引 -->
	<script type="text/html" id="zizeng">
		{{d.LAY_TABLE_INDEX+1}}
	</script>
	<script type="text/html" id="toolbarDemo">
	   <div class="layui-btn-container">
     	  <div class="layui-input-inline">
      	  <input type="text" name="txt" lay-verify="title"  autocomplete="off" placeholder="请输入名称" class="layui-input input">
     	  </div>
    	  <button class="layui-btn layui-btn-sm" lay-event="search">查询</button>
    	  <button class="layui-btn layui-btn-sm" lay-event="add">新增</button>
  	  </div>
	</script>

	<script>
		layui.use('table', function() {
			var table = layui.table;

			//第一个实例
			table.render({
				elem : '#demo',
				height : 462,
				url : 'index' //数据接口  /* s */
				,
				toolbar : '#toolbarDemo',
				page : true //开启分页
				,
				cols : [ [ //表头
				{
					field : 'zizeng',
					title : '编号',
					width : 80,
					sort : true,
					fixed : 'left',
					type:'numbers'
				}, {
					field : 'csrname',
					title : '客户名',
					width : 190
				},{
					field : 'csrtel',
					title : '客户电话',
					width : 280
				}, {
					field : 'csrsta',
					title : '客户状态',
					width : 180
				}, {
					field : 'sellname',
					title : '销售员',
					width : 180
				}, {
					fixed : 'right',
					title : '操作',
					toolbar : '#barDemo',
					width : 150,
					align : 'center'
				}

				] ],
				parseData : function(res) {
					return {
						"code" : res.code,
						"msg" : res.msg,
						"count" : res.count,
						data : res.list
					}
				}
			});

			//obj 行      obj.data 行数据    data.id 列
			//test  是table的lay-filter="test" 属性
			table.on('tool(test)', function(obj) {
				var data = obj.data;
				if (obj.event === 'del') { ///lay-event 属性

					myconfirm("刪除？", function() { // 删除
						 /* s */
						$.post("delete", {
							id : data.id
						}, function(json) {
							/* reload('demo'); */
							obj.del();
							layer.close(layer.index);
						}, "json");
					});
				} else {
					openFrame('edit.jsp?id=' + data.id); // 修改
				}
			});

			table.on('toolbar(test)', function(obj) {
				if (obj.event === 'search') { // 查询
					var txt = $(event.target).prev().find("input").val();
					reload('demo', {
						txt : txt
					});
				} else {
					openFrame("edit.jsp"); // 新增
				}
			});

		});
	</script>
</body>
</html>