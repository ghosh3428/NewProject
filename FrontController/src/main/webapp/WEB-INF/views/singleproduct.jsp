<div class="container">

	<!-- Breadcrumb -->
	<div class="row">

		<div class="col-xs-12">


			<ol class="breadcrumb">

				<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
				<li class="breadcrumb-item"><a
					href="${contextRoot}/show/all/active/product">Products</a></li>
				<li class="breadcrumb-item active">${product.name}</li>

			</ol>


		</div>


	</div>

	<div class="row">

		<div class="col-xs-12 col-sm-4">

			<div class="thumbnail">

				<img src="${images}/${product.code}.jpg" class="img img-responsive" />

			</div>

		</div>

		<div class="col-xs-12 col-sm-8">

			<h3>${product.name}</h3>
			<hr />

			<p>${product.description}</p>
			<hr />

			<h4>
				<s> Price: <strong> &#8377; ${product.unitPrice} /-</strong>
				</s>
			</h4>
			
			<h4>
				Discounted  Price: <strong> &#8377; ${product.unitPrice - (product.unitPrice*0.1)} /-</strong>
				
			</h4>

			<c:choose>

				<c:when test="${product.quantity < 1}">

					<h6>
						Qty. Available: <span style="color: red">Out of Stock!</span>
					</h6>

				</c:when>
				<c:otherwise>

					<h6>Qty. Available: ${product.quantity}</h6>

				</c:otherwise>

			</c:choose>

			<hr />



			</a> <a href="${contextRoot}/product/show/all/active/product"
				class="btn btn-primary">Go Back<span
				class="glyphicon glyphicon-circle-arrow-left"></span></a> </a> <a href="#"
				class="btn btn-primary"><span
				class="glyphicon glyphicon-circle-arrow-left">Add to Cart</span></a>

		</div>

	</div>

</div>

</div>