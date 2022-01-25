const container = document.querySelector(".container");
const seats = document.querySelectorAll(".row .seat:not(.sold)");
const count = document.getElementById("count");
const total = document.getElementById("total");
const totalPrice = document.getElementById("total-price");
const movieSelect = document.getElementById("movie");
localStorage.setItem("selectedSeats", null);


let ticketPrice = document.getElementById("price").value;

// Save selected movie index and price
function setMovieData(movieIndex, moviePrice) {
    localStorage.setItem("selectedMovieIndex", movieIndex);
    localStorage.setItem("selectedMoviePrice", moviePrice);
}

// Update total and count
function updateSelectedCount() {
    const selectedSeats = document.querySelectorAll(".row .seat.selected");

    const seatsIndex = [...selectedSeats].map((seat) => [...seats].indexOf(seat));
    localStorage.setItem("selectedSeats", JSON.stringify(seatsIndex));
    document.getElementById("selected-seats").value = seatsIndex;

    const selectedSeatsCount = selectedSeats.length;

    count.innerText = selectedSeatsCount;
    total.innerText = selectedSeatsCount * ticketPrice;
    totalPrice.value = total.innerText;

    //setMovieData(movieSelect.selectedIndex, movieSelect.value);
}


// Get data from localstorage and populate UI
function populateUI() {
    seats.forEach((seat, index) => {
        seat.classList.remove("selected", "sold");
    });

    const selectedSeats = JSON.parse(localStorage.getItem("selectedSeats"));
    const soldSeats = JSON.parse(localStorage.getItem("soldSeats"));

    if (soldSeats !== null && soldSeats.length > 0){
        seats.forEach((seat, index) => {
            if(soldSeats.indexOf(index) > -1) {
                seat.classList.add("sold");
            }
        })
    }

    if (selectedSeats !== null && selectedSeats.length > 0) {
        seats.forEach((seat, index) => {
            if (selectedSeats.indexOf(index) > -1) {
                seat.classList.add("selected");
            }
        });
    }

    const selectedMovieIndex = localStorage.getItem("selectedMovieIndex");

    if (selectedMovieIndex !== null) {
        movieSelect.selectedIndex = selectedMovieIndex;
    }
}


// Seat click event
container.addEventListener("click", (e) => {
    if (
        e.target.classList.contains("seat") &&
        !e.target.classList.contains("sold")
    ) {
        e.target.classList.toggle("selected");

        updateSelectedCount();
    }
});

$(document).ready(function() {
    $('.purchase-only').hide();
    $('.success-message').hide();

    $(document.getElementById("purchase")).click(function (){
        $('.purchase-only').show();
    });

    $(document.getElementById("reservation")).click(function (){
        $('.purchase-only').hide();
    });

    $(document.getElementById("select-b822")).each(function () {
        localStorage.setItem("soldSeats", document.getElementById(this.value).value);
    });

    $(document.getElementById("select-b822")).change(function () {
        console.log("select changed");
        localStorage.setItem("soldSeats", document.getElementById(this.value).value);
        populateUI();
    })

    var soldSeatsToCompare = localStorage.getItem("soldSeats");
    populateUI();

    $('.u-btn-submit').click(function (){

        // setTimeout(() => {
        //     if(soldSeatsToCompare !== document.getElementById(document.getElementById("select-b822").value).value){
        //         $('.u-inner-form').hide();
        //         $('.success-message').show();
        //         console.log("done");
        //     }
        // }, 600);
    });
});
