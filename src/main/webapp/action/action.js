function getAlert() {
	$.ajax({
		index : 0,
		type : "POST",
		data : {
			index : 0
		},
		url : "http://localhost:8080/datadel/getFileForm",
		success : function(data) {
			initFileForm(data);
		}
	});
}

function showListByfilename(){
    $.ajax({
		type : "POST",
		data : {
			index : 0,
			filename:"rna.gbk"
		},
		url : "http://localhost:8080/datadel/getDataForm",
		success : function(data) {
			initDataForm(data);
		}
	});
    
}
function showResult(){
	$.ajax({
		type : "POST",
		data : {
			uuid :"3d26cae1-be24-4f89-a21d-e1707a8ad691"
		},
		url : "http://localhost:8080/datadel/simgledealdata",
		success : function(data) {
			initDataForm(data);
		}
	});
}