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
	
	<!-- <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a> -->
	<script type="text/html" id="barDemo">
		<a class="layui-btn layui-btn-xs" lay-event="edit">查看</a>
	    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="rev">分配自己</a>
	</script>
		<!--自增索引 -->
	<script type="text/html" id="zizeng">
		{{d.LAY_TABLE_INDEX+1}}
	</script>
	<script type="text/html" id="toolbarDemo">
	   <div class="layui-btn-container">
     	  <div class="layui-input-inline">
      	  <input type="text" name="txt" lay-verify="title"  autocomplete="off" placeholder="请输入客户姓名" class="layui-input input">
     	  </div>
    	  <button class="layui-btn layui-btn-sm" lay-event="search">查询</button>
    	  <button class="layui-btn layui-btn-sm" lay-event="allocationAll">批量分配给自己</button>
  	  </div>
	</script>

	<script>
		layui.use('table', function() {
			var table = layui.table;

			//第一个实例
			table.render({
				elem : '#demo',
				height : 462,
				url : 'publicpool' //数据接口
				,
				toolbar : '#toolbarDemo',
				page : true //开启分页
				,
				cols : [ [ //表头
				{
					title : 'ID',
					width : 120,
					sort : true,
					//fixed : 'left',
					type:'checkbox'
				},{
					field : 'zizeng',
					title : '编号',
					width : 90,
					sort : true,
					//fixed : 'left',
					type:'numbers'
				}, {
					field : 'name',
					title : '客户姓名',
					width : 120
				}, {
					field : 'sexss',
					title : '性别',
					width : 120
				}, {
					field : 'tel',
					title : '电话',
					width : 120
				}/* , {
					field : 'qq',
					title : 'QQ',
					width : 120
				}, {
					field : 'email',
					title : '邮箱',
					width : 140
				} */, {
					field : 'infos',
					title : '额外信息',
					width : 120
				}/* , {
					field : 'clientstatuss',
					title : '客户状态',
					width : 120
				}, {
					field : 'linkstatuss',
					title : '电话状态',
					width : 120
				}, {
					field : 'purposestatuss',
					title : '意向状态',
					width : 120
				}, {
					field : 'assessstatuss',
					title : '评估状态',
					width : 120
				}, {
					field : 'execstatuss',
					title : '处理状态',
					width : 120
				}, {
					field : 'statuss',
					title : '信息状态',
					width : 120
				}, {
					field : 'clienttypename',
					title : '客户类型',
					width : 120
				}, {
					field : 'createoperatorname',
					title : '创建人',
					width : 120
				}, {
					field : 'srcname',
					title : '信息来源',
					width : 120
				}, {
					field : 'operatornames',
					title : '处理人',
					width : 120
				} */, {
					field : 'count',
					title : '回访次数',
					width : 120
				} , {
					field : 'comments',
					title : 'comments',
					width : 120
				}, {
					field : 'createdate',
					title : '创建时间',
					width : 120
				} , {
					fixed : 'right',
					title : '操作',
					toolbar : '#barDemo',
					width : 160,
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
			
			var ids = [];
		  	layui.table.on('checkbox(test)', function(obj){
		 		var id = obj.data.id;
		 		var t = 1;
		 		for(var j=0;j<ids.length;j++) {
		 			if(ids[j] == id) {
		 				ids.splice(j,1);
		 				t = 0;
		 			}
		 		}
		 		if(t == 1){
		 			ids.push(id);
		 			t = 1;
		 		}
		 		
		 		/* console.log(obj.data.id); //选中行的相关数据
		 		console.log(obj.checked); //当前是否选中状态
		 		console.log(obj.type); //如果触发的是全选，则为：all，如果触发的是单选，则为：one */
		 	});

			//obj 行      obj.data 行数据    data.id 列
			//test  是table的lay-filter="test" 属性
			table.on('tool(test)', function(obj) {
				var data = obj.data;
				if (obj.event === 'rev') { ///lay-event 属性
					//myconfirm("确认对其回访？", function() { // 删除
						
						/* $.post("delete", {
							id : data.id
						}, function(json) {
							//reload('demo'); 
							obj.del();
							layer.close(layer.index);
						}, "json"); */
						openFrame('pubfenpei.jsp?ids=' + data.id); // 分配自己
					//});
				} else {
					openFrame('Newfenpeiedit.jsp?id=' + data.id); // 查看
				}
			});

			table.on('toolbar(test)', function(obj) {
				if (obj.event === 'search') { // 查询
					var txt = $(event.target).prev().find("input").val();
					reload('demo', {
						txt : txt
					});
				} else if(obj.event === 'allocationAll'){
					openFrame('pubfenpei.jsp?ids='+ids); // 批量分配
				} else {
					openFrame("cc.jsp"); 
				}
			});

		});
	</script>
</body>
</html>