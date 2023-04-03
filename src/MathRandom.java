public class MathRandom {
    private int num1;
    private int num2;
    private int options;
    private int correct;

    public MathRandom() {}

    public MathRandom(int num1, int num2, int options) {
        this.num1 = num1;
        this.num2 = num2;
        this.options = options;
    }

    public String Random(int num1, int num2, int options){
        String text = "";
        if (options == 0){
            text = "Zadanie: " + num1 + "+" + num2 + ": ";
            correct = num1 + num2;
        } else{
            text = "Zadanie: " + num1 + "-" + num2 + ": ";
            correct = num1 - num2;
        }

        return text;
    }

    public int getCorrect() {
        return correct;
    }
}
