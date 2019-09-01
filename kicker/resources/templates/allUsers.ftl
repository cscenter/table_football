<#-- @ftlvariable name="data" type="com.kicker.Enteties.Users" -->
<html>
<body>
<ul>
    <#list data.items as user>
        <li>${user.nickName}</li>
    </#list>
</ul>
</body>
</html>