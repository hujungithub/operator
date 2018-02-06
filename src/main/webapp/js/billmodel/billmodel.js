function updateInfo(data){
	$("#RATEID").val(data.billModelDto[0].rateid);
	$("#BILLMODELID").val("方案"+data.billModelDto[0].billmodelid);
	$("#TIMEINTERVALCOUNT").val(data.billModelDto[0].timeintervalcount)
	//生效时间、失效时间
	$("#VALIDTIME").val(data.billModelDto[0].validtime);
	$("#INVALIDTIME").val(data.billModelDto[0].invalidtime);
	//服务费，尖、峰、平、谷电价
	$("#SERVICETIP").val(data.billModelDto[0].servicetip.toFixed(2));
	$("#JPRICE").val(data.billModelDto[0].jprice.toFixed(2));
	$("#FPRICE").val(data.billModelDto[0].fprice.toFixed(2));
	$("#PPRICE").val(data.billModelDto[0].pprice.toFixed(2));
	$("#GPRICE").val(data.billModelDto[0].gprice.toFixed(2));
	//时段类型
	$("#TI_1_ID").val(data.billModelDto[0].ti_1_ID);
	$("#TI_2_ID").val(data.billModelDto[0].ti_2_ID);
	$("#TI_3_ID").val(data.billModelDto[0].ti_3_ID);
	$("#TI_4_ID").val(data.billModelDto[0].ti_4_ID);
	$("#TI_5_ID").val(data.billModelDto[0].ti_5_ID);
	$("#TI_6_ID").val(data.billModelDto[0].ti_6_ID);
	$("#TI_7_ID").val(data.billModelDto[0].ti_7_ID);
	$("#TI_8_ID").val(data.billModelDto[0].ti_8_ID);
	//时段起始时刻
	$("#TI_1_START").val(data.billModelDto[0].ti_1_START);
	$("#TI_2_START").val(data.billModelDto[0].ti_2_START);
	$("#TI_3_START").val(data.billModelDto[0].ti_3_START);
	$("#TI_4_START").val(data.billModelDto[0].ti_4_START);
	$("#TI_5_START").val(data.billModelDto[0].ti_5_START);
	$("#TI_6_START").val(data.billModelDto[0].ti_6_START);
	$("#TI_7_START").val(data.billModelDto[0].ti_7_START);
	$("#TI_8_START").val(data.billModelDto[0].ti_8_START);
}



