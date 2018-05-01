function initEcharts(args){
	floatarr = args.floatArrList;
    var content = document.getElementsByClassName("admin-content-body")[0];
    content.innerHTML = "";
	initEchart(1);
	 }
function initEchart(arg){
    var echartsPie;  
    var arr = floatarr[arg];
    var json = [  
                {value:arr[0],name:'a'},  
                {value:arr[1],name:'t'},  
                {value:arr[2],name:'c'},  
                {value:arr[3],name:'g'}  
                ];  
    var option = {  
            title : {  
                text: 'atcg所占比例',  
                subtext: '独家报道',  
                x:'center'  
            },  
            tooltip : {  
                trigger: 'item',  
                formatter: "{a} <br/>{b} : {c} 岁"  
            },  
            legend: {  
                orient : 'vertical',  
                x : 'left',  
                data:['高圆圆','赵丽颖','江莱']  
            },  
            toolbox: {  
                show : true,  
                feature : {  
                    mark : {show: true},  
                    dataView : {show: true, readOnly: false},  
                    magicType : {  
                        show: true,   
                        type: ['pie', 'funnel'],  
                        option: {  
                            funnel: {  
                                x: '25%',  
                                width: '50%',  
                                funnelAlign: 'left',  
                                max: 1548  
                            }  
                        }  
                    },  
                    restore : {show: true},  
                    saveAsImage : {show: true}  
                }  
            },  
            calculable : true,  
            series : [  
                {  
                    name:'女神',  
                    type:'pie',  
                    radius : '55%',//饼图的半径大小  
                    center: ['50%', '60%'],//饼图的位置  
                    data:json  
                }  
            ]  
        };   
      
    echartsPie = echarts.init(document.getElementsByClassName('admin-content-body')[0]);  
    $(function(){  
        echartsPie.setOption(option);  
          
    });                       

}