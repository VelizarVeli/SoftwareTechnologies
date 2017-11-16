function SetValueToIndexes(input) {
    let length = Number(input[0]);
    let array = [];
    for(let i = 1; i < input.length; i++){
        let indexValue = input[i].split(' - ');
        let index = indexValue[0];
        let value = indexValue[1];
        array[index] = value;

    }
    for (let j = 0; j < length; j++){
        if(array[j] == undefined) {
            console.log(0);
        }
        else {
            console.log(array[j]);
        }
    }
}