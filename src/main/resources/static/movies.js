$(document).ready (function(){
    var $movieRow = $('#allMovies');
    //var op = $('#op').find(":selected").text();
    var i=0;
    var id;
    $.ajax({
        type:'GET',
        url:'/movie/all',
        success: function (movie) {
            console.log('success', movie);

            $movieRow.empty();
            var op = $('#op').find(":selected").text()
            console.log(op);
            // console.log(movie[1].movieImage);
            var source = movie.movieImage;
            $.each(movie, function (i, item) {
                console.log(item.title);
                console.log(item.movieImage);

                //console.log(typeof data.movieImage);
                if((op.localeCompare(movie[i].genres[0].genre))==0 || (op.localeCompare("All"))==0) {
                    id = movie[i].movieId;
                    console.log(id);
                    $movieRow.append('<div class="col-sm-6 col-md-3">' +
                        '<div class="latest-movie">' +
                        '<a href="#"> <img src="dummy/imgs/' + item.movieImage + '" alt="Movie 3" class="image"></a>' +
                        '<div id ="middle" class="middle">' +
                        '<div class="imageText"> Genre:' + movie[i].genres[0].genre + '</div>' +
                        '<div class="imageText"> Language:' + movie[i].language + '</div>' +
                        '<div class="imageText"> Actor:' + movie[i].actors[0].firstName + ' ' + movie[i].actors[0].lastName + '</div>' +
                        '<div class="imageText"> Rating:' + movie[i].ratings[0].rating + '/10</div>' +

                        '<button class="myButton" type = "submit" onclick = "window.location.href = \'booking.html?movieId=\'+'+id+'"> Book Tickets </button>' +
                        '</div>' +
                        '</div>' +
                        '</div>');
                }
            });

            $('.op').change(function(){
                $movieRow.empty();
                var op = $('#op').find(":selected").text()
                console.log(op);
                $.each(movie, function (i, item) {
                    console.log(item.title);


                    //console.log(typeof data.movieImage);
                    if((op.localeCompare(movie[i].genres[0].genre))==0 || (op.localeCompare("All"))==0) {
                        $movieRow.append('<div class="col-sm-6 col-md-3">' +
                            '<div class="latest-movie">' +
                            '<a href="#"> <img src="dummy/imgs/' + item.movieImage + '" alt="Movie 3" class="image"></a>' +
                            '<div id ="middle" class="middle">' +
                            '<div class="imageText"> Genre:' + movie[i].genres[0].genre + '</div>' +
                            '<div class="imageText"> Language:' + movie[i].language + '</div>' +
                            '<div class="imageText"> Actor:' + movie[i].actors[0].firstName + ' ' + movie[i].actors[0].lastName + '</div>' +
                            '<div class="imageText"> Rating:' + movie[i].ratings[0].rating + '/10</div>' +

                            '<button class="myButton" type = "submit" onclick = "window.location.href = \'booking.html?movieId=\'+'+id+'"> Book Tickets </button>' +

                            '</div>' +
                            '</div>' +
                            '</div>');

                    }
                });
                // $middle.append('<div class="imageText">Movie Review</div>');
                // $middle.append('<div class="imageText">'+data.genres[0].genre+'</div>');
                // $middle.append('<div class="imageText">'+data.ratings[0].rating+'/10</div>');

            });
        }
    });
    $('.op')
        .trigger('change');
});


