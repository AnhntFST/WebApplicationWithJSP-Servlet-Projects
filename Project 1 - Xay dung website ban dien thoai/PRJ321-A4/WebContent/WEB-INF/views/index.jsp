<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Header -->
<c:import url="header.jsp">
	<c:param name="title" value="Shopping Home" />
</c:import>
<!-- Body -->

<div class="container-fluid">
	<div class="row">
		<div class="col-md-9">
			<table class="table table-image">
				<tbody>
					<c:set var="widthTable" value="3"></c:set>
					<c:forEach var="product" items="${LIST_PRODUCTS}" varStatus="row">
							<c:if test="${row.index % widthTable == 0 }">
								<tr>
							</c:if>
							<td>
							<a href='<c:url value="products?action=DETAIL&productId=${product.productId}"></c:url>'>
							<img width="150px" hight="150px"; alt="${product.productName}" src="${product.productImgSource}" class="thumbnail img-responsive">
							</a>
								<p class="text-uppercase text-muted">${product.productType}</p>
								<p class="text-success">${product.productName}</p>
								<p class="text-danger">$${product.productPrice}</p>
							
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
			    <a href="${pageContext.request.servletContext.contextPath}/cart.jsp" class="btn btn-primary">Go to Cart</a>
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
				<a class="page-link" href="${pageContext.request.servletContext.contextPath}/products?action=page1">1
				</a>
				</li>
				<li class="page-item">
				<a class="page-link" href="${pageContext.request.servletContext.contextPath}/products?action=page2">2
				</a>
				</li>
		<li class="page-item"><a class="page-link" href="#">Next</a></li>
	</ul>
</nav>
<!-- footer -->
<c:import url="footer.jsp"></c:import>
