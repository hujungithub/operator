$(document).ready(function() {
	$('.tablelist tbody tr:odd').addClass('odd');	//奇数行换色

	$("#update-btn").attr("disabled", true);
	$("#update-btn").css("background", "#777777");
	$("#delete-btn").attr("disabled", true);
	$("#delete-btn").css("background", "#777777");
	$("#deleteModel-btn").attr("disabled", true);
	$("#deleteModel-btn").css("background", "#777777");
	$("#modifybalance").attr("disabled", true);
	$("#modifybalance").css("background", "#777777");
	//**************************************************************************//
	
    //增加按钮，隐藏div显示
	$("#add-btn").click(function() {
		//$("#add-form")[0]是DOM对象，调用DOM中的reset方法重置表单。jQuery中没有reset方法
		$("#add-form")[0].reset(); 
		//add  by niehy 2017/8/10 begin
		//(充电站用)
		var str = "<option value='" + '' + "'>" + '请选择市' + "</option>";
		$("#CITYID").append(str);
		str = "<option value='" + '' + "'>" + '请选择区' + "</option>";
		$("#AREAID").append(str);
		str = "<option value='" + '' + "'>" + '请选择地址' + "</option>";
		$("#ADDRESSID").append(str);
		//add  by niehy 2017/8/10 end
		$("#add-div").css("display", "block");
	});

	// 点击关闭清空数据 隐藏DIV
	$("#close-add").click(function() {
		$("#add-form")[0].reset();
		//清空市、区、地址下拉框内容(充电站用到)
		//add  by niehy 2017/8/10 begin
		$("#CITYID").find("option").remove(); 
		$("#AREAID").find("option").remove();
		$("#ADDRESSID").find("option").remove();
		//add  by niehy 2017/8/10 end
		$("#add-div").css("display", "none");
	});
	
	// 点击关闭修改
	$("#close-update").click(function() {
		$("#update-form")[0].reset();
		$(":checkbox").attr("checked", false);
		$("#update-btn").attr("disabled", true);
		$("#update-btn").css("background", "#777777");
		$("#modifybalance").attr("disabled", true);
		$("#modifybalance").css("background", "#777777");
		$("#delete-btn").attr("disabled", true);
		$("#delete-btn").css("background", "#777777");
		$("#update-div").css("display", "none");
		//add by nhy 2017/8/17 begin
		//修改地址之后点击取消使地址恢复
		$("#upselect").css("display", "block");
		$("#upinput").css("display", "none");
		//add by nhy 2017/8/17 end
	});

	// 点击删除
	$("#delete-btn").click(function() {
		$("#delcaution").css("display", "block");
	});
	//点击删除厂商的Model（厂商用）
	$("#deleteModel-btn").click(function() {
		$("#delcaution5").css("display", "block");
	});
	
	// 点击关闭删除
	$("#close-delete").click(function() {
		// window.location.reload();
		$(":checkbox").attr("checked", false);
		$("#update-btn").attr("disabled", true);
		$("#update-btn").css("background", "#777777");
		$("#delete-btn").attr("disabled", true);
		$("#delete-btn").css("background", "#777777");
		$("#deleteModel-btn").attr("disabled", true);
		$("#deleteModel-btn").css("background", "#777777");
		$("#delcaution").css("display", "none");
	});
	//点击关闭删除Model（厂商用）
	$("#close-deleteModel").click(function() {
		// window.location.reload();
		$(":checkbox").attr("checked", false);
		$("#update-btn").attr("disabled", true);
		$("#update-btn").css("background", "#777777");
		$("#delete-btn").attr("disabled", true);
		$("#delete-btn").css("background", "#777777");
		$("#deleteModel-btn").attr("disabled", true);
		$("#deleteModel-btn").css("background", "#777777");
		$("#delcaution5").css("display", "none");
	});
	
	
});
	//*******************************************************************//
	
//	$("#update-btn").click(function() {
//		alert("1232134");
//	});
//	
	
//	$("#submit-delete").click(function() {
//		alert("234234");
//	});		
