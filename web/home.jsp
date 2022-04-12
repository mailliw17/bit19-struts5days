<%-- 
    Document   : home
    Created on : Apr 6, 2022, 3:14:31 PM
    Author     : willi
--%>

<%@page import="com.myapp.struts.controller.LoginAction"%>
<%@page import="com.myapp.struts.model.LoginForm"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%-- JSTL tag libs --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
        <title>Home</title>

        <style>
            body {
                font-size: .875rem;
            }

            .feather {
                width: 16px;
                height: 16px;
                vertical-align: text-bottom;
            }

            /*
             * Sidebar
             */

            .sidebar {
                position: fixed;
                top: 0;
                bottom: 0;
                left: 0;
                z-index: 100; /* Behind the navbar */
                padding: 48px 0 0; /* Height of navbar */
                box-shadow: inset -1px 0 0 rgba(0, 0, 0, .1);
            }

            @media (max-width: 767.98px) {
                .sidebar {
                    top: 5rem;
                }
            }

            .sidebar-sticky {
                position: relative;
                top: 0;
                height: calc(100vh - 48px);
                padding-top: .5rem;
                overflow-x: hidden;
                overflow-y: auto; /* Scrollable contents if viewport is shorter than content. */
            }

            @supports ((position: -webkit-sticky) or (position: sticky)) {
                .sidebar-sticky {
                    position: -webkit-sticky;
                    position: sticky;
                }
            }

            .sidebar .nav-link {
                font-weight: 500;
                color: #333;
            }

            .sidebar .nav-link .feather {
                margin-right: 4px;
                color: #999;
            }

            .sidebar .nav-link.active {
                color: #007bff;
            }

            .sidebar .nav-link:hover .feather,
            .sidebar .nav-link.active .feather {
                color: inherit;
            }

            .sidebar-heading {
                font-size: .75rem;
                text-transform: uppercase;
            }

            /*
             * Navbar
             */

            .navbar-brand {
                padding-top: .75rem;
                padding-bottom: .75rem;
                font-size: 1rem;
                background-color: rgba(0, 0, 0, .25);
                box-shadow: inset -1px 0 0 rgba(0, 0, 0, .25);
            }

            .navbar .navbar-toggler {
                top: .25rem;
                right: 1rem;
            }

            .navbar .form-control {
                padding: .75rem 1rem;
                border-width: 0;
                border-radius: 0;
            }

            .form-control-dark {
                color: #fff;
                background-color: rgba(255, 255, 255, .1);
                border-color: rgba(255, 255, 255, .1);
            }

            .form-control-dark:focus {
                border-color: transparent;
                box-shadow: 0 0 0 3px rgba(255, 255, 255, .25);
            }
        </style>
    </head>
    <body>
        <c:choose>
            <c:when test="${user != null}">
                <nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
                    <a class="navbar-brand col-md-3 col-lg-2 mr-0 px-3" href="#">CCOS BCA -  Personal Loan</a>
                    <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-toggle="collapse"
                            data-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <input class="form-control form-control-dark w-100" type="text" placeholder="Welcome ${sessionScope.user} User" aria-label="Search" readonly="">
                    <ul class="navbar-nav px-3">
                        <li class="nav-item text-nowrap">
                            <a href="logout-action.do" class="nav-link btn btn-danger">Logout</a>
                        </li>
                    </ul>
                </nav>

                <div class="container-fluid">
                    <div class="row">
                        <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
                            <div class="sidebar-sticky pt-3">
                                <ul class="nav flex-column">
                                    <li class="nav-item">
                                        <a class="nav-link active" href="#">
                                            <span data-feather="home"></span>
                                            User ID :  ${sessionScope.user}<span class="sr-only">(current)</span>
                                        </a>
                                    </li>
                                    <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
                                        <span>CCOS-BCA</span>
                                        <a class="d-flex align-items-center text-muted" href="#" aria-label="Add a new report">
                                            <span data-feather="plus-circle"></span>
                                        </a>
                                    </h6>

                                    <li class="nav-item">
                                        <a class="nav-link" href="customer-action.do">
                                            <span data-feather="shopping-cart"></span>
                                            New Application
                                        </a>
                                    </li>

                                    <c:if test="${sessionScope.role == 'Admin'}">
                                        <li class="nav-item">
                                            <a class="nav-link" href="province-action.do">
                                                <span data-feather="shopping-cart"></span>
                                                Maintenance Province
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="city-action.do">
                                                <span data-feather="users"></span>
                                                Maintenance City
                                            </a>
                                        </li>
                                    </c:if>

                                    <li class="nav-item">
                                        <a class="nav-link" href="Report/generateReport.jsp">
                                            <span data-feather="bar-chart-2"></span>
                                            Reports
                                        </a>
                                    </li>
                                    
                                    <c:if test="${sessionScope.role == 'Admin'}">
                                    <li class="nav-item">
                                        <a class="nav-link" href="#">
                                            <span data-feather="layers"></span>
                                            Users
                                        </a>
                                    </li>
                                    </c:if>
                                </ul>
                            </div>
                        </nav>

                        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
                            <div
                                class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                                <h1 class="h2">CCOS-BCA : Consumer Credit Origination System - Bank Central Asia</h1>
                            </div>

                            <p>Welcome ${sessionScope.user} User</p>
                            <p>You are currently login as ${sessionScope.role}</p>

                        </main>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <c:redirect url="/login-action.do" />
            </c:otherwise>
        </c:choose>

        <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>

    </body>
</html>
