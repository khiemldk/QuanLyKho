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
						<form:form modelAttribute="changePasswordForm"
							cssClass="form-horizontal form-label-left"
							servletRelativeAction="/user/list/savePass" method="POST">
							<form:hidden path="id"/>
							<form:hidden path="password"/>
							<form:hidden path="username"/>
							<form:hidden path="name"/>
							<form:hidden path="email"/>
<%-- 							<form:hidden path="user_roles"/> --%>
<%-- 							<form:hidden path="user_roles"/> --%>
							<div class="item form-group">
								<label class="col-form-label col-md-3 col-sm-3 label-align"
									for="first-name">Old Password<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 ">
									<input type="password" name="oldPass" required="required" class="form-control " />
									
								</div>
							</div>
							<div class="item form-group">
								<label class="col-form-label col-md-3 col-sm-3 label-align"
									for="last-name">New Password<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 ">
									<input type="password" name="newPassword" required="required" class="form-control" />
									
								</div>
							</div>
							<div class="item form-group">
								<label for="middle-name"
									class="col-form-label col-md-3 col-sm-3 label-align">Again Password</label>
								<div class="col-md-6 col-sm-6 ">
									<input type="password" name="newPasswordAgain" class="form-control" required="required" />
									
								</div>
							</div>
							<div class="item form-group">
								<label for="middle-name"
									class="col-form-label col-md-3 col-sm-3 label-align"></label>
								<div class="col-md-6 col-sm-6 ">
									<p>${Notification }</p>
								</div>
							</div>
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






