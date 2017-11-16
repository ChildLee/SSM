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
        /*上传图片换成图片*/
        .fileInputContainer {
            position: relative;
            height: 100px;
            width: 100px;
            background: no-repeat url("resources/img/file_img.jpg");
            background-size: 100px 100px;
        }

        .fileInput {
            position: absolute;
            height: 100px;
            width: 100px;
            top: 0;
            left: 0;
            opacity: 0;
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="container-fluid">


    <ol class="breadcrumb">
        <li><a href="/admin">管理首页</a></li>
        <li>内容添加</li>
    </ol>

    <h3>上价商品</h3>
    <form method="post">
        <div class="form-group">
            <label for="title">商品名称:</label>
            <input type="text" name="title" class="form-control" id="title" placeholder="请输入内容标题">
        </div>
        <div class="form-group">
            <label for="title">商品分类:</label>
            <select name="category" id="category" class="form-control">
                <option value="">请选择商品分类</option>
                <option value="">你的</option>
            </select>
        </div>
        <div class="form-group">
            <label for="title">商品库存:</label>
            <input type="text" name="title" class="form-control" id="" placeholder="请输入商品库存">
        </div>
        <div class="form-group">
            <label for="title">商品单价:</label>
            <input type="text" name="title" class="form-control" id="" placeholder="请输入商品单价">
        </div>
        <div class="form-group">
            <label for="title">商品单位:</label>
            <input type="text" name="title" class="form-control" id="" placeholder="商品单位:双">
        </div>
        <div class="form-group">
            <label for="title">商品图片:</label>
            <div class="fileInputContainer">
                <input class="fileInput" type="file"/>
            </div>
        </div>
        <div class="form-group">
            <label for="description">商品详情:</label>
            <textarea rows="5" name="description" class="form-control" id="description"
                      placeholder="请输入内容简介"></textarea>
            <label for="description">商品详情图片:</label>
            <div class="fileInputContainer">
                <input class="fileInput" type="file"/>
            </div>
        </div>
        <div class="form-group">
            <label for="content">内容:</label>
            <textarea rows="10" name="content" class="form-control" id="content" placeholder="请输入内容"></textarea></div>
        <button type="submit" class="btn btn-default">提交</button>
    </form>
</div>
</body>
</html>