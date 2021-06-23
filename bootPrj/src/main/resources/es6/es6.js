import aaa,{test, test2} from './module1.js';
import bbb,{test as mtest, test2 as mtest2} from './module2.js';
import Exam from './exam.js';

aaa();
test();
test2();

bbb();
mtest();
mtest2();

let exaem = new Exam(1,1,1);

console.log(exaem.total());


/*
//---------Promise--------------------
function getCountSync(){ //동기식
    let result = 0;
    //Thread.sleep(3000); 

    //데이터가 로드된 후에
    //로드되는 시간이 3초라고 가정한다.   
        result = 3;//로드된 값을 3으로 가정한다

    return result;
}


function getCountAsync(callback){ //비동기식
    let result = 0;
    //데이터가 로드된 후에
    //로드되는 시간이 3초라고 가정한다.
    setTimeout(function(){ //비동기형
        result = 3;//로드된 값을 3으로 가정한다.
        callback(result);
    }, 3000);

    //return result;
}


// function getCountAsyncUsingPromise(/*callbac){ //비동기식
//     let promise = new Promise(function(resolve, reject){

//         setTimeout(function(){
//             let result = 3;
//             resolve(result);
//         }, 3000);
//         console.log("end function");
//     });
    
//     return promise;
// }


// getCountAsync(function(count){ //함수를 전달해서 결과값을 얻는 과정이지만...업무적으로 함수를(반환값) 얻는것인가..필요한 정보를 전달해주는가..싶어서 나온것이 결과값만 얻는promise
//     console.log(count);
// });

//위의 같이 콜백함수를 이용한 반환 값의 문제점
//1. 파라미터가 업무로직을 위한 값이 아니라 반환을 위한 값이 전달되어야 하는가
// let result = addSync(3,4);//동기
// addAysnc(3,4,function(result){}); //비동기

//1번째 방법
// let promise = getCountAsyncUsingPromise(); //1. 함수를 불러와서
// promise.then(function(result){ //2. then성공값? 반환값만 불러오면 호출할 수 있다.
//     console.log(`첫 번째 호출 ${result}`); //3. 성공된 반환값이 무엇인지 출력
// }); 

// //2번째 방법
// getCountAsyncUsingPromise()
// .then(function(result){
//     console.log(`두 번째 호출 ${result}`);
// });

// //3번쨰 방법
// async function printCount(){
//     let result = await getCountAsyncUsingPromise(); //await기다렸다가 결과값을 받겠다.
//     console.log(`세 번째 호출 ${result}`);
// } //기다리게하는방법, 동기형식으로

// printCount();

// (async function(){ //(async ()=> )
//     let result = await getCountAsyncUsingPromise();
// })();

// //--------------------------------------------------------------

// function add(x,y){ //비동기식
//     let promise = new Promise(function(resolve, reject){

//         setTimeout(function(){
//             let result = 3+x+y;

//             if(result > 10){
//                 reject("너무 큰 값이 계산되었다.");
//                 return;
//             }
//             resolve([{kor:10,eng:10},{kor:20,eng:20}]);
//         }, 3000);
//         console.log("end function");
//     });
    
//     return promise;
// }


// add(2,9,function(result){
//     console.log(result);
// });

/*
add(2,3)
.then(function(list){
    return list[0];
}, function(err){
    console.log(`err:${err}`);
})
.then(function(exam){
    return exam.kor;
})
.then(function(kor){ //계속 이어갈 수 있다.
    console.log(`kor:${kor}`)
}); */

//-----------------------------------------------------------------------





/*function getNotice(){ //Promise사용전 기존 문제점
    // JDBC like 라이브러리
    //let con = connection(); 자바스크립트에서는 이렇게 하지 않는다.
    let notice = null;
    query(function(result){ //콜백함수를 
        notice = result.set; 
    });

    return notice;
}

let notice = getNotice(); //위가 처리되고 이쪽으로 주는거지 실행하기전에 값이 오진 않는다.
console.log(notice);*/



// ---- Generator ---------------
// class MissileContainer{
//     #missiles
//     #index; // 누적을 위한 위치 인덱스
//     //#current;
//     constructor(){
//         this.#missiles = [];
//         this.#index = 0;
//         //this.#current = 0;
//     }

//     add(missile){
//         this.#missiles[this.#index] = missile;
//         this.#index++;
//     }

// }



// function* aa(){

//     for(let i=0; i<100; i++)
//      yield i+1;
//     // yield 1;
//     // yield 2;
//     // yield 3;
//     // yield 4;
//     // yield 5;

// }

// let it = aa();

// console.log(it.next().value);
// console.log(it.next().value);
// console.log(it.next().value);
// console.log(it.next().value);
// console.log(it.next().value);
// console.log(it.next().value);
// console.log(it.next().value);
// console.log(it.next().value);
// console.log(it.next().value);
// console.log(it.next().value);
// console.log(it.next().value);
// console.log(it.next().value);
// console.log(it.next().value);


    // next(){
    //     current++
    // }
    // 연산 Computed Property

// const aa = "kor";

// let obj = {
//     [aa]:1,
//     eng:2
// };

// console.log(obj.kor);


//------Interator 맨땅에 구현
// class MissileContainer {
//     #missiles
//     #index; //누적을 위한 위치 인덱스
//     #current;
//     constructor() {
//         this.#missiles = [];   //미사일은 배열이고     
//         this.#index = 0; //초기값은 0
//         //this.#current = 0;
//     }

