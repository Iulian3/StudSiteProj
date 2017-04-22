<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${param.title}</title>
</head>
<body>
<jsp:include page="/WEB-INF/app/views/templates/header.jsp"/>

	
	<h1>${param.title}</h1>

	<jsp:include page="/WEB-INF/pages/${param.content}.jsp"/>
	
	<jsp:include page="/WEB-INF/app/views/templates/footer.jsp"/>
</body>
</html>