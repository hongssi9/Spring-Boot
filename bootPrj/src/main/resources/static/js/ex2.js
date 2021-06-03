
/*-------------------------------------------*/

window.addEventListener("load", function(){
    var section = document.querySelector("#ex10");
	var tbody = section.querySelector("tbody");
    var requestButton = section.querySelector(".btn-request");
	var pager = section.querySelector(".pager");
	var fieldInput = section.querySelector(".search-form select");
	var queryInput = section.querySelector(".search-form input[name=q]");
	var submitButton = section.querySelector(".search-form input[type=submit]");
	var pageElement = pager.querySelector("a");
	
	submitButton.onclick = function(e){
		e.preventDefault();
		
		var field = fieldInput.value;
		var query = queryInput.value;
		
		bind(`../api/notice/list?f=${field}&q=${query}`);
	};

	pager.onclick = function(e){
		e.preventDefault();
		
		if(e.target.tagName != "A")
			return;
		
		var page = e.target.innerText;
		
		// "http://localhost:8080/api/notice/list?p=2"
		// "http://localhost:8080/js/ex1.html"
		console.log(`../api/notice/list?p=${page}`);
		bind(`../api/notice/list?p=${page}`);
		
		//var as = pager.querySelectorAll("a");
		//console.log(as.length);
		
		//for(var i=0; i<as.length; i++)
			//as[i].classList.remove("text-strong");
				
		pageElement.classList.remove("text-strong");		
		e.target.classList.add("text-strong");
		pageElement = e.target;
		
	};

    //requestButton.onclick = function(e){
    bind("http://localhost:8080/api/notice/list");
    //}
    function bind(url){
		var request = new XMLHttpRequest();
		
		
		request.onload = function(){
			
			// tbody의 자식들을 모두 지우는 트릭
			tbody.innerHTML = "";
				
			// 새로운 목록으로 tbody를 채우는 코드		
			var list = JSON.parse(request.responseText);			
			/*
			var tr = '<tr> \
			        		<td>1</td> \
			    			<td>안녕하세요</td> \
			        	</tr>';
			var tbody = section.querySelector("tbody");
			*/
			//1. innerHTML 
			/*tobdy.innerHTML += tr;*/			
			//2. DOM 을 직접 생성해서 추가하는 방법
			/*var tr = document.createElement("tr");
			var td = document.createElement("td");
			td.innerText = "1";
			tr.append(td);*/			
			//3. template을 이용한 클론
			/*var trTemplate = section.querySelector("#tr-template");
			var tr = trTemplate.cloneNode(true);
			tr.querySelector("td:first-child").innerText = "1";
			tobdy.append(tr);*/
			//4. insertAdjacentElement을 이용해서 문자열로 추가
			
			/*var trEmpty = tbody.querySelector(".empty");
			if(list.length > 0 && trEmpty != null)
				trEmpty.remove();*/
			
			for(var i=0; i<list.length; i++){
				var tr = `<tr>
				        		<td>`+list[i].id+`</td>
				    			<td>${list[i].title}</td>
				        	</tr>`;
			
				tbody.insertAdjacentHTML("beforeend", tr);
			}
			
			// 2. 창과 아이콘을 제거한다.
			screen.remove();
		};
		
		request.onabort = function(){
			console.log("aborted");
			screen.remove();
		};
		
        request.open("GET", url, true);
        request.send(null);

		var screen = document.createElement("div");	
	    screen.style.width = "100%";
	    screen.style.height = "100%";
	    screen.style.backgroundColor = "black";
	    screen.style.position = "absolute";
	    screen.style.top = "0px";
	    screen.style.left = "0px";
	    screen.style.opacity = 0;
	    screen.style.transition = ".5s";

		screen.style.display = "flex";
		screen.style.alignItems = "center";
		screen.style.justifyContent = "center";
		
		var img = document.createElement("img");
		img.src = "../images/ajax-loader.gif";		
		screen.append(img);
		
		var closeButton = document.createElement("input");
		closeButton.value="취소";		
		closeButton.type="button";
		closeButton.style.alignSelf = "flex-start";
		closeButton.style.position="absolute";
		closeButton.style.right = "0px";
		screen.append(closeButton);
		
		closeButton.onclick = function(){
			request.abort();
		};
	
	    setTimeout(function(){
	        screen.style.opacity = 0.7;
	    },0);
	
	    section.append(screen);
	}
});