$(document).ready(function(){
	// 页面初次加载 默认修改不可用
	$("#update-btn").attr("disabled", true);
	$("#update-btn").css("background", "#777777");
	
	$("#close-alert").click(function(){
		$("#delcaution3").css("display","none");
	});	

	//点击导出
	$("#export-btn").click(function(){
		$("#cpsearch").attr("action", "billModel/billExport");
		$("#cpsearch").submit();
	});

	////*****
	//点击修改按钮
	$("#update-btn").click(function() {
		var id = "";
		var billmodelid = "";
		var operatorid = "";
		var rateid = "";
		var csid = "";
		//获取选中的id
		$("input[name = checkone]").each(function() {
			if ($(this).attr("checked")) {
				id += $(this).val();
				var str = id.split(",");
				billmodelid = str[0];
				operatorid = str[1];
				rateid = str[2];
				csid = str[3];
			};
			
		});
		$.ajax({  
		    	type :"post",
		    	data : {"OPERATORID" : operatorid,
		    			"BILLMODELID":billmodelid,
		    			"RATEID":rateid,
		    			"CSID":csid},
		        url: "billModel/findUpdate", 
		        dataType: "json",   //告诉ajax，返回的数据时json类型的，这样就可以用data.xxx 来取值  
		        success: function (data)  
		        {  
		        
		           $("#updatecpdiv").css("display", "block");
		           if(data.billModelDto.timeintervalcount == 1){
		              $("#time_1").css("display", "block");
		              $("#time_2").css("display", "none");
		              $("#time_3").css("display", "none");
		              $("#time_4").css("display", "none");
		              $("#time_5").css("display", "none");
		              $("#time_6").css("display", "none");
		              $("#time_7").css("display", "none");
		              $("#time_8").css("display", "none");
		              $("#TI_1_END").val(data.billModelDto.ti_1_START);
		           
		           }else if(data.billModelDto.timeintervalcount == 2){
		           	  $("#time_1").css("display", "block");
		              $("#time_2").css("display", "block");
		              $("#time_3").css("display", "none");
		              $("#time_4").css("display", "none");
		              $("#time_5").css("display", "none");
		              $("#time_6").css("display", "none");
		              $("#time_7").css("display", "none");
		              $("#time_8").css("display", "none");
		              $("#TI_1_END").val(data.billModelDto.ti_2_START);
		              $("#TI_2_END").val(data.billModelDto.ti_1_START);
		           
		           }else if(data.billModelDto.timeintervalcount == 3){
		           	  $("#time_1").css("display", "block");
		              $("#time_2").css("display", "block");
		              $("#time_3").css("display", "block");
		              $("#time_4").css("display", "none");
		              $("#time_5").css("display", "none");
		              $("#time_6").css("display", "none");
		              $("#time_7").css("display", "none");
		              $("#time_8").css("display", "none");
		              $("#TI_1_END").val(data.billModelDto.ti_2_START);
		              $("#TI_2_END").val(data.billModelDto.ti_3_START);
		              $("#TI_3_END").val(data.billModelDto.ti_1_START);
		           
		           }else if(data.billModelDto.timeintervalcount == 4){
		           	  $("#time_1").css("display", "block");
		              $("#time_2").css("display", "block");
		              $("#time_3").css("display", "block");
		              $("#time_4").css("display", "block");
		              $("#time_5").css("display", "none");
		              $("#time_6").css("display", "none");
		              $("#time_7").css("display", "none");
		              $("#time_8").css("display", "none");
		              $("#TI_1_END").val(data.billModelDto.ti_2_START);
		              $("#TI_2_END").val(data.billModelDto.ti_3_START);
		              $("#TI_3_END").val(data.billModelDto.ti_4_START);
		              $("#TI_4_END").val(data.billModelDto.ti_1_START);
		           
		           }else if(data.billModelDto.timeintervalcount == 5){
		           	  $("#time_1").css("display", "block");
		              $("#time_2").css("display", "block");
		              $("#time_3").css("display", "block");
		              $("#time_4").css("display", "block");
		              $("#time_5").css("display", "block");
		              $("#time_6").css("display", "none");
		              $("#time_7").css("display", "none");
		              $("#time_8").css("display", "none");
		              $("#TI_1_END").val(data.billModelDto.ti_2_START);
		              $("#TI_2_END").val(data.billModelDto.ti_3_START);
		              $("#TI_3_END").val(data.billModelDto.ti_4_START);
		              $("#TI_4_END").val(data.billModelDto.ti_5_START);
		              $("#TI_5_END").val(data.billModelDto.ti_1_START);
		           
		           }else if(data.billModelDto.timeintervalcount == 6){
		           	  $("#time_1").css("display", "block");
		              $("#time_2").css("display", "block");
		              $("#time_3").css("display", "block");
		              $("#time_4").css("display", "block");
		              $("#time_5").css("display", "block");
		              $("#time_6").css("display", "block");
		              $("#time_7").css("display", "none");
		              $("#time_8").css("display", "none");
		              $("#TI_1_END").val(data.billModelDto.ti_2_START);
		              $("#TI_2_END").val(data.billModelDto.ti_3_START);
		              $("#TI_3_END").val(data.billModelDto.ti_4_START);
		              $("#TI_4_END").val(data.billModelDto.ti_5_START);
		              $("#TI_5_END").val(data.billModelDto.ti_6_START);
		              $("#TI_6_END").val(data.billModelDto.ti_1_START);
		           
		           }else if(data.billModelDto.timeintervalcount == 7){
		           	  $("#time_1").css("display", "block");
		              $("#time_2").css("display", "block");
		              $("#time_3").css("display", "block");
		              $("#time_4").css("display", "block");
		              $("#time_5").css("display", "block");
		              $("#time_6").css("display", "block");
		              $("#time_7").css("display", "block");
		              $("#time_8").css("display", "none");
		              $("#TI_1_END").val(data.billModelDto.ti_2_START);
		              $("#TI_2_END").val(data.billModelDto.ti_3_START);
		              $("#TI_3_END").val(data.billModelDto.ti_4_START);
		              $("#TI_4_END").val(data.billModelDto.ti_5_START);
		              $("#TI_5_END").val(data.billModelDto.ti_6_START);
		              $("#TI_6_END").val(data.billModelDto.ti_7_START);
		              $("#TI_7_END").val(data.billModelDto.ti_1_START);
		           
		           }else if(data.billModelDto.timeintervalcount == 8){
		           	  $("#time_1").css("display", "block");
		              $("#time_2").css("display", "block");
		              $("#time_3").css("display", "block");
		              $("#time_4").css("display", "block");
		              $("#time_5").css("display", "block");
		              $("#time_6").css("display", "block");
		              $("#time_7").css("display", "block");
		              $("#time_8").css("display", "block");
		              $("#TI_1_END").val(data.billModelDto.ti_2_START);
		              $("#TI_2_END").val(data.billModelDto.ti_3_START);
		              $("#TI_3_END").val(data.billModelDto.ti_4_START);
		              $("#TI_4_END").val(data.billModelDto.ti_5_START);
		              $("#TI_5_END").val(data.billModelDto.ti_6_START);
		              $("#TI_6_END").val(data.billModelDto.ti_7_START);
		              $("#TI_7_END").val(data.billModelDto.ti_8_START);
		              $("#TI_8_END").val(data.billModelDto.ti_1_START);
		           
		           }else{
	           		  $("#time_1").css("display", "none");
		              $("#time_2").css("display", "none");
		              $("#time_3").css("display", "none");
		              $("#time_4").css("display", "none");
		              $("#time_5").css("display", "none");
		              $("#time_6").css("display", "none");
		              $("#time_7").css("display", "none");
		              $("#time_8").css("display", "none");
		           }
		           updateInfo(data);
		        },
		        error: function (data)  
		        {  
		            alert("错误！");  
		        },
    	});
    	
    	
	});

	//点击关闭修改 
	$("#close-update").click(function() {
		$(":checkbox").attr("checked", false);
		$("#update-btn").attr("disabled", true);
		$("#update-btn").css("background", "#777777");
//		$("#delete").attr("disabled", true);
//		$("#delete").css("background", "#777777");
		$("#updatecpdiv").css("display", "none");
	});

	//点击保存 提交修改信息 
	$("#submit-update").click(function() {
		var operatorloginid = $("#OPERATORLOGINID").val();
		var operatorid = $("#OPERATORID").val();
		var csid = $("#csid").val();
		var roleid = $("#ROLELOGINID").val();
		$("#updatecpform").attr("action", "billModel/billUpdate?operatorid="+operatorid+"&roleid="+roleid
							+"&csid="+csid+"&operatorloginid="+operatorloginid);
		$("#updatecpform").submit();
	});
	//********************************
	//点击查询按钮
	$("#search").click(function() {
		var pageNow = 1;
		var url = "billModel/findBillFirst";
		searchByPage(pageNow, url);
	});	
	
	//表单必填项验证
	$("#updatecpform").validate({
		rules : {
		    VALIDTIME:"required",
		    INVALIDTIME:"required",
			JPRICE : "required",
			FPRICE : "required",
			PPRICE : "required",
			GPRICE : "required",
			TI_1_START : "required",
			TI_2_START : "required",
			TI_3_START : "required",
			TI_4_START : "required",
			TI_5_START : "required",
			TI_6_START : "required",
			TI_7_START : "required",
			TI_8_START : "required"
		},
		messages : {
		    VALIDTIME:"请选择生效时间",
		    INVALIDTIME:"请选择失效时间",
			JPRICE : "请填写尖电价",
			FPRICE : "请填写峰电价",
			PPRICE : "请填写平电价",
			GPRICE : "请填写谷电价",
			TI_1_START : "请选择起始时刻",
			TI_2_START : "请选择起始时刻",
			TI_3_START : "请选择起始时刻",
			TI_4_START : "请选择起始时刻",
			TI_5_START : "请选择起始时刻",
			TI_6_START : "请选择起始时刻",
			TI_7_START : "请选择起始时刻",
			TI_8_START : "请选择起始时刻"
		},

	});		
});

