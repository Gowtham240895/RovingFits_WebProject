<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cr2" value="${pageContext.request.contextPath}" />
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<style>
.table>tbody>tr>td, .table>tfoot>tr>td {
	vertical-align: middle;
}

@media screen and (max-width: 600px) {
	table#cart tbody td .form-control {
		width: 20%;
		display: inline !important;
	}
	.actions .btn {
		width: 36%;
		margin: 1.5em 0;
	}
	.actions .btn-info {
		float: left;
	}
	.actions .btn-danger {
		float: right;
	}
	table#cart thead {
		display: none;
		text-align: center;
		margin: 5%;
	}
	table#cart tbody td {
		display: block;
		padding: .6rem;
		min-width: 320px;
	}
	table#cart tbody tr td:first-child {
		background: #333;
		color: #fff;
	}
	table#cart tbody td:before {
		content: attr(data-th);
		font-weight: bold;
		display: inline-block;
		width: 4rem;
	}
	table#cart tfoot td {
		display: block;
	}
	table#cart tfoot td .btn {
		display: block;
	}
}
</style>
<div class="container" style="margin-top: 5%">

	<table id="cart" class="table table-hover table-condensed">
		<thead>
			<tr>
				<div class="row">
					<c:forEach items="${orderlist}" begin="0" end="0" var="o">
						<div class="col-8">
							<h5>order Id :${o.order_Id}</h5>
							<h5>order Date :${o.order_Date}</h5>

						</div>
						<div class="col-4">
							<div class="col-12">
								<h3 class="card-title" data-toggle="tooltip"
									title="${o.address.name}">${o.address.name}</h3>

							</div>
							<div class="col-12">
								<p class="card-text">
									<span class="mytext"> ${o.address.line1}</span>
								</p>
							</div>
							<div class="col-12">
								<p class="card-text">
									<span class="mytext"> ${o.address.line2}</span>
								</p>
							</div>

							<div class="col-12">
								<p class="card-text">
									<span class="mytext"> ${o.address.area}</span>
								</p>
							</div>

							<div class="col-12">
								<p class="card-text">
									<span class="mytext"> ${o.address.pincode}</span>
								</p>
							</div>

						</div>
					</c:forEach>
				</div>
			</tr>
		</thead>
		<tbody>
			<c:set var="Total" value="0" />
			<c:forEach items="${cartinfo}" var="p">
				<c:set var="subtotal"
					value="${p.pro_Quantity*p.prodDetails.pro_Price}"></c:set>


				<tr>

					<td data-th="Product">
						<div class="row">
							<div class="col-4">
								<img src="${cr2 }/pimg/${p.prodDetails.pro_Id}.jpeg" alt="..."
									class="img-responsive" height="100%" />
							</div>
							<div class="col-8">
								<h3 class="nomargin" style="padding-top: 50px;">${p.prodDetails.pro_Name}</h3>
								<div>
									<a href="${cr2}/user/deleteitem?cartid=${p.cart_Id}"
										class="btn btn-danger"><i class="fa fa-trash"></i>Remove</a>
								</div>
								<c:if test="${error && PID==p.prodDetails.pro_Id}">
									<div style="margin-top: 2%" class="alert alert-warning">
										<strong>${message}</strong>
									</div>
								</c:if>
							</div>
						</div>
					</td>
					<td data-th="Price">${p.prodDetails.pro_Price}</td>
					<td data-th="Quantity">
						<div>
							<form action="${cr2 }/addtocart" method="post">

								<input type="number" class="form-control" id="quantity"
									name="quantity" value="${p.pro_Quantity}"> <input
									type="hidden" value="${p.prodDetails.pro_Id }" id="productid"
									name="productid"> <input type="hidden" value="true"
									id="cartpage" name="cartpage">


								<button type="submit" class="btn btn-primary">
									<i class="fa fa-plus"></i>
								</button>

							</form>
						</div>
					</td>
					<td data-th="Total" class="text-center" colspan="1"><lable>${p.prodDetails.pro_Price}</lable>
					</td>
				</tr>


			</c:forEach>

		</tbody>
		<tfoot>
			<tr>
				<td>Subtotal</td>
				<td />
				<td />
				<td data-th="Total" class="text-center" colspan="1">${total }</td>

			</tr>
			<tr>
				<td>Shipping</td>
				<td />
				<td />
				<td data-th="Total" class="text-center" colspan="1"><c:if
						test="${total<1000 }">
						<c:set var="shipping" value="0"></c:set>
			               FREE
					</c:if> <c:if test="${total>=1000 }">
						<c:set var="shipping" value="100"></c:set>
			               ${shipping}
					</c:if></td>

			</tr>
			<tr>
				<td>Total</td>
				<td />
				<td />
				<td data-th="Total" class="text-center" colspan="1">${total+shipping}</td>

			</tr>

			<tr>
				<td><a href="${contextroot }/allproducts"
					class="btn btn-warning"><i class="fa fa-angle-left"></i>
						Continue Shopping</a></td>
				<td colspan="2" class="hidden-xs"></td>
				<td />
				<td />


				<td><a href="${cr2}/user/selectaddress"
					class="btn btn-success btn-block">Checkout <i
						class="fa fa-angle-right"></i>
				</a></td>
			</tr>
		</tfoot>
	</table>

