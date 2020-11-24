<%@include file="header.jsp"%>

<div class="py-5"></div>
  <div class="container">
    <div class="col-sm-2">
      <h3>Log In</h3>
    </div>
    <br>
    <form action="Login" method="POST" class="form-horizontal" role="form">
        <div class="form-group">
            <label for="username" class="col-sm-2 control-label">Username</label>
            <div class="col-sm-10">
                <input type="text" name="username" class="form-control" placeholder="Username">
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">Password</label>
            <div class="col-sm-10">
                <input type="password" name="password" class="form-control" placeholder="Password">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">Log In</button>
            </div>
        </div>
    </form>
    <p>Don't have an account? <a href="signup.jsp">Sign In</a></p> 
  </div>
</div>


<%@include file="footer.jsp"%>

