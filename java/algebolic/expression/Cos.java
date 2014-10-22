// This file is part of algebolic. Copyright (C) 2014-, Jony Hudson.
//
// Not for distribution.

package algebolic.expression;

import java.util.List;

public class Cos extends UnaryExpr {

    public Cos(JExpr arg1) {
        super(arg1);
    }

    @Override
    public double evaluate(List<Double> vars) {
        return Math.cos(arg1.evaluate(vars));
    }

    @Override
    public double[] evaluateD(List<Double> vars) {
        int n = vars.size();
        double[] res = new double[n + 1];

        double[] a1v = arg1.evaluateD(vars);

        res[0] = Math.cos(a1v[0]);

        // Calculate the derivative using the chain rule.
        double s = -1.0 * Math.sin(a1v[0]);
        for (int i = 0; i < n; i++) {
            res[i + 1] = a1v[i + 1] * s;
        }
        return res;
    }
}
