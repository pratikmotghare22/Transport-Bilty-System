
<%@page import="dao.VehicleDao,bean.VehicleBean,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="main">
	<h3>TransportBillingSystem</h3>
</div>
<div class="row">
	<div class="column">
		<img src="RESOURCE/IMG/logo.png">
	</div>

	<div class="column">

		<br>
		<hr>

		<h2>View Vehicle Details</h2>

		<%
			List<VehicleBean> list = VehicleDao.view();
		request.setAttribute("list", list);
		%>


		<table id="view">
			<tr>
				<th>Type</th>
				<th>Name</th>
				<th>Number</th>
				<th>Owner</th>
				<th>Insurance</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${list}" var="bean">
				<tr>
					<td>${bean.getVehicleType()}</td>
					<td>${bean.getVehicleName()}</td>
					<td>${bean.getVehicleNumber()}</td>
					<td>${bean.getOwnerName()}</td>
					<td>${bean.getInsurance()}</td>
					<td><a href='EditVehicle?vehicleid=${bean.getVehicleId()}'><i
							class='fas fa-edit' style='color: #567DAF'></i></a></td>
					<td><a
						href='DeleteVehicle?vehicleno=${bean.getVehicleNumber()}'
						onclick="return confirmation()"><i class='fas fa-trash'
							style='color: red'></i></a></td>
				</tr>

			</c:forEach>
		</table>
	</div>

</div>
<br>
<br>
<script type="text/javascript">
	function confirmation() {
		return confirm('Are you sure delete this vehicledetails?');
	}
</script>

