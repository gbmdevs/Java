<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<body>
<h1>${msg}</h1>
<h2>Hoje a Data eh: <fmt:formatDate value="${today}" pattern="dd-MM-yyyy" /></h2>
</body>
</html>