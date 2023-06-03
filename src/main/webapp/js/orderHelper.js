const dateDispatch = document.getElementById("dateDispatch");
const dateDelivery= document.getElementById("dateDelivery");
function setMinAndMaxDate(){

    dateDispatch.setAttribute("min",getDate());
    dateDelivery.setAttribute("disabled","disabled");

}





function setRangeToDeliveryDate(){
    dateDelivery.removeAttribute("disabled")
    dateDelivery.setAttribute("min",dateDispatch.value);
}



function getDate(){
    const dateObject = new Date();
    const year = dateObject.getFullYear();
    const month = dateObject.getMonth() + 1;
    const day = dateObject.getDate();
    const formattedDate = `${year}-${month.toString().padStart(2, '0')}-${day.toString().padStart(2, '0')}`;
    return formattedDate;
}
