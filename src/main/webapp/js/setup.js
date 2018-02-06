﻿function setSidebarHeight(){
	setTimeout(function(){
	var height = $(document).height();
	$('.grid_12').each(function () {
		height -= $(this).outerHeight();
	});
	height -= $('#site_info').outerHeight();
	height-=1;
	$('.sidemenu').css('height', height);
},100);
}

// 返回年月日的对象

	var myDate = new Date();
      //获取当前年份(2位)
	var y =	myDate.getFullYear();    //获取完整的年份(4位,1970-????)
	var m = myDate.getMonth()+1;       //获取当前月份(0-11,0代表1月)
	var d = myDate.getDate();        //获取当前日(1-31)

	// console.log(y+"======"+m+"======="+d);
	return {y:y,m:m,d:d};
}
//根据范围参数a,b返回一个长度为d的随机数数组
// <!--a,b表示随机数的范围；d表示长度-->
function getRandomNo(a,b,d){
  var array = new Array();
	for (var i = 0; i < d; i++) {
			array[i] = parseInt(Math.random()*Math.abs(a-b)+Math.min(a,b),10);
	}
	return array;
}
//将月份的天数组成一个数组返回
function getDaysInMonth(year,month){
			month = parseInt(month,10); //parseInt(number,type)这个函数后面如果不跟第2个参数来表示进制的话，默认是10进制。
			
			
		  for (var i = 0; i < temp.getDate(); i++) {
						
			}
		 return array;
}
//返回一个图标横轴数组根据日期对象
/*参数为一个日期的对象*/
function getDaysOfMonth(obj){
			var array = new Array();
      var month = obj.m //当前月份

			var ds = getDInMonth(obj.y,month-1);//上月的天数
			var d = obj.d //当天的日期
			// ds=30;
			// d = 29;

			for (var i = 0; i < ds; i++) {

				 if (ds-ds+d+i+1 > ds) {

						  array[i] = ds -(ds-d)+i+1 - ds;
							if (array[i] == 1) {
								 array[i] == month+"月"+array[i];
							}
						  // console.log("当月"+array[i]);
					}else{

					    array[i] = ds -(ds-d)+i+1;
							// console.log("上个月" + array[i]);
				  }
					// console.log(ds);

			}
	return array;
}
//返回月份的天数
function getDInMonth(year,month){
 //parseInt(number,type)这个函数后面如果不跟第2个参数来表示进制的话，默认是10进制。
    month = parseInt(month,10);
    var temp = new Date(year,month,0);
		return temp.getDate();
}
//画详情页的图
function setupDetailPileChart(containerElementId,type) {

	  var dateObj = getDateYearMonth();

    var s1 = getRandomNo(30,100,30);
    var s2 = getRandomNo(80,500,30);
    var s3 = getRandomNo(130,600,30);
    // var s4 = getRandomNo(100,1000,dateObj.d);
		// Can specify a custom tick Array.
		// Ticks should match up one for each y value (category) in the series.
		var render;
		var ticks = getDaysOfMonth(dateObj);
		switch (type) {
			case 1:
			render = $.jqplot.LinearAxisRender;
			break;
			case 2:
			render = $.jqplot.BarRenderer;
			break;
			default:
			render = $.jqplot.LinearAxisRender;
			break;
		}
		var plot1 = $.jqplot(containerElementId, [s1, s2, s3], {
			 seriesDefaults: {
				 renderer: render,
				 showTickMarks:true,
				 rendererOptions: {
					//设置是否显示刻度,
					 fillToZero: true
				 }

			 },
			 series: [
				 { label: '电量' },
				 { label: '频率' },
				 { label: '金额' }
			 ],
				 legend: {
					 show: true,
					 placement: 'outsideGrid'
				 },
        axes: {
					// Use a category axis on the x axis and use our custom ticks.
					xaxis: {
						renderer: $.jqplot.CategoryAxisRenderer,
						ticks: ticks
					},
						yaxis: {
							 pad: 0.5,
							 tickOptions: { formatString: '%d' }
						 }
					 }
				 });
			 }
