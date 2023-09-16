<div class="col-lg-3">
	<h1 class="my-4">Online Shopping</h1>
	<div class="list-group">

		<c:forEach items="${categorylist}" var="category">

			<a href="${contextRoot}/product/show/category/${category.id}/product"
				class="list-group-item">${category.name} </a>
		</c:forEach>

	</div>

</div>