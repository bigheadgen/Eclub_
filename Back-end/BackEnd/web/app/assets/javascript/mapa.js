
function initMap() {
  		var map;
  		var options ={
		 zoom: 8,
    	 center: {lat: -8.36914281798175, lng: -35.2798211914062},
   		 mapTypeControl: false
		}
		map = new google.maps.Map(document.getElementById('map'), options);

	}
initMap(); 
