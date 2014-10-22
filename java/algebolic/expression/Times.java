// This file is part of algebolic. Copyright (C) 2014-, Jony Hudson.
//
// Not for distribution.

package algebolic.expression;

import java.util.ArrayList;
import java.util.List;

public class Times extends BinaryExpr {

    public Times(JExpr arg1, JExpr arg2) {
        super(arg1, arg2);
    }

    @Override
    public double evaluate(List<Double> vars) {
        return arg1.evaluate(vars) * arg2.evaluate(vars);
    }

    @Override
    public double[] evaluateD(List<Double> vars) {
        int n = vars.size();
        double[] res = new double[n + 1];

        double[] a1v = arg1.evaluateD(vars);
        double[] a2v = arg2.evaluateD(vars);

        res[0] = a1v[0] * a2v[0];

        // Product rule for each variable.
        for (int i = 0; i < n; i++) {
            res[i + 1] = (a1v[0] * a2v[i + 1]) + (a1v[i + 1] * a2v[0]);
        }
        return res;
    }
}
