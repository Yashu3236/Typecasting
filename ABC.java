class GettersandSetters {
    int a;
    int b;

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    boolean compare(GettersandSetters ob) {
        return this.a == ob.a;
    }
}

public class ABC {
    public static void main(String[] args) {
        GettersandSetters ob1 = new GettersandSetters();
        ob1.setA(23);

        GettersandSetters ob2 = new GettersandSetters();
        ob2.setA(23);

        GettersandSetters ob3 = new GettersandSetters();
        ob3.setA(40);

        System.out.println(ob1.compare(ob2));
        System.out.println(ob1.compare(ob3));
    }
}
