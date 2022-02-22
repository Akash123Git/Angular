class Student{
    private roll:number;
    private name:string;
    private age:number;
    private marks: number;

    public constructor(roll:number=undefined,name:string=undefined,age:number=undefined,marks:number=undefined){
        this.roll=roll
        this.name=name
        this.age=age
        this.marks=marks
    }

    public show(): void
    {
        console.log("roll: ",this.roll," name: ",this.name," age: ",this.age," marks: ",this.marks);
    }
}

var ob1=new Student(101,"name",25,76);
var ob2=new Student()

ob1.show();
ob2.show();