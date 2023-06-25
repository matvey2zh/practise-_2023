function saveCurrentDispatcher() {
    let dispatcherSurname = document.getElementById("currentSurname").value;
    document.cookie=dispatcherSurname;
}


function ordersOnLoad(){

    document.getElementById("dispatcherInput").value=document.cookie;
}
