<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    <!-- <link rel="stylesheet" src="<%=basePath%>https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css"> -->
    <link rel="stylesheet" type="text/css" href="<%=basePath%>media/css/jquery.dataTables.css">
    <!-- <link rel="stylesheet" type="text/css" href="<%=basePath%>media/images/resources/demo.css"> -->
    <link rel="stylesheet" type="text/css" href="<%=basePath%>media/images/resources/syntax/shCore.css">

    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/reset.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/reset.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/text.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/grid.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/layout.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/nav.css" media="screen" />
    <link href="<%=basePath%>css/themes/base/jquery.ui.all.css" rel="stylesheet" type="text/css" />

    <link type="text/css" rel="stylesheet" href="<%=basePath%>jedate/skin/jedate.css">
    <script type="text/javascript" src="<%=basePath%>jedate/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="<%=basePath%>jedate/jquery.jedate.js"></script>

    <!-- <script type="text/javascript" language="javascript" src="<%=basePath%>media/js/jquery.js"></script> -->
    <script type="text/javascript" language="javascript" src="<%=basePath%>media/js/jquery.dataTables.js"></script>


    <script type="text/javascript" src="<%=basePath%>js/jquery-ui/jquery.ui.core.min.js"></script>
    <script src="<%=basePath%>js/jquery-ui/jquery.ui.widget.min.js" type="text/javascript"></script>
    <script src="<%=basePath%>js/jquery-ui/jquery.ui.accordion.min.js" type="text/javascript"></script>
    <script src="<%=basePath%>js/jquery-ui/jquery.effects.core.min.js" type="text/javascript"></script>
    <script src="<%=basePath%>js/jquery-ui/jquery.ui.datepicker.min.js" type="text/javascript"></script>
    <script src="<%=basePath%>js/jquery-ui/jquery.ui.progressbar.min.js" type="text/javascript"></script>
    <script type="text/javascript" language="javascript" class="init">
    $(document).ready(function() {
      setDatePicker('date-picker1');
      setDatePicker('date-picker2');

    } );
    function setDatePicker(containerElement) {
        var datePicker = $('#' + containerElement);
        datePicker.datepicker({
          showOn: "button",
          buttonImage: "<%=basePath%>img/calendar.gif",
          buttonImageOnly: true
        });

    }
	</script>