</div><%@ page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cr2" value="${pageContext.request.contextPath}" />
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<style>
.table>tbody>tr>td, .table>tfoot>tr>td {
	vertical-align: middle;
}

@media screen and (max-width: 600px) {
	table#cart tbody td .form-control {
		width: 20%;
		display: inline !important;
	}
	.actions .btn {
		width: 36%;
		margin: 1.5em 0;
	}
	.actions .btn-info {
		float: left;
	}
	.actions .btn-danger {
		float: right;
	}
	table#cart thead {
		display: none;
		text-align: center;
		margin: 5%;
	}
	table#cart tbody td {
		display: block;
		padding: .6rem;
		min-width: 320px;
	}
	table#cart tbody tr td:first-child {
		background: #333;
		color: #fff;
	}
	table#cart tbody td:before {
		content: attr(data-th);
		font-weight: bold;
		display: inline-block;
		width: 4rem;
	}
	table#cart tfoot td {
		display: block;
	}
	table#cart tfoot td .btn {
		display: block;
	}
}
</style>
<div class="container" style="margin-top: 5%">

	<table id="cart" class="table table-hover table-condensed">
		<thead>
			<tr>
				<div class="row">
					<c:forEach items="${orderlist}" begin="0" end="0" var="o">
						<div class="col-8">
							<h5>order Id :${o.order_Id}</h5>
							<h5>order Date :${o.order_Date}</h5>

						</div>
						<div class="col-4">
							<div class="col-12">
								<h3 class="card-title" data-toggle="tooltip"
									title="${o.address.name}">${o.address.name}</h3>

							</div>
							<div class="col-12">
								<p class="card-text">
									<span class="mytext"> ${o.address.line1}</span>
								</p>
							</div>
							<div class="col-12">
								<p class="card-text">
									<span class="mytext"> ${o.address.line2}</span>
								</p>
							</div>

							<div class="col-12">
								<p class="card-text">
									<span class="mytext"> ${o.address.area}</span>
								</p>
							</div>

							<div class="col-12">
								<p class="card-text">
									<span class="mytext"> ${o.address.pincode}</span>
								</p>
							</div>

						</div>
					</c:forEach>
				</div>
			</tr>
		</thead>
		<tbody>
			<c:set var="Total" value="0" />
			<c:forEach items="${cartinfo}" var="p">
				<c:set var="subtotal"
					value="${p.pro_Quantity*p.prodDetails.pro_Price}"></c:set>


				<tr>

					<td data-th="Product">
						<div class="row">
							<div class="col-4">
								<img src="${cr2 }/pimg/${p.prodDetails.pro_Id}.jpeg" alt="..."
									class="img-responsive" height="100%" />
							</div>
							<div class="col-8">
								<h3 class="nomargin" style="padding-top: 50px;">${p.prodDetails.pro_Name}</h3>
								<div>
									<a href="${cr2}/user/deleteitem?cartid=${p.cart_Id}"
										class="btn btn-danger"><i class="fa fa-trash"></i>Remove</a>
								</div>
								<c:if test="${error && PID==p.prodDetails.pro_Id}">
									<div style="margin-top: 2%" class="alert alert-warning">
										<strong>${message}</strong>
									</div>
								</c:if>
							</div>
						</div>
					</td>
					<td data-th="Price">${p.prodDetails.pro_Price}</td>
					<td data-th="Quantity">
						<div>
							<form action="${cr2 }/addtocart" method="post">

								<input type="number" class="form-control" id="quantity"
									name="quantity" value="${p.pro_Quantity}"> <input
									type="hidden" value="${p.prodDetails.pro_Id }" id="productid"
									name="productid"> <input type="hidden" value="true"
									id="cartpage" name="cartpage">


								<button type="submit" class="btn btn-primary">
									<i class="fa fa-plus"></i>
								</button>

							</form>
						</div>
					</td>
					<td data-th="Total" class="text-center" colspan="1"><lable>${p.prodDetails.pro_Price}</lable>
					</td>
				</tr>


			</c:forEach>

		</tbody>
		<tfoot>
			<tr>
				<td>Subtotal</td>
				<td />
				<td />
				<td data-th="Total" class="text-center" colspan="1">${total }</td>

			</tr>
			<tr>
				<td>Shipping</td>
				<td />
				<td />
				<td data-th="Total" class="text-center" colspan="1"><c:if
						test="${total<1000 }">
						<c:set var="shipping" value="0"></c:set>
			               FREE
					</c:if> <c:if test="${total>=1000 }">
						<c:set var="shipping" value="100"></c:set>
			               ${shipping}
					</c:if></td>

			</tr>
			<tr>
				<td>Total</td>
				<td />
				<td />
				<td data-th="Total" class="text-center" colspan="1">${total+shipping}</td>

			</tr>

			<tr>
				<td><a href="${contextroot }/allproducts"
					class="btn btn-warning"><i class="fa fa-angle-left"></i>
						Continue Shopping</a></td>
				<td colspan="2" class="hidden-xs"></td>
				<td />
				<td />


				<td><a href="${cr2}/user/selectaddress"
					class="btn btn-success btn-block">Checkout <i
						class="fa fa-angle-right"></i>
				</a></td>
			</tr>
		</tfoot>
	</table>

</div>