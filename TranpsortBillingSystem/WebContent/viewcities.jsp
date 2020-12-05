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

		<br>
		<hr>

		<h2>View City</h2>
		<%
			List<CityBean> list = CityDao.view();
		request.setAttribute("list", list);
		%>

		<table id="view">
			<tr>
				<th>City</th>
				<th>City Code</th>
				<th>State</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${list}" var="bean">

				<tr>
					<td>${bean.getCity()}</td>
					<td>${bean.getCity_Code()}</td>
					<td>${bean.getState()}</td>
					<td><a href='EditCity?id=${bean.getId()}'><i
							class='fas fa-edit' style='color: #567DAF'></i></a></td>
					<td><a href='DeleteCity?cityname=${bean.getCity()}'
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
		return confirm('Are you sure delete this citydetails?');
	}
</script>

