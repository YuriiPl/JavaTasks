<#macro page>
<#import "/spring.ftl" as i18n/>
<#import "navbar.ftl" as nb>
<#import "bootstrap.ftl" as bt>

<!DOCTYPE html>
<html lang="<@i18n.message "lang"/>">
<head>
    <#if title?has_content>
        <title><@i18n.message "${title}"/>}</title>
    <#else>
        <title><@i18n.message "title"/></title>
    </#if>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<@bt.bootstrap></@bt.bootstrap>
    <script src="scripts/fetch.js"></script>
    <script src="scripts/lang.js"></script>
</head>
<body>
<@nb.navbar></@nb.navbar>
<#nested>
</body>
</html>
</#macro>