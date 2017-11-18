<%--
  Created by IntelliJ IDEA.
  User: LISETTE
  Date: 18/11/2017
  Time: 02:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Log in</h3>
    </div>
    <div class="panel-body">

        <div class="container">
            <form action="" method="post" class="form-horizontal" role="form">

                <div class="form-group">
                    <label for="username" class="col-sm-2 control-label">Label:</label>
                    <div class="col-sm-10">
                        <input type="text" name="username" id="username" class="form-control" value="username" title=""
                               required="required">
                    </div>
                </div>

                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">Label:</label>
                    <div class="col-sm-10">
                        <input type="text" name="password" id="password" class="form-control" value="password" title=""
                               required="required">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-10 col-sm-offset-2">
                        <button type="submit" class="btn btn-primary">Log in</button>
                    </div>
                </div>
            </form>
        </div>

    </div>
</div>

</body>
</html>
