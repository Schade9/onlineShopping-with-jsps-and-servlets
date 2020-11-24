<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page import="users.model.User" %>


<%
User user = (User)request.getSession().getAttribute("user");
if(user == null) {
	System.out.println("unknown user");
	response.sendRedirect("login.jsp");
} 
%>

<%@include file="header.jsp" %>
<div class="py-5">
    <div class="container">
        <div class="row">
            <div class="col-10 mx-auto my-2 text-center text-title">
                <h1 class="text-capitalize font-weight-bold">YOUR
                    <strong class="text-blue">CART</strong>
                </h1>
            </div>
        </div>
        
        <div class="container mt-5">
        	<div class="row">
        		<div class="col-10 mx-auto text-center text-title">
        			<h1>your cart is currently empty</h1>
        		</div>
        	</div>
        </div>

    </div>
</div>

<%@include file="footer.jsp" %>