//Dashboard chart
function setupDashboardChart(containerElementId,type) {
	var dateObj = getDateYearMonth();

	var s1 = getRandomNo(30,100,30);
	var s2 = getRandomNo(80,500,30);
	var s3 = getRandomNo(130,600,30);
	var s4 = getRandomNo(100,1000,30);
	// Can specify a custom tick Array.
	// Ticks should match up one for each y value (category) in the series.
	var render;
	var ticks = getDaysOfMonth(dateObj);
		switch (type) {
			case 1:
			render = $.jqplot.LinearAxisRender;
			break;
			case 2:
			render = $.jqplot.BarRenderer;
			break;
			default:
			render = $.jqplot.LinearAxisRender;
			break;
		}
		var plot1 = $.jqplot(containerElementId, [s1, s2, s3, s4], {
			// The "seriesDefaults" option is an options object that will
			 // be applied to all series in the chart.
			 seriesDefaults: {
				 renderer: render,
				 showTickMarks:true,
				 rendererOptions: {
					 fillToZero: true
				 }
			 },

			 series: [
				 { label: '尚宽' },
				 { label: '安速达' },
				 { label: '鑫港' },
				 { label: '东客站' },
				 { label: '五湖饮品' }
			 ],

				 legend: {
					 show: true,
					 placement: 'outsideGrid'
				 },
        axes: {
					// Use a category axis on the x axis and use our custom ticks.
					xaxis: {
						renderer: $.jqplot.CategoryAxisRenderer,
						ticks: ticks
					},
					 // Pad the y axis just a little so bars can get close to, but
					  // not touch, the grid boundaries.  1.2 is the default padding.
						yaxis: {
							 pad: 0.5,
							 tickOptions: { formatString: '￥%d' }
						 }
					 }
				 });
			 }