//     add(missile) {
//         this.#missiles[this.#index] = missile; //마시일을 채우자
//         this.#index++
//     }
// }

//     // //자바에서 outer class
//     // class A{
//     //     private int a;

//     //     //inner class : nested class
//     //     class B{
//     //         private int b;
//     //         public void f1(){
//     //             this.b=3;
//     //         }

//     //     }
//     // }


//     iteration(){
//         return new this.MissileIterator(this.#missile, this.#index);
//     }

//     MissileContainer = class { //중첩클래스를 쓰는 방식
//         #current;
//         #missiles;
//         #index;

//         constructor(missile, index) {
//             this.#missile = missile;
//             this.#current = 0;
//             this.#index = index;
//         }

//         next() {
//             let value = this.#missiles[this.#current];
//            this.#current++;

//            //index : 2
//            // current : 1

//            let done = this.#index == this.#current;


//            return {value, done};
//         }
//     };


// let mc = new MissileContainer();
// mc.add("미사일1");
// mc.add("미사일2");

// let it = mc.iteration();
// //미사일을 꺼내보고 싶으면 iteration 하고싶다.
// let result = it.next();
// while (!result.done){
//     console.log(result.value); //미사일1, 미사일2
//     result = it.next();
// }


// it = mc.iteration();
// console.log(it.next());
// console.log(it.next());
// console.log(it.next());

// console.log(it.next()); //첫번째 미사일
// console.log(it.next()); //두번쨰 미사일





//----------javascript Object Oriented Programming-------------
// class Exam{
//     #kor;
//     #eng;
//     #math;

//     constructor(kor=0, eng=0, math=0 ){ //1 .생성자
//         this.#kor = kor;
//         this.eng = eng;
//         this.math = math;

//         console.log(new.target == NewlecExam);
//     }

//     set kor(kor){
//         this.#kor = kor;
//     }

//     get kor(){
//         return this.#kor;
//     }


//     total(){ //2
//        return this.#kor + this.#eng + this.#math;

//     }
// }

// // inheritacne
// class NewlecExam extends Exam{
//     #com;

//     //overload
//     constructor(kor=0, eng=0, math=0, com=0){
//         super(kor, eng, math);
//         this.#com = com;
//     }

//     //override
//     total(){
//         return super.total() + this.#com;
//     }
// }

// // Exam.prototype.aa = function(){
// //     return 10;
// // }

// let exam = new NewlecExam(1,1,1,1); //예는 1을 보지못함.. -> 2에서만 받아온다
// console.log(exam.total()); //exam타입은 object이다. Exam타입은 함수이다. 키워드만 class이고 불러오는건 함수!

// for(let k in exam){
//     console.log(k);
// }

// Array.prototype.이후이후이 = function(){
//     console.log("나는 출력");
// };
// let aa = [1,1,2];
// aa.이후이후이();


//함수만드는 두가지 방법

//행위 또는 처리하는 함수
// function pring(){ //예는 함수다
//     console.log(this === window); //여기서 쓰이는 this는 window객체이다.
// }

// print();

// //데이터 객체를 만들어서 초기화 하는 목적의 함수 : 생성자 함수
// function Exam(){ //예는 자료형이되고
//     console.log(this);
//     this.kor = 0;
//     this.eng = 10;
//     this.math = 20;
// }

// Exam.prototype.aa= [2,3,4];
// Exam.prototype.total = function(){
//         //1. 지역변수
//         //2. 매개변수
//         //3. 넘겨받은 this 인스턴스
//         return this.kor+this.eng+this.math;
//     }

// //어떤 total이 출력되는걸까 -> total이라는 함수에서 가져온다. Exam은 볼 수 없다.

// let exam1 = new Exam();
// let exam2 = new Exam();
// console.log(exam1.total === exam2.total);



//2. iterator : Es6에서부터 지원하는 새로운 방법
// -> for-of : 값을 뽑아주는 제어구조
// for (let v of arr)

//     console.log(v);

// let ob1 = {};
// let ob2 = {};

// let s1 = "hello";
// let s2 = "hello";

// let set = new Set();
// set.add(ob1);
// set.add(ob2);

// //ob1 = null;

// console.log(set.size);


// let exam = new Map();
// exam.set("kor",10);
// exam.set("eng",20);
// exam.set("math",40);

// for(let k of exam.keys())
//     console.log(exam.get(k));

// for(let v of exam.values()) //값을 뽑고싶으면 values
//     console.log(v);

// for(let [k, v] of exam.entries()) //값을 뽑고싶으면 values
//     console.log(`key:${k}, value:${v}`);

// exam.forEach((v, k, obj)=>{
//     console.log(`key:${k}, value:${v}`);
// });

// Rest Operator
//function print(x, y, ...restvalues){};

// Spread Operator
// function print(x,y,z){};
// let arr = [1,2,3];
// print(...arr);
// console.log(print);

// Default values
// function print(x, y=10){
//     console.log(arguments.length);
//     console.log(`x:${x}, y:${y}`);
// }

// print(10);

// let arr = [2,3,4,12,23,2,1,4,5,323,1];
// arr.sort((a, b)=>a-b);
// console.log(arr);