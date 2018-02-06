<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>充电桩系统概览</title>

     <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/reset.css" media="screen"/>

     <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/text.css" media="screen"/>

     <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/grid.css" media="screen"/>

     <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/layout.css" media="screen"/>

     <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/nav.css" media="screen"/>




     <script type="text/javascript" language="javascript" src="<%=basePath%>/media/js/jquery.js"></script>
     <script type="text/javascript" src="<%=basePath%>/js/jquery-ui/jquery.ui.core.min.js"></script>

     <script src="<%=basePath%>/js/jquery-ui/jquery.ui.widget.min.js" type="text/javascript"></script>

     <script src="<%=basePath%>/js/jquery-ui/jquery.ui.accordion.min.js" type="text/javascript"></script>

     <script src="<%=basePath%>/js/jquery-ui/jquery.effects.core.min.js" type="text/javascript"></script>



     <link href="<%=basePath%>/../css/themes/base/jquery.ui.all.css" rel="stylesheet" type="text/css"/>


     <link type="text/css" rel="stylesheet" href="<%=basePath%>/jedate/skin/jedate.css">
     <script type="text/javascript" src="<%=basePath%>/jedate/jquery-1.7.2.js"></script>
     <script type="text/javascript" src="<%=basePath%>/jedate/jquery.jedate.js"></script>


     <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/jquery.jqplot.min.css"/>

     <script language="javascript" type="text/javascript" src="<%=basePath%>/js/jqPlot/jquery.jqplot.min.js"></script>

     <script language="javascript" type="text/javascript" src="<%=basePath%>/js/jqPlot/plugins/jqplot.barRenderer.min.js"></script>

     <script language="javascript" type="text/javascript" src="<%=basePath%>/js/jqPlot/plugins/jqplot.pieRenderer.min.js"></script>

     <script language="javascript" type="text/javascript" src="<%=basePath%>/js/jqPlot/plugins/jqplot.categoryAxisRenderer.min.js"></script>

     <script language="javascript" type="text/javascript" src="<%=basePath%>/js/jqPlot/plugins/jqplot.highlighter.min.js"></script>

     <script language="javascript" type="text/javascript" src="<%=basePath%>/js/jqPlot/plugins/jqplot.pointLabels.min.js"></script>

     <script src="<%=basePath%>/js/setup.js" type="text/javascript"></script>
	 <script type="text/javascript" src="<%=basePath%>js/echarts.js"></script>

     <script type="text/javascript">

     $(document).ready(function () {
    	 changedata();

});
     
     function changedata(){
    	 getCharge();
    	 getCount();
    	 getIncome();
     }
     
  // 统计充电量
     function getCharge() {
     	var myChart = echarts.init(document.getElementById('chart2'));
     	option = {
     		title : {
     			text : '消耗电量',
     		},
     		tooltip : {
     			trigger : 'axis'
     		},
     		toolbox : {
     			show : true,
     			feature : {
     				mark : {
     					show : true
     				},
     				magicType : {
     					show : true,
     					type : [ 'line', 'bar' ]
     				},
     				restore : {
     					show : true
     				},
     				saveAsImage : {
     					show : true
     				}
     			}
     		},
     		calculable : true,
     		xAxis : [ {
     			type : 'category',
     			boundaryGap : false,
     			data : [],
     			axisLabel : {
     				textStyle : {
     					color : "gray",
     					fontSize : 15
     				}
     			}
     		} ],
     		yAxis : [ {
     			type : 'value',
     			name : '度',
     			axisLabel : {
     				textStyle : {
     					color : "gray",
     					fontSize : 15
     				}
     			}
     		} ],
     		series : [ {
     			name : '消耗电量',
     			type : 'line',
     			data : [],
     			color : '#0066CC',
     			itemStyle : {
     				normal : {
     					color : '#0066CC'
     				}
     			},
     			markLine : {
     				data : [ {
     					type : 'average',
     					name : '平均值'
     				} ]
     			}
     		}, ]
     	};

     	var year = $("#YEAR").val();
     	var operatorid = $("#OPERATORID").val();
     	var month = $("#MONTH").val();
     	var date = new Date(year, month, 0);
     	var day = date.getDate();
     	// alert("operatorid = "+operatorid+"year = "+year+"month="+month+"day
     	// ="+day);
     	// ajax获取数据
     	myChart.showLoading();
     	$.ajax({
     		type : "post",
     		data : {
     			"year" : year,
     			"month" : month,
     			"day" : day,
     			"operatorid" : operatorid
     		},
     		url : "index/getChargeStatistic",
     		dataType : "json", // 告诉ajax，返回的数据时json类型的，这样就可以用data.xxx 来取值
     		success : function(data) {
     			myChart.hideLoading();
     			myChart.setOption({

     				xAxis : {
     					data : data.xAxis

     				},
     				series : {
     					data : data.yAxis
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
     function getCount() {
     	var myChart = echarts.init(document.getElementById('chart3'));
     	option = {
     		title : {
     			text : '充电频率',
     		},
     		tooltip : {
     			trigger : 'axis'
     		},
     		toolbox : {
     			show : true,
     			feature : {
     				mark : {
     					show : true
     				},
     				magicType : {
     					show : true,
     					type : [ 'line', 'bar' ]
     				},
     				restore : {
     					show : true
     				},
     				saveAsImage : {
     					show : true
     				}
     			}
     		},
     		calculable : true,
     		xAxis : [ {
     			type : 'category',
     			boundaryGap : false,
     			data : [],
     			axisLabel : {
     				textStyle : {
     					color : "gray",
     					fontSize : 15
     				}
     			}
     		} ],
     		yAxis : [ {
     			type : 'value',
     			name : '次',
     			axisLabel : {
     				textStyle : {
     					color : "gray",
     					fontSize : 15
     				}
     			}
     		} ],
     		series : [ {
     			name : '充电频率',
     			type : 'line',
     			data : [],
     			color : '#0066CC',
     			itemStyle : {
     				normal : {
     					color : '#0066CC'
     				}
     			},
     			markLine : {
     				data : [ {
     					type : 'average',
     					name : '平均值'
     				} ]
     			}
     		}, ]
     	};

     	var year = $("#YEAR").val();
     	var operatorid = $("#OPERATORID").val();
     	var month = $("#MONTH").val();
     	var date = new Date(year, month, 0);
     	var day = date.getDate();
     	// alert("operatorid = "+operatorid+"year = "+year+"month="+month+"day
     	// ="+day);
     	// ajax获取数据
     	myChart.showLoading();
     	$.ajax({
     		type : "post",
     		data : {
     			"year" : year,
     			"month" : month,
     			"day" : day,
     			"operatorid" : operatorid
     		},
     		url : "index/getCountStatistic",
     		dataType : "json", // 告诉ajax，返回的数据时json类型的，这样就可以用data.xxx 来取值
     		success : function(data) {
     			myChart.hideLoading();
     			myChart.setOption({

     				xAxis : {
     					data : data.xAxis
     				},
     				series : {
     					data : data.yAxisc
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
     function getIncome() {
     	var myChart = echarts.init(document.getElementById('chart1'));
     	option = {
     		title : {
     			text : '营业额',
     		},
     		tooltip : {
     			trigger : 'axis'
     		},
     		toolbox : {
     			show : true,
     			feature : {
     				mark : {
     					show : true
     				},
     				magicType : {
     					show : true,
     					type : [ 'line', 'bar' ]
     				},
     				restore : {
     					show : true
     				},
     				saveAsImage : {
     					show : true
     				}
     			}
     		},
     		calculable : true,
     		xAxis : [ {
     			type : 'category',
     			boundaryGap : false,
     			data : [],
     			axisLabel : {
     				textStyle : {
     					color : "gray",
     					fontSize : 15
     				}
     			}
     		} ],
     		yAxis : [ {
     			type : 'value',
     			name : '元',
     			axisLabel : {
     				textStyle : {
     					color : "gray",
     					fontSize : 15
     				}
     			}
     		} ],
     		series : [ {
     			name : '营业额',
     			type : 'bar',
     			data : [],
     			color : '#0066CC',
     			itemStyle : {
     				normal : {
     					color : '#0066CC'
     				}
     			},
     			markLine : {
     				data : [ {
     					type : 'average',
     					name : '平均值'
     				} ]
     			}
     		}, ]
     	};

     	var year = $("#YEAR").val();
     	var operatorid = $("#OPERATORID").val();
     	var month = $("#MONTH").val();
     	var date = new Date(year, month, 0);
     	var day = date.getDate();
     	// alert("operatorid = "+operatorid+"year = "+year+"month="+month+"day
     	// ="+day);
     	// ajax获取数据
     	myChart.showLoading();
     	$.ajax({
     		type : "post",
     		data : {
     			"year" : year,
     			"month" : month,
     			"day" : day,
     			"operatorid" : operatorid
     		},
     		url : "index/getIncomeStatistic",
     		dataType : "json", // 告诉ajax，返回的数据时json类型的，这样就可以用data.xxx 来取值
     		success : function(data) {
     			myChart.hideLoading();
     			myChart.setOption({
     				xAxis : {
     					data : data.xAxis
     				},
     				series : {
     					data : data.yAxis
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

</script>


<style type="text/css">

#demo-side-bar{
  left:95%!important;
  display:block!important;
}

#branding .floatright{
  margin-right:130px!important;
}

.wid{
  width: 90%;
}
.h2{

  color: #1b548d;
  background:#e6f0f3;
  font-size: 1.2em;
  font-weight: bold;
  line-height: 2.4em;
  margin: -10px -10px 0 -10px;
  padding: 0px 12px;
  border-bottom: 1px solid #b3cbd6;
  border-radius: 5px 5px 0px 0px;
}
.home-label div p{
  font-size: 2em;
  padding: 10px 0px;
}

.my-je-select{
        min-width: 80px;
        height: 34px;
        line-height: 34px;
        font-size: 14px;
        background-color: rgb(255, 255, 255);
        display: inline-block;
        cursor: pointer;
        position: relative;
        text-overflow: ellipsis;
        white-space: nowrap;
        padding: 0px 22px 0px 8px;
        border-width: 1px;
        border-style: solid;
        border-color: rgb(217, 217, 217);
        border-radius: 3px;
        overflow: hidden;
        transition: border-color 0.15s cubic-bezier(0.65, 0.05, 0.35, 0.5);
        width: 150px;
     }
     
     .je-w33{
      	width: 150px;
      	float:left;
      	
      }
      
      .je-dib input,select{
       vertical-align:middle!important;
     }
     
    
</style>
		<div class="box round first" style="margin-top: 0px;width: 98%">

            <h2 class="">运营统计</h2>
			
			<br/>

            <div class="stat-col">
              <span >充电站</span>
              <p class="purple"><img src="<%=basePath%>/img/icon-direction.png" alt="" />&nbsp;${indexDto.CSCOUNT}&nbsp;</p>
            </div>

            <div class="stat-col">
              <span >充电桩</span>
              <p class="yellow"><img src="<%=basePath%>/img/icon-direction.png" alt="" />&nbsp;${indexDto.CPCOUNT}&nbsp;</p>
            </div>

            <div class="stat-col">
              <span>直流桩</span>
              <p class="green"><img src="<%=basePath%>/img/icon-direction.png" alt="" />&nbsp;${indexDto.DCPCOUNT}&nbsp;</p>
            </div>

            <div class="stat-col">
              <span>交流桩</span>
              <p class="blue"><img src="<%=basePath%>/img/icon-direction.png" alt="" />&nbsp;${indexDto.ACPCOUNT}&nbsp;</p>
            </div>

            <div class="stat-col">
              <span>充电总度数(度)</span>
              <p class="red"><img src="<%=basePath%>/img/icon-direction.png" alt="" />&nbsp;${indexDto.CHARGECOUNT}&nbsp;</p>
            </div>
            
              <div class="stat-col">
                <span>充电总电费(元)</span>
                <p class="purple">
                  <img src="<%=basePath%>/img/icon-direction.png" alt="" />&nbsp;${indexDto.MONEYCOUNT}&nbsp;
                </p>
              </div>
              
              <div class="stat-col">
                <span>充电总服务费(元)</span>
                <p class="green">
                  <img src="<%=basePath%>/img/icon-direction.png" alt="" />&nbsp;${indexDto.SERVICECOUNT}&nbsp;
                </p>
              </div>
              
              <div class="stat-col">
                <span>APP用户数</span>
                <p class="blue">
                  <img src="<%=basePath%>/img/icon-direction.png" alt="" />&nbsp;${indexDto.APPCOUNT}&nbsp;
                </p>
              </div>

              <div class="stat-col">
                 <span>卡用户数</span>
                 <p class="darkblue">
                   <img src="<%=basePath%>/img/icon-direction.png" alt="" />&nbsp;${indexDto.CARDCOUNT}&nbsp;
                 </p>
              </div>
              
              <div class="stat-col last">
                 <span>微信用户数</span>
                 <p class="yellow">
                   <img src="<%=basePath%>/img/icon-direction.png" alt="" />&nbsp;1600&nbsp;
                 </p>
              </div>

                   <div class="clear">

                   </div>

                 </div>

			
  <div class="grid_10 wid" style="width: 98%">
	
	
    <div class="box round first">

      <div class="h2" style="margin-left: -20px">统计图表</div>
    </div>

	<div class="je-form-item">
				<div class="je-w33 je-dib" >
					<select id = "YEAR" class="my-je-select" onchange="changedata()">
						<option value = "2017" ${dateyear == 2017 ? "selected= 'selected'" : " "}>2017年</option>
						<option value = "2018" ${dateyear == 2018 ? "selected= 'selected'" : " "}>2018年</option>
						<option value = "2019" ${dateyear == 2019 ? "selected= 'selected'" : " "}>2019年</option>
						<option value = "2020" ${dateyear == 2020 ? "selected= 'selected'" : " "}>2020年</option>
						<option value = "2021" ${dateyear == 2021 ? "selected= 'selected'" : " "}>2021年</option>					
					</select>
				</div>
				<div class="je-w33 je-dib" >
					<select id = "MONTH" class="my-je-select" onchange="changedata()">
						<option value = "1" ${datemonth == 1 ? "selected= 'selected'" : " "}>1月</option>
						<option value = "2" ${datemonth == 2 ? "selected= 'selected'" : " "}>2月</option>
						<option value = "3" ${datemonth == 3 ? "selected= 'selected'" : " "}>3月</option>
						<option value = "4" ${datemonth == 4 ? "selected= 'selected'" : " "}>4月</option>
						<option value = "5" ${datemonth == 5 ? "selected= 'selected'" : " "}>5月</option>
						<option value = "6" ${datemonth == 6 ? "selected= 'selected'" : " "}>6月</option>
						<option value = "7" ${datemonth == 7 ? "selected= 'selected'" : " "}>7月</option>
						<option value = "8" ${datemonth == 8 ? "selected= 'selected'" : " "}>8月</option>
						<option value = "9" ${datemonth == 9 ? "selected= 'selected'": " "}>9月</option>
						<option value = "10" ${datemonth == 10 ? "selected= 'selected'" : " "}>10月</option>
						<option value = "11" ${datemonth == 11 ? "selected= 'selected'" : " "}>11月</option>
						<option value = "12" ${datemonth == 12 ? "selected= 'selected'" : " "}>12月</option>
					</select>
				</div>
				<div class="je-w33 je-dib" >
					<select class="my-je-select" id="OPERATORID" name="OPERATORID" onchange="changedata()">
						<c:forEach items="${operList}" var="oper">
							<option value="${oper.OPERATORID}">${oper.OPERATORNAME}</option>
						</c:forEach>
					</select>
				</div>
			</div>
<div class="block" style="margin-top: 40px;">
  
  <div id="chart1" style="width: 530px;height:350px;float: left;"></div>
  <div id="chart3" style="width: 450px;height:350px;float: left;"></div>
  <div id="chart2" style="width: 530px;height:350px;float: left;"></div>

</div>

</div>
</div>

             <!-- </div>

                   <div class="grid_5 wid">

                                 <div class="box round">

                                   <h2>消耗电量</h2>

                     <div class="block">


                       <div id="chart2" style="width: 1000px;height:500px;"></div>

                     </div>

                   </div>

                 </div>

                 <div class="grid_5 wid">

        <div class="box round">

          <h2>充电频率</h2>

          <div class="block">

            <div id="chart3" style="width: 1000px;height:500px;"></div>

            <p>

            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor
                        incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
                        exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute
                        irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
                        pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia

            deserunt mollit anim id est laborum.

          </p>

           </div>

         </div>

       </div>

       <div class="clear"></div>

     </div> -->

     <!--wrapper end-->
	<!--Dynamically creates analytics markup-->

</body>

  </html>
