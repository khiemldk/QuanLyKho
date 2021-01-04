<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<div class="dataTables_paginate paging_simple_numbers"
							id="datatable_paginate">
							<ul class="pagination">
								<li class="paginate_button previous disabled"
									id="datatable_previous"><a href="<c:url value="/category/list/${crpage-1}"/>"
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
												href="<c:url value="/category/list/${loop.index}"/>">${loop.index}</a></li>
										</c:otherwise>
									</c:choose>

									<li></li>
								</c:forEach>
								<li class="paginate_button next" id="datatable_next"><a
									href="<c:url value="/category/list/${crpage+1}"/>" aria-controls="datatable" data-dt-idx="7" tabindex="0">Next</a></li>
							</ul>
						</div>