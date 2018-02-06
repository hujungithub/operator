
//********************************************************************************//
function select_CITY(obj) {
	var PROVINCEID = $(obj).val();
//	if (!PROVINCEID)
//		return;
	$.ajax({
		type : "post",
		url : "location/findCityByPro",
		data : {
			"PROVINCEID" : PROVINCEID
		},
		dataType : "json",
		success : function(data) {
			if (data == "{}") {
				alert("查询数据不存在");
			} else {
				// 点击省查询市 清空区
				$("#AREAID").html("");
				var str = "<option value='" + '' + "'>" + '选择区域' + "</option>";
				$("#AREAID").append(str);
				$("#CITYID").html("");
				str = "<option value='" + '' + "'>" + '选择市区' + "</option>";
				$("#CITYID").append(str);
				$.each(data, function(i, item) {
					str = "<option value='" + item.cityid + "'>"
							+ item.cityname + "</option>";
					$("#CITYID").append(str);
				});
			}
		},
		error : function() {
			alert("请选择省份！");
			$("#CITYID").html("");
			str = "<option value='" + '' + "'>" + '请选择市' + "</option>";
			$("#CITYID").append(str);
			$("#AREAID").html("");
			var str = "<option value='" + '' + "'>" + '请选择区' + "</option>";
			$("#AREAID").append(str);
		}
	});
}

// 查区
function select_AREA(obj) {
	var CITYID = $(obj).val();
	if (!CITYID)
		return;
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
				$("#AREAID").html("");
				var str = "<option value='" + '' + "'>" + '选择区县' + "</option>";
				$("#AREAID").append(str);
				$.each(data, function(i, item) {
					str = "<option value='" + item.areaid + "'>"
							+ item.areaname + "</option>";
					$("#AREAID").append(str);
				});
			}
		},
		error : function() {
			$("#AREAID").html("");
			var str = "<option value='" + '' + "'>" + '请选择区' + "</option>";
			$("#AREAID").append(str);
		}
	});

}
// 查地址
function select_ADDRESS(obj) {
	var AREAID = $(obj).val();
//	if (!AREAID)
//		return;
	$.ajax({
		type : "post",
		url : "location/findAddressByArea",
		data : {
			"AREAID" : AREAID
		},
		dataType : "json",
		success : function(data) {
			if (data == null) {
				alert("查询数据不存在");
			} else {
				$("#ADDRESSID").html("");
				var str = '<option value="' + "" + '">' + '请选择地址' + "</option>";
				$("#ADDRESSID").append(str);
				var str = "<option value='" + "0" + "'>" + '其它地址' + "</option>";
				$("#ADDRESSID").append(str);
				var count;
				//遍历
				$.each(data, function(i, item) {
					 var str = "<option value='" + item.addressid + "'>"
						+ item.addressname + "</option>";
					$("#ADDRESSID").append(str);
					count = i;
				});
				//没有地址时选择addinput，有地址时选择addselect
				if (count == null  ) {
					$("#addselect").css("display", "none");
					$("#addinput").css("display", "block");
				} else {
					$("#addselect").css("display", "block");
					$("#addinput").css("display", "none");
				}
			}
		},
		error : function() {
			alert("请与管理员联系");
		}
	});
}


//MODIFIED BY HANMJ 20170721 BEGIN
//点击地址 更换其他地址
function select_Other(obj) {
	var addressId = $(obj).val();
	if (addressId == "0") {
		$("#addselect").css("display", "none");
		$("#addinput").css("display", "block");
	} else {
		$("#addselect").css("display", "block");
		$("#addinput").css("display", "none");
	}
}
//MODIFIED BY HANMJ 20170721 END


function select_Model(obj) {
	var MFRID = $(obj).val();
	if (!MFRID)
		return;
	$.ajax({
		type : "post",
		url : "manufacturers/findModelByMfr",
		data : {
			"MFRID" : MFRID
		},
		dataType : "json",
		success : function(data) {
			if (data == "{}") {
				alert("查询数据不存在");
			} else {
				// 点击省查询市 清空区
				// $("#MODEL").empty;
				$("#MODEL").html("");
				var str = "<option value='" + '' + "'>" + '选择型号' + "</option>";
				$("#MODEL").append(str);
				$.each(data, function(i, item) {
					str = "<option value='" + item.model + "'>" + item.model
					+ "</option>";
					$("#MODEL").append(str);
				});
			}
		},
		error : function() {
			alert("请与管理员联系");
		}
	});
}

// 根据运营商找CS
function select_CS(obj) {
	var OPERATORID = $(obj).val();
	if (!OPERATORID)
		return;
	$.ajax({
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
				$("#CSID").html("");
				var str = "<option value='" + '' + "'>" + '选择充电站'
				+ "</option>";
				$("#CSID").append(str);
				$.each(data, function(i, item) {
					str = "<option value='" + item.csid + "'>"
					+ item.csname + "</option>";
					$("#CSID").append(str);
				});
				//充电报表用
				$("#CPID").html("");
				var str = "<option value='" + '' + "'>" + '选择充电桩'
				+ "</option>";
				$("#CPID").append(str);
			}
		},
		error : function() {
			alert("请与管理员联系");
		}
	});

//******************************************************************************************//

function select_CLEAR() {
	$("#CSID").html("");
	var str = "<option value='" + '' + "'>" + '选择站' + "</option>";
	$("#CSID").append(str);
}
}

//根据站找桩 /充电报表用
function select_CP(obj){
	var CSID = $(obj).val();
	if (!CSID)
		return;
	$.ajax({
		type : "post",
		url : "userreports/findCPByCSID",
		data : {
			"CSID" : CSID
		},
		dataType : "json",
		success : function(data) {
			if (data == "{}") {
				alert("查询数据不存在");
			} else {
				$("#CPID").html("");
				var str = "<option value='" + '' + "'>" + '选择充电桩'
				+ "</option>";
				$("#CPID").append(str);
				$.each(data, function(i, item) {
					str = "<option value='" + item.cpid + "'>"
					+ item.cpname + "</option>";
					$("#CPID").append(str);
				});
				}
				
			},
		error : function() {
			alert("请与管理员联系");
		}
	});
}

//站找费率
function select_bill(obj){
	var csid = $(obj).val();
	$.ajax({
		type:"post",
		url:"chargePile/findBill",
		data:{"CSID":csid
		},
		datatype:"text",
		success:function(data){
			$("#RATEID").html("");
			str = "<option  value = ''>请选择费率</option> ";
			for(var i = 0;i < data.length ; i++){
				str += "<option  value = '" + data[i]
				+ "' >第" + data[i] + "套</option>";
			}
			$("#RATEID").append(str);
		},
		error:function(){
			alert("请联系管理员！");
		},
	});
}