//points charts
 drawPointsChart(containerElement) {
    var cosPoints = [];
		for (var i = 0; i < 2 * Math.PI; i += 0.4) {
			cosPoints.push([i, Math.cos(i)]);
		}
		var sinPoints = [];
		for (var i = 0; i < 2 * Math.PI; i += 0.4) {
			sinPoints.push([i, 2 * Math.sin(i - .8)]);
		}
		var powPoints1 = [];
		for (var i = 0; i < 2 * Math.PI; i += 0.4) {
			powPoints1.push([i, 2.5 + Math.pow(i / 4, 2)]);
		}
    var powPoints2 = [];
		for (var i = 0; i < 2 * Math.PI; i += 0.4) {
			powPoints2.push([i, -2.5 - Math.pow(i / 4, 2)]);
		}

    var plot3 = $.jqplot(containerElement, [cosPoints, sinPoints, powPoints1, powPoints2],
    {
			title: 'Line Style Options',
		 // Series options are specified as an array of &quot;, one object
		 // for each series.
		 series: [
			 {
			  // Change our line width and use a diamond shaped marker.
				lineWidth: 2,
				markerOptions: { style: 'dimaond' }
			},

		 {
						// Don't show a line, just show markers.
						// Make the markers 7 pixels with an 'x' style
						showLine: false,
						markerOptions: {
							size: 7,
							style: "x"
						}
			},
      {
				markerOptions: {
					style: "circle"
				 }
			
      {
				// Use a thicker, 5 pixel line and 10 pixel
				// filled square markers.
				lineWidth: 5,
				markerOptions: {
					style: "filledSquare",
					size: 10
				}
			}
		]
	}
);

//draw pie chart
function drawPieChart(containerElement) {
	var data = [
		 ['Heavy Industry', 12],
		 ['Retail', 9],
		 ['Light Industry', 14],
		 ['Out of home', 16],
		 ['Commuting', 7],
		 ['Orientation', 9]
	 ];
	 var plot1 = jQuery.jqplot('chart1', [data],
    {
			seriesDefaults: {
				// Make this a pie chart.
				renderer: jQuery.jqplot.PieRenderer,
				rendererOptions: {
					// Put data labels on the pie slices.
					// By default, labels show the percentage of the slice.
					showDataLabels: true
				}
			},
			legend: {
				show: true,
				location: 'e'
			}
		}
  );
}
//draw donut chart
function drawDonutChart(containerElement) {
    var s1 = [['a', 6], ['b', 8], ['c', 14], ['d', 20]];
		var s2 = [['a', 8], ['b', 12], ['c', 6], ['d', 9]];
    var plot3 = $.jqplot(containerElement, [s1, s2], {
			seriesDefaults: {
				renderer: $.jqplot.DonutRenderer,
				rendererOptions: {
					// Donut's can be cut into slices like pies.
					sliceMargin: 3,
					// Pies and donuts can start at any arbitrary angle.
					startAngle: -90,
					showDataLabels: true,
					// By default, data labels show the percentage of the donut/pie.
					// You can show the data 'value' or data 'label' instead.
					dataLabels: 'value'
				}
			}
		});
	}

//draw bar chart
function drawBarchart(containerElement) {
	var s1 = [200, 600, 700, 1000];
	var s2 = [460, -210, 690, 820];
	var s3 = [-260, -440, 320, 200];
	 // Can specify a custom tick Array.
	  // Ticks should match up one for each y value (category) in the series.
		 var ticks = ['May', 'June', 'July', 'August'];
		 var plot1 = $.jqplot(containerElement, [s1, s2, s3],
			 {
			 // The "seriesDefaults" option is an options object that will
			 // be applied to all series in the chart.
			 seriesDefaults: {
				 renderer: $.jqplot.BarRenderer,
				 rendererOptions: {
					 fillToZero: true
				 }
			 },
			 // Custom labels for the series are specified with the "label"
			  // option on the series option.  Here a series option object
				 // is specified for each series.
				 series: [
            { label: 'Hotel' },
						{ label: 'Event Regristration' },
						{ label: 'Airfare' }
					 ],
					  // Show the legend and put it outside the grid, but inside the
					  // plot container, shrinking the grid to accomodate the legend.
						// A value of "outside" would not shrink the grid and allow
						// the legend to overflow the container.
						legend: {
							show: true,
							placement: 'outsideGrid'
						},
        axes: {
					// Use a category axis on the x axis and use our custom ticks.
					 xaxis: {
						 renderer: $.jqplot.CategoryAxisRenderer,
						 ticks: ticks
					 },
            // Pad the y axis just a little so bars can get close to, but
						 // not touch, the grid boundaries.  1.2 is the default padding.
						 yaxis: {
							 pad: 1.05,
							 tickOptions: { formatString: '$%d' }
						 }
					 }
				 });
			 }
//draw bubble chart
function drawBubbleChart(containerElement) {
    var arr = [
			[11, 123, 1236, ""],
			[45, 92, 1067, ""],
			[24, 104, 1176, ""],
			[50, 23, 610, "A"],
			[18, 17, 539, ""],
			[7, 89, 864, ""],
			[2, 13, 1026, ""]
		 ];
    var plot1b = $.jqplot(containerElement, [arr], {
			seriesDefaults: {
				renderer: $.jqplot.BubbleRenderer,
				rendererOptions: {
					bubbleAlpha: 0.6,
					highlightAlpha: 0.8,
					showLabels: false
				},
				shadow: true,
				shadowAlpha: 0.05
			}
		});

    // Legend is a simple table in the html.
		// Dynamically populate it with the labels from each data value.
		$.each(arr, function (index, val) {
			$('#' + containerElement).append('<tr><td>' + val[3] + '</td><td>' + val[2] + '</td></tr>');
		});

    // Now bind function to the highlight event to show the tooltip
		// and highlight the row in the legend.
		$('#' + containerElement).bind('jqplotDataHighlight',
		function (ev, seriesIndex, pointIndex, data, radius) {
			var chart_left = $('#' + containerElement).offset().left,
			chart_top = $('#' + containerElement).offset().top,
			x = plot1b.axes.xaxis.u2p(data[0]),  // convert x axis unita to pixels
			y = plot1b.axes.yaxis.u2p(data[1]);  // convert y axis units to pixels
		var color = 'rgb(50%,50%,100%)';
		$('#tooltip1b').css({
			left: chart_left + x + radius + 5, top: chart_top + y
		});
		$('#tooltip1b').html('<span style="font-size:14px;font-weight:bold;color:' +
		color + ';">' + data[3] + '</span><br />' + 'x: ' + data[0] +
		'<br />' + 'y: ' + data[1] + '<br />' + 'r: ' + data[2]);
		$('#tooltip1b').show();
		$('#legend1b tr').css('background-color', '#ffffff');
		$('#legend1b tr').eq(pointIndex + 1).css('background-color', color);
	});

    // Bind a function to the unhighlight event to clean up after highlighting.
		 $('#' + containerElement).bind('jqplotDataUnhighlight',
		 function (ev, seriesIndex, pointIndex, data) {
			 
			 $('#tooltip1b').hide();
			 $('#' + containerElement + ' tr').css('background-color', '#ffffff');
		 });
}

//-------------------------------------------------------------- */
// Gallery Actions
//-------------------------------------------------------------- */

function initializeGallery() {
	$("ul.gallery li").hover(function () {
		var $image = (this);
		// Shows actions when hovering
		 $(this).find(".actions").show();
		 // If the "x" icon is pressed, show confirmation (#dialog-confirm)
		 $(this).find(".actions .delete").click(function () {
            // Confirmation
						$("#dialog-confirm").dialog({
							resizable: false,
							modal: true,
							minHeight: 0,
							draggable: false,
							buttons: {
								"Delete": function () {
									$(this).dialog("close");
									// Removes image if delete is pressed
									$($image).fadeOut('slow', function () {
										$($image).remove();
									});
								},
								// Removes dialog if cancel is pressed
								Cancel: function () {
									$(this).dialog("close");
								}
							}
						});
            return false;
        });
        // Changes opacity of the image
				$(this).find("img").css("opacity", "0.5");
				// On hover off
				$(this).hover(function () {
				},
				function () {
            // Hides actions when hovering off
						$(this).find(".actions").hide();
						// Changes opacity of the image back to normal
						$(this).find("img").css("opacity", "1");
					});
    });
}
function setupGallery() {
	initializeGallery();
	//-------------------------------------------------------------- */
	// 	**** Gallery Sorting (Quicksand) ****
	//
	// 	For more information go to:
	//	http://razorjack.net/quicksand/
	//-------------------------------------------------------------- */
	$('ul.gallery').each(function () {
        // get the action filter option item on page load
				var $fileringType = $("ul.sorting li.active a[data-type]").first().before(this);
				var $filterType = $($fileringType).attr('data-id');
        var $gallerySorting = $(this).parent().prev().children('ul.sorting');
				 // get and assign the ourHolder element to the
				 // $holder varible for use later
				 var $holder = $(this);
        // clone all items within the pre-assigned $holder element
				var $data = $holder.clone();
        // attempt to call Quicksand when a filter option
				// item is clicked
				$($gallerySorting).find("a[data-type]").click(function (e) {
					// reset the active class on all the buttons
					$($gallerySorting).find("a[data-type].active").removeClass('active');
					// assign the class of the clicked filter option
					// element to our $filterType variable
					var $filterType = $(this).attr('data-type');
					$(this).addClass('active');
					if ($filterType == 'all') {
						// assign all li items to the $filteredData var when
						 // the 'All' filter option is clicked
						 var $filteredData = $data.find('li');
					 }
					 else {
						 // find all li elements that have our required $filterType
						 // values for the data-type element
						 var $filteredData = $data.find('li[data-type=' + $filterType + ']');
					 }

            // call quicksand and assign transition parameters
            $holder.quicksand($filteredData, {
							duration: 800,
							easing: 'easeInOutQuad',
							useScaling: true,
							adjustHeight: 'auto'
						}, function () {
							$('.popup').facebox();
							initializeGallery();
						});
            return false;
        });

    });
}

//setup pretty-photo
function setupPrettyPhoto() {
    $("a[rel^='prettyPhoto']").prettyPhoto();
}

//setup tinyMCE
function setupTinyMCE() {
	$('textarea.tinymce').tinymce({
		script_url: 'js/tiny-mce/tiny_mce.js',
		theme: "advanced",
		plugins: "autolink,lists,pagebreak,style,layer,table,save,advhr,advimage,advlink,emotions,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template,advlist",
		// Theme options
		theme_advanced_buttons1: "save,newdocument,|,bold,italic,underline,strikethrough,|,justifyleft,justifycenter,justifyright,justifyfull,styleselect,formatselect,fontselect,fontsizeselect",
		theme_advanced_buttons2: "cut,copy,paste,pastetext,pasteword,|,search,replace,|,bullist,numlist,|,outdent,indent,blockquote,|,undo,redo,|,link,unlink,anchor,image,cleanup,help,code,|,insertdate,inserttime,preview,|,forecolor,backcolor",
		theme_advanced_buttons3: "tablecontrols,|,hr,removeformat,visualaid,|,sub,sup,|,charmap,emotions,iespell,media,advhr,|,print,|,ltr,rtl,|,fullscreen",
		theme_advanced_buttons4: "insertlayer,moveforward,movebackward,absolute,|,styleprops,|,cite,abbr,acronym,del,ins,attribs,|,visualchars,nonbreaking,template,pagebreak",
		theme_advanced_toolbar_location: "top",
		theme_advanced_toolbar_align: "left",
		theme_advanced_statusbar_location: "bottom",
		theme_advanced_resizing: true,
    // Example content CSS (should be your site CSS)
		content_css: "css/content.css",
		// Drop lists for link/image/media/template dialogs
		template_external_list_url: "lists/template_list.js",
		external_link_list_url: "lists/link_list.js",
		external_image_list_url: "lists/image_list.js",
		media_external_list_url: "lists/media_list.js",

    template_replace_values: {
					username: "Some User",
					staffid: "991234"
				}
			});
		}

//setup DatePicker
setDatePicker(containerElement) {
	var datePicker = $('#' + containerElement);


	datePicker.datepicker({
							 defaultDate: datePicker.val(),
							 dateFormat: "yy-mm-dd",
							 showSecond: true,
							 timeFormat: 'hh:mm:ss',
							 stepHour: 1,
							 stepMinute: 1,
							 stepSecond: 1
					 })
	// datePicker.datepicker({
	// 	showOn: "button",
	// 	buttonImage: "img/calendar.gif",
	// 	buttonImageOnly: true
		// });

//setup progressbar
setupProgressbar(containerElement) {
	$("#" + containerElement).progressbar({
		value: 59
	});


//setup dialog box
setupDialogBox(containerElement, associatedButton) {
	$.fx.speeds._default = 1000;
	$("#" + containerElement).dialog({
		autoOpen: false,
		show: "blind",
		hide: "explode"
	});

	$("#" + containerElement).dialog("open");
	return false;
});

//setup accordion
setupAccordion(containerElement) {
	$("#" + containerElement).accordion();
}
	//setup radios and checkboxes
	//function setupGrumbleToolTip(elementid) {
	//    initializeGrumble(elementid);
	
	
	//    });
	//}
	//function initializeGrumble(elementid) {
	//    $('#' + elementid).grumble(
	//	{
	//	    text: 'Whoaaa, this is a lot of text that i couldn\'t predict',
	//	    angle: 85,
	//	    distance: 50,
	//	    showAfter: 1000,
	//	    hideAfter: 2000
	//	}
	//);
	//}
	//setup left menu
	setupLeftMenu() {
    $("#section-menu")
        .accordion({
					"header": "a.menuitem"
				})
        .bind("accordionchangestart", function (e, data) {
					data.newHeader.next().andSelf().addClass("current");
				  data.oldHeader.next().andSelf().removeClass("current");
				})
        .find("a.menuitem:first").addClass("current")
				.next().addClass("current");
				$('#section-menu .submenu').css('height','auto');
	}