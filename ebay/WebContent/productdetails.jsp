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
    	<!-- title -->
    	<div class="row">
    		<div class="col-10 mx-auto text-center text-slanted text-blue my-5">
    			<h1> Product Details</h1>
    		</div>
    	</div>
    	<!-- end of title -->
 
    	<!-- product info -->
    	<div class="row">
    		<div class="col-10 mx-auto col-md-6 my-3">
    			<img src="images/${fileName}" class="img-fluid" alt="image">
    		</div>
    		<!-- product text -->
    		<div class="col-10 mx-auto col-md-6 my-3 text-capitalize">
    			<h1>${name}</h1>
    			<h4 class="text-blue">
    				<strong>
    					price : <span>$</span> ${price}
    				</strong>
    			</h4>
    			<p class="text-capitalize font-weight-bold mt-3 mb-0">
    				details:
    			</p>
    			<p class="text-muted lead">
    				${description}
    			</p>
    			<!-- Buttons -->
    			<div>
    				<a href="index.jsp">
    					<button class="btn btn-info">back to products</button>
    				</a>
    				<a href="ConfirmOrder?pdtId=${id}">
    					<button class="btn btn-success">Add To Cart</button>
    				</a>
    				<!-- take user to confirm order page where they will add the quantity they want
    				and then after add the item to the cart -->
    			</div>
    		</div>
    	</div>

    </div>
</div>

<%@include file="footer.jsp" %></title>
</head>
<body>

</body>
</html>