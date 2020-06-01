<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<header class="">
    <div class="header-top">
        <!-- LOGO  Btn -->
        <h1 class="logo"><a href="home">BlogCentral</a></h1>
        <!-- LOGIN -->
        <c:choose>
            <c:when test="${!isLoggedIn}">
                <a class="sign-in" href="login">LOGIN &nbsp;<i class="fa fa-sign-in" aria-hidden="true"></i></a>
            </c:when>
            <c:otherwise>
                <a class="sign-in" href="logout">LOGOUT &nbsp;<i class="fa fa-sign-in" aria-hidden="true"></i></a>
            </c:otherwise>
        </c:choose>
    </div>
    <!-- SEARCH Wrapper -->
    <div class="search-wrapper">
        <form action="search" method="get">
            <input type="text" name="query" autocomplete="off" placeholder="Search for&hellip;" type="submit"></input>
            <button type="submit" class="mysearchicon"> &nbsp;<i class="fa fa-search fa-lg"
                    aria-hidden="true"></i></button>
        </form>
    </div>
    <!-- REGISTER  Btn -->
    <div>
        <c:choose>
            <c:when test="${!isLoggedIn}">
                <a class="register" href="register">REGISTER&nbsp;<i class="fa fa-user-plus"></i></a>
            </c:when>
            <c:otherwise>
                <a class="register" href="register">UPDATE PROFILE&nbsp;<i class="fa fa-user-plus"></i></a>
            </c:otherwise>
        </c:choose>
    </div>
</header>