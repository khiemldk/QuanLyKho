<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left"></div>
		</div>
		<div class="clearfix"></div>
		<div class="col-md-12 col-sm-12  ">
			<div class="x_panel">
				<div class="x_title">
					<h2>Table Category</h2>

					<div class="clearfix"></div>
				</div>

				<div class="x_content">


					<div class="table-responsive">
						<table class="table table-striped jambo_table bulk_action">
							<thead>
								<tr class="headings">

									<th class="column-title">#</th>
									<th class="column-title">ID</th>
									<th class="column-title">User name</th>
									<th class="column-title">Email</th>
									<th class="column-title">Full Name</th>
									<th class="column-title no-link last text-center" colspan="3"><span
										class="nobr">Action</span></th>

								</tr>
							</thead>

							<tbody>
								<c:forEach items="${listUser}" var="list" varStatus="i">
									<c:set var="cssTr" value="odd pointer" />
									<c:if test="${i.index %2 ==0}">
										<c:set var="cssTr" value="even pointer" />
									</c:if>
									<tr class="${cssTr }">

										<td class=" ">${pageInfo.getOffset()+i.index+1 }</td>
										<td class=" ">${list.getId() }</td>
										<td class=" ">${list.getUsername() }</td>
										<td class=" ">${list.getEmail()}</td>
										<td class=" ">${list.getName()}</td>
										
										<td class="text-center"><a
											href='<c:url value="/user/list/edit/${list.getId() }"/>'
											class="btn btn-round btn-primary">Edit</a></td>
										<td class="text-center"><a href="javascript:void(0);"
											onclick="confirmDelete(${list.getId()});"
											class="btn btn-round btn-danger">Delete</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div class="dataTables_paginate paging_simple_numbers"
							id="datatable_paginate">
							<ul class="pagination">
								<li class="paginate_button previous disabled"
									id="datatable_previous"><a href="<c:url value="/user/list/${crpage-1}"/>"
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
												href="<c:url value="/user/list/${loop.index}"/>">${loop.index}</a></li>
										</c:otherwise>
									</c:choose>

									<li></li>
								</c:forEach>
								<li class="paginate_button next" id="datatable_next"><a
									href="<c:url value="/user/list/${crpage+1}"/>" aria-controls="datatable" data-dt-idx="7" tabindex="0">Next</a></li>
							</ul>
					
					</div>


				</div>
				<div class="container">
					<a class="btn btn-app" href='<c:url value="/user/list/add"/>'> <i
						class="fa fa-plus"></i> Add New User
					</a>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
function confirmDelete(id){
	if (confirm("Do u want to delete this record?")) {
		window.location.href= '<c:url value="/user/list/delete/"/>'+id
	}
}

</script>