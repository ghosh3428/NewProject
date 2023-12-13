<%@include file="../../shared/header.jsp"%>

<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container">

	<div class="row">

		<div class="col-md-5">

			<h4>Select Shipping Address</h4>
			<hr />

			<c:forEach items="${addresses}" var="address">
				<div class="row">
					<div class="cols-xs-12">
						<h5>${address.addressLineOne}</h5>
						<h5>${address.addressLineTwo}</h5>
						<h5>${address.city} - ${address.postalCode}</h5>
						<h5>${address.state} -${address.country}</h5>
						<hr />
						<div class="text-center">
							<a href="${flowExecutionUrl}&_eventId_payment"
								class="btn btn-primary btn-sm">Select</a>
						</div>
					</div>
				</div>
			</c:forEach>

		</div>

		<div class="col-md-7">


			<div class="card card-success">

				<div class="card-heading text-center">
					<h4>Sign Up - Address</h4>
				</div>

				<div class="card-body">

					<form method="POST" class="form-horizontal" id="billingForm">


						<div class="form-group row">
							<label class="control-label col-md-4" for="addressLineOne">Address
								Line One</label>
							<div class="col-md-8">
								<input type="text" class="form-control"
									placeholder="Enter Address Line One" />

							</div>
						</div>

						<div class="form-group row">
							<label class="control-label col-md-4" for="addressLineTwo">Address
								Line Two</label>
							<div class="col-md-8">
								<input type="text" path="addressLineTwo" class="form-control"
									placeholder="Enter Address Line Two" />

							</div>
						</div>

						<div class="form-group row">
							<label class="control-label col-md-4" for="city">City</label>
							<div class="col-md-8">
								<input type="text" class="form-control"
									placeholder="Enter City Name" />

							</div>
						</div>

						<div class="form-group row">
							<label class="control-label col-md-4" for="postalCode">Postal
								Code</label>
							<div class="col-md-8">
								<input type="text" class="form-control" placeholder="XXXXXX" />

							</div>
						</div>

						<div class="form-group row">
							<label class="control-label col-md-4" for="state">State</label>
							<div class="col-md-8">
								<input type="text" class="form-control"
									placeholder="Enter State Name" />

							</div>
						</div>

						<div class="form-group row">
							<label class="control-label col-md-4" for="country">Country</label>
							<div class="col-md-8">
								<input type="text" class="form-control"
									placeholder="Enter Country Name" />

							</div>
						</div>


						<div class="form-group row">
							<div class="offset-md-4 col-md-8">
								<button type="submit" name="_eventId_payment"
									class="btn btn-primary btn-lg">
									<span class="glyphicon glyphicon-plus"></span> Add Address
								</button>
							</div>
						</div>


					</form>


				</div>


			</div>



		</div>


	</div>

</div>
<%@include file="../../shared/footer.jsp"%>