function start_scenario() {
    var psc_location = "/Crisis/psc.xhtml";
    var fsc_location = "/Crisis/fsc.xhtml";
    var timer;
    timer = setTimeout(function () {
        document.location = psc_location;
    }, 2000);
    clearTimeout(timer);
    timer = setTimeout(function () {
        document.location = fsc_location;
    }, 3000);
}