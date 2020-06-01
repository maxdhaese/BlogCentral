<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">

<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <link href="https://fonts.googleapis.com/css?family=Yeon+Sung&display=swap" rel="stylesheet"/>
    <!--===============================================================================================-->
    <link href="https://fonts.googleapis.com/css?family=McLaren|Yeon+Sung&display=swap" rel="stylesheet"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/1-Front-End/home/css/normalize.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/1-Front-End/home/css/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/1-Front-End/home/css/header.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/1-Front-End/home/css/sortBtn.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/1-Front-End/home/css/sidebar.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/1-Front-End/home/css/card_style.css"/>


    <title>CentralBlog</title>
</head>

<body>
<jsp:include page="../generalcomponents/sidebar.jsp"></jsp:include>
<jsp:include page="../generalcomponents/header.jsp"></jsp:include>

<!-- HEADER Section -->
<!-- End Header-Section  -->

<!-- Main-Section -->
<main class="grid-container">
    
    <!-- SORT Header -->
    <div class="collapse">
    <button type="button" class="collapsible">Sort</button>
    <div class="content">
      <div class="sortMenu">
        <li><a href="#">POPULAR</a></li>
        <li><a href="#">LATEST</a></li>
        <li><a href="#">ELDEST</a></li>
      </div>
    </div>
  </div>
        <!-- USER Container -->
        <div class="container">
            <div class="userComment">


                <%--            The cards are looping below --%>

                <c:forEach items="${blogsDynamic}" var="blogloaded">

                    <c:set var="iteratedusername" value="${blogloaded.author.username}"/>
                    <c:set var="iteratedtitle" value="${blogloaded.title}"/>
                    <c:set var="iteratedlike" value="${blogloaded.likeCount}"/>
                    <c:set var="iteratedmessage" value="${blogloaded.message}"/>

                    <%--                    <c:set var="iteratedusername" value="${blogloaded.author.username}"/>--%>
                    <%--                    <c:set var="iteratedtitle" value="${blogloaded.title}"/>--%>
                    <%--                    <c:set var="iteratedlike" value="${blogloaded.likeCount}"/>--%>
                    <%--                    <c:set var="iteratedmessage" value="${blogloaded.message}"/>--%>
                    <%--                    <c:set var="iteratednoofcomments" value="${fn:length(blogloaded.comments)}"/>--%>

                    <%--             The division below is card to be repeated in our loop--%>

                    <!-- POST Card -->
                    <div class="card">

                        <!-- CARD Left -->
                        <div class="card-left">
                            <a class="card-left-title" href="#">${iteratedusername}</a>
                            <i class="fa fa-user fa-lg"></i>
                            <!-- <img src="https://switchfully.com/img/switchfully_small_logo.png"> -->
                            <span>Some sub-text</span>
                        </div>
                        <!-- CARD-Right -->
                        <div class="right">
                            <fieldset>
                                <legend>
                                    <h3><a class="card-title" href="#">${iteratedtitle}</a></h3>
                                </legend>

                                <p class="card-message">
                                        ${iteratedmessage}
                                </p>
                                <div class="card-icons">
                                <a class="like-icon" title="Like" href="#">
                                    <i class="fa fa-thumbs-up"></i>
                                </a>

                                <span class="likes-count" title="Likes">111</span>
            <a class="reply-icon" title="Comment" href="" onclick="alertFunction()"><i class="fa fa-comment"></i></a>
            <a class="tags-icon" title="Tags" href="" onclick="alertFunction()"><i class="fa fa-tags"></i></a>&nbsp;
            <a class="tags-icon" title="Bookmark" href="" onclick="alertFunction()"><i class="fa fa-bookmark"
                aria-hidden="true"></i></a>

                            </div>
                            </fieldset>


                            
                        </div>
                    </div>

                    <a href="" onclick="topFunction()" id="myBtn" title="Back to top"><i class="fa fa-arrow-up"></i></a>
                    <!-- <button onclick="topFunction()" id="myBtn" title="Go to top">Top</button> -->



                </c:forEach>

                <%--            End of the loop of cards--%>


            </div>

        </div>
    </div>
</main>
<script src="resources/1-Front-End/home/js/collapsible.js"></script>
</body>

</html>