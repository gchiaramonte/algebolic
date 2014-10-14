package algebolic.expression;

public class Plus implements Expression {
    private Expression arg1;
    private Expression arg2;

    public Plus(Expression arg1, Expression arg2) {
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    public double evaluate(double[] vars) {
       return arg1.evaluate(vars) + arg2.evaluate(vars);
    }
}
