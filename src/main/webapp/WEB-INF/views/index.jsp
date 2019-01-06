
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Learning English</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmd" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page session="true"%>
<script type="text/javascript" src="${root}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${root}/js/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="${root}/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="${root}/css/bootstrap.min.css">
<%-- <link rel="stylesheet" type="text/css" href="${root}/css/animate.min.css"> --%>
<link rel="stylesheet" type="text/css" href="${root}/css/style.css">
</head>
<body style="font-family: Helvetica,Arial,sans-serif;">
	<div class="container" style="margin-top: 20px;">
		<div class="row">
			<div id="user" class="col-md-12">
				<div class="panel panel-primary panel-table animated slideInDown">
					<div class="panel-heading " style="padding: 5px;">
						<c:if test="${not empty chapter}">							
							<c:forEach var="c" items="${chapter}">						
								<div class="row">
									<div class="col col-xs-4 text-left"></div>
									<div class="col col-xs-4 text-center">
										<a href="${root}/unit/${c.id}" class="btn btn-default" aria-controls="list" role="tab" data-toggle="tab" style="text-transform: capitalize;"> 
											${c.name}&nbsp;
											<c:if test="${not empty c.subtotal}">
												(${c.subtotal}/${c.total})
											</c:if>
											<c:if test="${empty c.subtotal}">
												(0/${c.total})
											</c:if>
										</a>
									</div>
									<div class="col col-xs-4 text-left"></div>
								</div>	<br>															
							</c:forEach>
						</c:if>
						<c:if test="${not empty unit}">							
							<c:forEach var="c" items="${unit}" varStatus="itr">						
								<div class="row">
									<div class="col col-xs-4 text-left">
										<a href="${root}/index" class="btn btn-default" aria-controls="list" role="tab" data-toggle="tab" style="text-transform: capitalize;"> 
											Home
										</a>
									</div>
									<div class="col col-xs-4 text-left">
										<a href="${root}/leason/${c.id}" class="btn btn-default" aria-controls="list" role="tab" data-toggle="tab" style="text-transform: capitalize;"> 
											Unit&nbsp;${itr.index+1}&nbsp;${c.name}
										</a>
									</div>
									<div class="col col-xs-4 text-left"></div>
								</div>	<br>															
							</c:forEach>
						</c:if>
						<c:if test="${not empty state}">											
							<div class="row">
								<div class="col col-xs-4 text-left">
									<a href="${root}/leason/${state}/1" class="btn btn-default" aria-controls="list" role="tab" data-toggle="tab" style="text-transform: capitalize;"> 
										Know
									</a>
								</div>
								<div class="col col-xs-4 text-left">
									<a href="${root}/leason/${state}" class="btn btn-default" aria-controls="list" role="tab" data-toggle="tab" style="text-transform: capitalize;"> 
										All
									</a>
								</div>
								<div class="col col-xs-4 text-left">
									<a href="${root}/leason/${state}/0" class="btn btn-default" aria-controls="list" role="tab" data-toggle="tab" style="text-transform: capitalize;"> 
										Remind
									</a>
									<a href="${root}/index" class="btn btn-default" aria-controls="list" role="tab" data-toggle="tab" style="text-transform: capitalize;float: right;"> 
										Back
									</a>
								</div>
							</div>	
						</c:if>
					</div>
					<div class="panel-body">
						<div class="tab-content">
							<div role="tabpanel" class="tab-pane active" id="list">
								<c:if test="${not empty leason}">
									<table class="table table-striped table-bordered table-list" id="myTable">
										<thead>
											<tr>
												<th>STT</th>
												<th>English</th>
												<th>Vietnamese</th>												
											</tr>
										</thead>
										<tbody style="cursor:pointer;">										
											<c:forEach var="c" items="${leason}" varStatus="itr">
												<tr>
													<td>${itr.index+1}</td>
													<td onclick='handleClick(${c.id});' >														
														${c.name}																											
													</td>													
													<td>${c.vietnamese}</td>
												</tr>
											</c:forEach>										
										</tbody>
									</table>
								</c:if>
							</div>
							<!-- END id="list" -->
						</div>
						<!-- END tab-content -->
					</div>

				</div>
				<!--END panel-table-->
			</div>
		</div>
	</div>
</body>
<script>

function handleClick(id) {
	$.post('handleClick', {'id': id}, function (data) {
		location.reload();               
     }); 
  
}
</script>
</html>