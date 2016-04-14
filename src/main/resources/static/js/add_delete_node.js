copy = function(){
	var tmp = document.createDocumentFragment();
    var div = tmp.appendChild(document.createElement("div")); 
    var sel = document.getElementById("filed_div");
    div.innerHTML = sel.outerHTML;
    var cloned = div.firstChild;
    document.getElementById("fileds_div").appendChild(cloned);
}

removeElement = function (_element){
    var _parentElement = _element.parentNode;
    var _parentElement_pre = _parentElement.parentNode;
    
    if(_parentElement && _parentElement_pre && _parentElement_pre.childElementCount>1){
           _parentElement_pre.removeChild(_parentElement);
    }
}
