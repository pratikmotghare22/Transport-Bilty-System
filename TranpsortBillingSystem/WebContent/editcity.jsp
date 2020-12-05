<%@page import="dao.CityDao,bean.CityBean,java.util.*"%>
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

		<h2>Edit City</h2>
		<%
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		CityBean bean=CityDao.getRecordById(id);
		%>
		<form action="EditCityForm" method="post">
			<div class="row">
				<div class="col-75">
					<input type="hidden" id="id" name="cityid"
						value="<%=bean.getId() %>" placeholder="City">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="city">City Name</label>
				</div>
				<div class="col-75">
					<input type="text" id="city" name="city"
						value="<%=bean.getCity() %>" placeholder="City">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="city_code">City Code</label>
				</div>
				<div class="col-75">
					<input type="text" id="city_code" name="city_code"
						value="<%=bean.getCity_Code() %>" placeholder="City Code">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="state">State</label>
				</div>
				<div class="col-75">
					<select id="state" name="state">
						<option value="<%=bean.getState() %>">Choose</option>
						<option>Maharashtra</option>
						<option>Delhi</option>
						<option>Madhya Pradesh</option>
					</select>
				</div>
			</div>
			<br>
			<div class="row">
				<input type="submit" value="Submit">
			</div>
		</form>
	</div>

</div>

