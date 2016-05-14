var map;
					
	function initMap() {
  		var options ={
		 zoom: 7,
    	 center: {lat: -8.36914281798175, lng: -35.2798211914062},
   		 mapTypeControl: false
		}
		map = new google.maps.Map(document.getElementById('map'), options);
	}
initMap(); 

	function buttonLeg(){
		var msg ='1 - ROCK  2 - FORRO\n 3 - REGGAE  4 - BALADAS'
		alert(msg);
	}