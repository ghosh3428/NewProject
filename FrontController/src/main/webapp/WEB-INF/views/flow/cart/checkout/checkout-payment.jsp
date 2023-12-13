<%@include file="../../shared/header.jsp"%>
<div class="container">

	<div class="row">
		<!--  To display all the goods -->
		<div class="col-md-6">


			<c:forEach items="checkoutModel.cartLines" var="cartLine">
				<div class="row">
					<div class="col-xs-12">

						<div>
							<h4>cartLine.product.name</h4>
							<h5>Quantity - cartLine.productCount</h5>
							<h5>Buying Price - &#8377; cartLine.buyingPrice/-</h5>
						</div>
						<hr />
						<div class="text-right">
							<h5>Total - &#8377; cartLine.total/-</h5>
							</hr>
						</div>
						<hr />
					</div>

				</div>
			</c:forEach>
			<div class="text-right">
				<h4 class="fw-bold">Grand Total - &#8377;
					checkoutModel.cart.grandTotal/-</h4>
				</hr>
			</div>


		</div>

		<div class="offset-md-1 col-md-5">
			<div class="card ">
				<div class="card-heading text-center">
					<h3>Payment Details</h3>
				</div>
				<div class="card-body">
					<form role="form">
						<div class="form-group">
							<label for="cardNumber"> CARD NUMBER</label>
							<div class="input-group">
								<input type="text" class="form-control" id="cardNumber"
									placeholder="Valid Card Number" required autofocus /> <span
									class="input-group-addon"><span
									class="glyphicon glyphicon-lock"></span></span>
							</div>
						</div>
						<div class="row">
							<div class="col-md-7">
								<div class="form-group">
									<label for="expityMonth" class="row">EXPIRY DATE</label>
									<div class="input-group">
										<div class="col-lg-6 ">
											<input type="text" class="form-control" id="expityMonth"
												placeholder="MM" required />
										</div>
										<div class="col-lg-6">
											<input type="text" class="form-control" id="expityYear"
												placeholder="YY" required />
										</div>
									</div>
								</div>
							</div>
							<div class=" col-md-5 ">
								<div class="form-group">
									<label for="cvCode"> CV CODE</label> <input type="password"
										class="form-control" id="cvCode" placeholder="CV" required />
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
			<ul class="nav nav-pills nav-stacked">
				<li class="active"><a href="#"><span
						class="badge pull-right"> &#8377;
							checkoutModel.checkoutTotal/-</span> Final Payment</a></li>
			</ul>
			<br /> <a href="${flowExecutionUrl}&_eventId_pay"
				class="btn btn-success btn-lg btn-block" role="button">Pay</a>
		</div>
	</div>
</div>

<%@include file="../../shared/footer.jsp"%>