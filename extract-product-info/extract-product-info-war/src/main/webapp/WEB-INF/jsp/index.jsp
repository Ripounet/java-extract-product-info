<html>
<head>
 <title>Basic HTML data extractor</title>
</head>
<body>

<h1>HTML page fetch and mine</h1>
<h2>With JEE and AppEngine</h2>

<div>
 <h3>Simple Servlet</h3>
 <form action="/analyze" method="GET">
 	<input type="text" name="targetURL" placeholder="Paste URL here" value="http://www.etronics.com/coby-cve56blu-jammerz-moods-colorful-isolation-stereo-earphones-blue.html" size="80" />
 	<input type="submit" value="Process" />
 </form>
</div>

<div>
 <h3>Raw text service</h3>
 <form action="/api/extract/flat" method="GET">
 	<input type="text" name="targetURL" placeholder="Paste URL here" value="http://www.etronics.com/coby-cve56blu-jammerz-moods-colorful-isolation-stereo-earphones-blue.html" size="80" />
 	<input type="submit" value="Process" />
 </form>
</div>

<div>
 <h3>JSON service</h3>
 <form action="/api/extract/json" method="GET">
 	<input type="text" name="targetURL" placeholder="Paste URL here" value="http://www.etronics.com/coby-cve56blu-jammerz-moods-colorful-isolation-stereo-earphones-blue.html" size="80" />
 	<input type="submit" value="Process" />
 </form>
</div>

</body>
</html>