 $(function () {  
        $("#upload").click(function () {  
            var formData = new FormData($('#uploadForm')[0]);  
            $.ajax({  
                type: 'post',  
                url: "http://192.168.1.101:8080/springbootdemo/file/uploadFiles",  
                data: formData,  
                cache: false,  
                processData: false,  
                contentType: false,  
            }).success(function (data) {  
                alert(data);  
            }).error(function () {  
                alert("上传失败");  
            });  
        });  
    }); 