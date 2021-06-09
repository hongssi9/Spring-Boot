<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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

                  
                  <form action="edit" method="post">
                           <table border="1">                        
                              <tr>
                                 <th>제목</th>
                                 <td colspan="3"><input type="text" name="title" value="${notice.title}"></td>
                              </tr>
                              <tr>
                                 <th>작성일</th>
                                 <td colspan="3">${notice.regDate}</td>
                              </tr>
                              <tr>
                                 <th>작성자</th>
                                 <td>${notice.writerId}</td>
                                 <th>조회수</th>
                                 <td>${notice.hit}</td>
                              </tr>
                              <tr>
                                 <th>첨부파일</th>
                                 <td colspan="3">${notice.files}</td>
                              </tr>
                              <tr>
                                 <td colspan="4">
                                 <textarea rows="20" cols="80" name="content">${notice.content}</textarea>
                                    
                                 </td>
                              </tr>
                           </table>
                     <div>
                        <input type="hidden" name="id" value="${notice.id}" >
                        <input type="submit" value="저장">
                        <a href="detail?id=${notice.id}">취소</a>
                     </div>
                  </form>
                    </section>

                </main>