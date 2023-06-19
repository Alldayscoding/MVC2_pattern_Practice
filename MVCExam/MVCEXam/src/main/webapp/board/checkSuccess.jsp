<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2023-06-19
  Time: 오후 2:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<script type="text/javascript">
if(window.name="update") {

  window.opener.parent.location.href =
          "BoardServlet?command=board_update_form&num=${param.num}";
}
window.close();
</script>
<h2>success!</h2>


</body>
</html>
