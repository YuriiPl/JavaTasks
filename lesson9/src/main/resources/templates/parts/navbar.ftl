<#macro navbar>
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
                </ul>
                <ul class="navbar-nav d-flex">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            ${i18n["language.top"]}
                        </a>
                        <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                            <li onclick="changeLang('en')"><a class="dropdown-item" href="#">${i18n["language.en"]}</a></li>
                            <li onclick="changeLang('uk_UA')"><a class="dropdown-item" href="#">${i18n["language.ua"]}</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</#macro>