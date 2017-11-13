//后端访问地址的前缀
var baseUrl = 'http://localhost/hr';

//全局ajax事件,处理ajax超时事件

$.ajaxSetup({
	complete: function(xhr, textStatus) {
		//通过ajax核心对象获得响应报头
		var sessionStatus = xhr.getResponseHeader('sessionStatus');

		if (sessionStatus == 'timeout') {
			layer.msg('登录超时,请重新登录!');
			setTimeout(function() {
				location.href = baseUrl + '/logout.jsp';
			}, 1000);
			return false;

		}

	}
});