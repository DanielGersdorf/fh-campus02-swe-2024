package at.campus02.swe.logic;


import at.campus02.swe.Calculator;
import at.campus02.swe.CalculatorException;

import java.util.Stack;

public class CalculatorImpl implements Calculator {

    private Stack<Double> stack_ = new Stack<Double>();

    @Override
    public double perform(Operation op) throws CalculatorException {

        if (op.equals(Operation.cos))
        {double c = pop();
            return Math.cos(c);}

        if (op.equals(Operation.sin))
        {double c = pop();
            return Math.sin(c);}

        if (op.equals(Operation.dotproduct)) {
            if (stack_.empty()) {
                throw new CalculatorException("Stack is empty");
            } else {
                double vektorsize = pop();
                double result = 0.0;
                double[] a = new double[(int) vektorsize];
                double[] b = new double[(int) vektorsize];

                for (int i = 0; i < vektorsize; i++) {
                    b[i] = pop();
                }

                for (int i = 0; i < vektorsize; i++) {
                    a[i] = pop();
                }

                for (int i = 0; i < vektorsize; i++) {
                    result += a[i] * b[i];
                }

                return result;
            }
        }


        else {
        double b = pop();
        double a = pop();

        switch (op) {
            case add:
                return a + b;
            case sub:
                return a - b;
            case div:
                double c = a / b;
                if (Double.isInfinite(c))
                    throw new CalculatorException("Division by zero");
                return c;
            case modulo:
                if (b == 0) { // Prüfe den Divisor direkt
                    throw new CalculatorException("Modulo by zero");
                }
                return a % b;
            case mul:
                return a * b;
        }
        return 0;}
    }

    @Override
    public double pop() throws CalculatorException {
        if (stack_.isEmpty())
            throw new CalculatorException("Zu Wenig Input");
        return stack_.pop();
    }

    @Override
    public void push(double v) {
        stack_.push(v);
    }

    @Override
    public void clear() {
        stack_.clear();
    }



}
