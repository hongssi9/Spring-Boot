<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

		<header id="header">
            <div class="float-content">
                <h1 class="logo"><img src="/images/logo.png" alt="뉴렉처 온라인"></h1>
                <section>
                    <h1 class="d-none">헤더</h1>
                    <nav class="main-menu">
                        <h1 class="d-none">메인메뉴</h1>
                        <ul>
                            <li><a class="redsun" href="" dir="ltr">학습가이드</a></li>
                            <li><a href="">강좌선택</a></li>
                            <li><a href="">AnswerIs</a></li>
                        </ul>
                    </nav>                    
                    <section class="lecture-search-form">
                        <h1 class="d-none">강좌검색폼</h1>
                        <form>
                            <fieldset>
                                <legend class="d-none">과정 검색 필드</legend>
                                <label>과정검색</label>
                                <input id="a1" type="text" value="테스트">
                                <input class="button" type="submit" value="검색">
                            </fieldset>
                        </form>
                    </section>

                    <nav class="member-menu">
                        <h1 class="d-none">회원메뉴</h1>
                        <ul>
                            <li><a href="index.html">HOME</a></li>
                            <li><a href="/member/login">로그인</a></li>
                             <li><a href="/member/logout">로그아웃</a></li>
                            <%-- <c:if test="${empty sessionScope.uid}"> <!-- 값이넘어오면 로그인 -->
                            <li><a href="/member/login">로그인</a></li>
                            </c:if>
                            <c:if test="${not empty sessionScope.uid}">               
                            <li><a href="/member/login">로그아웃</a></li> <!-- 연결된 페이지는 무조건 절대경로로 해야한다. -->
                            </c:if> --%>
                            <li>data:${data}</li>
                            <li><a href="">회원가입</a></li>
                        </ul>
                    </nav>

                    <nav class="customer-menu">
                        <h1 class="d-none">고객센터메뉴</h1>
                        <ul>
                            <li><a class="button mypage-button" href="">마이페이지</a></li>
                            <li><a class="button customer-button" href="">고객센터</a></li>
                        </ul>
                    </nav>
                </section>
            </div>
        </header>