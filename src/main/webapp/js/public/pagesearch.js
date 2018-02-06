////MODIFIED BY HANMJ 20170717 BEGIN
////切换每页数量
//function changePageSize(url) {
//	//alert(url);
//	var pageNow = 1;
//	searchByPage(pageNow, url);
//}
////MODIFIED BY HANMJ 20170717 END

// 首页 切换每页数量
function PageHead(url) {
	var pageNow = 1;
	searchByPage(pageNow, url);
};

// 上一页
function PagePre(url) {
	var pagenow = $("#currPage").html();
	var pageNow;
	if (Number(pagenow) > Number(1)) {
		pageNow = Number(pagenow) - Number(1);
	} else if (pagenow == 1) {
		pageNow = pagenow;
	}
	searchByPage(pageNow, url);
};

// 下一页
function PageNext(url) {
		
	//当前页数
	var pagenow = $("#currPage").html();
	//总页数
	var totalPageCount = $("#totalPage").html();
	var pageNow;
	if (pagenow == totalPageCount) {
		pageNow = pagenow;
	} else if (Number(pagenow) + Number(1) <= Number(totalPageCount)) {
		pageNow = Number(pagenow) + Number(1);
	}
	searchByPage(pageNow, url);
};

//切换每页数量
function changePageSize(url) {
	var pageNow = 1;
	searchByPage(pageNow,url);
}	

// 尾页
function PageEnd(url) {
	var totalPageCount = $("#totalPage").html();
	var pageNow = totalPageCount;
	searchByPage(pageNow, url);
};

// 每页显示设置， 页码切换 查询 保存条件
function searchByPage(pageNow, url) {
	var pageSize = $("#pageSize-select").val();
	url = url + "?pageSize=" + pageSize + "&pageNow=" + pageNow;
	$.ajax({
				type : "post",
				data : $("#search-form").serialize(), //序列化表单作为参数
				dataType : "json", // 告诉ajax，返回的数据时json类型的，这样就可以用data.xxx 来取值
				url : url,  //进去url
				success : function(data) {
					var page = data;
					$("#totalPage").html(page.totalPageCount);
					$("#totalCount").html(page.totalCount);
					$("#currPage").html(page.pageNow);
					$("#data_body").html("");
					if (page.totalPageCount == "") {
						str = "<tr>"
								+ "    <td style='text-align:left' colspan='21'>没有查询到数据！</td>"
								+ "</tr>";
						$("#data_body").append(str);
					} else {
						var myTemplate = Handlebars.compile($("#table-template").html());
						$("#data_body").html(myTemplate(page));
					}
					
				},
				error : function(data) {
					alert("错误！");
				}
			});
 };