// --------------------------------------------
window.addEventListener("load", function(){
    var section = document.querySelector("#ex9");
    
    var uploadBox = section.querySelector(".upload-box");
    var selButton = section.querySelector(".btn-sel");
    var fileButton = section.querySelector(".btn-file");
    
    uploadBox.ondragenter = function(e){
        
        console.log("enter");
    }

    uploadBox.ondragover = function(e){
        e.preventDefault();

        var valid = e.dataTransfer.types.indexOf("Files") >= 0;
        console.log(valid);

        if(!valid)
            uploadBox.style.backgroundColor = "red";
        else
            uploadBox.style.backgroundColor = "green";        
    }

    uploadBox.ondragleave = function(e){
        uploadBox.style.backgroundColor = "white";
        console.log("leave");
    }

    uploadBox.ondrop= function(e){
        uploadBox.style.backgroundColor = "white";
        e.preventDefault();
        
        console.log(e.dataTransfer.files[0].size);
        
        for(var k in e.dataTransfer.files[0])
            console.log(k);

        console.log(e.dataTransfer.files[0]);
    }

    
    fileButton.oninput = function(e){

        // for(var k in fileButton.files[0])
        //     console.log(k);
        // console.log("file button inp...");

        console.log(fileButton.files[0]);
    };


    selButton.onclick = function(e){
        var event = new MouseEvent("click", {
            'view': window,
            'bubbles': true,
            'cancelable': true
        });

        fileButton.dispatchEvent(event);
    }
});
// ----------------------------------
window.addEventListener("load", function(){
    var section = document.querySelector("#ex8");
    
    var product = section.querySelector(".product");
    
    product.onclick = function(e){        
        var target = e.target;
        if(!target.classList.contains("up") &&
        !target.classList.contains("down") &&
        !target.classList.contains("current"))
            return;

        if(target.classList.contains("up")){
            var input = target.parentNode.querySelector("input");
            input.value = parseInt(input.value)+1;
        }
        else if(target.classList.contains("down")){
            var input = target.parentElement.querySelector("input");
            input.value = parseInt(input.value)-1;
        }
        else if(target.classList.contains("current")){
            target.parentElement.classList.toggle("current");
        }
    }
});
// ---------------------------------------------------------------
window.addEventListener("load", function(){
    var section = document.querySelector("#ex7");
    
    var accordion = section.querySelector(".accordion");
    accordion.onclick = function(e){
        // 1. .title이 아니면 return
        if(!e.target.classList.contains("title"))
            return;

        // 2. target의 동생의 d-none 제거
        e.target.nextElementSibling.classList.toggle("d-none");
    }
});
// -------------------------------------------
window.addEventListener("load", function(){
    var section = document.querySelector("#ex6");
    
    var container = section.querySelector(".container");
    var btnDel = section.querySelector(".btn-del");
    var btnClone = section.querySelector(".btn-clone");
    var btnChange = section.querySelector(".btn-change");
    
    var selected = null;   

    container.onclick = function(e){
        //if(e.target.className != "box")
        if(!e.target.classList.contains("box"))
            return;

        if(selected != null /* 첫 선택이 아닐 때*/
            && selected != e.target)
            selected.classList.remove("selected");
        
        selected = e.target;  
        selected.classList.toggle("selected");
        
        // if(selected.classList.contains("selected"))
        //     selected.classList.remove("selected");  
        // else
        //     selected.classList.add("selected");
    }

    // var boxes = container.querySelectorAll(".box");
    // boxes[0].onclick = function(){
    //     console.log("box");
    // };
    // for(let i=0; i<boxes.length; i++){
    //     boxes[i].onclick = function(){            
    //         selected = boxes[i];
    //         console.log(selected);
    //     };
    // }

    btnDel.onclick = function(){
        if(selected != null)
            selected.remove();
    }
});
// ------------------------------------------------------------
window.addEventListener("load", function(){
    var section = document.querySelector("#ex5");
    
    var container = section.querySelector(".container");
    var idInput = section.querySelector(".id-input");
    var colorInput = section.querySelector(".color-input");
    var btnAdd = section.querySelector(".btn-add");
    var btnDel = section.querySelector(".btn-del");
    var btnClone = section.querySelector(".btn-clone");
    var btnChange = section.querySelector(".btn-change");
    
    btnAdd.onclick = function(){
        // 1. 엘리먼트 객체를 생성하기
        //var img = document.createElement("img");
        //var txt = document.createTextNode("1");
        var div = document.createElement("div");
        
        // 2. 엘리먼테 객체의 속성 설정하기
        //.src = "../images/1.jpg";
        //div.style["background-color"] = "blue";
        div.style.backgroundColor = colorInput.value;
        div.style.width = "100px";
        div.style.height = "100px";
        div.style.borderRadius = "50px";
        div.style.textAlign = "center";
        div.style.color = "blue";
        div.style.lineHeight = "100px";

        //div.appendChild(txt);
        div.append(idInput.value);
        //div.innerText = "1";

        // 3. 엘리먼트 객체를 문서에 추가하기
        //container.appendChild(img);
        //container.appendChild(div);
        container.append(div);        
        //container.innerHTML += '<div style="border-radius:50px;background-color:blue;width:100px;height:100px;">1</div>';
    };
    btnDel.onclick = function(){
        var div = container.querySelector("div:first-child");
        div.remove();
        //container.removeChild(div);
        
    };
    btnClone.onclick = function(){
        var div = container.querySelector("div:first-child");
        var clone = div.cloneNode();
        container.append(clone);
    };
    btnChange.onclick = function(){
        var es = container.querySelectorAll("div");
        var e1 = es[0];//첫번째
        var e2 = es[1];//두번째


//        Detach
//        Replace
        var old = container.replaceChild(e1, e2);
//        insertBefore
        //container.insertBefore(old, e1); //old
        e1.insertAdjacentElement('beforebegin',old);

    };
});
    
