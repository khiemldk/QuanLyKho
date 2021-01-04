<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
					<form:form modelAttribute="thongKeForm"
						cssClass="form-horizontal form-label-left"
						servletRelativeAction="/history/thongke/save" method="POST">
						<form:hidden path="id" />
						<div class="item form-group">
							<label class="col-form-label col-md-3 col-sm-3 label-align"
								for="first-name">Action Name<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input path="action_name" cssClass="form-control " />
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-3 col-sm-3 label-align"
								for="last-name">Type<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input path="type" cssClass="form-control" />
							</div>
						</div>
<%-- 						<jsp:setProperty name="dateValue" property="time" value="${timestamp.time}" />  --%>
						<div class="item form-group">
							<label class="col-form-label col-md-3 col-sm-3 label-align"
								for="last-name">Date<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
<%-- 							<fmt:formatDate value="${history.update_date }" pattern="yyyy/MM/dd" var="myDate" /> --%>
							<input type="date" value="${date }" class="form-control" name="date" placeholder="YYYY-MM-DD" required="required" />
							<input type="date" value="${date1 }" class="form-control" name="date1" placeholder="YYYY-MM-DD" required="required" />
							
							</div>
						</div>

						<div class="ln_solid"></div>
						<div class="item form-group">
							<div class="col-md-6 col-sm-6 offset-md-3">
								<button class="btn btn-primary" type="button" onclick="cancel()">Cancel</button>
								<button class="btn btn-primary" type="reset">Reset</button>
								<button type="submit"  class="btn btn-success">Submit</button>
							</div>
						</div>

					</form:form>

					<div class="table-responsive">
						<table class="table table-striped jambo_table bulk_action">
							<thead>
								<tr class="headings">

									<th class="column-title">#</th>
									<th class="column-title">Action</th>
									<th class="column-title">Tình Trạng</th>
									<th class="column-title">Ngày</th>
									<th class="column-title">Số Lượng</th>
									
								</tr>
							</thead>

							<tbody>
								<c:forEach items="${listThongKe}" var="obj" varStatus="i">
									<c:set var="cssTr" value="odd pointer" />
									<c:if test="${i.index %2 ==0}">
										<c:set var="cssTr" value="even pointer" />
									</c:if>
									<tr class="${cssTr }">

										<td class=" ">${i.index+1 }</td>
										<td class=" ">${String.valueOf(obj[0]) }</td>
										<td class=" ">${String.valueOf(obj[1]) }</td>
										<td class=" ">${String.valueOf(obj[2])}</td>
										<td class=" ">${String.valueOf(obj[3])}</td>

									</tr>
								</c:forEach>
							</tbody>
						</table>
<!-- 						<ul class="pagination"> -->
<%-- 							<c:forEach begin="1" end="${pageInfo.totalPages}" --%>
<%-- 								varStatus="loop"> --%>
<%-- 								<c:choose> --%>
<%-- 									<c:when test="${pageInfo.currentPage== loop.index}"> --%>
<!-- 										<li class="active" style="border: 5px solid #1ABB9C;"><a -->
<%-- 											href="javascript:void(0);">${loop.index}</a></li> --%>
<%-- 									</c:when> --%>
<%-- 									<c:otherwise> --%>
<!-- 										<li style="border: 5px solid;"><a -->
<%-- 											href="<c:url value="/category/list/${loop.index}"/>">${loop.index}</a></li> --%>
<%-- 									</c:otherwise> --%>
<%-- 								</c:choose> --%>

<!-- 								<li></li> -->
<%-- 							</c:forEach> --%>
<!-- 						</ul> -->
					</div>


				</div>

			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	function confirmDelete(id) {
		if (confirm("Do u want to delete this record?")) {
			window.location.href = '<c:url value="/category/delete/"/>' + id
		}
	}
	function xuly(){
		$('#thongKeForm').attr('action','<c:url value="/product-info/list/"/>'+page);
		 $('#thongKeForm').submit();
		
	}
	function ham(){
		console.log(thongKeForm.update_date.value + " "+ thongKeForm.type.value)
	}
	
</script>