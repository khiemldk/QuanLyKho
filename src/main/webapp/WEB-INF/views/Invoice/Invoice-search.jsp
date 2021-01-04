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

						<form:form modelAttribute="SearchForm"
							cssClass="form-horizontal form-label-left"
							servletRelativeAction="/goods-recept/list/search" method="POST">
							
							<div class="item form-group">
								<label class="col-form-label col-md-3 col-sm-3 label-align"
									for="last-name">Code<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 ">
									<form:input path="code" cssClass="form-control" />
								</div>
							</div>
							<div class="item form-group">
								<label class="col-form-label col-md-3 col-sm-3 label-align"
									for="last-name">type<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 ">
									<form:input path="type" cssClass="form-control" />

								</div>
							</div>
							<div class="item form-group">
								<label class="col-form-label col-md-3 col-sm-3 label-align"
									for="last-name">Product ID<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 ">
									<form:select path="product.id" cssClass="form-control">
										<form:options  items="${idList}"/>
									</form:select>

								</div>
							</div>
							
							

							<div class="ln_solid"></div>
							<div class="item form-group">
								<div class="col-md-6 col-sm-6 offset-md-3">
									<button class="btn btn-primary" type="button"
										onclick="cancel()">Cancel</button>
									<button type="submit" class="btn btn-success">Search</button>

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
	$(document).ready(function(){
		
	});
	function cancel() {
		window.location.href = '<c:url value="/invoice/list"/>';
	}
</script>






