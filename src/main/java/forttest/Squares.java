package forttest;

public class Squares {
    public float kvadrat(float width){
        return width*width;
    }

    public boolean isSimple(int number){
        if(number <= 1) return false;
        for(int i = 2; i < number; i++){
            if(number % i == 0) return false;
        }
        return true;
    }

    public boolean simpleNum(int value) {
        for (int i = 2; i < value; i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }
}
