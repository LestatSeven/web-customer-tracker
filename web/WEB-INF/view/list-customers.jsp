<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>List Customers</title>
</head>
<body>
    <h2>List customers...</h2>

    <div id="wrapper">
        <div id="header">
            <h2>CRM - Customer Relationship Manager</h2>
        </div>
    </div>

    <div id="container">
        <div id="content">
            <table>
                <tr>
                    <th>First name</th>
                    <th>Last name</th>
                    <th>Email</th>
                </tr>

                <c:forEach var="customer" items="${customers}">
                    <tr>
                        <td>${customer.firstName}</td>
                        <td>${customer.lastName}</td>
                        <td>${customer.email}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>