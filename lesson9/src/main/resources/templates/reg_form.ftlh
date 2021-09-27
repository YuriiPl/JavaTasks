<#import "parts/common.ftl" as c>
<@c.page>

<div class="container-fluid" style="max-width: 500px">
    <div class="container">

        <h1>${i18n["regform.title"]}</h1>

        <form action='/api/reg_form' method="post" onsubmit="fetchPostJson(this,alert); return false">
            <div class="form-group">
                <label for="user-name">${i18n["regform.yourname"]}</label>
                <input required type="text" class="form-control" id="user-name" name="name" placeholder="${i18n["regform.placeholder.yourname"]}">
            </div>
            <div class="form-group">
                <label for="user-email">${i18n["regform.email"]}</label>
                <input required type="email" class="form-control" id="user-email" name="email" aria-describedby="emailHelp" placeholder="${i18n["regform.placeholder.email"]}">
                <small id="emailHelp" class="form-text text-muted">${i18n["regform.email.noshare"]}</small>
            </div>
            <div class="form-check">
                <input type="checkbox" class="form-check-input" name="acceptNewsLatter" id="chkBxAccept">
                <label class="form-check-label" for="chkBxAccept">${i18n["regform.chkbx.accept"]}</label>
            </div>
            <div class="form-group">
                <label for="user-login">${i18n["regform.login"]}</label>
                <input required type="text" class="form-control" id="user-login" name="login" placeholder="${i18n["regform.placeholder.login"]}">
            </div>
            <div class="form-group">
                <label for="user-passwd">${i18n["regform.password"]}</label>
                <input required type="password" class="form-control" id="user-passwd" name="password" placeholder="${i18n["regform.placeholder.password"]}">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>

    </div>
</div>
</@c.page>