
		// 基于准备好的dom，初始化echarts实例
	$(document).ready(function(){
		getCharge();	
	});
	// 统计充电量
	function getCharge(){
		var myChart = echarts.init(document.getElementById('main'));	
		option = {				
			    title : {
			        text: '充电电量',
			    },
			    tooltip : {
			        trigger: 'axis'
			    },
			    toolbox: {
			        show : true,
			        feature : {
			            mark : {show: true},			           
			            magicType : {show: true, type: ['line', 'bar']},
			            restore : {show: true},
			            saveAsImage : {show: true}
			        }
			    },
			    calculable : true,
			    xAxis : [
			        {
			            type : 'category',
			            boundaryGap : false,
			        	data : [],
			        	axisLabel:{
 			                textStyle:{
 			                   color:"gray",
 			                   fontSize:15
 			                }
                        }
			        }
			    ],
			    yAxis : [
			        {
			            type : 'value',
			            name : '度',
		            	axisLabel:{
 			                textStyle:{
 			                   color:"gray",
 			                   fontSize:15
 			                }
                        }
			        }
			    ],
			    series : [
			        {
			            name:'充电电量',
			            type:'line',
			            data: [],	
			            color:'#0066CC',
			            itemStyle:{
			            	normal:{
			            		color:'#0066CC'
			            	}
			            },
			            markLine : {
			                data : [
			                    {type : 'average', name: '平均值'}
			                ]
			            }
			        },
			    ]
			};
		
		var year = $("#YEAR").val();		
		var operatorid = $("#OPERATORLOGINID").val();		
		var month = $("#MONTH").val();		
		var date = new Date(year,month,0);
		var day = date.getDate();
		//alert("operatorid = "+operatorid+"year = "+year+"month="+month+"day ="+day);
		// ajax获取数据
		 myChart.showLoading();  
		$.ajax({
			type : "post",
			data : {
				"year":year,"month":month,"day":day,"operatorid":operatorid
			},
			url : "index/getChargeStatistic",
			dataType : "json", //告诉ajax，返回的数据时json类型的，这样就可以用data.xxx 来取值  
			success : function(data) {
				myChart.hideLoading();  
                myChart.setOption({  
                
                	xAxis:{  
                             data:data.xAxis
                             
                          },                                    
                    series:{
                     		data:data.yAxis 
                     }
				});
			},
			error : function(data) {
				alert("错误！");
			}
		});	                    	
        // 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
	}
	
	// 统计次数
	function getCount(){
		var myChart = echarts.init(document.getElementById('main'));	
		option = {				
			    title : {
			        text: '充电次数',
			    },
			    tooltip : {
			        trigger: 'axis'
			    },
			    toolbox: {
			        show : true,
			        feature : {
			            mark : {show: true},
			            magicType : {show: true, type: ['line', 'bar']},
			            restore : {show: true},
			            saveAsImage : {show: true}
			        }
			    },
			    calculable : true,
			    xAxis : [
			        {
			            type : 'category',
			            boundaryGap : false,
			            data : [],
			            axisLabel:{
 			                textStyle:{
 			                   color:"gray",
 			                   fontSize:15
 			                }
                        }
			        }
			    ],
			    yAxis : [
			        {
			            type : 'value',
			            name : '次',
			            axisLabel:{
 			                textStyle:{
 			                   color:"gray",
 			                   fontSize:15
 			                }
                        }
			        }
			    ],
			    series : [
			        {
			            name:'充电次数',
			            type:'line',
			            data: [],
			            color:'#0066CC',
			            itemStyle:{
			            	normal:{
			            		color:'#0066CC'
			            	}
			            },
			            markLine : {
			                data : [
			                    {type : 'average', name: '平均值'}
			                ]
			            }
			        },
			    ]
			};
		
		var year = $("#YEAR").val();		
		var operatorid = $("#OPERATORLOGINID").val();		
		var month = $("#MONTH").val();		
		var date = new Date(year,month,0);
		var day = date.getDate();		
		//alert("operatorid = "+operatorid+"year = "+year+"month="+month+"day ="+day);
		// ajax获取数据
		 myChart.showLoading();  
		$.ajax({
			type : "post",
			data : {
				"year":year,"month":month,"day":day,"operatorid":operatorid
			},
			url : "index/getCountStatistic",
			dataType : "json", //告诉ajax，返回的数据时json类型的，这样就可以用data.xxx 来取值  
			success : function(data) {
				myChart.hideLoading();  
                myChart.setOption({  
                
                	xAxis:{  
                             data:data.xAxis  
                          },                                    
                    series:{
                     		data:data.yAxisc 
                     }
				});
			},
			error : function(data) {
				alert("错误！");
			}
		});	                    	
        // 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
	}
	
	
	
	// 统计收入
	function getIncome(){
		var myChart = echarts.init(document.getElementById('main'));	
		option = {				
			    title : {
			        text: '充电收入',
			    },
			    tooltip : {
			        trigger: 'axis'
			    },
			    toolbox: {
			        show : true,
			        feature : {
			            mark : {show: true},			     
			            magicType : {show: true, type: ['line', 'bar']},
			            restore : {show: true},
			            saveAsImage : {show: true}
			        }
			    },
			    calculable : true,
			    xAxis : [
			        {
			            type : 'category',
			            boundaryGap : false,
			            data : [],
			            axisLabel:{
 			                textStyle:{
 			                   color:"gray",
 			                   fontSize:15
 			                }
                        }
			        }
			    ],
			    yAxis : [
			        {
			            type : 'value',
			            name : '元',
			            axisLabel:{
 			                textStyle:{
 			                   color:"gray",
 			                   fontSize:15
 			                }
                        }
			        }
			    ],
			    series : [
			        {
			            name:'充电收入',
			            type:'line',
			            data: [],
			            color:'#0066CC',
			            itemStyle:{
			            	normal:{			            		
			            		color:'#0066CC'
			            	}
			            },
			            markLine : {
			                data : [
			                    {type : 'average', name: '平均值'}
			                ]
			            }
			        },
			    ]
			};
		
		var year = $("#YEAR").val();		
		var operatorid = $("#OPERATORLOGINID").val();		
		var month = $("#MONTH").val();		
		var date = new Date(year,month,0);
		var day = date.getDate();		
		//alert("operatorid = "+operatorid+"year = "+year+"month="+month+"day ="+day);
		// ajax获取数据
		 myChart.showLoading();  
		$.ajax({
			type : "post",
			data : {
				"year":year,"month":month,"day":day,"operatorid":operatorid
			},
			url : "index/getIncomeStatistic",
			dataType : "json", //告诉ajax，返回的数据时json类型的，这样就可以用data.xxx 来取值  
			success : function(data) {
				myChart.hideLoading();  
                myChart.setOption({                 
                	xAxis:{  
                             data:data.xAxis  
                          },                                    
                    series:{
                     		data:data.yAxis 
                     }
				});
			},
			error : function(data) {
				alert("错误！");
			}
		});	                    	
        // 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
	}
