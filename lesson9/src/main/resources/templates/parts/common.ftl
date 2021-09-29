<#macro page>
<#import "navbar.ftl" as nb>
<#import "bootstrap.ftl" as bt>

<!DOCTYPE html>
<html lang="${i18n["lang"]}">
<head>
    <#if title?has_content>
        <title>${i18n["${title}"]}</title>
    <#elseif i18n?keys?seq_contains("title")>
        <title>${i18n["title"]}</title>
    <#else>
        <title></title>
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