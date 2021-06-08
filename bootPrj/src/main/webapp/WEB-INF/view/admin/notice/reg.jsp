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

                  
                  <form class="form" action="reg" method="post">
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