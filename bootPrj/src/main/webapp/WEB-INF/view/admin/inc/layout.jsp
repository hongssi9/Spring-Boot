<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="../../css/style.css" type="text/css" rel="stylesheet">
    <script src="list.js"></script>
</head>

<body>
    <div id="root">
    
        <!-- header 부분 -->
        <tiles:insertAttribute name="header"/>


        <div id="visual">
            <div class="float-content">

            </div>
        </div>

        <div id="body">
            <div class="float-content">
                <!-- asdie 영역 -->
                <tiles:insertAttribute name="aside"/>
                
                <!-- main 영역 -->
                <tiles:insertAttribute name="main"/>
            </div>
        </div>

       <!-- footer 영역 -->
       <tiles:insertAttribute name="footer"/>
       
    </div>


</body>


</html>