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
        
        <!--<div class="container mt-5">
        	<div class="row">
        		<div class="col-10 mx-auto text-center text-title">
        			<h1>your cart is currently empty</h1>
        		</div>
        	</div>
        </div>-->
        
        <div class="container-fluid text-center d-none d-lg-block">
	        <div class="row">
				<div class="col-10 mx-auto col-lg-2">
					<p class="text-uppercase">products</p>
				</div>
				<div class="col-10 mx-auto col-lg-2">
					<p class="text-uppercase">name</p>
				</div>
				<div class="col-10 mx-auto col-lg-2">
					<p class="text-uppercase">price</p>
				</div>
				<div class="col-10 mx-auto col-lg-2">
					<p class="text-uppercase">quantity</p>
				</div>
				<div class="col-10 mx-auto col-lg-2">
					<p class="text-uppercase">total</p>
				</div>
				<div class="col-10 mx-auto col-lg-2">
					<p class="text-uppercase">remove</p>
				</div>
	        	<c:forEach var="cart" items="${listCart}" >
		        	<div class="container-fluid">
		        		<div class="row my-2 text-capitalize text-center">
			        		<div class="col-10 mx-auto col-lg-2">
			        			<img class="img-fluid" style="width: 5rem; height: 5rem;" src="images/<c:out value="${cart.pdt_fileName}"/>" alt="image"/>
			        		</div>
			        		<div class="col-10 mx-auto col-lg-2">
			        			<span class="d-lg-none">Product: </span> <c:out value="${cart.pdt_name}"/>
			        		</div>
			        		<div class="col-10 mx-auto col-lg-2">
			        			<span class="d-lg-none">Price: </span> $<c:out value="${cart.pdt_price}"/>
			        		</div>
			        		<div class="col-10 mx-auto col-lg-2 my-2 my-lg-0">
			        			<div class="d-flex justify-content-center">
			        				<span class="btn button-black mx-1"><c:out value="${cart.pdt_quantity}"/></span>
			        			</div>
			        		</div>
			        		<div class="col-10 mx-auto col-lg-2">
			        			<strong>$<c:out value="${cart.total}"/></strong> 
			        		</div>
			        		<div class="col-10 mx-auto col-lg-2">
			        			<div>
			        				<a href="DeleteFromCart?cartId=<c:out value="${cart.id}"/>">
			        					<button class="btn btn-sm btn-warning">Delete</button>
			        				</a>
			        			</div>
			        		</div>
		        		</div>
		        	</div>
	        	</c:forEach>
	        </div>
        </div>
        
        <div class="container">
        	<div class="row">
        		<div class="col-10 mt-2 ml-sm-5 ml-md-auto col-sm-8 text-capitalize text-right">
        			<!--<a href="EmptyCart">
        				<button class="btn btn-danger mb-3 text-uppercase px-5">clear cart</button>
        			</a>-->
        			<h5>
        				<span class="text-title">Subtotal: </span>
        				<strong>$ ${subTotal}</strong>
        			</h5>
        			<h5>
        				<span class="text-title">Tax: </span>
        				<strong>$ ${tax}</strong>
        			</h5>
        			<h5>
        				<span class="text-title">Total: </span>
        				<strong>$ ${grandTotal}</strong>
        			</h5>
        			<a href="checkout.jsp">
        				<button class="btn btn-success mb-3 text-uppercase px-5">Check out</button>
        			</a><br>
        			<small class=text-muted>Terms and conditions apply</small>
        		</div>
        	</div>
        </div>
    </div>
</div>

<%@include file="footer.jsp" %>