    function initFileForm(data) {
	initFormHead(data);
	initAmg();
	initOption();
	initFormBody(data);
}
function initFormHead(data) {
	var contentbody = document.getElementsByClassName("admin-content-body")[0];
	contentbody.innerHTML = "";
	var amcfampadding = document.createElement("div");
	amcfampadding.classList.add("am-cf", "am-padding", "am-padding-bottom-0");
	var amf1 = document.createElement("div");
	amf1.classList.add("am-f1", "am-cf");
	var strong = document.createElement("strong");
	strong.classList.add("am-text-primary", "am-text-lg");
	strong.innerHTML = "文件列表"
	var smal = document.createElement("small");
	smal.innerHTML = "Table";
	amf1.appendChild(strong);
	amf1.appendChild(smal);
	amcfampadding.appendChild(amf1);
	contentbody.appendChild(amcfampadding);
	var hr = document.createElement("hr");
	contentbody.appendChild(hr);

}
function initAmg() {
	var contentbody = document.getElementsByClassName("admin-content-body")[0];
	var amgdiv = document.createElement("div");
	amgdiv.classList.add("am-g");
	var amgusm = document.createElement("div");
	amgusm.classList.add("am-u-sm-12", "am-u-md-6");
	var btntool = document.createElement("div");
	btntool.classList.add("am-btn-toolbar");
	var btngroup = document.createElement("div");
	btngroup.classList.add("am-btn-group", "am-btn-group-xs");
	var btn1 = document.createElement("button");
	var span1 = document.createElement("span");
	btn1.classList.add("am-btn", "am-btn-default");
	span1.classList.add("am-icon-plus");
	span1.innerHTML = "新增";
	btn1.appendChild(span1);
	var btn2 = document.createElement("button");
	var span2 = document.createElement("span");
	btn2.classList.add("am-btn", "am-btn-default");
	span2.classList.add("am-icon-save");
	span1.innerHTML = "保存";
	btn2.appendChild(span2);
	var btn3 = document.createElement("button");
	var span3 = document.createElement("span");
	btn3.classList.add("am-btn", "am-btn-default");
	span3.classList.add("am-icon-archive");
	span3.innerHTML = "审核";
	btn3.appendChild(span3);
	var btn4 = document.createElement("button");
	var span4 = document.createElement("span");
	btn4.classList.add("am-btn", "am-btn-default");
	span4.classList.add("am-icon-trash-o");
	span4.innerHTML = "删除";
	btn4.appendChild(span4);
	btngroup.appendChild(btn1);
	btngroup.appendChild(btn2);
	btngroup.appendChild(btn3);
	btngroup.appendChild(btn4);
	btntool.appendChild(btngroup);
	amgusm.appendChild(btntool);
	amgdiv.appendChild(amgusm);
	contentbody.appendChild(amgdiv);

}
function initOption() {

}
function initFormBody(data) {
	initHead();
	initbody(data);
	initfoot();
}
function initHead() {
	var contentbody = document.getElementsByClassName("admin-content-body")[0];
	var amgdiv = document.createElement("div");
	amgdiv.classList.add("am-g");
	var amgusm = document.createElement("div");
	amgusm.classList.add("am-u-sm-12");
	var amform = document.createElement("form");
	amform.classList.add("am-form");
	var formtable = document.createElement("table");
	formtable.classList.add("am-table", "am-table-striped", "am-table-hove",
			"table-main");
	var formthead = document.createElement("thead");
	var trhead = document.createElement("tr");
	var th1 = document.createElement("th");
	th1.classList.add("table-check");
	var input = document.createElement("input")
	input.type = "checkbox";
	th1.appendChild(input);
	var th2 = document.createElement("th");
	th2.classList.add("table-id");
	th2.innerHTML = "ID";
	var th3 = document.createElement("th");
	th3.classList.add("table-title");
	th3.innerHTML = "作者";
	var th4 = document.createElement("th");
	th4.classList.add("table-type");
	th4.innerHTML = "类别";
	var th5 = document.createElement("th");
	th5.classList.add("table-author", "am-hide-sm-only");
	th5.innerHTML = "标题"
	var th6 = document.createElement("th");
	th6.classList.add("table-date", "am-hide-sm-only");
	th6.innerHTML = "修改日期"
	var th7 = document.createElement("th");
	th7.classList.add("table-set");
	th7.innerHTML = "操作"
	trhead.appendChild(th1);
	trhead.appendChild(th2);
	trhead.appendChild(th3);
	trhead.appendChild(th4);
	trhead.appendChild(th5);
	trhead.appendChild(th6);
	trhead.appendChild(th7);
	formthead.appendChild(trhead);
	var tbody = document.createElement("tbody");
	formtable.appendChild(formthead);
	formtable.appendChild(tbody);
	amform.appendChild(formtable);
	amgusm.appendChild(amform);
	amgdiv.appendChild(amgusm);
	contentbody.appendChild(amgdiv);
}
function initbody(data) {
	var table = document.getElementsByClassName("table-main")[0].children[1];
	for (var i = 0; i < data.length; i++) {
		var item = initItem(data[i], i);
		table.appendChild(item);

	}

}
function initItem(arg, i) {
	var tr = document.createElement("tr");
	var td1 = document.createElement("td");
	var input = document.createElement("input");
	input.type = "checkbox";
	td1.appendChild(input);
	var td2 = document.createElement("td");
	td2.innerHTML = i;
	var td3 = document.createElement("td");
	var a = document.createElement("a");
	a.href = "#";
	a.innerHTML = "lijuny";
	td3.appendChild(a);
	var td4 = document.createElement("td");
	td4.innerHTML = "default";
	var td5 = document.createElement("td");
	td5.classList.add("am-hide-sm-only1");
	td5.innerHTML = arg;
	var td6 = document.createElement("td");
	td6.classList.add("am-hide-sm-only");
	td6.innerHTML = "2014年9月4日 7:28:47";
	var td7 = document.createElement("td");
	var ambtn = document.createElement("div");
	ambtn.classList.add("am-btn-toolbar");
	var ambtngroup = document.createElement("div");
	ambtngroup.classList.add("am-btn-group", "am-btn-group-xs");
	var btn1 = document.createElement("button");
	btn1.classList.add("am-btn", "am-btn-default", "am-btn-xs",
			"am-text-secondary");
	btn1.addEventListener("click", showListByfilename, false);
	btn1.type = "button";
	var span1 = document.createElement("span");
	span1.classList.add("am-icon-pencil-square-o");
	span1.innerText = "showlist";
	btn1.appendChild(span1);
	var btn2 = document.createElement("button");
	btn2.classList.add("am-btn", "am-btn-default", "am-btn-xs",
			"am-hide-sm-only");
	btn2.type = "button";
	var span2 = document.createElement("span");
	span2.classList.add("am-icon-copy");
	span2.innerText = "copy";
	btn2.appendChild(span2);
	var btn3 = document.createElement("button");
	btn3.type = "button";
	btn3.classList.add("am-btn", "am-btn-default", "am-btn-xs",
			"am-text-danger", "am-hide-sm-only");
	var span3 = document.createElement("span");
	span3.classList.add("am-icon-trash-o");
	span3.innerText = "delete";
	btn3.appendChild(span3);
	ambtngroup.appendChild(btn1);
	ambtngroup.appendChild(btn2);
	ambtngroup.appendChild(btn3);
	ambtn.appendChild(ambtngroup);
	td7.appendChild(ambtn);
	tr.appendChild(td1);
	tr.appendChild(td2);
	tr.appendChild(td3);
	tr.appendChild(td4);
	tr.appendChild(td5);
	tr.appendChild(td6);
	tr.appendChild(td7);
	return tr;
}
function initfoot() {
	var form = document.getElementsByClassName("am-form")[0];
	var amcf = document.createElement("div");
	amcf.classList.add("am-cf");
	amcf.innerText = "共 15 条记录";
	var amfr = document.createElement("div");
	amfr.classList.add("am-fr");
	var ul = document.createElement("ul");
	ul.classList.add("am-pagination");
	var li1 = document.createElement("li");
	li1.classList.add("am-disabled");
	var a1 = document.createElement('a');
	a1.href = "#";
	a1.innerText = "«";
	li1.appendChild(a1);
	var li2 = document.createElement("li");
	var a2 = document.createElement('a');
	a2.href = "#";
	a2.innerText = "»";
	li2.appendChild(a2);
	ul.appendChild(li1);
	ul.appendChild(li2);
	amfr.appendChild(ul);
	amcf.appendChild(amfr);
	form.appendChild(amcf);
}
function initDataForm(data){
	// 	setTableHead("uuid","filename")
	initDataTable(data);
}
function initDataTable(data){
	var tablebody = document.getElementsByClassName("table-main")[0].children[1];
	tablebody.innerHTML = "";
	for(var i=0;i<data.length;i++){
		var item = initDataItem(data[i],i);
		tablebody.appendChild(item);
		
	}
}
function initDataItem(arg, i) {
	var tr = document.createElement("tr");
	var td1 = document.createElement("td");
	var input = document.createElement("input");
	input.type = "checkbox";
	td1.appendChild(input);
	var td2 = document.createElement("td");
	td2.innerHTML = i;
	var td3 = document.createElement("td");
	var a = document.createElement("a");
	a.href = "#";
	a.innerHTML = "lijuny";
	td3.appendChild(a);
	var td4 = document.createElement("td");
	td4.innerHTML = "default";
	var td5 = document.createElement("td");
	td5.classList.add("am-hide-sm-only1");
	td5.innerHTML = arg;
	var td6 = document.createElement("td");
	td6.classList.add("am-hide-sm-only");
	td6.innerHTML = "2014年9月4日 7:28:47";
	var td7 = document.createElement("td");
	var ambtn = document.createElement("div");
	ambtn.classList.add("am-btn-toolbar");
	var ambtngroup = document.createElement("div");
	ambtngroup.classList.add("am-btn-group", "am-btn-group-xs");
	var btn1 = document.createElement("button");
	btn1.classList.add("am-btn", "am-btn-default", "am-btn-xs",
			"am-text-secondary");
	btn1.addEventListener("click", showResult, false);
	btn1.type = "button";
	var span1 = document.createElement("span");
	span1.classList.add("am-icon-pencil-square-o");
	span1.innerText = "showresult";
	btn1.appendChild(span1);
	
	ambtngroup.appendChild(btn1);

	ambtn.appendChild(ambtngroup);
	td7.appendChild(ambtn);
	tr.appendChild(td1);
	tr.appendChild(td2);
	tr.appendChild(td3);
	tr.appendChild(td4);
	tr.appendChild(td5);
	tr.appendChild(td6);
	tr.appendChild(td7);
	return tr;
}