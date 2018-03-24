<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form name="" action="" method="post">
	<c:forEach var="p" items="${list}" varStatus="i">
		<fieldset>
		<form name="" action="Updateprog" method="post">   
			<legend class="text-danger">Session ${i.count}</legend>
			
			<input type="hidden" name="pid" value="${p.pid }" />                                          
				<table class="table alert alert-danger">
					<tr>   
						<td>Time:</td>
						<td><input type="text" name="time" value="${p.time }"
							class="form-control" /></td>
					</tr>
					<td>Heading:</td>
					<td><input type="text" name="heading" value="${p.heading }"
						class="form-control" /></td>
					</tr>
					<tr>
						<td colspan="2"><c:forEach var="e" items="${listsp}"
								varStatus="status1">
								<c:if test="${p.pid == e.pid}">
									<div class="col-lg-6 col-md-6">
										<fieldset>
											<legend class="text-primary">Speaker:
												${status1.count}</legend>
											<table class="table alert alert-primary">

												<tr>
													<td>Name:</td>
													<td><input type="text" name="name" value="${e.name }"
														class="form-control" /></td>
												</tr>
												<tr>
													<td>Designation:</td>
													<td><input type="text" name="designation"
														value="${e.designation }" class="form-control" /></td>
												</tr>

												<tr>
													<td>Image:</td>
													<td><input type="
								text
						" name="images"
														value="${e.image }" class="form-control" /></td>
												</tr>
											</table>
										</fieldset>
									</div>
								</c:if>
							</c:forEach></td>
					</tr>
					<tr>
					<td><input type="submit" value="Update" />    </td>
					</tr>
				</table>
				
			
			</form>
		</fieldset>
	</c:forEach>

</form>