// 根据省查找市
function find_CITY(obj) {
	var PROVINCEID = $(obj).val();
	$.ajax({
		type : "post",
		url : "location/findCityByPro",
		data : {
			"PROVINCEID" : PROVINCEID
		},
		dataType : "json",
		success : function(data) {
			if (data == "{}" ) {
				alert("查询数据不存在");
			} else {
				$("#areaid").html("");
				var str = "<option value='" + '' + "'>" + '选择区域' + "</option>";
				$("#areaid").append(str);
				$("#cityid").html("");
				var str = "<option value='" + '' + "'>" + '选择市区' + "</option>";
				$("#cityid").append(str);
				$.each(data, function(i, item) {
					str = "<option value='" + item.cityid + "'>"
							+ item.cityname + "</option>";
					$("#cityid").append(str);
				});
			}
		},
		error : function() {
			alert("请选择省份！");
			//add by niehy 2017/8/8 begin
			$("#cityid").html("");
			var str = "<option value='" + '' + "'>" + '请选择市' + "</option>";
			$("#cityid").append(str);
			$("#areaid").html("");
			var str = "<option value='" + '' + "'>" + '请选择区' + "</option>";
			$("#areaid").append(str);
			//add by niehy 2017/8/8 end
		}
	});
}

// 根据市查区
function find_AREA(obj) {
	var CITYID = $(obj).val();
	$.ajax({
		type : "post",
		url : "location/findAreaByCity",
		data : {
			"CITYID" : CITYID
		},
		dataType : "json",
		success : function(data) {
			if (data == "{}") {
				alert("查询数据不存在");
			} else {
				$("#areaid").html("");
				var str = "<option value='" + '' + "'>" + '选择区域' + "</option>";
				$("#areaid").append(str);
				$.each(data, function(i, item) {
					str = "<option value='" + item.areaid + "'>"
							+ item.areaname + "</option>";
					$("#areaid").append(str);
				});
			}
		},
		error : function() {
			//add by niehy 2017/8/8 begin
			$("#areaid").html("");
			var str = "<option value='" + '' + "'>" + '请选择区' + "</option>";
			$("#areaid").append(str);
			//add by niehy 2017/8/8 end
		}
	});
}

// 根据运营商找站 
function find_CS(obj) {
	var OPERATORID = $(obj).val();
	if (!OPERATORID) {
		return;
	}
	$
			.ajax({
				type : "post",
				url : "operator/findCSByOper",
				data : {
					"OPERATORID" : OPERATORID
				},
				dataType : "json",
				success : function(data) {

					if (data == "{}") {
						alert("查询数据不存在");
					} else {
						$("#csid").html("");
						var str = "<option value='" + '' + "'>" + '选择充电站'
								+ "</option>";
						$("#csid").append(str);
						$.each(data, function(i, item) {
							str = "<option value='" + item.csid + "'>"
									+ item.csname + "</option>";
							$("#csid").append(str);
						});
					}
				},
				error : function() {
					alert("请与管理员联系");
				}
			});
}
