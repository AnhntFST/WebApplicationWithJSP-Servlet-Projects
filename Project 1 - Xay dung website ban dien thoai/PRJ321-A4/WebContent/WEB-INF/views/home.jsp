<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Header -->
<c:import url="header.jsp">
	<c:param name="title" value="Shopping Home" />
</c:import>
<!-- Body -->

<div class="container-fluid">
	<div class="row">
		<div class="col-md-9">
		<!-- Create table to show product by JSTL -->
			<table class="table table-image">
				<tbody>
					<c:set var="widthTable" value="3"></c:set>
					<c:forEach var="product" items="${listProducts}" varStatus="row">
							<c:if test="${row.index % widthTable == 0 }">
								<tr>
							</c:if>
							<td>
							<a href='<c:url value="products?action=DETAIL&productId=${product.id}"></c:url>'>
							<img width="200px" hight="200px" alt="${product.name}" src="${product.img_source}" class="thumbnail img-responsive">
							</a>
								<p class="text-uppercase text-muted pl-5"><c:out value="${product.type}"></c:out></p>
								<p class="text-success  pl-5"><c:out value="${product.name}"></c:out></p>
								<p class="text-danger  pl-5">$<c:out value="${product.price}"></c:out></p>
							
							</td>
							<c:if test="${(row.index + 1) % widthTable == 0 }">
								</tr>
							</c:if>
							
					</c:forEach>
				</tbody>
			</table>
		</div>
		
	<div class="col-md-3">
			<div class="card mr-0">
			  <div class="card-header" >
			    Cart
			  </div>
			  <div class="card-body">
			    <h5 class="card-title">Number of product in Cart</h5>
			    <p class="card-text"><c:out value="${total}"/></p>
			    <a href="#" class="btn btn-primary">Go to Cart</a>
			  </div>
			</div>
		</div>
	
	</div>
</div>

<!-- Number of page -->
<nav aria-label="Page navigation example">
	<ul class="pagination justify-content-center">
		<li class="page-item"><a class="page-link">Previous</a></li>
				<li class="page-item">
				<a class="page-link" href="#">1
				</a>
				</li>
				<li class="page-item">
				<a class="page-link" href="#">2
				</a>
				</li>
		<li class="page-item"><a class="page-link" href="#">Next</a></li>
	</ul>
</nav>
<!-- footer -->
<c:import url="footer.jsp"></c:import>
