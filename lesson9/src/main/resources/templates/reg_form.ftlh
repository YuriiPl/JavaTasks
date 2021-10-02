<#import "parts/common.ftl" as c>
<@c.page>

<div class="container-fluid" style="max-width: 500px">
    <div class="container">

        <h1>${i18n["regform.title"]}</h1>

        <form action='/api/reg_form' name="sendForm" method="post" onsubmit="
                                        let inp1 = document.getElementById('user-passwd');
                                        let inp2 = document.getElementById('user-passwd-repeat');
                                        if(inp1.value===inp2.value){
                                            fetchPostJson(this,
                                                    function (json) {
                                                        document.getElementById('iframe1').contentWindow.location.reload(); this.document.forms.item(sendForm).reset();
                                                    },
                                                    function (json) {
                                                        const map1 = new Map();
                                                        map1.set('wrongSex', '${i18n["regform.wrongSex"]}');
                                                        map1.set('wrongAcceptNews', '${i18n["regform.wrongAcceptNews"]}');
                                                        map1.set('wrongLoginSize', '${i18n["regform.wrongLoginSize"]}');
                                                        map1.set('wrongLogin', '${i18n["regform.wrongLogin"]}');
                                                        map1.set('wrongEmail', '${i18n["regform.wrongEmail"]}');
                                                        map1.set('wrongUsername', '${i18n["regform.wrongUsername"]}');
                                                        map1.set('wrongPassword', '${i18n["regform.wrongPassword"]}');
                                                        map1.set('user_email_exist', '${i18n["regform.userEmailExists"]}');
                                                        let h='';
                                                        for (let i in json.message) {
                                                            // console.log(json.message[i]+' '+map1.get(json.message[i]));
                                                            h += map1.get(json.message[i])+'<br>';
                                                        }
                                                        let modalWindow = new bootstrap.Modal(document.getElementById('modalWindow'), {});
                                                        document.querySelector('#modalWindow .modal-body').innerHTML=h;
                                                        modalWindow.show();
                                                    }
                                            );
                                        } else {
                                            let modalWindow = new bootstrap.Modal(document.getElementById('modalWindow'), {});
                                            document.querySelector('#modalWindow .modal-body').innerHTML='${i18n["regform.passwordMismatch"]}';
                                            modalWindow.show();
                                        }
                                        return false">
            <div class="form-group">
                <label for="user-name">${i18n["regform.yourname"]}</label>
                <input required type="text" class="form-control" id="user-name" name="name" placeholder="${i18n["regform.placeholder.yourname"]}">
            </div>
            <div class="form-group">
                <span>${i18n["regform.sex"]}:</span>
                    <input type="radio" id="contactChoice1" name="userSex" value="MALE" checked>
                    <label for="contactChoice1">${i18n["regform.male"]} </label>
                    <input type="radio" id="contactChoice2" name="userSex" value="FEMALE">
                    <label for="contactChoice2">${i18n["regform.female"]} </label>
                    <input type="radio" id="contactChoice3" name="userSex" value="OTHER">
                    <label for="contactChoice3">${i18n["regform.other"]} </label>
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
                <label for="user-passwd-repeat">${i18n["regform.password.repeat"]}</label>
                <input required type="password" class="form-control" id="user-passwd-repeat" placeholder="${i18n["regform.placeholder.password.repeat"]}">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>

    </div>
</div>

    <!-- Modal window -->
    <div class="modal fade" id="modalWindow" tabindex="-1" aria-labelledby="modalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="modalLabel"></h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Закрыть"></button>
                </div>
                <div class="modal-body">
                    ...
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Закрыть</button>
                </div>
            </div>
        </div>
    </div>

    <div>Just for test</div>
    <iframe id="iframe1" src="/users" width="100%" height="700" />
</@c.page>