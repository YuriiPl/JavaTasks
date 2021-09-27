<#import "parts/common.ftl" as c>
<@c.page title="${i18n['title']}">
    <div>${i18n["message"]}</div>
<input class='ua' type=button value='укр' onclick="changeLang('uk_UA')">
<input class='eng' type=button value='eng' onclick="changeLang('en')">
</@c.page>