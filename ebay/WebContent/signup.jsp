<%@include file="header.jsp" %>
<div class="py-5">
    <div class="container">
        <div class="col-sm-2">
            <h3>Sign Up</h3>
        </div>
        <br>
        <form action="SignUp" method="POST" class="form-horizontal" role="form">
            <div class="form-group">
                <label for="username" class="col-sm-2 control-label">Username</label>
                <div class="col-sm-10">
                    <input type="text" name="username" class="form-control" placeholder="Username" required>
                </div>
            </div>
            <div class="form-group">
                <label for="email" class="col-sm-2 control-label">Email</label>
                <div class="col-sm-10">
                    <input type="text" name="email" class="form-control" placeholder="Email" required>
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-2 control-label">Password</label>
                <div class="col-sm-10">
                    <input type="password" name="password" class="form-control" placeholder="Password" required>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-primary">Sign in</button>
                </div>
            </div>
        </form>
        <p>Already have an account? <a href="login.jsp">Log In</a></p>
    </div>
</div>
    

<%@include file="footer.jsp" %>