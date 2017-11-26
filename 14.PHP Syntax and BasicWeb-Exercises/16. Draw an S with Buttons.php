<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>First Steps Into PHP</title>
</head>
<body>
<?php
for ($i = 1; $i <= 5; $i++){
    echo "<button style='background-color: blue'>1</button>";
}
?>
<br>
<?php
for ($y = 1; $y <= 3; $y++) {
    for ($x = 1; $x <= 5; $x++) {
        if ($x == 1) {
            echo "<button style='background-color: blue'>1</button>";
        }
        else{
            echo "<button>0</button>";

        }
    }
    echo "<br>";
}
for ($i = 1; $i <= 5; $i++){
    echo "<button style='background-color: blue'>1</button>";
}
echo "<br>";
for ($y = 1; $y <= 3; $y++) {
    for ($x = 1; $x <= 5; $x++) {
        if ($x == 5) {
            echo "<button style='background-color: blue'>1</button>";
        }
        else{
            echo "<button>0</button>";

        }
    }
    echo "<br>";
}
for ($i = 1; $i <= 5; $i++){
    echo "<button style='background-color: blue'>1</button>";
}
?>
</body>
</html>