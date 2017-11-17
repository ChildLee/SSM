<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="resources/js/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="resources/css/bootstrap.css">
    <script src="resources/js/bootstrap.js"></script>
    <style>
        .table th, .table td {
            text-align: center;
            vertical-align: middle !important;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <ol class="breadcrumb">
        <li><a href="/admin">管理首页</a></li>
        <li>分类列表</li>
    </ol>

    <h3>分类列表</h3>

    <table class="table table-striped table-hover" style="vertical-align:middle">
        <tr>
            <th style="width: 20%">商品名字</th>
            <th style="width: 20%">商品图片</th>
            <th>商品详情</th>
            <th>商品单价</th>
            <th>商品库存</th>
            <th>操作</th>
        </tr>
        <tr>
            <td>华为 TalkBand B3 B3智能手环运动计步华为 TalkBand B3 B3智能手环运动计步华为 TalkBand B3 B3智能手环运动计步</td>
            <td>123</td>
            <td>华为 TalkBand B3 B3智能手环运动计步</td>
            <td>123</td>
            <td>123</td>
            <td>
                <a href="">修改</a>
                <a href="">删除</a>
            </td>
        </tr>
    </table>
</div>


<nav aria-label="...">
    <ul class="pager">
        <li class="previous"><a href=""><span aria-hidden="true">&larr;</span>上一页</a></li>
        <li>一共有1条数据,每页显示1条数据,一共1页,当前第1页</li>
        <li class="next"><a href="">下一页<span aria-hidden="true">&rarr;</span></a></li>
    </ul>
</nav>

</body>
</html>