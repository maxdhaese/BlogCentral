<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!--===============================================================================================-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/1-Front-End/home/css/normalize.css" />
    <!--===============================================================================================-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/1-Front-End/login/css/style.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/1-Front-End/login/css/utils.css" />
    <title>Login</title>
</head>

<a href="home" title="Back Home"><i class="fa fa-home fa-lg"></i></a>

<body>
    <div class="container">
        <form class="login100-form validate-form" action="loginpost" method="post">
            <span class="login100-form-title">
                Member Login
            </span>

            <div class="wrap-input100 validate-input" data-validate="Please enter username">
                <input class="input100" type="text" name="username" placeholder="Username">
                <span class="focus-input100"></span>
                <span class="symbol-input100">
                    <i class="fa fa-envelope fa-lg" aria-hidden="true"></i>
                </span>
            </div>

            <div class="wrap-input100 validate-input" data-validate="Password is required">
                <input class="input100" type="password" name="password" placeholder="Password">
                <span class="focus-input100"></span>
                <span class="symbol-input100">
                    <i class="fa fa-lock fa-lg" aria-hidden="true"></i>
                </span>
            </div>

            <div class="container-login100-form-btn">
                <input class="login100-form-btn" type="submit" value="Login">
            </div>

            <div class="utility">
                <div class="forgot text-center p-t-12">
                    <span class="txt1">
                        Forgot
                    </span>
                    <a class="txt2" href="/login/recovery.html">
                        Username / Password?
                    </a>
                </div>

                <div class="create text-center p-t-136">
                    <a class="txt2" href="register">
                        Create Account
                        <i class="fa fa-long-arrow-right m-l-5 fa-lg" aria-hidden="true"></i>
                    </a>
                </div>
            </div>

        </form>
    </div>
</body>

</html>