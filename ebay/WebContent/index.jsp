<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page import="users.model.User" %>


<% 
User user = (User)request.getSession().getAttribute("user");
if(user == null) {
	System.out.println("unknown user");
	response.sendRedirect("login.jsp");
} else if(user.getUsername().equals("admin")){
	response.sendRedirect("admindashboard.jsp");
}
%>

<%@include file="header.jsp" %>
<div class="py-5">
    <div class="container">
        <div class="row">
            <div class="col-10 mx-auto my-2 text-center text-title">
                <h1 class="text-capitalize font-weight-bold">OUR
                    <strong class="text-blue">PRODUCTS</strong>
                </h1>
            </div>
        </div>
        
        <sql:setDataSource var="db" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/ebay" user="root" password=""/>
        <sql:query var="rs" dataSource="${db}">
        	select * from products
        </sql:query>
        
          
        <div class="row">
            <!-- product wrapper -->
            <c:forEach items="${rs.rows}" var="prod">
	            <div class="col-9 mx-auto col-md-6 col-lg-3 my-3">
	                <div class="card">
	                    <div class="img-container p-5">
	                        <a href="ProductDetails?productId=${prod.id}">
	                            <img class="card-img-top" src="images/${prod.fileName}" alt="image">
	                        </a>
	                        <a href="ConfirmOrder?pdtId=${prod.id}"><button class="cart-btn">
	                            <p class="text-capitalize mb-0">Add</p>
	                        </button></a>
	                    </div>
	                    <!-- Card footer -->
	                    <div class="card-footer d-flex justify-content-between">
	                        <p class="align-self-center mb-0 font-weight-bold">
	                            ${prod.name}
	                        </p>
	                        <h4 class="text-blue font-italic mb-0">
	                            <span class="mr-1">$</span>
	                            ${prod.price}
	                        </h4>
	                    </div>
	                </div>
	            </div>
	        </c:forEach>
            <!-- product wrapper -->

        </div>
    </div>
</div>

<%@include file="footer.jsp" %>