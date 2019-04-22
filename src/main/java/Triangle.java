public class Triangle {

    private int a;
    private  int b;
    private int c;

    Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    boolean isTriangle(){
        return (a + b > c) && (b + c > a) && (c + a > b);
    }
}
