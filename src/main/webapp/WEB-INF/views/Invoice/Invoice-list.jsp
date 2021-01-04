<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="right_col" role="main">
	<div class="">

		<div class="clearfix"></div>
		<div class="col-md-12 col-sm-12 col-xs-12">
			<div class="x_panel">
				<div class="x_title">
					<h2>Product In Stock List</h2>

					<div class="clearfix"></div>
				</div>



				<div class="table-responsive">
					<table class="table table-striped jambo_table bulk_action">
						<thead>
							<tr class="headings">
								<th class="column-title">#</th>
								<th class="column-title">ID</th>
								<th class="column-title">Product ID</th>
								<th class="column-title">Code</th>
								<th class="column-title">Type</th>
								<th class="column-title">Image</th>
								<th class="column-title">Qty</th>
								<th class="column-title">Price</th>
								<th class="column-title no-link last text-center" colspan="2"><span
									class="nobr">Action</span></th>

							</tr>
						</thead>

						<tbody>
							<c:forEach items="${listInvoice}" var="product" varStatus="loop">

								<c:choose>
									<c:when test="${loop.index%2==0 }">
										<tr class="even pointer">
									</c:when>
									<c:otherwise>
										<tr class="odd pointer">
									</c:otherwise>
								</c:choose>
								<td class=" ">${pageInfo.getOffset()+loop.index+1 }</td>
								<td class=" ">${product.getId() }</td>
								<td class=" ">${product.getProduct().getId() }</td>
								<td class=" ">${product.getCode() }</td>
								<td class=" ">${product.getType() }</td>
								<td class=" "><img
									src="<c:url value="${product.getProduct().getImg_url()}"/>"
									width="100px" height="100px" /></td>
								<td class=" ">${product.getQty() }</td>
								<td class=" ">${product.getPrice() }</td>
		
								<td class="text-center"><a
									href='<c:url value="/goods-recept/list/edit/${product.getId() }"/>'
									class="btn btn-round btn-primary">Update</a></td>
								<td class="text-center"><a href="javascript:void(0);"
									onclick="confirmDelete(${product.getId()});"
									class="btn btn-round btn-danger">Delete</a></td>
							
							</c:forEach>
							
						</tbody>
					</table>
					<div class="dataTables_paginate paging_simple_numbers"
							id="datatable_paginate">
							<ul class="pagination">
								<li class="paginate_button previous disabled"
									id="datatable_previous"><a href="<c:url value="/goods-recept/list/${crpage-1}"/>"
									aria-controls="datatable" data-dt-idx="0" tabindex="0">Previous</a></li>
								<c:forEach begin="1" end="${pageInfo.totalPages}"
									varStatus="loop">
									<c:choose>
										<c:when test="${pageInfo.currentPage== loop.index}">
											<li class="paginate_button active"><a
												href="javascript:void(0);">${loop.index}</a></li>
										</c:when>
										<c:otherwise>
											<li class="paginate_button "><a
												href="<c:url value="/goods-recept/list/${loop.index}"/>">${loop.index}</a></li>
										</c:otherwise>
									</c:choose>

									<li></li>
								</c:forEach>
								<li class="paginate_button next" id="datatable_next"><a
									href="<c:url value="/goods-recept/list/${crpage+1}"/>" aria-controls="datatable" data-dt-idx="7" tabindex="0">Next</a></li>
							</ul>
						</div>
				</div>
				<div class="container" >
                    <a class="btn btn-app" href='<c:url value="/goods-recept/list/FormSearch"/>'>
                    <i class="fa fa-plus"></i>Search Invoice
                  </a>
                  
                  <a class="btn btn-app" href='<c:url value="/goods-issue/list/export/${type}"/>'>
                    <i class="fa fa-file-excel-o"></i>Export File
                  </a>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
function confirmDelete(id){
	if (confirm("Do u want to delete this record?")) {
		window.location.href= '<c:url value="/goods-recept/list/delete/"/>'+id
	}
}
</script>
