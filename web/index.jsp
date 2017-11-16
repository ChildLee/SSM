<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="resources/js/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="resources/css/bootstrap.css">
    <script src="resources/js/bootstrap.js"></script>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">圆梦园小程序后台管理系统</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">首页<span class="sr-only">(current)</span></a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">商品管理<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">商品列表</a></li>
                        <li><a href="/admin">上架商品</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">添加/删除分类</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">添加/删除轮播图</a></li>
                    </ul>
                </li>
                <li><a href="#">订单管理</a></li>
                <li><a href="#">会员管理</a></li>
                <li><a href="#">配送与支付管理</a></li>
                <li><a href="#">商家入驻</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">常见问题<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">常见问题列表</a></li>
                        <li><a href="#">添加常见问题</a></li>
                    </ul>
                </li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">注销</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">用户<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">修改密码</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">退出</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="jumbotron">
        <h1>Hello!</h1>
        <p>欢迎进入后台管理系统</p>
    </div>
</div>

</body>
</html>