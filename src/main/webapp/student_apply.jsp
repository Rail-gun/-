<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!doctype html>
<html lang="zh">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>请求界面</title>
  <link rel="stylesheet" type="text/css" href="css/default.css">
  <link rel="stylesheet" href="css/reset.css"> <!-- CSS reset -->
  <link rel="stylesheet" href="css/style.css"> <!-- Resource style -->
  <script src="js/modernizr.js"></script> <!-- Modernizr -->
</head>


<body>
  <div class="container">

     <form action="apply"  method="post" id = "apply" class="cd-form floating-labels">
      <fieldset>
        <legend>填写请假单</legend>

        <div class="error-message">
          <p>请输入正确的信息</p>
        </div>

      </fieldset>
      <fieldset>
        <legend>请假开始时间</legend>

        <div>
          
          
          <p class="cd-select icon">
         
            <select class="budget" name = "leave_year">
              <option value="00">请选择年</option>
              <option value="2017">2017年</option>
              <option value="2018">2018年</option>
              <option value="2019">2019年</option>
              <option value="2020">2020年</option>
              <option value="2021">2021年</option>
              <option value="2022">2022年</option>
              <option value="2023">2023年</option>
              <option value="2024">2024年</option>
              <option value="2025">2025年</option>
              <option value="2026">2026年</option>
              <option value="2027">2027年</option>
              <option value="2028">2028年</option>
            </select>
            
            
            
            
          </p>
          
        </div>
        
        <div>
          
          
          <p class="cd-select icon">
         
            <select class="budget" name = "leave_month">
            
              <option value="0">请选择月</option>
              <option value="1">1月</option>
              <option value="2">2月</option>
              <option value="3">3月</option>
              <option value="4">4月</option>
              <option value="5">5月</option>
              <option value="6">6月</option>
              <option value="7">7月</option>
              <option value="8">8月</option>
              <option value="9">9月</option>
              <option value="10">10月</option>
              <option value="11">11月</option>
              <option value="12">12月</option>
            </select>
            
            
            
            
          </p>
          
        </div>
        
        <div>
          
          
          <p class="cd-select icon">
         
            <select class="budget" name = "leave_day">
              <option value="0">请选择日</option>
              <option value="1">1日</option>
              <option value="2">2日</option>
              <option value="3">3日</option>
              <option value="4">4日</option>
              <option value="5">5日</option>
              <option value="6">6日</option>
              <option value="7">7日</option>
              <option value="8">8日</option>
              <option value="9">9日</option>
              <option value="10">10日</option>
              <option value="11">11日</option>
              <option value="12">12日</option>
              <option value="13">13日</option>
              <option value="14">14日</option>
              <option value="15">15日</option>
              <option value="16">16日</option>
              <option value="17">17日</option>
              <option value="18">18日</option>
              <option value="19">19日</option>
              <option value="20">20日</option>
              <option value="21">21日</option>
              <option value="22">22日</option>
              <option value="23">23日</option>
              <option value="24">24日</option>
              <option value="25">25日</option>
              <option value="26">26日</option>
              <option value="26">27日</option>
              <option value="28">28日</option>
              <option value="29">29日</option>
              <option value="30">30日</option>
              <option value="31">31日</option>
              
            </select>
            
            
            
            
          </p>
          
        </div>
         </fieldset>
      <fieldset>
        <legend>请假结束时间</legend>

        <div>
          
          
          <p class="cd-select icon">
         
            <select class="budget" name = "return_year">
			  <option value="00">请选择年</option>
              <option value="2017">2017年</option>
              <option value="2018">2018年</option>
              <option value="2019">2019年</option>
              <option value="2020">2020年</option>
              <option value="2021">2021年</option>
              <option value="2022">2022年</option>
              <option value="2023">2023年</option>
              <option value="2024">2024年</option>
              <option value="2025">2025年</option>
              <option value="2026">2026年</option>
              <option value="2027">2027年</option>
              <option value="2028">2028年</option>
            </select>
            
            
            
            
          </p>
          
        </div>
        
        <div>
          
          
          <p class="cd-select icon">
         
            <select class="budget" name = "return_month">
            
			  <option value="0">请选择月</option>
              <option value="1">1月</option>
              <option value="2">2月</option>
              <option value="3">3月</option>
              <option value="4">4月</option>
              <option value="5">5月</option>
              <option value="6">6月</option>
              <option value="7">7月</option>
              <option value="8">8月</option>
              <option value="9">9月</option>
              <option value="10">10月</option>
              <option value="11">11月</option>
              <option value="12">12月</option>
            </select>
            
            
            
            
          </p>
          
        </div>
        
        <div>
          
          
          <p class="cd-select icon">
         
            <select class="budget" name = "return_day">
              <option value="0">请选择日</option>
              <option value="1">1日</option>
              <option value="2">2日</option>
              <option value="3">3日</option>
              <option value="4">4日</option>
              <option value="5">5日</option>
              <option value="6">6日</option>
              <option value="7">7日</option>
              <option value="8">8日</option>
              <option value="9">9日</option>
              <option value="10">10日</option>
              <option value="11">11日</option>
              <option value="12">12日</option>
              <option value="13">13日</option>
              <option value="14">14日</option>
              <option value="15">15日</option>
              <option value="16">16日</option>
              <option value="17">17日</option>
              <option value="18">18日</option>
              <option value="19">19日</option>
              <option value="20">20日</option>
              <option value="21">21日</option>
              <option value="22">22日</option>
              <option value="23">23日</option>
              <option value="24">24日</option>
              <option value="25">25日</option>
              <option value="26">26日</option>
              <option value="26">27日</option>
              <option value="28">28日</option>
              <option value="29">29日</option>
              <option value="30">30日</option>
              <option value="31">31日</option>
              
            </select>
            
            
            
            
          </p>
          
        </div>
         </fieldset>
        <fieldset>
        <legend>请假原因</legend>
        <div>
          

          <ul class="cd-form-list">
            <li>
              <input type="radio" name="reason" id="cd-radio-1" value = "1" checked>
              <label for="cd-radio-1">出国留学</label>
            </li>
              
            <li>
              <input type="radio" name="reason" id="cd-radio-2" value = "2">
              <label for="cd-radio-2">参加比赛/培训</label>
            </li>

            <li>
              <input type="radio" name="reason" id="cd-radio-3" value = "3">
              <label for="cd-radio-3">国内交流</label>
            </li>
            <li>
              <input type="radio" name="reason" id="cd-radio-4" value = "4">
              <label for="cd-radio-4">病假</label>
            </li>
            <li>
              <input type="radio" name="reason" id="cd-radio-5" value = "5">
              <label for="cd-radio-5">其他</label>
            </li>
          </ul>
        </div>

        

        <div class="icon">
          <label class="cd-label" for="cd-textarea">请假原因详细描述</label>
              <textarea class="message" name="detail" id="detail" required></textarea>
        </div>

        <div>
              <input type="submit" value="确定申请请假">
          </div>
      </fieldset>
    </form>
  </div>
  
  <script src="js/jquery-2.1.1.js"></script>
  <script src="js/main.js"></script> <!-- Resource jQuery -->
  
</body>
</html>