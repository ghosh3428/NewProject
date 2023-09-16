<%@include file="../shared/header.jsp"%>
<div class="container">

	<div class="row">

		<div class="col-md-6">

			<div class="card">

				<div class="card-heading bg-dark">
					<h2 class="text-light text-center">Personal Details</h2>
				</div>

				<div class="card-body">
					<table class="table">
						<tbody>
							<tr>
								<th>Name</th>
								<td>${registerModel.user.firstName}
									${registerModel.user.lastName}</td>
							</tr>
							<tr>
								<th>Email</th>
								<td>${registerModel.user.email}</td>
							</tr>
							<tr>
								<th>Contact</th>
								<td>${registerModel.user.contactNumber}</td>
							</tr>
							<tr>
								<th>Role</th>
								<td>${registerModel.user.role}</td>
							</tr>
						</tbody>
					</table>
					<p>
						<a href="${flowExecutionUrl}&_eventId_personal"
							class="btn btn-warning">Edit</a>
					</p>
				</div>


			</div>

		</div>



		<div class="col-md-6">

			<div class="card">

				<div class="card-heading bg-dark">
					<h2 class="text-light text-center">Billing Details</h2>
				</div>

				<div class="card-body">

					<table class="table">
						<tbody>
							<tr>
								<th>Address</th>
								<td>${registerModel.billing.addressLineOne},
									${registerModel.billing.addressLineTwo}</td>
							</tr>
							<tr>
								<th>City</th>
								<td>${registerModel.billing.city}-
									${registerModel.billing.postalCode}</td>
							</tr>
							<tr>
								<th>State</th>
								<td>${registerModel.billing.state}</td>
							</tr>
							<tr>
								<th>Country</th>
								<td>${registerModel.billing.country}</td>
							</tr>
						</tbody>
					</table>
					<p>
						<a href="${flowExecutionUrl}&_eventId_billing"
							class="btn btn-warning">Edit</a>
					</p>

				</div>

			</div>

		</div>
	</div>
	<br/>
	<div class="row">

		<div class="offset-md-5 col-md-2">

			<div class="text-center">

				<a href="${flowExecutionUrl}&_eventId_success"
					class="btn btn-success">Confirm</a>

			</div>

		</div>

	</div>

</div>
<%@include file="../shared/footer.jsp"%>