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
    <p><a href="Servlet">Ga naar huis</a></p>
    <p><a href="Servlet?action=switchLanguage">EN</a></p>
</header>

<main>
    <article>
        <p>Aantal keren veranderd van taal: ${sessionScope.numberOfSwitches}</p>
        <p>Je vorige taal was ${sessionScope.previousLanguage}</p>
        <h1>Leuke vakanties</h1>
        <p>We <em>weten</em> hoe druk je het hebt. We <em>weten</em> hoe belangrijk je vakantie voor je is.
            Daarom willen we je helpen om de juiste keuze te maken.</p>
        <p>Deze website geeft je informatie over mogelijke bestemmingen. Zo kan je er zeker van zijn
            dat je de juiste keuze maakt. </p>
        <p>
            <a href="Servlet?action=somethingMore">Lees verder</a>.
        </p>
    </article>
</main>
</body>
</html>
