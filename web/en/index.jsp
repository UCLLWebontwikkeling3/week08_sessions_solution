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
    <p><a href="Servlet">Go Home</a></p>
    <p><a href="Servlet?action=switchLanguage">NL</a></p>
</header>

<main>
    <article>
        <p>Number of switches: ${sessionScope.numberOfSwitches}</p>
        <p>Your previous language was ${sessionScope.previousLanguage}</p>
        <h1>Sweet Holidays</h1>
        <p>We <em>know</em> how busy you are. We <em>know</em> how important your holiday is for you.
            That's why we want to help you in making the right choice.</p>
        <p>This site offers you information about countries.
            To make sure you choose your ideal destination.</p>
        <p>
            <a href="Servlet?action=somethingMore">Read some more stuff</a>.
        </p>
    </article>
</main>
</body>
</html>

