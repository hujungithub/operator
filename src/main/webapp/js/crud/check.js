//*****************************************************************************//
//*****************************************************************************//
//点击全选框
$("#checkall").live("click", function() {
	if ($(this).attr("checked")) {
		$(":checkbox").attr("checked", true);
		$("#delete-btn").attr("disabled", false);
		$("#delete-btn").css("background", "#ed5565");
		$("#deleteModel-btn").attr("disabled", false);
		$("#deleteModel-btn").css("background", "#ed5565");
		$("#update-btn").attr("disabled", true);
		$("#update-btn").css("background", "#777777");
	} else {
		$(":checkbox").attr("checked", false);
		$("#update-btn").attr("disabled", true);
		$("#update-btn").css("background", "#777777");
		$("#delete-btn").attr("disabled", true);
		$("#delete-btn").css("background", "#777777");
		$("#deleteModel-btn").attr("disabled", true);
		$("#deleteModel-btn").css("background", "#777777");
	}
});




// 点击子选项框
$(".checksub").live("click", function() {
	// alert("zzz");
	// 不是全选去掉全选勾
	if (!$("checkone").checked) {
		$("#checkall").attr("checked", false);
	}
	// 选项的数量
	var sonsub = $(":checkbox").length - 1;
	//alert(sonsub);
	// 已选中的数量
	var checksub = $(".checksub:checked").length;
	//alert(checksub);
	// 选中1个 可以删除修改
	if (checksub == 1) {
		$("#update-btn").attr("disabled", false);
		$("#update-btn").css("background", "#f8ac59");
		$("#delete-btn").attr("disabled", false);
		$("#delete-btn").css("background", "#ed5565");
		$("#deleteModel-btn").attr("disabled", false);
		$("#deleteModel-btn").css("background", "#ed5565");
		$("#modifybalance").attr("disabled", false);
		$("#modifybalance").css("background", "#ed5565");
	}// 选中大于1个只能删除
	else if (checksub > 1) {
		$("#delete-btn").attr("disabled", false);
		$("#delete-btn").css("background", "#ed5565");
		$("#deleteModel-btn").attr("disabled", false);
		$("#deleteModel-btn").css("background", "#ed5565");
		$("#update-btn").attr("disabled", true);
		$("#update-btn").css("background", "#777777");
		$("#modifybalance").attr("disabled", true);
		$("#modifybalance").css("background", "#777777");
	}// 未选中不能删除修改
	else {
		$("#update-btn").attr("disabled", true);
		$("#update-btn").css("background", "#777777");
		$("#delete-btn").attr("disabled", true);
		$("#delete-btn").css("background", "#777777");
		$("#deleteModel-btn").attr("disabled", true);
		$("#deleteModel-btn").css("background", "#777777");
		$("#modifybalance").attr("disabled", true);
		$("#modifybalance").css("background", "#777777");
	}
	// 若选中数量等于选项数量 勾全选框
	if (sonsub == checksub) {
		$("#checkall").attr("checked", true);
	}
});

//*****************************************************************************//
//*****************************************************************************//
