//**SEE BELOW** Add in the code for the interfaces below 
public class TestClass {

    //DO NOT MODIFY THIS METHOD
    public static void main(String[] args) {
        C2 x = new C2();

        System.out.println(x instanceof I1);
        System.out.println(x instanceof I2);
        System.out.println(x instanceof I3);
        System.out.println(x instanceof I4);
        System.out.println(x instanceof I5);
        System.out.println(x instanceof C1);

        C3 y = new C3();

        System.out.println(y instanceof I1);
        System.out.println(y instanceof I2);
        System.out.println(y instanceof I3);
        System.out.println(y instanceof I4);
        System.out.println(y instanceof I5);

    }
}

// Modify from here onwards .... 
// Add and modify the code for interfaces and classes according to the question

interface I1{
    int p1();
}

class C3 implements I5 {

    @Override
    public int p5() { return 0;}

}