//-----------------------------------------------------------------------
    window.addEventListener("load", function(){
        var section = document.querySelector("#ex4");
        
        var container = section.querySelector(".container");
        var boxes = section.querySelectorAll(".box");
        var button = section.querySelector("input[value='click']");
        
        button.onclick = function(){
            var box = boxes[0];
            let boxStyle = window.getComputedStyle(box);    
            
            var left = parseInt(boxStyle.getPropertyValue("left"));
            
            var tid = window.setInterval(function(){
                
                if(left >= 400)
                    clearInterval(tid);

                left++; // '70px'
                box.style.left = left+"px";

            }, 17);

            
        }
    });
    
// ------------------------------------------------------

    window.addEventListener("load", function(){
        //var section = document.getElementById("ex3");
        var section = document.querySelector("#ex3");
        
        var span = section.querySelector(".span");
        var button = section.querySelector(".btn");
        
        button.onclick = function(){
            
            window.setInterval(function(){
                var count = parseInt(span.innerText);
                count--;
                span.innerText = count;
            }, 1000);
            
        }
    });
    
// ------------------------------------------------------
    


//window.onload = function(){
window.addEventListener("load", function(){
    var section = document.getElementById("ex2");
    console.log(section);

    var xInput = section.getElementsByClassName("x-input")[0];
    var yInput = section.getElementsByClassName("y-input")[0];
    var submitButton = section.getElementsByClassName("submit-button")[0];
    var result = section.getElementsByClassName("result")[0];
    
    submitButton.onclick = function(){
        var x = parseInt(xInput.value);         
        console.log(x);
        var y = parseInt(yInput.value);
         console.log(y);
        result.innerText = x+y;
    }
});
//}

