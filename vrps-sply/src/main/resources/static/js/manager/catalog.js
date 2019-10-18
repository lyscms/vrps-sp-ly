$(function () {





    $(".add_Type_btn").click(function () {
        var type_name = $(".type_name").text();
        if(type_name!=""){
            $.ajax({
                url: "/catalog/manager/addType.html",
                type: "POST",
                dataType: "json",
                data: "subClassId=" + $(".subClass_id").val() + "&name=" + $(".type_name").text(),
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

    $(".add_Loc_btn").click(function () {
        var loc_name = $(".loc_name").text();
        if(loc_name!=""){
            $.ajax({
                url: "/catalog/manager/addLoc.html",
                type: "POST",
                dataType: "json",
                data: "name=" + $(".loc_name").text(),
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

    $(".add_Level_btn").click(function () {
        var level_name = $(".level_name").text();
        if(level_name!="") {
            $.ajax({
                url: "/catalog/manager/addLevel.html",
                type: "POST",
                dataType: "json",
                data: "name=" + $(".level_name").text(),
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

    $(".add_Decade_btn").click(function () {
        var decade_name = $(".decade_name").text();
        if(decade_name!="") {
            $.ajax({
                url: "/catalog/manager/addDecade.html",
                type: "POST",
                dataType: "json",
                data: "name=" + $(".decade_name").text(),
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

    $(".cataLog_id_subClass").change(function () {
        var catalog_id = $(this).val();
        $.ajax({
            url: "/video/manager/getSubClass.html",
            type: "get",
            dataType: "json",
            data: "cataLogId=" + catalog_id,
            success: function (data) {
                $(".subClass_id").find("option").remove();
                var jss = data;
                for (var i = 0; i < jss.length; i++) {
                    var op = "<option value='" + jss[i].id + "'>" + jss[i].name + "</option>";
                    $(".subClass_id").append($(op));
                }
            },
            error:function (e) {
                if(e.responseJSON.status=='403'){
                    alert(e.responseJSON.message+":你没有操作权限!");
                }else{
                    alert(e.responseJSON.message);
                }
            }
        });
    });

    $.ajax({
        url: "/video/manager/getSubClass.html",
        type: "get",
        dataType: "json",
        data:"cataLogId=" + $(".cataLog_id_subClass").val(),
        success: function (data) {
            var jss = data;
            for (var i = 0; i < jss.length; i++) {
                var op1 = "<option value='" + jss[i].id + "'>" + jss[i].name + "</option>";
                $(".subClass_id").append($(op1));
            }
        },
        error:function (e) {
            if(e.responseJSON.status=='403'){
                alert(e.responseJSON.message+":你没有操作权限!");
            }else{
                alert(e.responseJSON.message);
            }
        }
    });
});

function backFunction(data) {
    if (data != "0") {
        location.reload();
    }
}