function find_BILL(obj) {
	var CSID = $(obj).val();
	var OPERATORID = $("#OPERATORID").val();
	if (!CSID)
		return;
	$.ajax({
		type : "post",
		url : "billModel/findBillSaveData",
		data : {
			"OPERATORID":OPERATORID,
			"CSID":CSID
		},
		dataType : "json",
		success : function(data) {
			$("#data_body").html("");
			$.each(data, function (i,item) {
				var str = "";
				  str =  "<tr>"
                 			+"<td>" + "<input name= \"checkone\" class = \"checksub\" type= \"checkbox\"  value='"+item.billmodelid+","+item.operatorid+","+item.rateid+","+item.csid+"' />" +"</td>"
                			/* +"<td>" + item.rateid + "</td>"
                			+"<td>" + item.billmodelid  + "</td>" */
                			+"<td>" + (++i) + "</td>"
                			+"<td>" + item.operatorname + "</td>"
                			+"<td>" + item.csname + "</td>"
                			+"<td>" + item.validtime + "</td>"
                			+"<td>" + item.invalidtime + "</td>"	                			
                			+"<td>" + item.timeintervalcount + "</td>"
                			+"<td>" + item.servicetip.toFixed(4) + "</td>"
                			+"<td>" + item.jprice.toFixed(4) + "</td>"
                			+"<td>" + item.fprice.toFixed(4) + "</td>"
                			+"<td>" + item.pprice.toFixed(4) + "</td>"	                			
                			+"<td>" + item.gprice.toFixed(4)+ "</td>";
                	if(item.ti_1_START !='0:00'){
                		str		+="<td>" + item.ti_1_START + "</td>"
                			+"<td>" + item.ti_1_ID + "</td>";
                	}
                	if(item.ti_1_START =='0:00'){
                		str		+="<td style='background:#b6cad2'>" + item.ti_1_START + "</td>"
                			+"<td style='background:#b6cad2'>" + item.ti_1_ID + "</td>";
                	}	
                	
                	if(item.ti_2_START !='0:00'){
                		str		+="<td>" + item.ti_2_START + "</td>"
                			+"<td>" + item.ti_2_ID + "</td>";
                	}
                	if(item.ti_2_START =='0:00'){
                		str		+="<td style='background:#b6cad2'>" + item.ti_2_START + "</td>"
                			+"<td style='background:#b6cad2'>" + item.ti_2_ID + "</td>";
                	}	
                	
                	if(item.ti_3_START !='0:00'){
                		str		+="<td>" + item.ti_3_START + "</td>"
                			+"<td>" + item.ti_3_ID + "</td>";
                	}
                	if(item.ti_3_START =='0:00'){
                		str		+="<td style='background:#b6cad2'>" + item.ti_3_START + "</td>"
                			+"<td style='background:#b6cad2'>" + item.ti_3_ID + "</td>";
                	}	
                	
                	if(item.ti_4_START !='0:00'){
                		str		+="<td>" + item.ti_4_START + "</td>"
                			+"<td>" + item.ti_4_ID + "</td>";
                	}
                	if(item.ti_4_START =='0:00'){
                		str		+="<td style='background:#b6cad2'>" + item.ti_4_START + "</td>"
                			+"<td style='background:#b6cad2'>" + item.ti_4_ID + "</td>";
                	}	
                	
                	if(item.ti_5_START !='0:00'){
                		str		+="<td>" + item.ti_5_START + "</td>"
                			+"<td>" + item.ti_5_ID + "</td>";
                	}
                	if(item.ti_5_START =='0:00'){
                		str		+="<td style='background:#b6cad2'>" + item.ti_5_START + "</td>"
                			+"<td style='background:#b6cad2'>" + item.ti_5_ID + "</td>";
                	}	
                	
                	if(item.ti_6_START !='0:00'){
                		str		+="<td>" + item.ti_6_START + "</td>"
                			+"<td>" + item.ti_6_ID + "</td>";
                	}
                	if(item.ti_6_START =='0:00'){
                		str		+="<td style='background:#b6cad2'>" + item.ti_6_START + "</td>"
                			+"<td style='background:#b6cad2'>" + item.ti_6_ID + "</td>";
                	}	
                	
                	if(item.ti_7_START !='0:00'){
                		str		+="<td>" + item.ti_7_START + "</td>"
                			+"<td>" + item.ti_7_ID + "</td>";
                	}
                	if(item.ti_7_START =='0:00'){
                		str		+="<td style='background:#b6cad2'>" + item.ti_7_START + "</td>"
                			+"<td style='background:#b6cad2'>" + item.ti_7_ID + "</td>";
                	}	
                	
                	if(item.ti_8_START !='0:00'){
                		str		+="<td>" + item.ti_8_START + "</td>"
                			+"<td>" + item.ti_8_ID + "</td>";
                	}
                	if(item.ti_8_START =='0:00'){
                		str		+="<td style='background:#b6cad2'>" + item.ti_8_START + "</td>"
                			+"<td style='background:#b6cad2'>" + item.ti_8_ID + "</td>";
                	}		
                	
                			
                		str	+="</tr>";
                			$("#data_body").append(str);
			});	
			 $(".tablelist tbody tr:odd").addClass('odd');     
		},	
		error : function() {
			alert("请与管理员联系");
		}
	});
}

