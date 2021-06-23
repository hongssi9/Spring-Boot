export default class Exam{
    #kor;
    #eng;
    #math

    constructor(kor=0, eng=0, math=0){
        this.#kor = kor;
        this.#eng = eng;
        this.#math = math;
    }

    set kor(kor){
        this.#kor = kor;
    }

    get kor(){
        return this.#kor;
    }

    total(){
        return this.#kor + this.#eng + this.#math;
    }
    
}
