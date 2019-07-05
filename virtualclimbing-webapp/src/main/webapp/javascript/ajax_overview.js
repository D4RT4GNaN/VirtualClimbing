// ----- Called when the select tag for site bean change -----
function onSelectSiteChange() {
	var url = urlDetailSite;
	
	var params = {
        site: jQuery("#selectSite").val()
    };
	
	jQuery.post(
		url,
		params,
		function (data) {
			var image = document.createElement("IMG");
			image.alt = "Bannière du site colima'100";
			image.setAttribute('class', 'img-thumbnail');
			image.src=data.imageUrl;
			
			var $imageSite = jQuery("#banner_site");
			$imageSite.empty();
			$imageSite.append(image);
			
			$lat = data.latitude;
			$lon = data.longitude;
			
			mapChange();
			
			var $location = jQuery("#locationTD");
			$location.empty();
			$location.append(data.location);
			
			var $access = jQuery("#accessTD");
			$access.empty();
			$access.append(data.access);
			
			var $rockType = jQuery("#rockTypeTD");
			$rockType.empty();
			$rockType.append(data.rockType);
			
			var $profil = jQuery("#profilTD");
			$profil.empty();
			$profil.append(data.profil);
			
			var $anchorage = jQuery("#anchorageTD");
			$anchorage.empty();
			$anchorage.append(data.anchorage);
			
			var $maxHeight = jQuery("#maxHeightTD");
			$maxHeight.empty();
			$maxHeight.append(data.maxHeight);
			
			var $minAltitude = jQuery("#minAltitudeTD");
			$minAltitude.empty();
			$minAltitude.append(data.minAltitude);
			
			var $orientation = jQuery("#orientationTD");
			$orientation.empty();
			$orientation.append(data.orientation);
			
			var $note = jQuery("#noteTD");
			$note.empty();
			$note.append(data.note);
			
			changeSelectSectorList();
			
		}
	)
	.fail(function (data) {
		alert("Une erreur s'est produite.")
	});
}

/* 
	Called when the select tag for site bean change 
	(change the list in select tag for sector bean) 
*/
function changeSelectSectorList() {
	var url = urlListSector;
	
	var params = {
        site: jQuery("#selectSite").val()
    };
	
	jQuery.post(
		url,
		params,
		function (data) {
			var $selectSector = jQuery("#selectSector");
			$selectSector.empty();
			jQuery.each(data, function(key, val) {
				$selectSector.append(
					jQuery("<option>")
						.text(val.name)
						.val(val.name)
				);
			})
			onSelectSectorChange();
		}
	)
	.fail(function (data) {
		alert("Une erreur s'est produite.")
	});
}

// ----- Called when the select tag for sector bean change -----
function onSelectSectorChange() {
	var url = urlListRoute;
	
	var params = {
        sector: jQuery("#selectSector").val()
    };
	
	jQuery.post(
		url,
		params,
		function (data) {		
			var $tbody = jQuery("#bodyTable");
			$tbody.empty();
			
			jQuery.each(data, function(key, val) {
				$tbody.append(
					jQuery("<tr>").append(
						jQuery("<td>").text(key),
						jQuery("<td>").text(val.name),
						jQuery("<td>").text(val.height),
						jQuery("<td>").text(val.grade),
						jQuery("<td>").text(val.note)
					)
				);
			})
			
			doAjaxGetDetailSector();
			
		}
	)
	.fail(function (data) {
		alert("Une erreur s'est produite.")
	});
}

function doAjaxGetDetailSector() {
	var url = urlDetailSector;
	
	var params = {
        sector: jQuery("#selectSector").val()
    };
	
	jQuery.post(
		url,
		params,
		function (data) {
			var img = document.createElement("IMG");
			img.alt = "Ensemble des voies du secteur";
			img.setAttribute('class', 'img-thumbnail');
			img.src=data.imageUrl;
			
			var $imageSector = jQuery("#banner_sector");
			$imageSector.empty();
			$imageSector.append(img);		
		}
	)
	.fail(function (data) {
		alert("Une erreur s'est produite.")
	});
}