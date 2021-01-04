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
						<form:form modelAttribute="menuForm"
							cssClass="form-horizontal form-label-left"
							servletRelativeAction="/menu/list/save" method="POST">
							<form:hidden path="id"/>
							<div class="item form-group">
								<label class="col-form-label col-md-3 col-sm-3 label-align"
									for="last-name">Role<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 ">
									<form:select path="roles.id" cssClass="form-control" >
										<form:options  items="${idRole}" />
									</form:select>

								</div>
							</div>
							<div class="item form-group">
								<label class="col-form-label col-md-3 col-sm-3 label-align"
									for="last-name">Menu<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 ">
									<form:select path="menu.id" cssClass="form-control" >
										<form:options  items="${idMenu}" />
									</form:select>
								</div>
							</div>
							<div class="item form-group">
								<label class="col-form-label col-md-3 col-sm-3 label-align" for="code">
									Permission
									<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6">
									
									<form:radiobutton path="permision" value="1" />
									Yes
									<form:radiobutton path="permision" value="0" />
									No
								</div>
							</div>
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
		window.location.href = '<c:url value="/menu/list"/>'
	}
</script>






