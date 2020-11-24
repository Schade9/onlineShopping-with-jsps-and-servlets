<%@include file="header.jsp"%>

<div class="py-5">
    <div class="container">
        <div class="col-sm-2">
            <h3>Add Product</h3>
        </div>
        <br>
        <form action="AddProduct" method="POST" enctype="multipart/form-data" class="form-horizontal" role="form">
            <div class="form-group">
                <label for="product_name" class="col-sm-2 control-label">Product name</label>
                <div class="col-sm-10">
                    <input type="text" name="name" class="form-control" placeholder="">
                </div>
            </div>
            <div class="form-group">
                <label for="product_price" class="col-sm-2 control-label">Product price</label>
                <div class="col-sm-10">
                    <input type="text" name="price" class="form-control" placeholder="">
                </div>
            </div>
            <div class="form-group">
                <label for="product_description" class="col-sm-2 control-label">Product description</label>
                <div class="col-sm-10">
                    <textarea name="description" rows="8" class="form-control" placeholder=""></textarea>
                </div>
            </div>
            <div class="form-group">
                <label for="product_image" class="col-sm-2 control-label">Product image</label>
                <div class="col-sm-10">
                    <input type="file" name="img" class="" required>
                </div> 
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-primary">Add Product</button>
                </div>
            </div>
        </form>
    </div>
</div>

<%@include file="footer.jsp"%>