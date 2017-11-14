function PrintLines(lines) {
    for(let i = 0; i < lines.length; i++){
        if(lines[i] === "Stop"){
            break;
        }
        console.log(lines[i]);
    }
}