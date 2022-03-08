<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : Menu
    Created on : 21-Jan-2021, 17:02:16
    Author     : alias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
            <div class="container">
                <a class="fa-phone" href="home">KING's OF SNEAKER</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
                    <ul class="navbar-nav m-auto">
                        <c:if test="${account==null}">
                            <li class="nav-item">
                            <a class="nav-link" href="Login.jsp">Login</a>
                        </li>
                        </c:if>
                        <c:if test="${account!=null}">
                        <li class="nav-item">
                            <a class="nav-link" href="Logout">LogOut</a>
                        </li>
                        </c:if>
                        <c:if test="${account!=null}">
                        <li class="nav-item">
                            <a class="nav-link text-success" href="Login.jsp">Hello ${account.userName}</a>
                        </li>
                        </c:if>
                       <li class="nav-item">
                            <a class="nav-link text-success" href="adminlogin.jsp">Login as Admin</a>
                        </li>
                    </ul>

                    <form action="#" method="post" class="form-inline my-2 my-lg-0">
                        <div class="input-group input-group-sm">
                            <input name="txt" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                            <div class="input-group-append">
                                <button type="submit" class="btn btn-secondary btn-number">
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div>
                        <a class="btn btn-success btn-sm ml-3" href="Cart.jsp">
                            <i class="fa fa-shopping-cart"></i> Cart
                            <span class="badge badge-light">3</span>
                        </a>
                    </form>
                </div>
            </div>
        </nav>
        <section class="jumbotron text-center">
            <div class="container">
                <h1 class="jumbotron-heading">Siêu thị giày chất lượng cao</h1>
                <p class="lead text-muted mb-0">Uy tín tạo nên thương hiệu với hơn 10 năm cung cấp các sản phầm giày nhập từ China</p>
            </div>
        </section>
    </body>
</html>
