<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!doctype html>
<html lang="zh">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0 maximum-scale=1.0, user-scalable=no"/>
<title>教师确认页面</title>

<link rel="stylesheet" type="text/css" href="css/xiaojiademo.css">
<link rel="stylesheet" type="text/css" href="css/xiaojiastyle.css" />
<link rel="stylesheet" type="text/css" href="css/xiaojiabasictable.css" />

</head>

<style type="text/css">      
    .backg{
  BACKGROUND-COLOR: #56a2cf;
  BORDER : 1px solid #56a2cf;
  HEIGHT: 30px;
  border-radius:4px;
    width:120px ;
    font-size:15px;
    position:absolute;
    right:100px;
}
}    
 </style>
<body>
<div class="container">
  <div id="page">
    <h1>学生的请假情况</h1>
    
    <table id="table">
    <thead>
      <tr>
      <th>序号</th>
      <th>学号</th>
      <th>姓名</th>
      <th>请假原因</th>
      <th>请假开始时间</th>
      <th></th>
      </tr>
    </thead>
    <tbody>
      <tr>
      <td>1</td>
      <td>张强</td>
      <td>25</td> 
      <td>感冒发烧流鼻涕</td>
      <td>2017-09-09</td>
      <td><a href=Goto_edit?isbn=""><button class='btn btn-default btn-primary' style="color: white; font-weight:bold;BACKGROUND-COLOR: #56a2cf;border-radius:4px;BORDER : 1px solid #56a2cf;width:60px;HEIGHT: 30px" type="button">打印</button></a></td>
      </tr>
      <tr>
      <td>2</td>
      <td>钟铭凯</td>
      <td>18</td> 
      <td>精神亢奋</td>
      <td>2017-01-08</td>
      <td><a href=Goto_edit?isbn=""><button class='btn btn-default btn-primary' style="color: white; font-weight:bold;BACKGROUND-COLOR: #56a2cf;border-radius:4px;BORDER : 1px solid #56a2cf;width:60px;HEIGHT: 30px" type="button">打印</button></a></td>
      </tr>
      <tr>
      <td>3</td>
      <td>李书彬</td>
      <td>40</td> 
      <td>不告诉你</td>
      <td>2016-08-11</td>
      <td><a href=Goto_edit?isbn=""><button class='btn btn-default btn-primary' style="color: white; font-weight:bold;BACKGROUND-COLOR: #56a2cf;border-radius:4px;BORDER : 1px solid #56a2cf;width:60px;HEIGHT: 30px" type="button">打印</button></a></td>
      </tr>
    </tbody>
    </table>
  </div>
</div>
  <!-- <div>
       <a><input style="color: white; font-weight:bold;"class = "backg" type="submit" value="申请销假"></a>
          </div> -->
<script src="js/jquery-2.1.1.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.basictable.min.js"></script>
<script type="text/javascript">
  $(document).ready(function() {
    $('#table').basictable();

    $('#table-breakpoint').basictable({
    breakpoint: 768
    });

    $('#table-swap-axis').basictable({
    swapAxis: true
    });

    $('#table-force-off').basictable({
    forceResponsive: true
    });

    $('#table-no-resize').basictable({
    noResize: true
    });

    $('#table-two-axis').basictable();

    $('#table-max-height').basictable({
    tableWrapper: true
    });
  });
  </script>

</body>
</html>