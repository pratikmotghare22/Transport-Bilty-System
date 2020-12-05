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

		<hr>

		<h2>Edit Vehicle</h2>
		<%
			String vehicleid = request.getParameter("vehicleid");
			int id = Integer.parseInt(vehicleid);
			VehicleBean bean = VehicleDao.getRecordByVehicleId(id);
		%>
		<form action="EditVehicleForm" method="post">
			<div class="row">
				<div class="col-75">
					<input type="hidden" id="vehicleid" name="vehicleid"
						placeholder="vehicle id" value="<%=bean.getVehicleId()%>">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="vehicletype">Vehicle Type</label>
				</div>
				<div class="col-75">
					<select id="vehicletype" name="vehicletype">
						<option value="<%=bean.getVehicleType()%>">Choose</option>
						<option value="Truck">Truck</option>
						<option value="Pick-Up">Pick-Up(4 wheelar)</option>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="vehiclename">Vehicle Name</label>
				</div>
				<div class="col-75">
					<input type="text" id="vehiclename" name="vehiclename"
						placeholder="vehicle name" value="<%=bean.getVehicleName()%>">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="vehiclenumber">Vehicle Number</label>
				</div>
				<div class="col-75">
					<input type="text" id="vehiclenumber" name="vehiclenumber"
						placeholder="vehicle number" value="<%=bean.getVehicleNumber()%>">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="ownername">Vehicle Owner Name</label>
				</div>
				<div class="col-75">
					<input type="text" id="ownername" name="ownername"
						placeholder="owner name" value="<%=bean.getOwnerName()%>">
				</div>
			</div>

			<div class="row">
				<div class="col-25">
					<label for="insurance">Insurance</label>
				</div>
				<div class="col-75">
					<input type="radio" id="insurance1" name="insurance"
						value="Yes"> <label for="insurance1">YES</label>
					<input type="radio" id="insurance2" name="insurance"
						value="No"> <label for="insurance2">NO</label>
				</div>
			</div>
			<br>
			<div class="row">
				<input type="submit" value="Submit">
			</div>
		</form>
	</div>

</div>

