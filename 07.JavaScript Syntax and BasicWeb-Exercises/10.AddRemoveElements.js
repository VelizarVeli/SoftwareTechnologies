function AddRemoveElements(input) {
    let array = [];
    for(let i = 0; i < input.length; i++){
        let commandValue = input[i].split(' ');
        let command = commandValue[0];
        let value = commandValue[1];
        if(command == "add"){
            array.push(value);
        }
        if (command == "remove" && value > -1 && value < array.length) {
                  array.splice(value, 1)

        }

    }
    for (let j = 0; j < array.length; j++){

        console.log(array[j]);

    }
}