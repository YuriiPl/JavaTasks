<#--<#import "parts/common.ftl" as c>-->
<#--<@c.page>-->

<#import "/spring.ftl" as i18n/>
<#import "parts/bootstrap.ftl" as bt>
<@bt.bootstrap></@bt.bootstrap>

<div class="container-fluid" style="max-width: 1200px; margin: 1px auto">
    <div class="container">
    <div style="height: auto; margin:10% auto;text-align:center">

        <table class="table table-striped table-bordered table-hover">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Login</th>
                    <th scope="col">Password</th>
                    <th scope="col">E-mail</th>
                    <th scope="col">Want news</th>
                    <th scope="col">Sex</th>
                </tr>
            </thead>
        <#list users as u>
            <tr>
                <td>${u.name}</td>
                <td>${u.login}</td>
                <td>${u.password}</td>
                <td>${u.email}</td>
                <td><#if u.acceptNewsLatter><@i18n.message "yes"/><#else><@i18n.message "no"/></#if></td>
                <td>${u.userSex}</td>
            </tr>
        </#list>
        </table>

    </div>
    </div>
</div>

<#--</@c.page>-->