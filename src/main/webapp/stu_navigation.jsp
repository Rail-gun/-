<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<title>login</title>
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" type="text/css" href="css/demo.css" />
<!--必要样式-->
<link rel="stylesheet" type="text/css" href="css/component.css" />
<!--[if IE]>
<script src="js/html5.js"></script>
<![endif]-->
</head>
<body>
    <div class="container demo-1">
      <div class="content">
        <div id="large-header" class="large-header">
          <canvas id="demo-canvas"></canvas>
          <div class="logo_box">
            <h3>功能选择</h3>
			<!-- <form action="#" name="f" method="post"> -->
              <div class="mb2"><a class="act-but submit" href="stu_apply?logname=${logname}" style="color: #FFFFFF">请假</a></div>
            <!-- </form>
            <form action="##" name="ff" method="post"> -->
              <div class="mb2"><a class="act-but submit" href="stu_cancel?logname=${logname}" style="color: #FFFFFF;position:absolute; z-index:100;width:330px ">销假</a></div>
            <!-- </form> -->
          </div>
        </div>
      </div>
    </div><!-- /container -->
    <script src="js/TweenLite.min.js"></script>
    <script src="js/EasePack.min.js"></script>
    <script src="js/rAF.js"></script>
    <script src="js/demo-1.js"></script>
  </body>
</html>