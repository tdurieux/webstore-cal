function getXhr(){
        var xhr = null; 
        if(window.XMLHttpRequest) // Firefox et autres
           xhr = new XMLHttpRequest(); 
        else if(window.ActiveXObject){ // Internet Explorer 
           try {
                xhr = new ActiveXObject("Msxml2.XMLHTTP");
            } catch (e) {
                xhr = new ActiveXObject("Microsoft.XMLHTTP");
            }
        }
        else { // XMLHttpRequest non supporté par le navigateur 
           alert("Votre navigateur ne supporte pas les objets XMLHTTPRequest..."); 
           xhr = false; 
        } 
        return xhr
}

function refresh(timeoutPeriod) {
    setTimeout("location.reload(true);", timeoutPeriod);
}

function addBook(book){
        var xhr = getXhr()
        
        xhr.onreadystatechange = function(){
                if(xhr.readyState == 4 && xhr.status == 200){
                        alert(xhr.responseText);
                }
        }

        // xhr.open("DELETE","/passerelleREST/resources/ftp/delete/",true)
        // xhr.send(book)
        refresh(1000)
}

function display() {
    hidden = document.getElementsByClassName("hiddenBooks")
    status = hidden[0].style.display ;
    if (status == '')
        hidden[0].style.display = 'block'
}