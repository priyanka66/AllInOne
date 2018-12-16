$(document).ready (function(){
    var $movieRow = $('#allMovies');
    //var op = $('#op').find(":selected").text();
    var i=0;
    var id;
    $.ajax({
        type:'GET',
        url:'/restaurant/all',
        success: function (restaurant) {
            console.log('success', restaurant);

            //$movieRow.empty();
            //var op = $('#op').find(":selected").text()
            //console.log(op);
            // console.log(movie[1].movieImage);
            var source = restaurant.restaurantImage;
            $.each(restaurant, function (i, item) {
                console.log(item.restaurantName);
                //console.log(item.movieImage);
                id = restaurant[i].restaurantId;
                //console.log(typeof data.movieImage);

                $movieRow.append('<div class="col-sm-6 col-md-3">' +
                    '<div class="latest-movie">' +
                    '<a href="#"> <img src="dummy/imgs/' + restaurant[i].restaurantImage + '" alt="restaurant 3" class="image"></a>' +
                    '<div id ="middle" class="middle">' +
                    '<div class="imageText"> Name:' + restaurant[i].restaurantName + '</div>' +
                    '<div class="imageText"> Rating:' + restaurant[i].rating.overallRatingValue + '/10</div>' +
                    '<div class="imageText"> Address:' + restaurant[i].address + '</div>' +
                    '<button class="myButton" type = "submit" onclick = "window.location.href = \'reserving.html?restaurantId=\'+'+id+'"> Reserve Seats </button>' +
                    '</div>' +
                    '</div>' +
                    '</div>');
            });
        }
    });
});


