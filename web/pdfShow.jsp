<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PDF</title>
</head>
<body style="margin: auto">
<div id="pdf"></div>
</body>
</html>
<script type="text/javascript" src="js/pdfobject.js"></script>
<script>
    PDFObject.embed("${pageContext.request.contextPath}${param.file}", "#pdf");
</script>

