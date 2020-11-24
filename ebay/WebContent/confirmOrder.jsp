<%@include file="header.jsp"%>

<div class="py-5"></div>
  <div class="container">
    <div class="col-sm-5">
      <h3>Confirm Order</h3>
    </div>
    <br>
    <form action="ConfirmOrder" method="POST" class="form-horizontal" role="form">
    	<input type="hidden" name="pdt_id" value="${pdt_id}"/>
    	<input type="hidden" name="pdt_fileName" value="${pdt_fileName}"/>
        <div class="form-group">
            <label for="username" class="col-sm-2 control-label">Product name</label>
            <div class="col-sm-10">
                <input type="text" name="pdt_name" value="${pdt_name}" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">Product price $</label>
            <div class="col-sm-10">
                <input type="text" name="pdt_price" value="${pdt_price}" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">Product quantity</label>
            <div class="col-sm-10">
                <input type="text" name="pdt_quantity" class="form-control" placeholder="Eg. 10">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">Add to cart</button>
            </div>
        </div>
    </form>
  </div>
</div>


<%@include file="footer.jsp"%>

