import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class MyPolynomial {
    private double[] coeffs;

    public MyPolynomial(double... coeffs) {
        for (int i = 0; i < coeffs.length; i++)
            this.coeffs = coeffs;
    }

    public MyPolynomial(String poly) {
        Scanner in = null;
        try {
            in = new Scanner(new File(poly)); // open file
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int degree = in.nextInt(); // read the degree
        coeffs = new double[degree + 1]; // allocate the array
        for (int i = 0; i < coeffs.length; ++i) {
            coeffs[i] = in.nextDouble();
        }
    }

    public int getDegree() {
        int degree;
        degree = coeffs.length - 1;
        return degree;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < coeffs.length; i++) {
            if (i > 0) {
                if (i == 1) {
                    s = "+" + s;
                } else {
                    s = "x^" + i + "+" + s;
                }
            }
            s = Math.abs(coeffs[i]) + s;

            if (coeffs[i] >= 0 && i < coeffs.length - 1) {
                s = " + " + s;
            } else {
                if (coeffs[i] < 0) {
                    s = " - " + s;
                }
            }
        }
        return s;
    }
    public double evaluate(double x) {
        double acc = 0;
        for (int i = 0; i < coeffs.length; i++) {
            acc = coeffs[i] * Math.pow(x, i);
        }
        return acc;
    }

    public MyPolynomial add(MyPolynomial poly) {
        MyPolynomial polyResult;
        double[] result;
        int degree = getDegree();
        if (poly.getDegree() > degree) {
            degree = poly.getDegree();
        }
        result = new double[degree - 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = 0;
        }
        for (int i = 0; i < coeffs.length; i++) {
            result[i] = coeffs[i];
        }
        for (int i = 0; i < poly.coeffs.length; i++) {
            result[i] += poly.coeffs[i];
        }
        polyResult = new MyPolynomial(result);
        return polyResult;
    }

}

