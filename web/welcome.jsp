<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <meta charset="UTF-8">
    <title>Tourism</title>
    <link rel="stylesheet" href="../css/sample.css">
</head>
<body>
<header>
    <p><a href="Controller">Home</a></p>
    <p><a href="Controller?command=switchLanguage">NL</a></p>
</header>
<main>
    <article>
        <p>WELCOME</p>
        <p>Number of switches: ${sessionScope.numberOfSwitches}</p>
        <p>Your previous language was ${sessionScope.previousLanguage}.</p>    </article>
</main>
</body>
</html>
