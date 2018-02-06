//*************************************************************************************//
//*************************************************************************************//
//修改用js
//修改地址赋值
function select_CITYup(obj) {
	var PROVINCEID = $(obj).val();
	//alert(PROVINCEID);
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
				$("#AREAIDup").html("");
				var str = "<option value='" + '' + "'>" + '选择区域' + "</option>";
				$("#AREAIDup").append(str);
				$("#CITYIDup").html("");
				var str = "<option value='" + '' + "'>" + '选择市区' + "</option>";
				$("#CITYIDup").append(str);
				$.each(data, function(i, item) {
					//item里没有CITYID
					str = "<option value='" + item.cityid+ "'>"
					+ item.cityname + "</option>";
					/*str = "<option value='" + item.CITYID + "'>"
							+ item.cityname + "</option>";*/
					$("#CITYIDup").append(str);
				});
			}
		},
		error : function() {
			alert("请选择省份！");
			$("#CITYIDup").html("");
			var str = "<option value='" + '' + "'>" + '请选择市' + "</option>";
			$("#CITYIDup").append(str);
			$("#AREAIDup").html("");
			var str = "<option value='" + '' + "'>" + '请选择区' + "</option>";
			$("#AREAIDup").append(str);
		}
	});
}

// 根据市查区
function select_AREAup(obj) {
	var CITYID = $(obj).val();
	//alert(CITYID);
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
				$("#AREAIDup").html("");
				var str = "<option value='" + '' + "'>" + '选择区域' + "</option>";
				$("#AREAIDup").append(str);
				$.each(data, function(i, item) {
					str = "<option value='" + item.areaid + "'>"
					+ item.areaname + "</option>";
					$("#AREAIDup").append(str);
				});
			}
		},
		error : function() {
			$("#AREAIDup").html("");
			var str = "<option value='" + '' + "'>" + '请选择区' + "</option>";
			$("#AREAIDup").append(str);
		}
	});
}
//根据区查地址
function select_ADDRESSup(obj) {
	var AREAID = $(obj).val();
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
				$("#ADDRESSIDup").html("");
				var str = "<option value='" + '' + "'>" + '选择地址' + "</option>";
				$("#ADDRESSIDup").append(str);
				str = "<option value='" + '0' + "'>" + '其它地址' + "</option>";
				$("#ADDRESSIDup").append(str);
				var count;
				//遍历
				$.each(data, function(i, item) {
					var str = "<option value='" + item.addressid + "'>"
					+ item.addressname + "</option>";
					$("#ADDRESSIDup").append(str);
					count = i;
				});
				if (count == null) {
					$("#upselect").css("display", "none");
					$("#upinput").css("display", "block");
				} else {
					$("#upselect").css("display", "block");
					$("#upinput").css("display", "none");
				}
			}
		},
		error : function() {
			alert("请与管理员联系");
		}
	});
}

function  select_Otherup(obj){
	var addressId = $(obj).val();
	if (addressId == 0) {
		$("#upselect").css("display", "none");
		$("#upinput").css("display", "block");
	} else {
		$("#upselect").css("display", "block");
		$("#upinput").css("display", "none");
	}
}


//运营商找CS
function select_CSup(obj) {
	var OPERATORID = $(obj).val();
	// alert("根据运营商找cs"+OPERATORID);
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
						$("#CSIDup").html("");
						var str = "<option value='" + '' + "'>" + '选择充电站'
								+ "</option>";
						$("#CSIDup").append(str);
						$.each(data, function(i, item) {
							str = "<option value='" + item.csid + "'>"
									+ item.csname + "</option>";
							$("#CSIDup").append(str);
						});
					}
				},
				error : function() {
					alert("请与管理员联系");
				}
			});
}


function select_Modelup(obj) {
	var MFRID = $(obj).val();
	if (!MFRID)
		return;
	$.ajax({
		type : "post",
		url : "manufacturers/findModelByMfr",
		data : {
			"MFRID" : MFRID,
		},
		dataType : "json",
		success : function(data) {
			if (data == "{}") {
				alert("查询数据不存在");
			} else {
				// 点击省查询市 清空区
				// $("#MODEL").empty;
				$("#MODELup").html("");
				var str = "<option value='" + '' + "'>" + '选择型号' + "</option>";
				$("#MODELup").append(str);
				$.each(data, function(i, item) {
					str = "<option value='" + item.model + "'>" + item.model
							+ "</option>";
					$("#MODELup").append(str);
				});
			}
			;
		},
		error : function() {
			alert("请与管理员联系");
		},
	});
}

//*************************************************************************************//
//*************************************************************************************//


function clear_up() {
	$("#CSIDup").html("");
	var str = "<option value='" + '' + "'>" + '选择站' + "</option>";
	$("#CSIDup").append(str);
}


