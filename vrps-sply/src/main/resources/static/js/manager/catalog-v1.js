layui.config({
    base: '/static/plugins/layui/lay/modules/'
}).use(['tree'], function() {

    $.ajax({
        type: "get",
        dataType: "json",
        url: "/catalog/manager/cataLog-list.html",
        success: function (data) {
            initTree(data);
        },
        error:function (e) {
            if(e.responseJSON.status=='403'){
                layer.msg(e.responseJSON.message+":你没有操作权限!");
            }else{
                layer.msg(e.responseJSON.message);
            }
        }
    });


    function initTree(data){
        layui.tree({
            elem:'#catalog-tree',
            target:'_self',
            click: function(node){
                console.log(node);
            },
            nodes: data
        });
    }
});