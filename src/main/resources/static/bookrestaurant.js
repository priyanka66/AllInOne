$(document).ready (function(){

    function getUrlVars() {
        var vars = {};
        var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
            vars[key] = value;
        });
        return vars;
    }
    var id = getUrlVars()["restaurantId"];
    console.log("restaurant: "+ id);

    var $movieRow = $('#reserveRow');
    //var op = $('#op').find(":selected").text();
    var i=0;
    $.ajax({
        type: 'GET',
        url: '/restaurant/'+id,
        success: function (restaurant) {
            console.log('success', restaurant);

            $movieRow.append('<div class="col-sm-6 col-md-5">'+
                '<div class="restaurant">'+
                '<a href="#"> <img src="dummy/imgs/'+restaurant.restaurantImage+'" alt="restaurant 3" class="image"></a>'+
                // '<div id ="middle" class="middle">'+
                '</div>'+
                '</div>'+
                '<div class="col-sm-6 col-md-7">'+
                '<div class="section-title"> Name:'+restaurant.restaurantName+'</div>'+
                '<div class="section-title"> '+restaurant.overview+'</div>'+
                '<div class="section-title"> Rating:'+restaurant.rating.overallRatingValue+'/10</div>'+
                '<div class="section-title"> Address:'+restaurant.address+'</div><br>'+

                '<h3>No of people:</h3>'+
                '<div class="quantity buttons_added">'+
                    '<input type="number" step="1" min="1" max="12" name="quantity" value="1" title="Qty" class="input-text qty text" size="2" pattern="" inputmode="">'+
                '</div>'+ '<br>'+


            // '<div class="imageText"> Rating:'+restaurant[i].OverallRating[i].'/10</div>'+

                '<button class="myButton" type = "submit" onclick = "window.location.href = \'success.html\'"> Reserve Seats </button>' +
                '</div>'+
                '</div>'+
                '</div>');
        }


        // success: function (theatre) {
        //     $('.op').change(function() {
        //         console.log('success', theatre);
        //         var op = $('#op').find(":selected").text();
        //         console.log(op);
        //         var ticketPrice = op * 10.75;
        //         console.log(ticketPrice);
        //
        //     })




    });





    // $.ajax({
    //     type:'GET',
    //     url:'/restaurant/all',
    //     success: function (restaurant) {
    //         console.log('success', restaurant);
    //
    //         //$movieRow.empty();
    //         //var op = $('#op').find(":selected").text()
    //         //console.log(op);
    //         // console.log(movie[1].movieImage);
    //         var source = restaurant.restaurantImage;
    //         $.each(restaurant, function (i, item) {
    //             console.log(item.restaurantName);
    //             //console.log(item.movieImage);
    //             id = restaurant[i].restaurantId;
    //             //console.log(typeof data.movieImage);
    //
    //             $movieRow.append('<div class="col-sm-6 col-md-3">'+
    //                 '<div class="latest-movie">'+
    //                 '<a href="#"> <img src="dummy/imgs/'+restaurant[i].restaurantImage+'" alt="restaurant 3" class="image"></a>'+
    //                 '<div id ="middle" class="middle">'+
    //                 '<div class="imageText"> Name:'+restaurant[i].restaurantName+'</div>'+
    //                 '<div class="imageText"> Rating:'+restaurant[i].rating.overallRatingValue+'/10</div>'+
    //                 '<div class="imageText"> Address:'+restaurant[i].address+'</div>'+
    //                 // '<div class="imageText"> Rating:'+restaurant[i].OverallRating[i].'/10</div>'+
    //
    //                 '<button class="myButton" type = "submit" onclick = "window.location.href = \'reserving.html?restaurantId=\'+'+id+'"> Reserve Seats </button>' +
    //                 '</div>'+
    //                 '</div>'+
    //                 '</div>');
    //
    //         });
    //     }
    // });
});


