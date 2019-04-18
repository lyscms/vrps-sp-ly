layui.config({
    base: '/static/plugins/layui/lay/modules/'
}).extend({
    authtree: 'authtree'
}).use(['authtree','form','table'], function() {
    var authtree = layui.authtree;
    var form = layui.form;
    var table = layui.table;
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

    //初始化地区表格
    table.render({
        elem: '#loc-id'
        ,url:'/catalog/manager/loc-list'
        ,cols: [[
            {field: 'name', title: '地区名称',sort: true},
            {field: 'createTime', title: '时间',sort: true},
            {fixed: 'right', title:'操作', toolbar: '#operate-bar', width:200}
        ]]
        ,page: true,
        id:'locId'
    });


    /**
     * 删除地区
     * @param data
     */
    function deleteLoc(data) {
        $.ajax({
            url: "/catalog/manager/delete-loc",
            type: "post",
            dataType: "json",
            data:'id='+data.id,
            success: backFunction,
            error:function (e) {
                if(e.responseJSON.status=='403'){
                    alert(e.responseJSON.message+":你没有操作权限!");
                }else{
                    alert(e.responseJSON.message);
                }
            }
        });
    }

    /**
     * 删除年代
     * @param data
     */
    function deleteDecade(data) {
        $.ajax({
            url: "/catalog/manager/delete-decade",
            type: "post",
            dataType: "json",
            data:'id='+data.id,
            success: backFunction,
            error:function (e) {
                if(e.responseJSON.status=='403'){
                    alert(e.responseJSON.message+":你没有操作权限!");
                }else{
                    alert(e.responseJSON.message);
                }
            }
        });
    }

    //监听工具条
    table.on('tool(loc-id)', function(obj){
        debugger;
        var data = obj.data;
        if(obj.event === 'detail'){
            layer.msg('ID：'+ data.id + ' 的查看操作');
        } else if(obj.event === 'del'){
            layer.confirm('真的删除行么', function(index){
                obj.del();
                deleteLoc(data);
                layer.close(index);
            });
        } else if(obj.event === 'edit'){
            $("#loc-edit-name").val(data.name);
            layer.open({
                type: 1
                ,offset: 'auto' //
                ,id: 'layerDemo'+'auto' //防止重复弹出
                ,content: $("#loc-edit-form").html()
                ,btn: ['确认','取消']
                ,shade: 0 //不显示遮罩
                ,yes: function(){
                    layer.closeAll();

                }
            });
        }
    });

    //监听工具条
    table.on('tool(decade-id)', function(obj){
        debugger;
        var data = obj.data;
        if(obj.event === 'detail'){
            layer.msg('ID：'+ data.id + ' 的查看操作');
        } else if(obj.event === 'del'){
            layer.confirm('真的删除行么', function(index){
                obj.del();
                deleteDecade(data);
                layer.close(index);
            });
        } else if(obj.event === 'edit'){
            layer.alert('编辑行：<br>'+ JSON.stringify(data))
        }
    });

    //初始化地区表格
    table.render({
        elem: '#decade-id'
        ,url:'/catalog/manager/decade-list'
        ,cols: [[
            {field: 'name', title: '年代名称',sort: true},
            {field: 'createTime', title: '时间',sort: true},
            {fixed: 'right', title:'操作', toolbar: '#operate-bar', width:200}
        ]]
        ,page: true
    });





    function initTree(data){
        //普通列表转换树接口数据
        var trees = authtree.listConvert(data, {
            primaryKey: 'id'
            ,startPid: '0'
            ,parentKey: 'parentId'
            ,nameKey: 'name'
            ,valueKey: 'id'
            ,checkedKey: ""
        });
        //渲染树
        authtree.render('#catalog-tree', trees, {
            autowidth: true,
            autochecked:false
        });

        //authtree.showDept("#catalog-tree", 2);
    }
    $.ajax({
        url: "/catalog/manager/catalog",
        type: "post",
        dataType: "json",
        success: function (data) {
            var html = [];
            for (var i=0;i<data.length;i++){
                html.push("<option value="+data[i].id+">"+data[i].name+"</option>");
            }
            $("#cataLog_id").append(html.join(''));
            $("#type-catalog").append(html.join(''));
            updateSubclass($("#type-catalog").val());
        },
        error:function (e) {
            if(e.responseJSON.status=='403'){
                alert(e.responseJSON.message+":你没有操作权限!");
            }else{
                alert(e.responseJSON.message);
            }
        }
    });

    //监听提交
    form.on('select(type-catalog)', function(data){
        updateSubclass(data.value);
    });



    function updateSubclass(data){
        var catalog_id = data;
        $.ajax({
            url: "/video/manager/getSubClass.html",
            type: "get",
            dataType: "json",
            data: "cataLogId=" + catalog_id,
            success: function (data) {
                $("#type-sub-class").find("option").remove();

                var html = [];
                for (var i = 0; i < data.length; i++) {
                    html.push("<option value='" + data[i].id + "'>" + data[i].name + "</option>");
                }
                $("#type-sub-class").append(html.join(''));

                form.render();
            },
            error:function (e) {
                if(e.responseJSON.status=='403'){
                    alert(e.responseJSON.message+":你没有操作权限!");
                }else{
                    alert(e.responseJSON.message);
                }
            }
        });
    }


    $(".add_CataLog_btn").click(function () {
        var catalog_name = $("#catalog_name").val();
        if(catalog_name!=""){
            $.ajax({
                url: "/catalog/manager/addCataLog.html",
                type: "POST",
                dataType: "json",
                data: "name=" + catalog_name,
                success: backFunction,
                error:function (e) {
                    debugger;
                    if(e.responseJSON.status=='403'){
                        alert(e.responseJSON.message+":你没有操作权限!");
                    }else{
                        alert(e.responseJSON.message);
                    }
                }
            });
        }else{
            alert("字段为空！");
        }
    });

    $(".add_SubClass_btn").click(function () {
        var subClass_name = $(".subClass_name").val();
        if(subClass_name!="") {
            $.ajax({
                url: "/catalog/manager/addSubClass.html",
                type: "POST",
                dataType: "json",
                data: "cataLogId=" + $("#cataLog_id").val() + "&name=" + subClass_name,
                success: backFunction,
                error:function (e) {
                    if(e.responseJSON.status=='403'){
                        alert(e.responseJSON.message+":你没有操作权限!");
                    }else{
                        alert(e.responseJSON.message);
                    }
                }
            });
        }else{
            alert("字段为空！");
        }
    });


    $("#add_Type_btn").click(function () {
        var type_name = $("#type_name").val();
        if(type_name!=""){
            $.ajax({
                url: "/catalog/manager/addType.html",
                type: "POST",
                dataType: "json",
                data: "subClassId=" + $("#type-sub-class").val() + "&name=" + $("#type_name").val(),
                success: backFunction,
                error:function (e) {
                    if(e.responseJSON.status=='403'){
                        alert(e.responseJSON.message+":你没有操作权限!");
                    }else{
                        alert(e.responseJSON.message);
                    }
                }
            });
        }else{
            alert("字段为空！");
        }
    });

    $("#add_loc_btn").click(function () {
        var loc_name = $("#loc_name").val();
        if(loc_name!=""){
            $.ajax({
                url: "/catalog/manager/addLoc.html",
                type: "POST",
                dataType: "json",
                data: "name=" + loc_name,
                success: backFunction,
                error:function (e) {
                    if(e.responseJSON.status=='403'){
                        alert(e.responseJSON.message+":你没有操作权限!");
                    }else{
                        alert(e.responseJSON.message);
                    }
                }
            });
        }else{
            alert("字段为空！");
        }
    });

    $("#add_decade_btn").click(function () {
        var decade_name = $("#decade_name").val();
        if(decade_name!="") {
            $.ajax({
                url: "/catalog/manager/addDecade.html",
                type: "POST",
                dataType: "json",
                data: "name=" + decade_name,
                success: backFunction,
                error:function (e) {
                    try {
                        if(e.responseJSON.status=='403'){
                            alert(e.responseJSON.message+":你没有操作权限!");
                        }else{
                            alert(e.responseJSON.message);
                        }
                    }catch (e) {

                    }
                }
            });
        }else{
            alert("字段为空！");
        }
    });



});

