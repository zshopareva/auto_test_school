public class Treangle {

    public boolean isTreangle(int a, int b, int c){
        if((a + b > c) && (b + c > a) && (c + a > b)) {
            return true;
        }
        return false;
    }
}
