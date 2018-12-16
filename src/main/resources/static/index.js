$(document).ready (function() {
    var $movieRow = $('#movieRow');
    var $restaurantRow = $('#RestaurantRow');
    var str = "booking.html";
    //var $middle = $('#middle');
    // var limit =;
    var id;
    console.log("index.js");
    $.ajax({
        type: 'GET',
        url: '/movie/all',
        success: function (movie) {
            console.log('success', movie);
            // console.log(movie[1].movieImage);
            var source = movie.movieImage;
            var i = 0;
            while (i < 4) {
                console.log(movie[i].title);

                //console.log(typeof data.movieImage);
                id = movie[i].movieId;
                console.log(id);
                $movieRow.append('<div class="col-sm-6 col-md-3">' +
                    '<div class="latest-movie">' +
                    '<a href="#"> <img src="dummy/imgs/' + movie[i].movieImage + '" alt="Movie 3" class="image"></a>' +
                    '<div id ="middle" class="middle">' +
                    '<div class="imageText"> Genre:' + movie[i].genres[0].genre + '</div>' +
                    '<div class="imageText"> Language:' + movie[i].language + '</div>' +
                    '<div class="imageText"> Actor:' + movie[i].actors[0].firstName + ' ' + movie[i].actors[0].lastName + '</div>' +
                    '<div class="imageText"> Rating:' + movie[i].ratings[0].rating + '/10</div>' +

                    '<button class="myButton" type = "submit" onclick = "window.location.href = \'booking.html?movieId=\'+'+id+'"> Book Tickets </button>' +
                    '</div>' +
                    '</div>' +
                    '</div>');
                i++;
            }
            // $middle.append('<div class="imageText">Movie Review</div>');
            // $middle.append('<div class="imageText">'+data.genres[0].genre+'</div>');
            // $middle.append('<div class="imageText">'+data.ratings[0].rating+'/10</div>');

            $.ajax({
                type: 'GET',
                url: '/restaurant/all',
                success: function (restaurant) {
                    console.log('success', restaurant);
                    // console.log(movie[1].movieImage);
                    var i = 0;
                    var id;
                    while (i < 4) {
                        console.log(restaurant[i].title);

                        //console.log(typeof data.movieImage);
                        id = restaurant[i].restaurantId;
                        $restaurantRow.append('<div class="col-sm-6 col-md-3">' +
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
                        i++;
                    }
                    // $middle.append('<div class="imageText">Movie Review</div>');
                    // $middle.append('<div class="imageText">'+data.genres[0].genre+'</div>');
                    // $middle.append('<div class="imageText">'+data.ratings[0].rating+'/10</div>');

                }

            });
        }
    });

})