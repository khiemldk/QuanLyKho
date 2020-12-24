<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="right_col" role="main">
	<div class="">

		<div class="clearfix"></div>
		<div class="col-md-12 col-sm-12 col-xs-12">
			<div class="x_panel">
				<div class="x_title">
					<h2>Product Info List</h2>

					<div class="clearfix"></div>
				</div>


			
					<div class="table-responsive">
						<table class="table table-striped jambo_table bulk_action">
							<thead>
								<tr class="headings">
									<th class="column-title">#</th>
									<th class="column-title">Id</th>
									<th class="column-title">Code</th>
									<th class="column-title">Name</th>
									<th class="column-title">Image</th>
								</tr>
							</thead>

							<tbody>
								<c:forEach items="${listProduct}" var="product" varStatus="loop">

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
									<td class=" ">${product.getCode() }</td>
									<td class=" ">${product.getName() }</td>
									<td class=" "><img src="<c:url value="${product.getImg_url()}"/>" width="100px" height="100px"/></td>
									</tr>
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
											href="<c:url value="/product-info/list/${loop.index}"/>">${loop.index}</a></li>
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
</div>