// ------------------------------------------------------

//window.onload = function(){
window.addEventListener("load", function(){
    var section = document.getElementById("ex1");

    var submitButtons = section.getElementsByClassName("submit-button");
    var submitButton = submitButtons[0];
    
    
    
    submitButton.onclick = function(){
        console.log("test");
    }
});
//};

/*function printExam(exam){
	// 객체를 뽀개지 않고 사용하는 방식은 가독성이나 실행 성능을 낮출 수 있다.
	var total = exam.kor + exam.eng + exam.math;
	console.log(`kor:${exam.kor}, eng:${exam.eng}, math:${exam.math}`);
	console.log(`total is ${total}`);
}*/

function printExam(exam){
	// 뽀개기 : Destructuring를 이용한 코드
	/*let kor = exam.kor;
	let eng = exam.eng;
	let math = exam.math;*/
	// ES6에서 지원해주는 뽀개기
	//let {kor, eng, math} = exam;
	//-- 속성의 일부만 ------------------------
	/*let {kor, eng} = exam;
	let math = exam.math;*/
	//-- 객체의 속성이 아닌 변수도 함께 가능?
	/*let {kor, eng, math, avg=100} = exam;
	//let avg;
	console.log(avg);*/
	//-- 뽀개는 객체의 속성명의 별칭도 가능?
	/*let {kor:k, eng, math, avg=100} = exam;
	
	console.log(k);
	
	let total = kor + eng + math;
	console.log(`kor:${kor}, eng:${eng}, math:${math}`);
	console.log(`total is ${total}`);*/
}

/*let exam = {
	kor:10,
	eng:20,
	math:30
};*/

/*printExam(exam);*/

/*===== 연습 코드 ===========*/
/*let exam = {
	kor:10,
	eng:20,
	math:20,
	student:{
		name:'newlec',
		phone:'010-9632-8956'
	},
	aa:{
		x:1
	}
};

let {kor, eng, math, student:{name, phone}} = exam;
console.log(name);
console.log(phone);

function printExam({kor, eng, math}){
	// ES6에서 지원해주는 뽀개기
	//let {kor, eng, math} = exam;
	
	let total = kor + eng + math;
	console.log(`kor:${kor}, eng:${eng}, math:${math}`);
	console.log(`total is ${total}`);
}


printExam(exam);*/

let lotto = [10,20,30,41,4,5];

let [, num2, ,num4] = lotto;

let [x, y] = [2,3];
console.log(x);
console.log(y);

[x, y] = [3, 4];

//console.log(num1);
console.log(x);
console.log(y);

// swapping
[x, y] = [y, x];
console.log(x);
console.log(y);

let a;
let b;

[a, b, c=0] = [10,20];
console.log(`a:${a}, b:${b}, c:${c}`);

let kor;
let eng;

({kor, eng} = {kor:80,eng:90});
console.log(`kor:${kor}, eng:${eng}`);

//-- 중첩된 배열 뽀개기

let [n1,n2,n3,[n4,n5,n6]] = [1,2,3,[11,22,33]];
console.log(`n1:${n1}, n4:${n4}, n5:${n5}`);


/*let num1 = lotto[0];
let num2 = lotto[1];
let num3 = lotto[2];
let num4 = lotto[3];
let num5 = lotto[4];
let num6 = lotto[5];*/

//===== 연습문제 

let notices = {
	title:"공지사항목록",
	list:[
		{title:"굿~", content:"좋아요~"},
		{title:"호호~", content:"웃음소리~"}
	]
};

let {?title?} = notices;

console.log(title);












