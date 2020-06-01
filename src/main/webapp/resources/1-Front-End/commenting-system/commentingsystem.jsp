<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <meta charset="UTF-8">
    <title>Commenting System</title>
    <meta name="viewport" content="width=device-width">
    <!-- <link rel="icon" type="image/png" href="http://www.favicon.cc/logo3d/430212.png" /> -->
    <!--===============================================================================================-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"
        integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <!--===============================================================================================-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/1-Front-End/home/css/normalize.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/1-Front-End/home/css/style.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/1-Front-End/home/css/header.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/1-Front-End/home/css/sortBtn.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/1-Front-End/home/css/sidebar.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/1-Front-End/home/css/card_style.css" />
    <style>
        .collapsible {
            visibility: hidden;
        }
    </style>

</head>

<body>
    <div class="container">
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <c:set var="blog_id" value="${blog.id}" scope="request" />
        <c:set var="blog_username" value="${blog.author.username}" scope="request" />
        <c:set var="blog_title" value="${blog.title}" scope="request" />
        <c:set var="blog_likes" value="${blog.likeCount}" scope="request" />
        <c:set var="blog_message" value="${blog.message}" scope="request" />
        <c:set var="blog_comments" value="${blog.comments}" scope="request" />

        <c:import url="../generalcomponents/sidebar.jsp" />
        <c:import url="../generalcomponents/header.jsp" />
        <c:import url="../home/homecomponents/sortheader.jsp" />
        <c:import url="../generalcomponents/postcard with comments.jsp" />


    </div>

    <a href="" onclick="topFunction()" id="myBtn" title="Back to top"><i class="fa fa-arrow-up"></i></a>

    <script src="resources/1-Front-End/home/js/collapsible.js"></script>

</body>