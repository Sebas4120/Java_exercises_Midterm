package Lambda_expressions;

//Traditional way de como lo hacias antes
interface Addable{
    int addition(int a, int b);
}

class AddableImpl implements Addable{
    @Override
    public int addition(int a, int b){
        return a+b;
    }
}

public class Lambda_Parameters {

    public static void main(String[] args) {


        Addable addition = (int a, int b) -> (a + b);
        addition.addition(10, 20);
        };

    }


