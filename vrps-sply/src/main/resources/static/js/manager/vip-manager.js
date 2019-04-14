layui.config({
    base: '/static/plugins/layui/lay/modules/'
}).extend({
    formSelects: 'formSelects-v4'
}).use(['form', 'layedit', 'laydate','table','layer','jquery','formSelects'], function(){
    var table = layui.table;
    var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
    var formSelects = layui.formSelects;
    table.render({
        elem: '#vip-id',
        url: '/pay/manager/vip-code-list',
        toolbar: '#toolbar',
        title: 'VIP-CODE',
        cellMinWidth: 80, //全局定义常规单元格的最小宽度
        cols:
            [
                [
                    {type: 'checkbox', fixed: 'left', width:40},
                    {field: 'code', title: '编码',sort: true},
                    {field: 'expireTime', title: '过期时间'},
                    {field: 'remark', title: '备注'}
                ]
            ]
        ,
        id:'vipReload',
        page: true
    });

    var $ = layui.$, active = {
        reload: function(){
            //执行重载
            table.reload('vipReload', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                ,where: {

                }
            });
        },
        createCode :function () {
            $.ajax({
                url:"/pay/manager/createVipCode.html",
                type:"POST",
                dataType:"json",
                data:{
                    num:5
                },
                success:function (data) {
                    if(data.code=="1"){
                        debugger;
                        var html = [];
                        for (var i = 0; i < data.data.length; i++) {
                            html.push("<tr>");
                            html.push("<td>");
                            html.push(data.data[i].code);
                            html.push("</td>");
                            html.push("</tr>");
                        }
                        var h = "<table class='layui-table'>"+html.join('')+"</table>";
                        var type = "auto";
                        layer.open({
                            type: 1
                            ,area:'auto'
                            ,title:'生成加油卡'
                            ,offset: type
                            ,id: 'layerDemo'+type //防止重复弹出
                            ,content: '<div style="padding:2px;">'+ h +'</div>'
                            ,btn: '关闭'
                            ,btnAlign: 'c' //按钮居中
                            ,shade: 0 //不显示遮罩
                            ,yes: function(){
                                layer.closeAll();
                            }
                        });
                    }else{
                        layer.msg("生成加油卡失败！");
                    }
                },
                error:function (e) {
                    if(e.responseJSON.status=='403'){
                        layer.msg(e.responseJSON.message+":你没有操作权限!");
                    }else{
                        layer.msg(e.responseJSON.message);
                    }
                }
            });
        }
    };


    //头工具栏事件
    table.on('toolbar(vip-id)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        switch(obj.event){
            case 'create':
                var data = checkStatus.data;
                active.createCode();
                break;
        };
    });
});