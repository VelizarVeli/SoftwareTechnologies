function MultiplyDivideNumber(nums) {
    let num = Number(nums[0]);
    let command = Number(nums[1]);
    let result
    if(num <= command)
        result = num * command;
    else
        result = num / command;
    console.log(result);
}