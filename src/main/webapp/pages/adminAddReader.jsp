<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>系统管理员-录入读者</title>
  <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
  <link rel="stylesheet" type="text/css" href="../font-awesome/css/font-awesome.min.css">
  <link rel="stylesheet" type="text/css" href="../style/adminMain.css">
   <link rel="stylesheet" type="text/css" href="../style/adminAddReader.css">
   <link rel="stylesheet" type="text/css" href="../style/adminReader.css">
   <link rel="stylesheet" type="text/css" href="../style/searchTable.css">
  <script type="text/javascript" src="../script/jquery-2.1.4.min.js"></script>
  <script type="text/javascript" charset="utf-8" src="../ueditor/ueditor.config.js"></script>
  <script type="text/javascript" charset="utf-8" src="../ueditor/ueditor.all.min.js"> </script>
  <script type="text/javascript" charset="utf-8" src="../ueditor/lang/zh-cn/zh-cn.js"></script>
  <script type="text/javascript">
     $(document).ready(function() {
          var left_li=$(".left ul li:eq(0)");
              left_li.css("color","#FFF");
              left_li.css("background-color","#B78DE7");
          $(".left ul").find('li:eq(0)').children(".trig").css('display', 'block');
          $(".table tbody tr:odd").css("backgroundColor","#DFF0D8");
          $(".table tbody tr").eq(1).addClass('error')
          $(".table tbody tr").eq(2).addClass('error')
          var m_li=$(".menu ul li");
              m_li.eq(0).addClass('addCss');
              m_li.eq(0).click(function() {
                 $(".menu_left").css('display', 'block');
                 $(".menu_right").css('display', 'none');
                 m_li.eq(1).removeClass('addCss')
                 m_li.eq(0).addClass('addCss')
                
              });
              m_li.eq(1).click(function() {
                   $(".menu_left").css('display', 'none');
                   $(".menu_right").css('display', 'block');
                   m_li.eq(0).removeClass('addCss')
                   m_li.eq(1).addClass('addCss')
              });
     });
  </script>
</head>
<body>
<%
    String s = (String) session.getAttribute("insertUserInfo");
    if(s!=null){
        out.print(s);
        session.setAttribute("insertUserInfo","");
    }
