<#macro page>
<#import "navbar.ftl" as nb>

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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="scripts/fetch.js"></script>
    <script src="scripts/lang.js"></script>
</head>
<body>
<@nb.navbar></@nb.navbar>
<#nested>
</body>
</html>
</#macro>