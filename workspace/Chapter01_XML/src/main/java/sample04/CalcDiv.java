package sample04;

public class CalcDiv implements Calc {
    private int num;

    @Override
    public void calculate(int x, int y) {
        System.out.println(x + " * " + y + " = " + x*y);
    }
}