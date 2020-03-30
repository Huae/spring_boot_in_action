<%@ page language="java" contentType="text/html;UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta content="text/html;charset=UTF-8" http-equiv="Content-Type">
    <title>async</title>
    <script type="text/css" src="/assets/test.js"></script>
</head>
<body>
<script type="text/javascript" src="assets/js/jquery.js"></script>
<script type="text/javascript">
    deferred();

    function deferred() {
        $.get('defer', function (data) {
            console.log(data);
            deferred();
        })
    }
</script>
</body>
</html>