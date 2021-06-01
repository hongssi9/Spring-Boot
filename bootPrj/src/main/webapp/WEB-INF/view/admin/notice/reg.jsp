
<%@page import="com.newlecture.web.entity.Notice"%>
<%@page import="com.newlecture.web.service.JdbcNoticeService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="../../css/style.css" type="text/css" rel="stylesheet">
    <script src="../../js/admin/notice/reg.js"></script>
    <script src="list.js"></script>
</head>

<body>
    <div id="root">
        <!-- header 영역 -->
        <jsp:include page="/WEB-INF/view/inc/header.jsp"/>

        <div id="visual">
            <div class="float-content">

            </div>
        </div>

        <div id="body">
            <div class="float-content">
                <aside id="aside">
                    <h1 id="aside-title" onclick="printSum();">고객센터</h1>                    
                    <nav class="main-aside-menu">
                        <h1>고객센터메뉴</h1>
                        <ul>
                            <li><a class="current" href="list.html">공지사항</a></li>
                            <li><a href="">자주하는 질문</a></li>
                            <li><a href="">수강문의</a></li>
                            <li><a href="">이벤트</a></li>
                        </ul>
                    </nav>

                    <nav class="aside-menu recommend-aside-menu">
                        <h1>협력업체</h1>
                        <ul>
                            <li><a class="img img-notepubs" href="">노트펍스</a></li>
                            <li><a class="img img-namoolab" href="">나무랩연구소</a></li>
                        </ul>
                    </nav>

                </aside>
                <main id="main">
                    <section>
                        <h1 class="main-title">공지사항</h1>
                                          
                        <section class="breadcrumb">
                            <h1 class="d-none">경로</h1>
                            <ol>
                                <li>home</li>
                                <li>고객센터</li>
                                <li>공지사항</li>
                            </ol>
                        </section>

                  
                  <form class="form" action="reg" method="post" enctype="multipart/form-data">
                           <table border="1">                        
                              <tr>
                                 <th>제목</th>
                                 <td colspan="3"><input type="text" name="title" value=""></td><!--제목-->
                              </tr>                     
                              
                              <tr>
                                 <th>첨부파일</th>
                                 <td colspan="3">
                                 	<input type="file" name="f">
                                 </td>
                              </tr>
                              	<!-- <tr>
                              		<td>
                              		취미 : <label>십자수</label>
                              		<input type="checkbox" value="1" name="h">
                              		<label>등산</label>
                              		<input type="checkbox" value="2" name="h">
                              		</td>
                              	</tr>   -->                            
                              <tr>
                                 <th>첨부파일</th>
                                 <td colspan="3">
                                 	<input type="file" name="f">
                                 </td>
                              </tr>
                              
                              <tr>
                                 <td colspan="4">
                                 <textarea rows="20" cols="80" name="content"></textarea> <!--글 내용-->
                                    
                                 </td>
                              </tr>
                           </table>
                           
                           <div class="progress-status">
                           		<div><span class="bar">0%</span></div>
                           		<ul>
                           			
                           		</ul>
                           	</div>
                           <section id="dnd-box">
						        <style>
						            #dnd-box .upload-box{
						                width:500px;
						                height: 150px;
						                border:1px solid gray;
						                box-shadow: 2px 3px 9px hsl(0, 0%, 47%);
						                padding:10px;
						            }
						            #dnd-box .upload-box.valid{
						            	background: green;	
						            }
						            #dnd-box .upload-box.invalid{
						            	background: red;
						            }
						            .progress-status{
						            	font-size: 20px;
						            	width: 600px;
						            }
						            
						            .progress-status .bar{
						            	display: inline-block;
						            	height: 20px;
						            	width: 0%;
						            	background: green;
						            	text-align: right;
						            	color:#fff;
						            	
						            	transition:0.5s;
						            }
						        </style>
						        <h1 class="d-none">파일업로드 : DND & Trigger</h1>
						        <div class="upload-box">
						            <button class="btn-sel">파일선택</button>						            
						            <input class="btn-file d-none" type="file">           
						        </div>
						    </section>

                           
                     <div>
                        <input type="submit" value="저장">
                        <a href="list.jsp">취소</a>
                     </div>
                  </form>
                    </section>

                </main>
            </div>
        </div>

        <footer id="footer">
            <div class="float-content">
                <!-- 회사정보
        Copyright ⓒ newlecture.com 2012-2014 All Right Reserved. Contact admin@newlecture.com for more information -->
            </div>
        </footer>
    </div>

    <script>

        // var html = "<span>haha</span>";
        // //window.document.write(html);
        // asideTitle.innerHTML += html;

        // var result = window.confirm("정말?");
        // console.log(result);

        // var x = prompt("x:");
        // var y = prompt("y:");
        // x = parseInt(x);
        // y = parseInt(y);
        // alert(x+y);
        // window.x = 30;
        
        // function f1(){
        //     var x = 1;
        //     return function(){
        //         return ++x;
        //     };
        // }

        // var f = f1();
        // console.log(f());
        // console.log(f());
        // console.log(f());
        
        //var add = new Function("x, y", "return x+y;");
                
        // var add = function(x, y){
        //     return x + y;
        // };
        
        // console.log(add);
        // var result = add(3,4);
        // console.log(result);

        // ---------------------------------------

        // var ar = [2,3,4];
        // var obj = {"kor":10, "eng":20, "math":30};

        // for(var i=0; i<ar.length; i++)
        //     console.log(ar[i]);

        // for(var index in ar)
        //     console.log(ar[index]);

        // for(var key /*"kor"*/ in obj)
        //     console.log(obj[key]);

        // var x = 3;
        // console.log(x);

        // var y = 3;

        // var ob = {};
        // ob.a = 3;
        // ob["a"] = 3;


