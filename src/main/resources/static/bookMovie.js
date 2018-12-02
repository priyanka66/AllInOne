$(document).ready (function(){
    var $movieRow = $('#movieRow');
    var $restaurantRow = $('#RestaurantRow');
    //var $middle = $('#middle');
    // var limit =;
    var i=0;
    var img;
    console.log("index.js");
    $.ajax({
        type:'GET',
        url:'/movie/all',
        success: function (movie) {
            console.log('success', movie);
            // console.log(movie[1].movieImage);
            var source = movie.movieImage;