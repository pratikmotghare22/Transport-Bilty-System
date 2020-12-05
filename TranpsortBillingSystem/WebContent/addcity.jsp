
<div class="main">
	<h3>TransportBillingSystem</h3>
</div>
<div class="row">
	<div class="column">
		<img src="RESOURCE/IMG/logo.png">
	</div>

	<div class="column">

		<a href="CityPanel"><button>View Cities</button></a> <br> <br>
		<hr>

		<h2>Add City</h2>
		<form action="AddCity" method="post">
			<div class="row">
				<div class="col-25">
					<label for="city">City Name</label>
				</div>
				<div class="col-75">
					<input type="text" id="city" name="city" placeholder="City">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="city_code">City Code</label>
				</div>
				<div class="col-75">
					<input type="text" id="city_code" name="city_code"
						placeholder="City Code">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="state">State</label>
				</div>
				<div class="col-75">
					<select id="state" name="state">
						<option value="choose">Choose</option>
						<option value="Maharastra">Maharashtra</option>
						<option value="Delhi">Delhi</option>
						<option value="Madhya Pradesh">Madhya Pradesh</option>
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