//----------------------------------------
        // var x = "hello";
        // var y = new String("hello");

        // console.log(x == y);    // 값을 비교  .equals()
        // console.log(x === y);   // 참조를 비교 ==


        // var n1 = 3;
        // console.log(n1);
        // var n2 = new Number(3);
        // console.log(n2);

        
        // var exam1 = {kor:30,eng:40,math:50};
        // var exam2 = {kor:31,eng:41,math:51};
        // var exam3 = {kor:32,eng:42,math:52};
//----------------------------
        // var a = {"kor":20};
        
        // // var exams = [exam1, exam2, exam3];
        // var json = '{"kor":29}';
        // //var data = eval(json);
        // var data = JSON.parse(json);
        // console.log(data.kor);
//---------------------------------
        //"data = [2,3,4,5];"
        
        // JSON 문자열을 자바스크립트 객체로 변경하기

        //console.log(data[2]);
        // var x;
        // //eval();
        // eval("x = 3;");
        // console.log(x);


        // var exams = [
        //     {kor:30,eng:40,math:50},
        //     {kor:31,eng:41,math:51},
        //     {kor:32,eng:42,math:52}
        // ];        

        // console.log(exams[1].eng);

        // var exam = {};//new Object();
        // exam.kor = 30;
        // exam.eng = 40;
        // exam.math = 50;
        // exam["math"] = 60;
        // exam["w-1"] = 100;



        //exam.writer id = "newlec";

        // console.log(exam.kor + exam.math);
        // console.log(exam["w-1"]);

        // var nums = [1,2,3,4,5];//new Array(1,2,3,4,5);
        // console.log(nums);
        // nums.splice(2, 1)
        // console.log(nums);
        // nums.splice(2,0,3,4,5);
        // console.log(nums);
        // var subNums = nums.slice(1,3);
        // console.log(subNums);
        // console.log(nums.length);
        // console.log(nums.indexOf(35) >= 0);
        

        // var nums = new Array(5);
        // console.log(nums);

        // var nums1 = new Array(5, 10);
        // console.log(nums1);

        // var nums2 = new Array(5, 10, "hello", new Array(2,3,4));
        // console.log(nums2);
        // console.log(nums2[3][1]);
        // console.log(typeof nums2[2]);

        //데이터를 저장하는 구조 : 자료구조
        //[------>] 선형 : 버퍼로 사용하는 선형 : 큐
        //-->[1 5 2]-->
        // var q = new Array();
        // q.push(2);
        // console.log(q);
        // q.push(5);
        // console.log(q);
        // q.push(1);
        // console.log(q);
        // q.unshift(10);
        // console.log(q);

        // console.log(q.shift());
        // console.log(q);
        // console.log(q.shift());
        // console.log(q);
        // console.log(q.shift());
        // console.log(q.pop());
        // console.log(q.pop());


    </script>
</body>


</html>