function timechange(obj){
	var timecount = $(obj).val();
	var str = "00:00";
	if(timecount == 1){
         $("#time_1").css("display", "block");
         $("#time_2").css("display", "none");
         $("#time_3").css("display", "none");
         $("#time_4").css("display", "none");
         $("#time_5").css("display", "none");
         $("#time_6").css("display", "none");
         $("#time_7").css("display", "none");
         $("#time_8").css("display", "none");
         $("#TI_1_END").val($("#TI_1_START").val());
         
         
         $("#TI_2_START").val(str);
         $("#TI_3_START").val(str);
         $("#TI_4_START").val(str);
         $("#TI_5_START").val(str);
         $("#TI_6_START").val(str);
         $("#TI_7_START").val(str);
         $("#TI_8_START").val(str);
         
         $("#TI_2_ID").val(0);
         $("#TI_3_ID").val(0);
         $("#TI_4_ID").val(0);
         $("#TI_5_ID").val(0);
         $("#TI_6_ID").val(0);
         $("#TI_7_ID").val(0);
         $("#TI_8_ID").val(0);
      
      }else if(timecount == 2){
      	 $("#time_1").css("display", "block");
         $("#time_2").css("display", "block");
         $("#time_3").css("display", "none");
         $("#time_4").css("display", "none");
         $("#time_5").css("display", "none");
         $("#time_6").css("display", "none");
         $("#time_7").css("display", "none");
         $("#time_8").css("display", "none");
         $("#TI_1_END").val($("#TI_2_START").val());
         $("#TI_2_END").val($("#TI_1_START").val());
         
         $("#TI_3_START").val(str);
         $("#TI_4_START").val(str);
         $("#TI_5_START").val(str);
         $("#TI_6_START").val(str);
         $("#TI_7_START").val(str);
         $("#TI_8_START").val(str);
         
         $("#TI_3_ID").val(0);
         $("#TI_4_ID").val(0);
         $("#TI_5_ID").val(0);
         $("#TI_6_ID").val(0);
         $("#TI_7_ID").val(0);
         $("#TI_8_ID").val(0);
         
      
      }else if(timecount == 3){
      	 $("#time_1").css("display", "block");
         $("#time_2").css("display", "block");
         $("#time_3").css("display", "block");
         $("#time_4").css("display", "none");
         $("#time_5").css("display", "none");
         $("#time_6").css("display", "none");
         $("#time_7").css("display", "none");
         $("#time_8").css("display", "none");
         $("#TI_1_END").val($("#TI_2_START").val());
         $("#TI_2_END").val($("#TI_3_START").val());
         $("#TI_3_END").val($("#TI_1_START").val());
         
         $("#TI_4_START").val(str);
         $("#TI_5_START").val(str);
         $("#TI_6_START").val(str);
         $("#TI_7_START").val(str);
         $("#TI_8_START").val(str);
         
         $("#TI_4_ID").val(0);
         $("#TI_5_ID").val(0);
         $("#TI_6_ID").val(0);
         $("#TI_7_ID").val(0);
         $("#TI_8_ID").val(0);
      
      }else if(timecount == 4){
      	 $("#time_1").css("display", "block");
         $("#time_2").css("display", "block");
         $("#time_3").css("display", "block");
         $("#time_4").css("display", "block");
         $("#time_5").css("display", "none");
         $("#time_6").css("display", "none");
         $("#time_7").css("display", "none");
         $("#time_8").css("display", "none");
         $("#TI_1_END").val($("#TI_2_START").val());
         $("#TI_2_END").val($("#TI_3_START").val());
         $("#TI_3_END").val($("#TI_4_START").val());
         $("#TI_4_END").val($("#TI_1_START").val());
         
         $("#TI_5_START").val(str);
         $("#TI_6_START").val(str);
         $("#TI_7_START").val(str);
         $("#TI_8_START").val(str);
         
         $("#TI_5_ID").val(0);
         $("#TI_6_ID").val(0);
         $("#TI_7_ID").val(0);
         $("#TI_8_ID").val(0);
      
      }else if(timecount == 5){
      	 $("#time_1").css("display", "block");
         $("#time_2").css("display", "block");
         $("#time_3").css("display", "block");
         $("#time_4").css("display", "block");
         $("#time_5").css("display", "block");
         $("#time_6").css("display", "none");
         $("#time_7").css("display", "none");
         $("#time_8").css("display", "none");
         $("#TI_1_END").val($("#TI_2_START").val());
         $("#TI_2_END").val($("#TI_3_START").val());
         $("#TI_3_END").val($("#TI_4_START").val());
         $("#TI_4_END").val($("#TI_5_START").val());
         $("#TI_5_END").val($("#TI_1_START").val());
         
         $("#TI_6_START").val(str);
         $("#TI_7_START").val(str);
         $("#TI_8_START").val(str);
         
         $("#TI_6_ID").val(0);
         $("#TI_7_ID").val(0);
         $("#TI_8_ID").val(0);
      
      }else if(timecount == 6){
      	 $("#time_1").css("display", "block");
         $("#time_2").css("display", "block");
         $("#time_3").css("display", "block");
         $("#time_4").css("display", "block");
         $("#time_5").css("display", "block");
         $("#time_6").css("display", "block");
         $("#time_7").css("display", "none");
         $("#time_8").css("display", "none");
         $("#TI_1_END").val($("#TI_2_START").val());
         $("#TI_2_END").val($("#TI_3_START").val());
         $("#TI_3_END").val($("#TI_4_START").val());
         $("#TI_4_END").val($("#TI_5_START").val());
         $("#TI_5_END").val($("#TI_6_START").val());
         $("#TI_6_END").val($("#TI_1_START").val());
         
         $("#TI_7_START").val(str);
         $("#TI_8_START").val(str);
         
         $("#TI_7_ID").val(0);
         $("#TI_8_ID").val(0);
      
      }else if(timecount == 7){
      	 $("#time_1").css("display", "block");
         $("#time_2").css("display", "block");
         $("#time_3").css("display", "block");
         $("#time_4").css("display", "block");
         $("#time_5").css("display", "block");
         $("#time_6").css("display", "block");
         $("#time_7").css("display", "block");
         $("#time_8").css("display", "none");
         $("#TI_1_END").val($("#TI_2_START").val());
         $("#TI_2_END").val($("#TI_3_START").val());
         $("#TI_3_END").val($("#TI_4_START").val());
         $("#TI_4_END").val($("#TI_5_START").val());
         $("#TI_5_END").val($("#TI_6_START").val());
         $("#TI_6_END").val($("#TI_7_START").val());
         $("#TI_7_END").val($("#TI_1_START").val());
         
         $("#TI_8_START").val(str);
         
         $("#TI_8_ID").val(0);
      
      }else if(timecount == 8){
      	 $("#time_1").css("display", "block");
         $("#time_2").css("display", "block");
         $("#time_3").css("display", "block");
         $("#time_4").css("display", "block");
         $("#time_5").css("display", "block");
         $("#time_6").css("display", "block");
         $("#time_7").css("display", "block");
         $("#time_8").css("display", "block");
         $("#TI_1_END").val($("#TI_2_START").val());
         $("#TI_2_END").val($("#TI_3_START").val());
         $("#TI_3_END").val($("#TI_4_START").val());
         $("#TI_4_END").val($("#TI_5_START").val());
         $("#TI_5_END").val($("#TI_6_START").val());
         $("#TI_6_END").val($("#TI_7_START").val());
         $("#TI_7_END").val($("#TI_8_START").val());
         $("#TI_8_END").val($("#TI_1_START").val());
      
      }else{
  		 $("#time_1").css("display", "none");
         $("#time_2").css("display", "none");
         $("#time_3").css("display", "none");
         $("#time_4").css("display", "none");
         $("#time_5").css("display", "none");
         $("#time_6").css("display", "none");
         $("#time_7").css("display", "none");
         $("#time_8").css("display", "none");
      }

}