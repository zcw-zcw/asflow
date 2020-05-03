function creat(){
			  layer.open({
            title: '创建项目',
            closeBtn: 1,
			shadeClose: true,
            type: 2,
            area: ['400px', '250px'],
            fixed: false, //不固定
            maxmin: true,
            content: '/creat',

        });
		}
		function xinxi(){
			layer.open({
			    title: '修改信息',
			    closeBtn: 1,
				shadeClose: true,
			    type: 2,
			    area: ['300px', '350px'],
			    fixed: false, //不固定
			    maxmin: true,
			    content: '/xinxi',
			
			});
		}
		
		layui.use('element', function() {
			var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
			//监听导航点击
			element.on('nav(demo)', function(elem) {
				//console.log(elem)
				layer.msg(elem.text());
			});
		});
		
		function mail(){
			layer.open({
			    title: '发送邮件',
			    closeBtn: 1,
				shadeClose: true,
			    type: 2,
			    area: ['350px', '350px'],
			    fixed: false, //不固定
			    maxmin: true,
			    content: '/mail',
			
			});
		}
		function layout() {
			sessionStorage.clear();
			location="/login";
		}
function getParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg);  //匹配目标参数
	if (r != null) return decodeURI(r[2]); return null; //返回参数值
}

if(sessionStorage.getItem("uid")==''||sessionStorage.getItem("uid")==null){
	location="/login";
}

function check(i) {
	$.ajax({
		url:"/project/check",
		type:"get",
		data:{pid:getParam("pid")},
		success:function (msg) {
			if (msg.code == 100) {
				if (msg.data.project.stage > i) {

					return false;

				}
			} else {
				return true;
			}
			}
		})}

