<#macro page>
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


<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/">${i18n["menu.home"]}</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/form">${i18n["menu.registration"]}</a>
                </li>
<#--                <li class="nav-item dropdown">-->
<#--                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">-->
<#--                        ${i18n["language.top"]}-->
<#--                    </a>-->
<#--                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">-->
<#--                        <li onclick="changeLang('en')"><a class="dropdown-item" href="#">${i18n["language.en"]}</a></li>-->
<#--                        <li onclick="changeLang('uk_UA')"><a class="dropdown-item" href="#">${i18n["language.ua"]}</a></li>-->
<#--                        <li><hr class="dropdown-divider"></li>-->
<#--                        <li><a class="dropdown-item" href="#">Something else here</a></li>-->
<#--                    </ul>-->
<#--                </li>-->
            </ul>

            <ul class="navbar-nav d-flex">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        ${i18n["language.top"]}
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li onclick="changeLang('en')"><a class="dropdown-item" href="#">${i18n["language.en"]}</a></li>
                        <li onclick="changeLang('uk_UA')"><a class="dropdown-item" href="#">${i18n["language.ua"]}</a></li>
                    </ul>
                </li>
            </ul>


        </div>
    </div>
</nav>


<#nested>
</body>
</html>
</#macro>