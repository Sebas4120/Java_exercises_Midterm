package Annonymous_Inner_Class;

public class Main {

    public static void main(String[] args) {

        /*anonymous class = an inner class without a name
                            only a single object is created from one
                            The object may have “extras” or "changes"
                             and no need to create a separate innerclass
                                when it only need it once.
                            Helps us to avoid cluttering code with a class name

                            Syntax is similar to a constructor,
                            except that there is also a class definition
                            within a block of code.
                            GREAT FOR LISTENERS
  */

 //Asi lo hariamos normalmente no?, creamos una clase que tiene un metodo. Lego instantiamos esa
 // clase y con el object de esa clase usamos el metodo 'Greeting'
        Welcome welcome = new Welcome();

        welcome.Greeting();

        //Ahora mira como usamos Anonymous Inner class
        Welcome welcome2 = new Welcome(){
            @Override
            public void Greeting(){
                System.out.println("Hey Yo!");
            }
        };

        welcome2.Greeting();
    }






}
