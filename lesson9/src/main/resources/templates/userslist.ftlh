<#--<#import "parts/common.ftl" as c>-->
<#--<@c.page>-->

<div class="container-fluid" style="max-width: 900px">
    <div class="container">
    <div style="width: 500px; height: auto; margin:10% auto;text-align:center">
        <#list users as u>
            ${u.login}
            ${u.password}
            ${u.email}
            ${u.login}
            ${u.acceptNewsLatter?string(i18n['yes'], i18n['no'])}
        </#list>
    </div>
    </div>
</div>

<#--</@c.page>-->