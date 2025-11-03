function onMouseEnter(obj, str) {
    obj.src = str;
}
        
function onMouseExit(obj, str) {
    obj.src = str;
}

function showValue() {
    var element = document.getElementById("places-select");
    var value = element.value;
    changeBackground(value);
}

function changeBackground(value) {
    if (value == "mountain")
        document.body.style.backgroundImage = "url('media/mountain.jpg')";
    if (value == "coast")
        document.body.style.backgroundImage = "url('media/coast.jpg')";
    if (value == "road")
        document.body.style.backgroundImage = "url('media/road.jpg')";
    if (value == "park")
        document.body.style.backgroundImage = "url('media/park.jpg')";
}

function move() {
    document.querySelector(".welsh").classList.add("anim");
}