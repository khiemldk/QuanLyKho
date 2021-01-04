<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<p>${titlePage}</p>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 ">
				<div class="x_panel">
					<div class="x_content">
						<br />
						<form:form modelAttribute="userForm"
							cssClass="form-horizontal form-label-left"
							servletRelativeAction="/user/list/save" method="POST">
							<form:hidden path="id"/>
<%-- 							<form:hidden path="user_roles.id"/> --%>
							<div class="item form-group">
								<label class="col-form-label col-md-3 col-sm-3 label-align"
									for="first-name">Full Name<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 ">
									<form:input path="name" cssClass="form-control " />
									
								</div>
							</div>
							<div class="item form-group">
								<label class="col-form-label col-md-3 col-sm-3 label-align"
									for="last-name">User Name<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 ">
									<form:input path="username" cssClass="form-control" />
									
								</div>
							</div>
							<div class="item form-group">
								<label for="middle-name"
									class="col-form-label col-md-3 col-sm-3 label-align">Password</label>
								<div class="col-md-6 col-sm-6 ">
									<form:password path="password" cssClass="form-control"  />
									
								</div>
							</div>
							<div class="item form-group">
								<label for="middle-name"
									class="col-form-label col-md-3 col-sm-3 label-align">Email</label>
								<div class="col-md-6 col-sm-6 ">
									<form:input path="email" cssClass="form-control" />
								</div>
							</div>
<!-- 							<div class="item form-group"> -->
<!-- 								<label for="middle-name" -->
<!-- 									class="col-form-label col-md-3 col-sm-3 label-align">Role</label> -->
<!-- 								<div class="col-md-6 col-sm-6 "> -->
<%-- 									<form:input path="user_roles" cssClass="form-control" /> --%>
<!-- 								</div> -->
<!-- 							</div> -->
							<c:if test="${checkInUp==false }">
								<div class="item form-group">
								<label class="col-form-label col-md-3 col-sm-3 label-align"
									for="last-name">Role<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 ">
									<form:select path="roleId" cssClass="form-control" >
										<form:options  items="${idRole}" />
									</form:select>

								</div>
							</div>
							</c:if>
							<div class="ln_solid"></div>
							<div class="item form-group">
								<div class="col-md-6 col-sm-6 offset-md-3">
									<button class="btn btn-primary" type="button"
										onclick="cancel()">Cancel</button>
										<button type="submit" class="btn btn-success">Submit</button>
									
								</div>
							</div>

						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(document).ready(
			function() {
				$('#categorylistId').addClass('current-page').siblings()
						.removeClass('current-page');
				var parent = $('#categorylistId').parents('li');
				parent.addClass('active').siblings().removeClass('active');
				$('#categorylistId').parents().show();
			});
	function cancel() {
		window.location.href = '<c:url value="/user/list"/>'
	}
</script>






