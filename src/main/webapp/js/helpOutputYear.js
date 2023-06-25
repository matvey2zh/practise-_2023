function refactorYear(){

    const elements = document.getElementsByName("inputValueYear");
    const elementsOutput = document.getElementsByName("outputValueYear");




        console.log(elements.value);
        let output;
        const last = elements.value % 10;
        if (last === 1) {
            output = "год";
        } else if (last >= 2 && last <= 4) {
            output = "года";
        } else {
            output = "лет";
        }

        elementsOutput.value=output;

}


function lastDigit(number) {
    const last = number % 10;
    if (last === 1) {
        return "год";
    } else if (last >= 2 && last <= 4) {
        return "года";
    } else {
        return "лет";
    }
}