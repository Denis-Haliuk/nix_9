function updateStatus(id){
    window.location.href = '/admin/orders/update/' + id + '/' + getValue(id);
}
function getValue(id) {
    var e = document.getElementById("myselect" + id);
    return e.options[e.selectedIndex].text;
}