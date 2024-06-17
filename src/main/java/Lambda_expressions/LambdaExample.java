package Lambda_expressions;

//Traditional way de como lo hacias antes

// Functional Interface = an interface that contains only one abstract method

interface  shape{
    void draw();
}

/*
class Rectangle implements shape{
    @Override
    public void draw(){
        System.out.println("Drawing a rectangle");
    }
}

class Square implements shape{
    @Override
    public void draw(){
        System.out.println("Drawing a square");
    }
}

class Circle implements shape{
    @Override
    public void draw(){
        System.out.println("Drawing a circle");
    }
}

*/


public class LambdaExample {
    public static void main(String[] args) {
        //shape myShape = new Rectangle();
        //myShape.draw();

        //shape myShape = new Square();
        //myShape.draw();

        //shape myShape = new Circle();
        //myShape.draw();

   //Lambda way : functon - IMPLEMENT A FUNCTIONAL INTERFACE
        shape rectangle = () ->
                System.out.println("Drawing a rectangle");
//        rectangle.draw();
        print(rectangle);

        shape square = () ->
                System.out.println("Drawing a square");
        square.draw();

        shape circle = () ->
                System.out.println("Drawing a circle");
        circle.draw();
    }

    // Aqui dentro del parentesis va cualquier objeto que implemente la interfaz shape
    public static void print(shape shape){
        shape.draw();
    }
}
