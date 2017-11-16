function addRemove(arr) {
    let numbers = [];
    let comand;
    let number;
    for (let i = 0; i < arr.length - 1; i++) {
        let pair = arr[i].split(' ');
        comand = pair[0];
        number = pair[1];
        numbers[comand] = number
    }
    let key = arr[arr.length - 1]
    if (numbers[key] == undefined) {
        console.log("None")
    }
    else(
        console.log(numbers[key]))
}
addRemove(['key value', 'key eulav', 'test test', '3 test', '3 test1','key'])