
<%@page import="com.newlecture.web.entity.Notice"%>
<%@page import="java.util.List"%>
<%@page import="com.newlecture.web.service.JdbcNoticeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<%-- <c:set var="num" value="${count/10}" /> --%>
<%-- <fmt:formatNumber var="num" value="${count/10}" pattern="#.##"/>


<c:set var="LastPage" value="${num + (count%10==0?0:1)}" /> --%>


<%-- <%
String f = request.getParameter("f"); //list.jsp 에있는 (String field, String query)로 전달된다.
	String q = request.getParameter("q");
	String p = request.getParameter("p"); //페이지
	
	System.out.println(f);
	System.out.println(q);
	System.out.println(p);
	
	//변수 초기화 : 기본 값을 설정하는 것
	int page_ = 1; //페이지 수는 정수로 받아야 하기 때문에 page빨간줄이유 : page는 내장변수가 이미 어디서 쓰이고있어서
	String field = "title";
	String query = "";
	
	if(p != null && !p.equals(""))
		page_ = Integer.parseInt(p);
	
	if(f != null && f.equals("")) //null도 아니고 빈 문자도 아니면
		field = f;
	
	if(q != null && !q.equals(""))
		query = q;
		

   JdbcNoticeService noticeService = new JdbcNoticeService();
   /* List<Notice> list = noticeService.getList(p, f, q); */
   List<Notice> list = noticeService.getList(page_, field, query);
%> --%>

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
		<jsp:include page="/WEB-INF/view/inc/header.jsp"/>

		<div id="visual">
			<div class="float-content"></div>
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
						<%for(int i=0; i<5; i++){%>
						<div>hello</div>
						<% } %>

						<section class="breadcrumb">
							<h1 class="d-none">경로</h1>
							<ol>
								<li>home</li>
								<li>고객센터</li>
								<li>공지사항</li>
							</ol>
						</section>

						<section class="search-form">
							<h1>검색 폼</h1>
							<form action="list" method="get">
								<label class="d-none">검색분류</label>
								<%-- <%
									String selectedTitle = "";
									String selectedWriterId = "";
									
									if(field.equals("title"))
										selectedTitle = "selected";
									
										if(field.equals("writer_id"))
											selectedWriterId = "selected";
								%> --%> 
								<select name="f">
									<option value="">분류선택</option>
									<option ${param.f=='title'?'selected':''} value="title">제목</option>
									<option ${param.f=='writer_id'?'selected':''} value="writer_id">작성자</option>
									<%-- <option <%=selectedWriterId %> value="writer_id">작성자</option> --%>
								</select>
								<label class="d-none">검색어</label>
								<input type="text" name="q" value="${param.q}">
								<input type="hidden" name="p" value="${p=1}">
								<%-- <input type="text" name="q" value="<%=query%>"> <!--검색했던 데이터 남기기--> --%>
								<input type="submit" value="검색">
								</form>
						</section>

						<section class="mt-3">
							<h1 class="d-none">공지사항 목록</h1>
							<table class="table">
								<thead>
									<tr>
										<td class="w-1">번호</td>
										<td class="truncate">제목</td>
										<td class="w-2">작성자</td>
										<td class="w-2">작성일</td>
										<td class="w-1">조회수</td>
									</tr>
								</thead>
								<tbody>
										<!-- 꺼내온 list하나를 키값인 n에다 넣어준다. -->
								<c:forEach var="n" items="${list}" varStatus="st">
									<tr>
										<td class="w-1">${n.id}</td> <!-- 검색했을때 데이터베이스 값이 나오도록 값을 넣어줌 -->
										<td class="truncate text-align-left"><a href="detail?id=${n.id}">${n.title}[20]</a></td>
										<td class="w-2">${n.writerId}</td>		  
										<td class="w-2"><fmt:formatDate value="${n.regDate}" pattern="yyyy년 MM월 dd일" /> </td>
										<td class="w-1">${n.hit}</td>
									</tr>							
								</c:forEach>
								<%-- 	<% for(Notice n : ${list}){ %> <!-- 게시글 목록! 만들기 -->
									<tr>
										<td class="w-1"><%=n.getId() %></td> <!-- 검색했을때 데이터베이스 값이 나오도록 값을 넣어줌 -->
										<td class="truncate text-align-left"><a href="detail.jsp?id=<%=n.getId() %>"><%=n.getTitle() %>[20]</a></td>
										<td class="w-2"><%=n.getWriterId() %></td>		  
										<td class="w-2"><%=n.getRegDate() %></td>
										<td class="w-1"><%=n.getHit() %></td>
									</tr>
									<%} %> --%>
								</tbody>
							</table>
							
							
							<div>
								<a href="reg">글쓰기</a>	
							</div>
						</section>

						<section class="page-status mt-3">
							<h1 class="d-none">현재 페이지 정보</h1>
							<%-- <%
								int count = noticeService.getCount(field, query);
								int lastPage = count/10+ (count%10==0?0:1); //
							%>  --%>
							<div>
							<c:set var="LastPage" value="${count/10 + (count%10==0?0:1)}" />
							<c:set var="LastPage" value="${fn:substringBefore(LastPage, '.')}" />
								<span class="text-strong">${(empty param.p)?1:param.p}</span> / ${LastPage} pages
							</div>
						</section>
						
						<%-- <%
							String current = "";
						%> --%>

						<nav class="pager mt-3">
							<h1 class="d-none">페이저</h1>
							<div class="button">이전</div>
							<ul>
							<c:set var="page" value="${empty param.p?1:param.p}" />
							<c:forEach var="num" begin="1" end="10">
								<c:if test="${num <= LastPage }">
								<li><a class="${(page == num)?'text-strong':''}" href="list?p=${num}&f=${param.f}&q=${param.q}">${num}</a></li>
								</c:if>						
							</c:forEach>
							<%-- <%for(int i=0; i<5; i++){ %> <!--1.누르는 페이지만 색 입히기--> 
								<%if(i+1 <= lastPage) {%> <!--로드된 페이지만큼만 숫자가 뜨기(lastPage)-->
								<li><a class="<%=(page_ == i+1)?"text-strong":"" %>" href="list.jsp?p=<%=i+1 %>&f=<%=field %>&q=<%=query%>"><%=i+1 %></a></li>
								<%} %>
							<%} %> --%>					 <!-- 삼항연산 -->
							</ul>
							<div class="button">다음</div>
						</nav>

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