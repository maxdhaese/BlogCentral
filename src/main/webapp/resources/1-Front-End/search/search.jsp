<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <meta http-equiv="X-UA-Compatible" content="ie=edge" />
  <link href="https://fonts.googleapis.com/css?family=Yeon+Sung&display=swap" rel="stylesheet" />
  <!--===============================================================================================-->
  <link href="https://fonts.googleapis.com/css?family=McLaren|Yeon+Sung&display=swap" rel="stylesheet" />
  <!--===============================================================================================-->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <!--===============================================================================================-->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/1-Front-End/home/css/normalize.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/1-Front-End/home/css/style.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/1-Front-End/home/css/header.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/1-Front-End/home/css/sortBtn.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/1-Front-End/home/css/sidebar.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/1-Front-End/home/css/card_style.css" />


  <title>CentralBlog</title>
</head>


<body>
  <!-- Main-Section -->
  <div class="container">

    <!-- SIDE Function -->
    <jsp:include page="../generalcomponents/sidebar.jsp" />

    <!-- HEADER Section -->
    <jsp:include page="../generalcomponents/header.jsp" />

    <!-- SORT Header -->
    <jsp:include page="../home/homecomponents/sortheader.jsp" />

    <!-- POST Card -->
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <c:forEach items="${authorlist}" var="author">
      <c:set var="username" value="${author.username}" scope="request" />
      <c:import url="../generalcomponents/standaloneauthor.jsp" />
    </c:forEach>

    <c:forEach items="${bloglist}" var="blogloaded">
      <jsp:include page="../generalcomponents/postcard.jsp">
        <jsp:param name="id" value="${blogloaded.id}" />
        <jsp:param name="username" value="${blogloaded.author.username}" />
        <jsp:param name="title" value="${blogloaded.title}" />
        <jsp:param name="likes" value="${blogloaded.likeCount}" />
        <jsp:param name="message" value="${blogloaded.message}" />
      </jsp:include>
    </c:forEach>

    <c:forEach items="${commentlist}" var="comment">
      <c:set var="comment" value="${comment}" scope="request" />
      <c:import url="../generalcomponents/standalonecomment.jsp" />
    </c:forEach>

    <a href="" onclick="topFunction()" id="myBtn" title="Back to top"><i class="fa fa-arrow-up"></i></a>

    <script src="resources/1-Front-End/home/js/collapsible.js"></script>

</body>

</html>