var msgArray=new Array();
function Toast(message,duration,isAppend){
	var obj={
		message:message,
		duration:duration
	}
	duration=isNaN(duration)?3000:duration;
	var m = document.createElement('div');
	m.innerHTML = message;
	m.style.cssText="width:60%;display:none; min-width:150px; background:#000; opacity:0.9; height:40px; color:#fff; line-height:40px; text-align:center; border-radius:5px; position:fixed; top:80%; left:20%; z-index:999999; font-weight:bold;";
	
	if(msgArray.length==0||(isAppend!=null&&!isAppend)){
		document.body.appendChild(m);
		$(m).fadeIn(300,function(){
			setTimeout(function() {
				$(m).fadeOut(300,function(){
					document.body.removeChild(m);
					msgArray.shift();
					if(msgArray.length!=0){
						Toast(msgArray[0].message,msgArray[0].duration,false);
					}
				});
			},duration);
		});
	}

	if(isAppend==null||isAppend){
		msgArray.push(obj);
	}
}
