<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
										<td class="w-1">${n.id}</td><!-- id : entity에서 get --> <!-- 검색했을때 데이터베이스 값이 나오도록 값을 넣어줌 -->
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

  
