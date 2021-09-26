function changeLang(lang){
    document.cookie="lang="+lang+";SameSite=Lax";
    document.location=document.location;
}