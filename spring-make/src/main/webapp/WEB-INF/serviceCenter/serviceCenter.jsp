<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>


  <script src="https://code.jQuery.com/jquery-3.7.1.min.js"></script>
  <script src="./js/serviceCenter.js"></script>
  <link rel="stylesheet" href="./css/serviceCenter.css" />
</head>

<body>
  <button onclick="topFunction()" id="myBtnTop" title="Go to top">UP</button>
  <button onclick="bottomFunction()" id="myBtnBottom" title="Go to bottom">DOWN</button>


  <header class="banner">
    <div class="menu">

      <div class="logobar">

        <nav>
          <a class="logo" href="./mainpage.html">Nadeuli</a>
        </nav>

        <div class="search">
          <input type="text" placeholder="여행을 가고싶다면 어디로.." title="검색" id="inp_search" autocomplete="off" />
          <input type="button" id="searchBtn" value="검색하기" />
        </div>

        <div class="login">
          <input type="button" id="loginBtn" value="로그인" />
          <input type="button" id="JoinBtn" value="회원가입" />
        </div>

      </div>



      <div class="nav">
        <ul>
          <div class="menu-icon" onclick="toggleNavSections()">
            <span></span>
          </div>

          <li class="a1"><a href="./mainpage.html">홈</a></li>
          <li class="a2"><a href="./miniproject.html">여행지</a></li>
          <li class="a3"><a href="./miniproject.html">후기</a></li>
          <li class="a4"><a href="./miniproject.html">이벤트</a></li>
          <li class="a5"><a href="./serviceCenter.html">고객센터</a></li>
        </ul>
      </div>

    </div>

    <div class="nav_section">
      <div id="여행지" class="sub_menu travel">
        <ul>
          <li><a href="./mainpage.html">테마별 여행지</a></li>
          <li><a href="./mainpage.html">여행지 TOP 10</a></li>
        </ul>
      </div>

      <div id="후기" class="sub_menu review">
        <ul>
          <li><a href="./mainpage.html">여행 후기</a></li>
          <li><a href="./mainpage.html">블로그 후기</a></li>
        </ul>
      </div>

      <div id="이벤트" class="sub_menu event">
        <ul>
          <li><a href="./mainpage.html">진행중인 이벤트</a></li>
          <li><a href="./mainpage.html">종료된 이벤트</a></li>
        </ul>
      </div>

      <div id="고객센터" class="sub_menu service-center">
        <ul>
          <li><a href="serviceCenter.html#notice">공지사항</a></li>
          <li><a href="serviceCenter.html#inquiry">1 : 1 문의</a></li>
          <li><a href="serviceCenter.html#qna" style="margin-left: 6%;">FQA</a></li>
        </ul>
      </div>
    </div>

  </header>

  <hr>

  <div id="wrap">

    <div id="container">
      <div class="snb"><!--snb-->
        <h2>고객센터</h2>
        <ul>
          <li><a href="serviceCenter.html#notice">공지사항</a></li>
          <li><a href="serviceCenter.html#inquiry">1 : 1 문의</a></li>
          <li><a href="serviceCenter.html#faq">F A Q</a></li>
        </ul>
      </div><!-- snb -->

      <div id="content">

        <div id="noticeContent">
          <h2>공지사항</h2>
          <div class="notices">
          </div>
          <button id="createBtn">작성</button>
          <button id="editBtn">수정</button>
          <button id="deleteBtn">삭제</button>
        </div>

        <!-- 글 작성 화면 (초기에는 숨김 처리) -->
        <div id="writeForm" style="display: none;">
          <h2>공지사항 작성</h2>
          <textarea id="noticeText" rows="4" cols="50"></textarea><br>
          <button id="saveBtn">저장</button>
          <button id="cancelBtn">취소</button>
        </div>
        <!------------------------------------------------------------------>
        <div id="inquiryContent">
          <h2>1 : 1 문의</h2>

          <div id="inquirycontainer">
            <h1>문의하기</h1>
            <div id="inquirycomment_write">
            </div>
            <form id="comment11_form">
              <div>
                <label for="user11_name">작성자</label>

                <input type="text" name="user11_name" id="user11_name" value="닉네임" readonly disabled />
              </div>
              <br>
              <div>
                <label for="inquirycomment">문의 내용</label>
                <textarea name="inquirycomment" id="inquirycomment"></textarea>
                <div id="inquirycomment_error">내용을 입력해주세요.</div>
                <div id="secret">
                  <input type="checkbox" name="secret">
                  <label for="secret">비밀글</label>
                </div>
                <input class="iqrbtn" type="submit" value="등록" />
              </div>

              <br>

              <div id="inquirycomment_list"></div>
            </form>
          </div>
        </div><!-- inquirycontainer -->

      </div><!-- inquiryContent -->


      <div id="faqContent">
        <h2>자주 묻는 질문</h2>
        <br>
        <div class="faq">

        </div>

        <div class="btn3">
          <br>
          <button class="create-btn" style="display:block;" onclick="createFAQ();">작성</button>
        </div>
      </div><!-- faqContent -->
    </div><!--content-->
  </div><!--container-->

  </div> <!-- wrap -->

  <hr>

  <footer>

    <strong class="tit">여행 후기를 SNS에 남겨주세요!</strong>

    <br><br><br>

    <div class="sns_list">
      <ul>
        <li>
          <a href="http://blog.naver.com" target="_blank" title="새창">
            <span class="icon icon_blog"></span>
            <em class="sns_name">네이버 블로그</em>
          </a>
        </li>
        <li>
          <a href="http://post.naver.com" target="_blank" title="새창">
            <span class="icon icon_post"></span>
            <em class="sns_name">포스트</em>
          </a>
        </li>
        <li>
          <a href="https://band.us" target="_blank" title="새창">
            <span class="icon icon_band"></span>
            <em class="sns_name">네이버<br />밴드</em>
          </a>
        </li>
        <li>
          <a href="https://www.facebook.com" target="_blank" title="새창">
            <span class="icon icon_facebook"></span>
            <em class="sns_name">페이스북</em>
          </a>
        </li>
        <li>
          <a href="https://twitter.com" target="_blank" title="새창">
            <span class="icon icon_twitter"></span>
            <em class="sns_name">엑스</em>
          </a>
        </li>
        <li>
          <a href="https://story.kakao.com" target="_blank" title="새창">
            <span class="icon icon_kakaostory"></span>
            <em class="sns_name">카카오<br />스토리</em>
          </a>
        </li>
        <li>
          <a href="https://www.instagram.com" target="_blank" title="새창">
            <span class="icon icon_instagram"></span>
            <em class="sns_name">인스타<br />그램</em>
          </a>
        </li>
      </ul>
    </div>

    <hr />
    <br>
    <div>
      <ul class="btm_menu">
        <li><a href="javascript:" onclick="goTerm(1);" class="personal_info">개인정보처리방침</a></li>
        <li><a href="javascript:" onclick="goTerm(2);">이용약관</a></li><!-- 0703 추가 -->
        <li><a href="javascript:" onclick="goTerm(3);">위치기반서비스 이용약관</a></li><!-- 0717 추가 -->
        <li><a href="" target="_blank" title="새창">저작권정책</a></li>
        <li><a href="" target="_blank" title="새창">고객서비스헌장</a></li>
        <li><a href="" target="_blank" title="새창">전자우편무단수집거부</a></li>
        <li><a href="serviceCenter.html#qna" onclick="goQA();" title="페이지이동">Q&amp;A</a></li>
        <li><a href="" target="_blank" title="새창">찾아오시는 길</a></li>
      </ul>
    </div>
    <br>
    <hr />
    <div class="badak">
      <p>
        미니프로젝트
        <a href="https://naver.com">naver_cloud_camp</a>
      </p>
      <div>
        <a href="https://api.visitkorea.or.kr/#/" target="_blank" title="새창"><img src="./css/image/Tour_api.png"
            alt="TourAPI 4.0"></a>
      </div>
    </div>
  </footer>

</body>
</html>