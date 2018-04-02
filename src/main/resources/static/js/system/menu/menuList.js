layui.config({
    base: '../common/js/',
    v: new Date().getTime()
}).use(['btable', 'form'], function () {
    var btable = layui.btable(),
        $ = layui.jquery,
        layerTips = parent.layer === undefined ? layui.layer : parent.layer, //获取父窗口的layer对象
        layer = layui.layer,//获取当前窗口的layer对象;
        form = layui.form();

    btable.set({
        openWait: true,//开启等待框
        elem: '#content',
        url: 'userData', //数据源地址
        pageSize: 3,//页大小
        params: {//额外的请求参数
            t: new Date().getTime()
        },
        columns: [{ //配置数据列
            fieldName: '名称', //显示名称
            field: 'name', //字段名
            //: true //是否显示排序
        }, {
            fieldName: '加入时间',
            field: 'createTime',
            sortable: true
        }, {
            fieldName: '登陆名称',
            field: 'loginName' /* ,
            format: function (id, obj) {
              //id
                console.log(id);
                //行数据对象
                console.log(obj);
                //返回值：格式化的纯文本或html文本
                return obj.loginName;
            }*/
        }, {
            fieldName: '操作',
            field: 'id',
            format: function (val,obj) {
                var html = '<input type="button" value="编辑" data-action="edit" data-id="' + val + '" class="layui-btn layui-btn-mini" /> ' +
                    '<input type="button" value="删除" data-action="del" data-id="' + val + '" class="layui-btn layui-btn-mini layui-btn-danger" />';
                return html;
            }
        }],
        even: true,//隔行变色
        field: 'id', //主键ID
        //skin: 'row',
        checkbox: false,//是否显示多选框
        paged: true, //是否显示分页
        singleSelect: false, //只允许选择一行，checkbox为true生效
        onSuccess: function ($elem) { //$elem当前窗口的jq对象
            $elem.children('tr').each(function () {
                $(this).children('td:last-child').children('input').each(function () {
                    var $that = $(this);
                    var action = $that.data('action');
                    var id = $that.data('id');
                    $that.on('click', function () {
                        switch (action) {
                            case 'edit':
                                getEditWin("修改用户信息",id);
                                //layerTips.msg(action + ":" + id);
                                break;
                            case 'del': //删除
                                var name = $that.parent('td').siblings('td[data-field=name]').text();
                                //询问框
                                layerTips.confirm('确定要删除[ <span style="color:red;">' + name + '</span> ] ？', { icon: 3, title: '系统提示' }, function (index) {
                                    $that.parent('td').parent('tr').remove();
                                    layerTips.msg('删除成功.');
                                });
                                break;
                        }
                    });
                });
            });
        }
    });
    btable.render();
    //监听搜索表单的提交事件
    form.on('submit(search)', function (data) {

        btable.get(data.field);
        return false;
    });

    $('#addUser').on("click",function(){
        getEditWin("新增用户信息",'');
    });
    
    function  getEditWin(title,id) {
        layer.open({
            title: title,
            type: 2,
            area: ['70%', '80%'],
            fix: false, //不固定
            maxmin: true,
            content:  'toEdit?id='+id,
            success:function(layero,index){

            },
            end:function(){    //子页面销毁时回调的方法
                var handle = $("#handle").val();
                if( handle == 1){
                    layer.msg('保存成功', {
                        icon: 1,
                        time: 1500 //2秒关闭（如果不配置，默认是3秒）
                    }, function(){
                        $("#handle").attr("value","");
                        window.location.href = '重新加载的页面';
                    });

                }
            }
        });
    };


    $(window).on('resize', function (e) {
        var $that = $(this);
        $('#content').height($that.height() - 92);
    }).resize();



});