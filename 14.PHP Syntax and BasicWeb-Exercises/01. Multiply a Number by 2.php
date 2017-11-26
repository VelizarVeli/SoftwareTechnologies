<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>First Steps Into PHP</title>

</head>
<body><?php
if (isset($_GET['num'])){
    $n = intval($_GET['num']);
    $n = $n * 2;
}
?>
    <form>
        N: <input type="text" name="num" value="<?= $n ?>" />
        <input type="submit" />
    </form>
</body>
</html>