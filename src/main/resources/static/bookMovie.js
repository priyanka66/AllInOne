$(document).ready (function() {

    function getUrlVars() {
        var vars = {};
        var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
            vars[key] = value;
        });
        return vars;
    }

    var $movieRow = $('#movieRow');
    var $seats = $('#seats');
    var $shows = $('#shows');
    var $seatnum = $('#seatnum');
    var $seatnum1 = $('#seatnum1');
    var $showname1=$('#showname1');
    var $showname=$('#showname');
    var $restaurantRow = $('#RestaurantRow');
    var $bookingrow = $('#bookingrow');
    var id = getUrlVars()["movieId"];
    console.log("Movie: "+ id);

    //var $middle = $('#middle');
    // var limit =;
    var img;
    $.ajax({
        type: 'GET',
        url: '/movie/'+id,
        // url: '/movie/'+id+'/theatres',
        success: function (movie) {
            console.log('success', movie);
            $('.op').change(function() {
                $seatnum.empty();
                var op = $('#op').find(":selected").text();

                console.log(op);

                var ticketPrice = op * 10.75;
                console.log(ticketPrice);
                $seatnum.append(
                    // '<div class="col-sm-6 col-md-6">'+
                    '<h4> Total Ticket Price = ' + ticketPrice + '</h4>'+
                    '<button id= "booking" class="myButton"> Continue to Payment</button>'
                );
                // '</div>'
                $('#booking').click(function () {
                    console.log('paypal/make/payment?sum=' + ticketPrice);
                    $.ajax({
                        type: 'POST',
                        url: 'paypal/make/payment?sum=' + ticketPrice,
                        success: function (data, textStatus) {
                            if (data.redirect_url) {
                                console.log(data.redirect_url);
                                // data.redirect contains the string URL to redirect to
                                window.location.href = data.redirect_url;
                            }
                        }
                    })

                });
            });
            $('.op1').change(function() {

                $showname.empty();

                var op1 = $('#op1').find(":selected").text();

                console.log('op1:'+ op1);
                // '</div>'
                $showname.append(
                    // '<div class="col-sm-6 col-md-6">'+
                    '<h4> '+movie.title +' at '+op1+'</h4>'
                );
            })
            $('.opt').change(function() {
                $seatnum1.empty();
                var opt = $('#opt').find(":selected").text();

                console.log(opt);

                var ticketPrice = opt * 12;
                console.log(ticketPrice);
                $seatnum1.append(
                    // '<div class="col-sm-6 col-md-6">'+
                    '<h4> Total Ticket Price = ' + ticketPrice + '</h4>'+
                    '<button id= "booking2" class="myButton"> Continue to payment </button>'
                );
                // '</div>'
                $('#booking2').click(function () {
                    console.log('paypal/make/payment?sum=' + ticketPrice);
                    $.ajax({
                        type: 'POST',
                        url: 'paypal/make/payment?sum=' + ticketPrice,
                        success: function (data, textStatus) {
                            if (data.redirect_url) {
                                console.log(data.redirect_url);
                                // data.redirect contains the string URL to redirect to
                                window.location.href = data.redirect_url;
                            }
                        }
                    })

                });
            });
            $('.opt1').change(function() {

                $showname1.empty();

                var opt1 = $('#opt1').find(":selected").text();

                console.log('opt1:'+ opt1);
                // '</div>'
                $showname1.append(
                    // '<div class="col-sm-6 col-md-6">'+
                    '<h4> '+movie.title +' at '+opt1+'</h4>'
                );
            })

        }
    });
    $('.op')
        .trigger('change');
    $('.op1')
        .trigger('change');
    $('.opt')
        .trigger('change');
    $('.opt1')
        .trigger('change');

})