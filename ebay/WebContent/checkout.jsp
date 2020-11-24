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
                    <strong class="text-blue">CHECKOUT</strong>
                </h1>
            </div>
        </div>
        
        <div class="container mt-5">
        	<div class="row">
        		<div class="col-10 mx-auto text-center text-title">
        			<h1>instructions</h1>
        			<hr>
        			<p>We will send you an email to confirm your orders</p>
        			<p>Your goods will arrive in three days </p>
        			<p>You will pay the cash on delivery of the goods</p>
        			<hr>
        			<p>Thanks for shopping with us</p>
        			<a href="index.jsp">
        				<button class="btn btn-sm btn-success">Back to products</button>
        			</a>
        		</div>
        	</div>
        </div>

    </div>
</div>

<%@include file="footer.jsp" %>