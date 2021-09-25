function fetchPostJson(form, func){
    const elements = form.elements;
    let data = new FormData();
    let string = "";
    for (let item of elements) {
        if(!item.name)continue;
        data.append(item.name, item.value);
        string=string+item.name;
    }
    fetch(form.action, {
        method: form.method,
        body: data
    })
        .then(response => response.text())
        .then(json => {func(json);form.reset();})
        .catch(function (error) {
            console.log(error)
        });
    return false;
}