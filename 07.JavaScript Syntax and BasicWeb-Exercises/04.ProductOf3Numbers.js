function ProductOfThreeNumbers(nums) {
    let a = Number(nums[0]);
    let b = Number(nums[1]);
    let c = Number(nums[2]);
    if((a >= 0 && b >= 0 && c < 0) || (a >= 0 && c >= 0 && b < 0) || (b >= 0 && c >= 0 && a < 0))
        console.log("Negative");
    else
        console.log("Positive");
}