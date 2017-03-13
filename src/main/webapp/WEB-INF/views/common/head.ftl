<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fiction home page</title>
    <link href="/resources/plugin/bootstrap/css/bootstrap.css" rel="stylesheet"/>
    <link href="/resources/plugin/bootstrap/css/bootstrap-theme.css" rel="stylesheet"/>
    <style type="text/css">
        a:link {
            color: black
        }

        /* 未访问的链接 */
        a:visited {
            color: black
        }

        /* 已访问的链接 */
        a:hover {
            color: black
        }

        /* 鼠标移动到链接上 */
        a:active {
            color: black
        }

        /* 选定的链接 */
        a {
            color: black
        }

        a.fiction-head-font {
            color: black;
            font: 700 14px/44px PingFangSC-Regular, HelveticaNeue-Light, 'Helvetica Neue Light', 'Microsoft YaHei', sans-serif;
        }

        sidebar .widget {
            background: #ffffff none repeat scroll 0 0;
            padding: 21px 30px;
        }

        .widget {
            margin-bottom: 35px;
            border: 2px solid #eceeef;
        }

        .widget .title::after {
            background: #f4645f none repeat scroll 0 0;
            bottom: -1px;
            content: "";
            height: 1px;
            left: 0;
            position: absolute;
            width: 90px;
        }

        .widget .title {
            border-bottom: 1px solid #ebebeb;
            margin-bottom: 21px;
            margin-top: 0;
            padding-bottom: 7px;
            position: relative;
        }

        .panel .title {
            border-bottom: 1px solid #ebebeb;
            margin-bottom: 21px;
            margin-top: 0;
            padding-bottom: 7px;
            position: relative;
        }

        .panel .title::after {
            background: #f4645f none repeat scroll 0 0;
            bottom: -1px;
            content: "";
            height: 1px;
            left: 0;
            position: absolute;
            width: 90px;
        }

        .jobs-tabs {
            -moz-border-bottom-colors: none;
            -moz-border-left-colors: none;
            -moz-border-right-colors: none;
            -moz-border-top-colors: none;
            /*border-color: #fff #fff -moz-use-text-color;*/
            /*border-image: none;*/
            border-style: solid solid none;
            border-width: 0px 0px medium;
            display: flex;
            list-style: outside none none;
            padding-left: 0;
            text-align: center;
            margin-bottom: -9px;
        }

        .jobs-tabs .nav-link {
            color: black;
            padding: 1rem 0;
            transition: all 0.25s ease 0s;
        }

        .jobs-tabs li {
            flex: 1 1 100%;
        }

        .nav-link {
            display: block;
            padding: 1rem;
            font-weight: 800;
            font-size: 18px;
        }

        .welcome {
            padding: 3rem 0 6rem;
        }

        .welcome, .welcome .btn-link {
            color: #fff;
            text-align: center;
        }

        .welcome-title {
            color: inherit;
        }

        .welcome-slogan {
            font-size: 1.25rem;
        }

        h1 {
            font: \5fae\8f6f\96c5\9ed1;
        }

        h2 {
            font: \5fae\8f6f\96c5\9ed1;
        }

        h3 {
            font: \5fae\8f6f\96c5\9ed1;
        }

        h4 {
            font: \5fae\8f6f\96c5\9ed1;
        }

        h5 {
            font: \5fae\8f6f\96c5\9ed1;
        }

        .read-content {
            margin-bottom: 64px;
        }

        .read-content p {
            line-height: 1.8;
            margin: 0.8em 0;
            overflow: hidden;
            font-size: 18px;
        }

        p {
            word-break: break-all;
            word-wrap: break-word;
        }

        .read-color {
            background: rgba(0, 0, 0, 0) url('/resources/image/content-background.png') repeat scroll 0 0;
        }

        .read-title {
            margin-bottom: 20px;
        }

        .height15 {
            height: 150px;
        }

        .background1 {
            background-color: #ebebeb;
        }

        .searchImg{
            width:120px;
            height: 150px;;
        }

        .searchRead-color{
            background-color: #31b0d5;
            font-size: 15px;
        }

        .pointer-style{
            cursor:pointer;
        }


    </style>
</head>
<#include "/common/config.ftl"/>
<script src="/resources/js/head/head.js"></script>
<body class="background1">
<base target='_blank'>
<header class="navbar-static-top navbar-fixed-top navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <a style="font-family:楷体_GB2312;font-size: x-large;font-weight: bolder;" class="navbar-brand"
               href="/">江湖故事</a>
        </div>
        <nav class="collapse navbar-collapse">
            <form class="navbar-form navbar-left">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="输入一本书名" id="headContent">
                </div>
                <a  href="/homepage/search" onclick="javascript:homeSearch();"><button type="button" class="btn btn-default" >搜索</button></a>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a target="_blank" href="">登录</a></li>
                <li><a target="_blank" href="">注册</a></li>
            </ul>
        </nav>
    </div>
</header>
<div class="page-header page-header-no-bottom"
     style="background:url('/resources/image/head-img4.jpg') no-repeat scroll center top / cover;">
    <div class="welcome" >
        <h1 class="welcome-title"></h1>
        <div class="welcome-slogan">
        </div>
    </div>
    <div class="container" >
        <ul class="jobs-tabs nav nav-tabs">
            <li>
                <a class="nav-link active">
                    首页
                </a>
            </li>
            <li>
                <a class="nav-link ">
                    武侠
                </a>
            </li>
            <li>
                <a class="nav-link ">
                    都市
                </a>
            </li>
            <li>
                <a class="nav-link ">
                    言情
                </a>
            </li>
            <li>
                <a class="nav-link ">
                    玄幻
                </a>
            </li>
            <li class="dropdown ">
                <a data-toggle="dropdown" class="dropdown-toggle nav-link " href="#">更多分类<strong
                        class="caret"></strong></a>
                <ul class="dropdown-menu">
                    <li>
                        <a href="#">恐怖</a>
                    </li>
                    <li>
                        <a href="#">侦探</a>
                    </li>
                    <li>
                        <a href="#">穿越</a>
                    </li>
                    <li class="divider">
                    </li>
                    <li class="dropdown-header">
                        小小说
                    </li>
                    <li>
                        <a href="#">散文</a>
                    </li>
                    <li>
                        <a href="#">诗歌</a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</div>