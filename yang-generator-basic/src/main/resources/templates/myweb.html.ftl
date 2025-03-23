<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>My Web</title>
</head>
<body>
    <h1>Welcome to My Web</h1>
    <ul>
        <#-- 循环渲染导航条 -->
        <#list menuItems as item>
            <li><a href="${item.url}">${item.label}</a></li>
        </#list>
    </ul>

    <#-- 底部版权信息 (注释部分,不会被输出) -->
    <footer>
        ${currentYear} My Web. All rights reserved.
    </footer>
</body>
</html>

