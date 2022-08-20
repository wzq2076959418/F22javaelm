<%--
  Created by IntelliJ IDEA.
  User: 全
  Date: 2022/8/20
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登陆</title>
</head>
<body>
<div style="text-align: center">
    <form action="login" method="post" id="loginFrom">
        姓名:<input type="text" name="uname" id="uname" value="${messageModel.object.userName}"><br>
        姓名:<input type="password" name="upwd" id="upwd" value="${messageModel.object.password}"><br>
        <span id="msg" style="font-size: 12px;color: red">${messageModel.msg}</span><br>
        <button type="button">登录</button>
        <button type="button">注册</button>
    </form>
</div>

</body>
<%--引入js--%>
<script type="text/javascript" src="js/jquery-3.6.0.js"></script>
<script type="text/javascript">

    $("#loginBtn").click(function (){
        var uname=$("#uname").val();
        var upwd=$("#upwd").val();
        //判断姓名是否为空
        if (isEmpty(uname)){
            $("#span").html("用户姓名不能为空");
            return;
        }
        //判断密码
        if (isEmpty(upwd)){
            $("#span").html("用户密码不能为空");
            return;
        }
    //都不为空提交表单
        $("#loginFrom").submit();


    });

    function isEmpty(str) {
        if (str == null || str.trim() == ""){
            return true;
        }
        return false;
    }

</script>
</html>
