# Java程序设计实验
## 实验四、五、六
### 四、继承
【实验项目内容】<br>
学校中本科学生有姓名，学号，成绩，学习本科课程内容。<br>
学校中研究生有有姓名，学号，成绩，还有奖学金，学习研究生课程内容，做项目研究。<br>
对给出需求进行数据建模。<br>
【实验目的】<br>
1.  按照课上所写程序员与经理向上抽取成雇员，定义出私有的成员变量，构造函数<br>
2. 熟悉继承中的子类在new对象时构造函数在第一行先执行父类构造函数的用法<br>
3. 熟悉super关键字，做为父类构造函数的用法<br>
4. 熟悉对于父类私有成员属性，提供公有的get方法<br>
5. 熟悉父类的共有方法与子类的特有方法的用法<br>
6. 熟悉子类对父类的共有方法的重写<br>
【实验代码】<br>
```java
class Stu{
    private String name;
    private int number;
    private double grade;
    Stu(String name,int number,double grade){
        this.name = name;
        this.number = number;
        this.grade = grade;
    }
    public String getName(){
        return name;
    }
    public int getNumber(){
        return number;
    }
    public double getGrade(){
        return grade;
    }
    void study(){
        System.out.println("Studying");
    }
}

class undergraduate extends Stu{
    undergraduate(String name,int number,double grade){
        super(name,number,grade);
    }
    void study(){
        System.out.println(getName() + " undergraduate studying");
    }
}

class postgraduate extends Stu{
    private int scholarship;
    postgraduate(String name,int number,double grade,int scholarship){
        super(name,number,grade);
        this.scholarship = scholarship;
    }
    void study() {
        System.out.println(getName() + " postgraduate studying");
    }
    void projectstudy() {
        System.out.println(getName() + " making project");
    }
}


public class test1 {

    public static void main(String []args){
        undergraduate zzz = new undergraduate("wang",13,10.0);
        postgraduate ttt = new postgraduate("Tan",16,100.0,8000);
        System.out.println("name = "+zzz.getName() +",number = "+ zzz.getNumber() +",grade = "+  zzz.getGrade());
        zzz.study();
        ttt.study();
        ttt.projectstudy();
    }
}
```
### 五、类的继承与接口的实现
【实验项目内容】<br>
1. 导盲犬Dog和导盲机器人Robot抽取共性内容，导盲功能guide()放在导盲接口Guide中<br>
2. 导盲犬继承犬类<br>
3. 导盲机器人继承机器类<br>
4. 犬类Canidae中有犬种type，身height，体重weight三个成员变量，一个吼叫方法bark()<br>
5. 机器类Machine有型号type成员变量<br>
6. 根据不同的对象，得到其描述信息，实现导盲方法<br>

【实验目的】<br>
1. 熟悉java中单继承的特点<br>
2. 熟悉Java中多实现的特点<br>
【实验代码】<br>
```java
interface Guide{
    public abstract void guide();
}

class Canidae {
    String type;
    double height;
    double weight;

    Canidae(String type, double height, double weight) {
        this.type = type;
        this.height = height;
        this.weight = weight;
    }

    void bark() {
        System.out.println(type + " " + height + " " + weight + " 吼叫");
    }
}

class Machine{
    String type;
    Machine(String type){
        this.type = type;
    }
}

class Dog extends Canidae implements Guide{
    Dog(String type,double height,double weight){
        super(type, height, weight);
    }
    public void guide(){
        System.out.println(type + "在导盲");
    }
}
class Robot extends Machine implements Guide {
    Robot(String type) {
        super(type);
    }

    public void guide() {
        System.out.println(type + "在导盲");
    }
}

public class test2{
    public static void main(String []args){
        Dog d1 = new Dog("拉布拉多",110,80);
        d1.bark();
        d1.guide();
        Robot r1 = new Robot("智能机器人");
        r1.guide();
    }
}
```
### 六、多态
【实验项目内容】<br>
1. 三角形Triangle，圆形Circle与正方形Rectangle都有其面积公式，根据这一共性内容，向上抽取出形状类Shape或接口，在该类中有面积的抽象方法 area()<br>
2. 在三角形，圆形与正方形中重写其父类的抽象方法<br>
3. 在主类中，写一个getArea()方法，形参是父类的引用变量，实参传递子类的对象，形成多态<br>
4. 根据不同的对象，得到其面积具体的值<br>

【实验目的】<br>
1. 运用多态实现父类共有方法

【实验代码】<br>
```java
abstract class Shape{
    abstract double area();
}

class Triangle extends Shape{
    double d;
    double h;
    Triangle(double d,double h){
        this.d = d;
        this.h = h;
    }
    double area(){
        return 1.0/2*d*h;
    }
}

class Circle extends Shape{
    double r;
    Circle(double r){
        this.r = r;
    }
    double area(){
        return Math.PI*r*r;
    }
}

class Rectangle extends Shape{
    double a;
    Rectangle(double a){
        this.a = a;
    }
    double area(){
        return a*a;
    }
}

public class test3 {
    public static void main(String []args){
        Shape s1 = new Triangle(1,2);
        getArea(s1);
        Shape s2 = new Circle(1);
        getArea(s2);
        Shape s3 = new Rectangle(1);
        getArea(s3);
    }
    public static void getArea(Shape s){
        if(s instanceof Triangle){
            Triangle ss = (Triangle)s;
            System.out.println("三角形的面积"+ss.area());
        }
        else if(s instanceof Circle){
            Circle ss = (Circle)s;
            System.out.println("圆形的面积是"+ss.area());
        }
        else if(s instanceof Rectangle){
            Rectangle ss = (Rectangle)s;
            System.out.println("正方形的面积是"+ss.area());
        }
    }
}
```