%>
   <div class="ad_page">
    <div class="header">
      <img src="../images/logo.png">
      <div class="state">
      <div class="ad_name"><div class="fa_i"><i class="fa fa-user"></i></div><a href="adminPersonal">${sessionScope.SysAdname}</a></div>
        <div class="out"><a href="out">退出</a></div>
      </div>
      <div class="clear"></div>
    </div>
    <div class="content">
      <div class="left">
        <ul>
          <a href="adminAddReader"><li>录入新读者<div class="trig"></div></li></a>
          <a href="adminOutReader"><li>删除读者<div class="trig"></div></li></a>
          <a href="adminAlterReader"><li>修改读者信息<div class="trig"></div></li></a>
          <a href="adminAddAd"><li>录入图书管理员<div class="trig"></div></li></a>
          <a href="adminOutAd"><li>删除图书管理员<div class="trig"></div></li></a>
          <a href="adminAlterAd"><li>修改管理员信息<div class="trig"></div></li></a>
          <a href="adminSearchReader"><li>查看读者信息<div class="trig"></div></li></a>
          <a href="adminSearchAd"><li>查看管理员信息<div class="trig"></div></li></a>
          <a href="adminPersonal"><li>管理员中心<div class="trig"></div></li></a>
        </ul>
      </div>
      <div class="right">
      <!-- class="ad_data"的div中是系统管理员系统的切换部分 -->
        <div class="ad_data">
               <div class="menu_left">
                   <form action="insertUserInfo" method="get">
                       <div class="data"><label>借阅号</label><input type="text" name="UserId"/></div>
                       <div class="data"><label>用户名</label><input type="text" name="UserName"/></div>
                       <div class="data"><label>学院</label><input type="text" name="Departments"/></div>
                       <div class="data"><label>专业</label><input type="text" name="Major"/></div>
                       <div class="data"><label>电话</label><input type="text" name="Phone"/></div>
                       <div class="data"><label>邮箱</label><input type="text" name="Email"/></div>
                       <div class="data">
                           <label>借阅上限</label>
                           <select class="bookMax" name="Max">
                               <option value="10" >10</option>
                               <option value="15">15</option>
                           </select>
                       </div>
                       <div class="data">
                           <label>借阅期限</label>
                           <select class="bookMax" name="Time">
                               <option value="30">30天</option>
                               <option value="90">90天</option>
                           </select>
                       </div>
                       <input class="add_btn" type="submit" value="确认加入" />
                       <div class="noadd_btn">取消</div>
                   </form>
               </div>
               <div class="menu_right">
                  <input id="upload" style="width:300px"  type="text" value=""/>  
                  <script id="myeditor"></script>  
                  <input type="button" onclick="upFiles()" value="上传文件" />
                    <div>
                         <script id="editor" type="text/plain" style="width:1024px;height:500px;"></script>
                    </div>
                  <div class="table_div">
                     <table class="table">
                       <thead>
                          <tr>
                             <th class="tdOne">借阅号</th>
                             <th class="tdTwo">用户名</th>
                             <th>学院</th>
                             <th>专业</th>
                             <th>电话</th>
                             <th class="tdOne">邮箱</th>
                             <th>借阅上限</th>
                             <th>借阅期限</th>
                             <th class="tdOne">操作</th>
                          </tr>
                       </thead>
                       <tbody>
                           <tr>
                             <td>20151111</td>
                             <td>张三</td>
                             <td>计算机科学与工程学院</td>
                             <td>计算机科学与技术专业</td>
                             <td>11223344555</td>
                             <td>1111222233@qq.com</td>
                             <td>10</td>
                             <td>30</td>
                             <td>
                                <button>打印编码</button>
                                <button>删除</button>
                             </td>
                          </tr>
                           <tr>
                             <td>20151111</td>
                             <td>张三</td>
                             <td>计算机科学与工程学院</td>
                             <td>计算机科学与技术专业</td>
                             <td>11223344</td>
                             <td>1111222233@qq.com</td>
                             <td>10</td>
                             <td>30</td>
                             <td>
                                <button>打印编码</button>
                                <button>删除</button>
                             </td>
                          </tr>
                              <tr>
                                 <td>20151111</td>
                                 <td>张三</td>
                                 <td>计算机科学与工程学院</td>
                                 <td>计算机科学与技术专业</td>
                                 <td>11223344</td>
                                 <td>1111222233@qq.com</td>
                                 <td>10</td>
                                 <td>30</td>
                                 <td>
                                    <button>打印编码</button>
                                    <button>删除</button>
                                 </td>
                             </tr>
                              <tr>
                                 <td>20151111</td>
                                 <td>张三</td>
                                 <td>计算机科学与工程学院</td>
                                 <td>计算机科学与技术专业</td>
                                 <td>11223344</td>
                                 <td>1111222233@qq.com</td>
                                 <td>10</td>
                                 <td>30</td>
                                 <td>
                                    <button>打印编码</button>
                                    <button>删除</button>
                                 </td>
                             </tr>
                              <tr>
                                 <td>20151111</td>
                                 <td>张三</td>
                                 <td>计算机科学与工程学院</td>
                                 <td>计算机科学与技术专业</td>
                                 <td>11223344</td>
                                 <td>1111222233@qq.com</td>
                                 <td>10</td>
                                 <td>90</td>
                                 <td>
                                    <button>打印编码</button>
                                    <button>删除</button>
                                 </td>
                             </tr>
                              <tr>
                                 <td>20151111</td>
                                 <td>张三</td>
                                 <td>计算机科学与工程学院</td>
                                 <td>计算机科学与技术专业</td>
                                 <td>11223344</td>
                                 <td>1111222233@qq.com</td>
                                 <td>10</td>
                                 <td>90</td>
                                 <td>
                                    <button>打印编码</button>
                                    <button>删除</button>
                                 </td>
                             </tr>
                          </tbody>
                     </table>
                       <div class="book_num">读者数量: <span>6</span> 本</div>
                      <button class="submit">确认导入</button>
                  </div>
               </div>
        </div>
      </div>
      <div class="clear"></div>
    </div>
   </div>
   <script type="text/javascript">
                //重新实例化一个编辑器，防止在上面的editor编辑器中显示上传的图片或者文件
                var _editor = UE.getEditor('editor');
                _editor.ready(function () {
                    //设置编辑器不可用
                    //_editor.setDisabled();
                    //隐藏编辑器，因为不会用到这个编辑器实例，所以要隐藏
                    _editor.hide();
                   
                    //侦听文件上传
                    _editor.addListener('afterUpfile', function (t, arg) {
                        $("#file").attr("value", _editor.options.filePath + arg[0].url);
                    })
                });
               
                //弹出文件上传的对话框
                function upFiles() {
                    var myFiles = _editor.getDialog("attachment");
                    myFiles.open();
                }
                   </script>
</body>
</html>