function backFunction(data) {
    if (data != "0") {
        location.reload();
    }
}
// 全选样例
function checkAll(dst) {
    layui.use(['jquery', 'layer', 'authtree'], function () {
        var layer = layui.layer;
        var authtree = layui.authtree;

        authtree.checkAll(dst);
    });
}

// 全不选样例
function uncheckAll(dst) {
    layui.use(['jquery', 'layer', 'authtree'], function () {
        var layer = layui.layer;
        var authtree = layui.authtree;

        authtree.uncheckAll(dst);
    });
}

// 显示全部
function showAll(dst) {
    layui.use(['jquery', 'layer', 'authtree'], function () {
        var layer = layui.layer;
        var authtree = layui.authtree;

        authtree.showAll(dst);
    });
}

// 隐藏全部
function closeAll(dst) {
    layui.use(['jquery', 'layer', 'authtree'], function () {
        var layer = layui.layer;
        var authtree = layui.authtree;

        authtree.closeAll(dst);
    });
}

// 删除节点
function deleteCheck(dst) {

    layer.open({
        type: 1
        ,offset: 'auto' //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
        ,id: 'layerDemo'+'auto' //防止重复弹出
        ,content: '<div style="padding: 20px 100px;">是否删除?</div>'
        ,btn: ['确认','取消']
        ,btnAlign: 'c' //按钮居中
        ,shade: 0 //不显示遮罩
        ,yes: function(){
            layer.closeAll();
            layui.use(['jquery','authtree'], function () {
                var authtree = layui.authtree;

                var checked = authtree.getChecked(dst);
                console.log(checked);
                var cataLogs = {};
                cataLogs['cataIds'] = checked;
                $.ajax({
                    url: "/catalog/manager/delete",
                    type: "POST",
                    dataType: "json",
                    contentType: "application/json;charset=UTF-8",//指定消息请求类型
                    data: JSON.stringify(cataLogs),
                    success: backFunction,
                    error:function (e) {
                        try {
                            if(e.responseJSON.status=='403'){
                                alert(e.responseJSON.message+":你没有操作权限!");
                            }else{
                                alert(e.responseJSON.message);
                            }
                        }catch (e) {

                        }

                    }
                });

            });
        }
    });
}