<style media="screen">
td.details-control {
  /*background-image: url('media/images/resources/details_open.png');*/
  background: url('<%=basePath%>media/images/resources/details_open.png') no-repeat center center!important;
  /*background-color: red;*/
  cursor: pointer;
}
tr.shown td.details-control {
  /*background-image: url('media/images/resources/details_close.png');*/
  background: url('<%=basePath%>media/images/resources/details_close.png') no-repeat center center!important;
  /*background-color: purple;*/
}
.searchbox{
  text-align: right;
  padding-right: 30px;
  /*font-size: 14px;*/
}
.h2{
  color: #1b548d;
  /*background:rgba(241,241,241,0.5);*/
  font-size: 1.6em;
  font-weight: bold;
  line-height: 2.4em;
  margin: 10px 0px;
  padding: 5px 0px 5px 20px;
  /*border-bottom: 1px solid #b3cbd6;*/
  border-radius: 5px 5px 0px 0px;
}
</style>
<style>body{font-size:14px !important}</style>
  </head>
  <body >
    <div class="" style="background-color:rgba(241,241,241,0.5)">
      <div class="h2">告警信息列表</div>
    </div>
    <div class="searchbox">
    	<span class="h2">日期：</span>
      <input class="datainp wicon" id="inpstart" type="text" placeholder="开始日期" value=""  readonly>
       ——
      <input class="datainp wicon" id="inpend" type="text" placeholder="结束日期"   readonly>
      <button type="button" class="btn btn-purple" name="button">查询</button>
    </div>
    <div class="" style="background-color:white!important; border-radius:5px; padding:10px;">
      <table id="example" class="display" cellspacing="0" width="100%" >
          <thead>
              <tr>
                  <th></th>
                  <th>充电桩</th>
                  <th>枪</th>
                  <th>app/卡号</th>
                  <th>记录时间</th>
                  <th>充电方式</th>
                  <th>告警描述</th>
                  <th>状态</th>
              </tr>
          </thead>
      </table>

    </div>
  </body>
  <script type="text/javascript">
       $(document).ready(function () {
           var table = $('#example').DataTable({
               "data": testdata.data,
               select:"single",
               "columns": [
                   {
                       "className": 'details-control',
                       "orderable": false,
                       "data": null,
                       "defaultContent": '',
                       "render": function () {
                           return '<i class="fa fa-plus-square" aria-hidden="true"></i>';
                       },
                       width:"15px"
                   },
                   { "data": "name" },
                   { "data": "position" },
                   { "data": "office" },
                   { "data": "start_date"},
                   { "data": "salary" },
                   { "data": "extn" },
                   { "data": null,"defaultContent": "<button class='edit-btn' type='button'>确认</button>"}
               ],
               "order": [[1, 'asc']]
           });
           // Add event listener for opening and closing details
           $('#example tbody').on('click', 'td.details-control', function () {
               var tr = $(this).closest('tr');
               var tdi = tr.find("i.fa");
               var row = table.row(tr);
               if (row.child.isShown()) {
                   // This row is already open - close it
                   row.child.hide();
                   tr.removeClass('shown');
                   tdi.first().removeClass('fa-minus-square');
                   tdi.first().addClass('fa-plus-square');
                   console.log("close");
               }
               else {
                   // Open this row
                   row.child(format(row.data())).show();
                   tr.addClass('shown');
                   tdi.first().removeClass('fa-plus-square');
                   tdi.first().addClass('fa-minus-square');
                   console.log("open");
               }
           });
           table.on("user-select", function (e, dt, type, cell, originalEvent) {
               if ($(cell.node()).hasClass("details-control")) {
                   e.preventDefault();
               }
           });

         //日历选择器初始化调用
               $("#inpstart").jeDate(start);
               $("#inpend").jeDate(end);

       });

      function format(d){
           // `d` is the original data object for the row
           return '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">' +
               '<tr>' +
                   '<td>Full name:</td>' +
                   '<td>' + d.name + '</td>' +
               '</tr>' +
               '<tr>' +
                   '<td>Extension number:</td>' +
                   '<td>' + d.extn + '</td>' +
               '</tr>' +
               '<tr>' +
                   '<td>Extra info:</td>' +
                   '<td>And any further details here (images etc)...</td>' +
               '</tr>' +
           '</table>';
      }
      //实现日期选择联动
      var start = {
          format:'YYYY-MM-DD hh:mm',
          isToday:true,
          isTime:true,
          fixed:true,
          minDate: '2014-06-16 23:59:59', //设定最小日期为当前日期
          isinitVal:true,
          ishmsVal:false,
          maxDate: $.nowDate({DD:0}), //最大日期
          choosefun: function(elem,datas){
              endDates();
          },
          okfun:function (elem,datas) {
              alert(datas);
          }
      };
      var end = {
          format:'YYYY-MM-DD hh:mm',
          isToday:true,
          isTime:true,
          fixed:true,
          isinitVal:true,
          // minDate: $.nowDate({DD:0}), //设定最小日期为当前日期
          maxDate: '2099-06-16 23:59:59', //最大日期
          choosefun: function(elem,datas){
          }
      };
      function endDates() {
          end.trigger = false;
          $("#inpend").jeDate(end);
      }
      var testdata = {
      "data": [
      {
      "name": "Tiger Nixon",
      "position": "System Architect",
      "salary": "$320,800",
      "start_date": "2011/04/25",
      "office": "Edinburgh",
      "extn": "5421"
      },
      {
      "name": "Garrett Winters",
      "position": "Accountant",
      "salary": "$170,750",
      "start_date": "2011/07/25",
      "office": "Tokyo",
      "extn": "8422"
      },
      {
      "name": "Ashton Cox",
      "position": "Junior Technical Author",
      "salary": "$86,000",
      "start_date": "2009/01/12",
      "office": "San Francisco",
      "extn": "1562"
      },
      {
      "name": "Cedric Kelly",
      "position": "Senior Javascript Developer",
      "salary": "$433,060",
      "start_date": "2012/03/29",
      "office": "Edinburgh",
      "extn": "6224"
      },
      {
      "name": "Airi Satou",
      "position": "Accountant",
      "salary": "$162,700",
      "start_date": "2008/11/28",
      "office": "Tokyo",
      "extn": "5407"
      },
      {
      "name": "Brielle Williamson",
      "position": "Integration Specialist",
      "salary": "$372,000",
      "start_date": "2012/12/02",
      "office": "New York",
      "extn": "4804"
      },
      {
      "name": "Herrod Chandler",
      "position": "Sales Assistant",
      "salary": "$137,500",
      "start_date": "2012/08/06",
      "office": "San Francisco",
      "extn": "9608"
      },
      {
      "name": "Rhona Davidson",
      "position": "Integration Specialist",
      "salary": "$327,900",
      "start_date": "2010/10/14",
      "office": "Tokyo",
      "extn": "6200"
      },
      {
      "name": "Colleen Hurst",
      "position": "Javascript Developer",
      "salary": "$205,500",
      "start_date": "2009/09/15",
      "office": "San Francisco",
      "extn": "2360"
      },
      {
      "name": "Sonya Frost",
      "position": "Software Engineer",
      "salary": "$103,600",
      "start_date": "2008/12/13",
      "office": "Edinburgh",
      "extn": "1667"
      },
      {
      "name": "Jena Gaines",
      "position": "Office Manager",
      "salary": "$90,560",
      "start_date": "2008/12/19",
      "office": "London",
      "extn": "3814"
      },
      {
      "name": "Quinn Flynn",
      "position": "Support Lead",
      "salary": "$342,000",
      "start_date": "2013/03/03",
      "office": "Edinburgh",
      "extn": "9497"
      },
      {
      "name": "Charde Marshall",
      "position": "Regional Director",
      "salary": "$470,600",
      "start_date": "2008/10/16",
      "office": "San Francisco",
      "extn": "6741"
      },
      {
      "name": "Haley Kennedy",
      "position": "Senior Marketing Designer",
      "salary": "$313,500",
      "start_date": "2012/12/18",
      "office": "London",
      "extn": "3597"
      },
      {
      "name": "Tatyana Fitzpatrick",
      "position": "Regional Director",
      "salary": "$385,750",
      "start_date": "2010/03/17",
      "office": "London",
      "extn": "1965"
      },
      {
      "name": "Michael Silva",
      "position": "Marketing Designer",
      "salary": "$198,500",
      "start_date": "2012/11/27",
      "office": "London",
      "extn": "1581"
      },
      {
      "name": "Paul Byrd",
      "position": "Chief Financial Officer (CFO)",
      "salary": "$725,000",
      "start_date": "2010/06/09",
      "office": "New York",
      "extn": "3059"
      },
      {
      "name": "Gloria Little",
      "position": "Systems Administrator",
      "salary": "$237,500",
      "start_date": "2009/04/10",
      "office": "New York",
      "extn": "1721"
      },
      {
      "name": "Bradley Greer",
      "position": "Software Engineer",
      "salary": "$132,000",
      "start_date": "2012/10/13",
      "office": "London",
      "extn": "2558"
      },
      {
      "name": "Dai Rios",
      "position": "Personnel Lead",
      "salary": "$217,500",
      "start_date": "2012/09/26",
      "office": "Edinburgh",
      "extn": "2290"
      },
      {
      "name": "Jenette Caldwell",
      "position": "Development Lead",
      "salary": "$345,000",
      "start_date": "2011/09/03",
      "office": "New York",
      "extn": "1937"
      },
      {
      "name": "Yuri Berry",
      "position": "Chief Marketing Officer (CMO)",
      "salary": "$675,000",
      "start_date": "2009/06/25",
      "office": "New York",
      "extn": "6154"
      },
      {
      "name": "Caesar Vance",
      "position": "Pre-Sales Support",
      "salary": "$106,450",
      "start_date": "2011/12/12",
      "office": "New York",
      "extn": "8330"
      },
      {
      "name": "Doris Wilder",
      "position": "Sales Assistant",
      "salary": "$85,600",
      "start_date": "2010/09/20",
      "office": "Sidney",
      "extn": "3023"
      },
      {
      "name": "Angelica Ramos",
      "position": "Chief Executive Officer (CEO)",
      "salary": "$1,200,000",
      "start_date": "2009/10/09",
      "office": "London",
      "extn": "5797"
      },
      {
      "name": "Gavin Joyce",
      "position": "Developer",
      "salary": "$92,575",
      "start_date": "2010/12/22",
      "office": "Edinburgh",
      "extn": "8822"
      },
      {
      "name": "Jennifer Chang",
      "position": "Regional Director",
      "salary": "$357,650",
      "start_date": "2010/11/14",
      "office": "Singapore",
      "extn": "9239"
      },
      {
      "name": "Brenden Wagner",
      "position": "Software Engineer",
      "salary": "$206,850",
      "start_date": "2011/06/07",
      "office": "San Francisco",
      "extn": "1314"
      },
      {
      "name": "Fiona Green",
      "position": "Chief Operating Officer (COO)",
      "salary": "$850,000",
      "start_date": "2010/03/11",
      "office": "San Francisco",
      "extn": "2947"
      },
      {
      "name": "Shou Itou",
      "position": "Regional Marketing",
      "salary": "$163,000",
      "start_date": "2011/08/14",
      "office": "Tokyo",
      "extn": "8899"
      },
      {
      "name": "Michelle House",
      "position": "Integration Specialist",
      "salary": "$95,400",
      "start_date": "2011/06/02",
      "office": "Sidney",
      "extn": "2769"
      },
      {
      "name": "Suki Burks",
      "position": "Developer",
      "salary": "$114,500",
      "start_date": "2009/10/22",
      "office": "London",
      "extn": "6832"
      },
      {
      "name": "Prescott Bartlett",
      "position": "Technical Author",
      "salary": "$145,000",
      "start_date": "2011/05/07",
      "office": "London",
      "extn": "3606"
      },
      {
      "name": "Gavin Cortez",
      "position": "Team Leader",
      "salary": "$235,500",
      "start_date": "2008/10/26",
      "office": "San Francisco",
      "extn": "2860"
      },
      {
      "name": "Martena Mccray",
      "position": "Post-Sales support",
      "salary": "$324,050",
      "start_date": "2011/03/09",
      "office": "Edinburgh",
      "extn": "8240"
      },
      {
      "name": "Unity Butler",
      "position": "Marketing Designer",
      "salary": "$85,675",
      "start_date": "2009/12/09",
      "office": "San Francisco",
      "extn": "5384"
      },
      {
      "name": "Howard Hatfield",
      "position": "Office Manager",
      "salary": "$164,500",
      "start_date": "2008/12/16",
      "office": "San Francisco",
      "extn": "7031"
      },
      {
      "name": "Hope Fuentes",
      "position": "Secretary",
      "salary": "$109,850",
      "start_date": "2010/02/12",
      "office": "San Francisco",
      "extn": "6318"
      },
      {
      "name": "Vivian Harrell",
      "position": "Financial Controller",
      "salary": "$452,500",
      "start_date": "2009/02/14",
      "office": "San Francisco",
      "extn": "9422"
      },
      {
      "name": "Timothy Mooney",
      "position": "Office Manager",
      "salary": "$136,200",
      "start_date": "2008/12/11",
      "office": "London",
      "extn": "7580"
      },
      {
      "name": "Jackson Bradshaw",
      "position": "Director",
      "salary": "$645,750",
      "start_date": "2008/09/26",
      "office": "New York",
      "extn": "1042"
      },
      {
      "name": "Olivia Liang",
      "position": "Support Engineer",
      "salary": "$234,500",
      "start_date": "2011/02/03",
      "office": "Singapore",
      "extn": "2120"
      },
      {
      "name": "Bruno Nash",
      "position": "Software Engineer",
      "salary": "$163,500",
      "start_date": "2011/05/03",
      "office": "London",
      "extn": "6222"
      },
      {
      "name": "Sakura Yamamoto",
      "position": "Support Engineer",
      "salary": "$139,575",
      "start_date": "2009/08/19",
      "office": "Tokyo",
      "extn": "9383"
      },
      {
      "name": "Thor Walton",
      "position": "Developer",
      "salary": "$98,540",
      "start_date": "2013/08/11",
      "office": "New York",
      "extn": "8327"
      },
      {
      "name": "Finn Camacho",
      "position": "Support Engineer",
      "salary": "$87,500",
      "start_date": "2009/07/07",
      "office": "San Francisco",
      "extn": "2927"
      },
      {
      "name": "Serge Baldwin",
      "position": "Data Coordinator",
      "salary": "$138,575",
      "start_date": "2012/04/09",
      "office": "Singapore",
      "extn": "8352"
      },
      {
      "name": "Zenaida Frank",
      "position": "Software Engineer",
      "salary": "$125,250",
      "start_date": "2010/01/04",
      "office": "New York",
      "extn": "7439"
      },
      {
      "name": "Zorita Serrano",
      "position": "Software Engineer",
      "salary": "$115,000",
      "start_date": "2012/06/01",
      "office": "San Francisco",
      "extn": "4389"
      },
      {
      "name": "Jennifer Acosta",
      "position": "Junior Javascript Developer",
      "salary": "$75,650",
      "start_date": "2013/02/01",
      "office": "Edinburgh",
      "extn": "3431"
      },
      {
      "name": "Cara Stevens",
      "position": "Sales Assistant",
      "salary": "$145,600",
      "start_date": "2011/12/06",
      "office": "New York",
      "extn": "3990"
      },
      {
      "name": "Hermione Butler",
      "position": "Regional Director",
      "salary": "$356,250",
      "start_date": "2011/03/21",
      "office": "London",
      "extn": "1016"
      },
      {
      "name": "Lael Greer",
      "position": "Systems Administrator",
      "salary": "$103,500",
      "start_date": "2009/02/27",
      "office": "London",
      "extn": "6733"
      },
      {
      "name": "Jonas Alexander",
      "position": "Developer",
      "salary": "$86,500",
      "start_date": "2010/07/14",
      "office": "San Francisco",
      "extn": "8196"
      },
      {
      "name": "Shad Decker",
      "position": "Regional Director",
      "salary": "$183,000",
      "start_date": "2008/11/13",
      "office": "Edinburgh",
      "extn": "6373"
      },
      {
      "name": "Michael Bruce",
      "position": "Javascript Developer",
      "salary": "$183,000",
      "start_date": "2011/06/27",
      "office": "Singapore",
      "extn": "5384"
      },
      {
      "name": "Donna Snider",
      "position": "Customer Support",
      "salary": "$112,000",
      "start_date": "2011/01/25",
      "office": "New York",
      "extn": "4226"
      }
      ]
      };
  </script>
</html>
