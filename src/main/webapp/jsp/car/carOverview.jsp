<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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


     <script type="text/javascript">

     $(document).ready(function () {

            setupDashboardChart('chart1',1);
            setupDashboardChart('chart2',2);
            setupDashboardChart('chart3',3);
            // drawPieChart('chart2');

            $("#inpstart").jeDate(start);
            $("#inpend").jeDate(end);

});

//实现日期选择联动
var start = {
    format:'YYYY-MM-DD hh:mm',
    isinitVal:true,
    // minDate: '2014-06-16 23:59:59', //设定最小日期为当前日期
    // maxDate: $.nowDate({DD:0}), //最大日期
    choosefun: function(elem,datas){
        // end.minDate = $.nowDate({YYYY-MM-DD hh:mm});//开始日选好后，重置结束日的最小日期
        endDates();
    },
    okfun:function (elem,datas) {
        alert(datas);
    }
};
var end = {
    format:'YYYY-MM-DD hh:mm',
    isinitVal:true,
    // minDate: $.nowDate({DD:0}), //设定最小日期为当前日期
    // maxDate: '2099-06-16 23:59:59', //最大日期
    choosefun: function(elem,datas){
        // start.maxDate = $.nowDate({YYYY-MM-DD hh:mm}); //将结束日的初始值设定为开始日的最大日期
    }
};
function endDates() {
    end.trigger = false;
    $("#inpend").jeDate(end);
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
</style>


  <div class="clear"></div>

  <div class="grid_10 wid">

    <div class="box round first">

      <div class="h2">营业额<div class="floatright">
        <div class="datep">
          日期：
          <input class="datainp wicon" id="inpstart" type="text" placeholder="开始日期" value=""  readonly>
          ——
          <input class="datainp wicon" id="inpend" type="text" placeholder="结束日期"   readonly>
          <button type="button" class="btn btn-purple" name="button">查询</button>
        </div>
      </div>
    </div>


    <div class="block">

  <div id="chart1"></div>

</div>

</div>

  <div class="box round first">

            <h2 class="">设备运维</h2>
<br/>

            <div class="stat-col">

              <span>在线桩</span>

              <p class="purple"><img src="<%=basePath%>/img/icon-direction.png" alt="" />&nbsp;76&nbsp;</p>

            </div>

            <div class="stat-col">

              <span>充电中</span>

              <p class="yellow"><img src="<%=basePath%>/img/icon-direction.png" alt="" />&nbsp;73&nbsp;</p>

            </div>

            <div class="stat-col">

              <span>离线桩</span>

              <p class="green"><img src="<%=basePath%>/img/icon-direction.png" alt="" />&nbsp;12&nbsp;</p>

            </div>

            <div class="stat-col">

              <span>交流桩</span>

              <p class="blue"><img src="<%=basePath%>/img/icon-direction.png" alt="" />&nbsp;99&nbsp;</p>

            </div>

            <div class="stat-col">

              <span>直流桩</span>

              <p class="red"><img src="<%=basePath%>/img/icon-direction.png" alt="" />&nbsp;63&nbsp;</p>

              </div>

              <div class="stat-col">

                <span>充电桩</span>

                <p class="purple">

                  <img src="<%=basePath%>/img/icon-direction.png" alt="" />&nbsp;161&nbsp;

                </p>

              </div>

                <div class="stat-col last">

                  <span>站点</span>

                  <p class="darkblue">

                    <img src="<%=basePath%>/img/house.png" alt="" />&nbsp;16&nbsp;

                  </p>

                   </div>

                   <div class="clear">

                   </div>

                 </div>

               </div>

             </div>

                   <div class="grid_5 wid">

                                 <div class="box round">

                                   <h2>消耗电量</h2>

                     <div class="block">


                       <div id="chart2"></div>

                     </div>

                   </div>

                 </div>

                 <div class="grid_5 wid">

        <div class="box round">

          <h2>充电频率</h2>

          <div class="block">

            <div id="chart3"></div>

            <!-- <p>

            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor
                        incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
                        exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute
                        irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
                        pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia

            deserunt mollit anim id est laborum.

          </p> -->

           </div>

         </div>

       </div>

       <div class="clear"></div>

     </div>

     <!--wrapper end-->
	<!--Dynamically creates analytics markup-->

</body>

  </html>
