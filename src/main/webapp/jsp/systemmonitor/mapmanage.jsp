<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'graph.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="js/public/jquery-1.8.3.js" /></script>
<link rel="stylesheet" href="http://cache.amap.com/lbs/static/main1119.css"/>
<script type="text/javascript" src="http://webapi.amap.com/maps?v=1.3&key=b266cc1623d817117d948f52a4a72687&plugin=AMap.Autocomplete,AMap.PlaceSearch"></script>
<script type="text/javascript" src="http://cache.amap.com/lbs/static/addToolbar.js"></script>

<style type="text/css">
        body, html{width: 100%;height: 100%; font-family:"微软雅黑";font-size: 14px;}
        *{ margin: 0;padding: 0;}
        .left{float:left;}
        .right{float:right;}
        .clearfix{clear: both;}
        .hide{display: none;}
        #map{height:628px;width: calc(100% - 305px);border: 1px solid #dadada;}
        /*地图标注文本样式*/
        .amap-marker-label{
            background:none;
            border: none;
            color: #fff;
        }
        #result{height: 520px; font-size: 13px; line-height: 20px;overflow: auto;color: #666;}
        #result ul {
            list-style: outside none none;
        }
        #result ul li{
            border-bottom: 1px solid #dadada;
            padding: 10px;
        }
        #result ul li:hover{
            background-color: #f0f0f0;
            cursor: pointer;
        }
        #result .res-data{
            /* background: url(images/map_marker.png) no-repeat -1px 18px; */
        }
        #result .res-marker{
            width: 30px; 
            height: 58px; 
            line-height: 58px; 
            text-align: center; 
            color: red; 
            font-weight: bold;
        }
        #result .res-address{
            width: 235px;
        }
        #result .title{
            font-size: 16px;
            color: #000000;
        }
        #result .prohid{
            display:none;
        }
        .area-right{
            width:303px;
        }
        .area-right .search{
             border-bottom: 1px solid #dadada;
            padding: 8px 0;
            box-shadow: 5px 2px 5px #888888;
            margin-bottom: 8px;
        }
        .area-right .search .s-address{
            margin-bottom: 5px;position: relative;border-bottom: 1px solid #DADADA;padding: 0 10px;height: 32px;line-height: 32px;
        }
        .area-right .search .s-address .btn{
            position: absolute;right: 10px;top: 5px;cursor: pointer;
        }
        .area-right .search .s-address .btn img{
            width: 20px;
        }
        .area-right .search .address{
            height: 28px;
            line-height: 28px;
            border: none;
            outline: medium;/*去掉鼠标点击后的边框*/
        }
        
        .area-right .search .cur_point{
            color: #1E90FF;padding: 0 10px;font-size: 13px;
        }
        .area-right .search .point{
            border:none;
        }
    </style>


</head>

<body>
	<div>
        <div class="left" id="map"></div>
        <div class="left area-right">
            <div class="search">
                <div class="s-address">
                    检索地址：<input type="text" class="address" id="address"/><input type="hidden"
					id="OPERATORLOGINID" name="OPERATORLOGINID" value="${param.operatorid}" 
					 />
                    <div onclick="doSearch();" class="btn"><img src="img/search.png"/></div>
                </div>
                <div class="cur_point">
                    当前坐标：<span id="s-point"></span><br/>
                    当前检索城市：<span id="s-city"></span>
                </div>
            </div>
            <div id="result">
            </div>
        </div>
        <div class="clearfix"></div>
    </div>
