<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ebay</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="main.css">
    <style type="text/css">
        :root {
            --mainBlue: #2a2a72;
            --lightBlue: #009ffd;
            --mainWhite: #f3f3f3;
            --mainDark: #232528;
            --mainYellow: #ffa400;
        }

        body {
            font-family: "Oswald", sans-serif !important;
            background: var(--mainWhite) !important;
            color: var(--mainDark) !important
        }

        .text-title {
            font-family: 'Permanent Marker', cursive;
            letter-spacing: 0.3rem;
            text-transform: uppercase;
        }

        .text-blue {
            color: var(--mainBlue);
        }

        .text-bright {
            color: var(--lightBlue);
        }

        .navwrapper {
            background: var(--mainBlue) !important;
        }
        /*.nav-link {
            color: var(--mainWhite) !important;
            font-size: 1.3rem;
            text-transform: capitalize;
        }*/

        .card {
            border-color: transparent;
            transition: all 1s linear;
        }
        .card-footer {
            background: transparent;
            border-top: transparent;
            transition: all 1s linear;
        }
        .card:hover{
            border: 0.04rem solid rgba(0,0,0,0.2);
            box-shadow: 2px 2px 5px 0px rgba(0,0,0,0.2);
        }
        .card-footer:hover {
            background: rgba(247,247,247);
        }

        .img-container{
            position: relative;
            overflow: hidden;
        }
        .card-img-top {
            transition: all 1s linear;
        }

        .img-container:hover .card-img-top {
            transform: scale(1.2);
        }/*
        .btn {
            text-transform: capitalize;
            font-size: 1.4rem;
            background: transparent;
            border: 0.05rem solid var(--lightBlue);
            color: var(--lightBlue);
            border-radius: 0.5rem;
            cursor: pointer;
            margin: 0.2rem 0.5rem 0.2rem 0;
            transition: all 0.5s ease-in-out;
        }
        .btn:hover {
            background: var(--lightBlue);
            color: var(--mainBlue);
        }
        .btn:focus {
            outline: none;
        }*/
        .cart-btn {
            position: absolute;
            bottom: 0;
            right: 0;
            padding: 0.2rem 0.4rem;
            background: var(--lightBlue);
            border:none;
            color:var(--mainWhite);
            border-radius: 0.5rem 0 0 0;
            transform: translate(100%, 100%);
            transition: all 1s linear;
        }
        .img-container:hover .cart-btn {
            transform: translate(0, 0);
        }

        .cart-btn:hover {
            color: var(--mainBlue);
            cursor: pointer;
        }
		
       .button-black {
            background: transparent;
            text-transform: capitalize;
            font-size: 0.8rem !important;
            color: var(--mainDark);
            border-radius: 0 !important;
            border: 0.1rem solid var(--mainDark) !important;
        }
        
        .button-black:hover {
        	background: var(--mainDark) !important;
        	color: var(--mainWhite) !important;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-sm navbar-fixed-top navwrapper bg-primary navbar-dark px-sm-5">
        <a class="navbar-brand" href="#">ebay</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">Products</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ShowCart">My Cart</a>
                </li>
            </ul>
            <a href="logout.jsp" class="ml-auto">
                <button class="btn btn-primary mr-2">Logout</button>
            </a>
        </div>
    </nav>