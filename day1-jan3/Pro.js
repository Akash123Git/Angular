var Student = /** @class */ (function () {
    function Student(roll, name, age, marks) {
        if (roll === void 0) { roll = undefined; }
        if (name === void 0) { name = undefined; }
        if (age === void 0) { age = undefined; }
        if (marks === void 0) { marks = undefined; }
        this.roll = roll;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }
    Student.prototype.show = function () {
        console.log("roll: ", this.roll, " name: ", this.name, " age: ", this.age, " marks: ", this.marks);
    };
    return Student;
}());
var ob1 = new Student(101, "name", 25, 76);
var ob2 = new Student();
ob1.show();
ob2.show();