</body>
<script type="text/javascript">
$(function(){
        //浏览器当前窗口文档body的高度 
        var height = $(document.body).height();
        $("#map").css("height",(height-5)+"px");
        $("#result").css("height",(height-100)+"px");
        
        $("#address").val("");
        $("#result").on("click","li",function(){
            var point = $(this).find(".point").text();//获取坐标
            var prohid = $(this).find(".prohid").text();//获取城市
            var title = $(this).find(".title").text();//获取桩名
            var rout = $(this).find(".rout").text();//获取桩地址
            
            //信息窗显示的具体信息
            var info = [];
	        info.push("<div style=\"padding:0px 0px 0px 4px;\"><b>桩信息</b>");
	        info.push("桩名 : "+title);
	        info.push("桩地址 :"+rout+"</div>");
            var content =  info.join("<br/>");
            
            //赋值，背景色变化
            $("#s-point").text(point);
            $("#s-city").text(prohid);
            $("#result li").css("background-color","#fff");
            $(this).css("background-color","#f0f0f0");
            
            //获取信息窗显示的位置坐标
            var str = point.split(",");
            var lng = str[0];
            var lat = str[1];
            var jsObj = new AMap.LngLat(lng,lat);
            
            //调用test打开信息窗
            test(content,jsObj);
           
        });
        
        //绑定input文本框回车事件
        $('#address').bind('keypress',function(event){
            if(event.keyCode == "13"){
               doSearch(2);//搜索
            }
        });
    });
    window.onload = function() { 
        doSearch(1);  
    } ;
    //高德地图API功能
    var map = new AMap.Map('map', {
        resizeEnable: true,
        zoom:5,
    });
    
    /* //为地图注册click事件获取鼠标点击出的经纬度坐标
    var clickEventListener = map.on('click', function(e) {
        document.getElementById("s-point").innerHTML = e.lnglat.getLng() + ',' + e.lnglat.getLat();
        marker = new AMap.Marker({
            icon: "http://webapi.amap.com/theme/v1.3/markers/n/mark_b.png",
            position:[e.lnglat.getLng(),e.lnglat.getLat()]
        });
        marker.setMap(map);
    }); */
    
    
    var placeSearch = new AMap.PlaceSearch();  //构造地点查询类
    var infoWindow = new AMap.InfoWindow({offset: new AMap.Pixel(0, -30)});//信息窗口
    var markers = [];//定义标注数组
    //地址查询  
    function doSearch(num){
        map.remove(markers);//查询前先移除所有标注
        var address = $("#address").val();
        var OPERATORLOGINID = $("#OPERATORLOGINID").val(); 
        placeSearch.search(address, function(status, result) {
              // alert(JSON.stringify(result));
              $.ajax({
					type : "post",
					data : {
						"ADDRESS":address
					},
					url : "map/findmap",
					dataType : "json", //告诉ajax，返回的数据时json类型的，这样就可以用data.xxx 来取值  
					success : function(data) {
						var poiArr = data;
						
						var str = "<ul>";
		               for(var i=0;i<poiArr.length;i++){
		                    //在地图上创建标注点
		                    marker = new AMap.Marker({
		                        icon: "http://webapi.amap.com/theme/v1.3/markers/n/mark_r.png"
		                    });
		                    marker.setPosition(new AMap.LngLat(poiArr[i].LONGITUDE,poiArr[i].LATITUDE));
		                    marker.setMap(map);
		                    marker.setLabel({//label默认蓝框白底左上角显示，样式className为：amap-marker-label
		                        offset: new AMap.Pixel(1, 0),//修改label相对于maker的位置
		                        content: (i+1)
		                    });
		                    var info = [];
					        info.push("<div style=\"padding:0px 0px 0px 4px;\"><b>桩信息</b>");
					        info.push("桩名 : "+poiArr[i].CPNAME);
					        info.push("桩地址 :"+poiArr[i].LOCATION+"</div>");
		                    
		                    marker.content =  info.join("<br/>");
		                    marker.on('click', markerClick);
		//                    marker.emit('click', {target:marker});
		                    markers.push(marker);
		                       
		                       str+='<li>';
		                        str+='<div class="res-data">';
		                            str+='<div class="left res-marker">';
		                                str+='<span>'+(i+1)+'</span>';
		                            str+='</div>';
		                            str+='<div class="left res-address">';
		                                str+='<div class="title">'+poiArr[i].CPNAME+'</div>';
		                                str+='<div>地址：<span class="rout">'+poiArr[i].LOCATION+'</span></div>';
		                                str+='<div class="prohid"><span>'+poiArr[i].PROVINCENAME+'</span></div>';
		                                str+='<div>坐标：<span class="point">'+poiArr[i].LONGITUDE+","+poiArr[i].LATITUDE+'</span></div>';
		                            str+='</div>';
		                            str+='<div class="clearfix"></div>';
		                        str+='</div>';
		                    str+='</li>';
		               }
		                str+='</ul>';
		                $("#result").html(str);
		                //点击搜索时设置中心点
		                if(num == 2){
			                $("#s-point").text(poiArr[0].LONGITUDE+","+poiArr[0].LATITUDE);
			                //设置地图显示级别及中心点
			                map.setZoomAndCenter(14,new AMap.LngLat(poiArr[0].LONGITUDE,poiArr[0].LATITUDE));
		                    //获取查询城市信息
		                    map.getCity(function(res){
		                       $("#s-city").text(res.province+res.city);
		                    });
	                   }
					},
					error : function(data) {
						alert("错误！");
					}
				});	
            
        });
    }
    
     function test(content,jsObj){
    	infoWindow.setContent(content);
        infoWindow.open(map, jsObj);
    }
  
    //点击标注  显示信息窗口及内容
    function markerClick(e) {
        infoWindow.setContent(e.target.content);
        infoWindow.open(map, e.target.getPosition());
    }
</script>
</html>
