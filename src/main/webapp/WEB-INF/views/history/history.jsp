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
								<th class="column-title">Category</th>
								<th class="column-title">Product ID</th>
								<th class="column-title">Action Name</th>
								<th class="column-title">Qty</th>
								<th class="column-title">Price</th>

							</tr>
						</thead>

						<tbody>
							<c:forEach items="${listHistory}" var="history" varStatus="loop">

								<c:choose>
									<c:when test="${loop.index%2==0 }">
										<tr class="even pointer">
									</c:when>
									<c:otherwise>
										<tr class="odd pointer">
									</c:otherwise>
								</c:choose>
								<td class=" ">${pageInfo.getOffset()+loop.index+1 }</td>
								<td class=" ">${history.getId() }</td>
								<td class=" ">${history.getProduct().getCategory().getId() }</td>
								<td class=" ">${history.getProduct().getId() }</td>
								<td class=" ">${history.getAction_name() }</td>
								<td class=" ">${history.getQty() }</td>
								<td class=" ">${history.getPrice() }</td>
								

							</c:forEach>

						</tbody>
					</table>
					<ul class="pagination">
							<c:forEach begin="1" end="${pageInfo.totalPages}"
								varStatus="loop">
								<c:choose>
									<c:when test="${pageInfo.currentPage== loop.index}">
										<li class="active" style="border: 5px solid #1ABB9C;"><a href="javascript:void(0);">${loop.index}</a></li>
									</c:when>
									<c:otherwise>
										<li style="border: 5px solid;"><a
											href="<c:url value="/history/${loop.index}"/>">${loop.index}</a></li>
									</c:otherwise>
								</c:choose>

								<li></li>
							</c:forEach>
						</ul>
				</div>
				
			</div>
		</div>
	</div>
</div>


