<%@page import="wp.mvc.Book"%>
<%
	Book book=(Book) session.getAttribute("bookinfo");
%>

<html>
<body>
	<h3>Book Details</h3>
	<hr>
		<pre>
			BCode   :	<%=book.getCode()%>
			Title   :	<%=book.getTitle()%>
			Author  :	<%=book.getAuthor()%>
			Subject :	<%=book.getSubject()%>
			Price   :	<%=book.getPrice()%>
		
		</pre>
	<hr>
	<a href="search.jsp">Search-More</a><br>
	<a href="index.jsp">Home</a>
</body>
</html>