
public class Polynomials {
    public static void main(String[] args) {
        // Test program
// Can invoke with a variable number of arguments
        MyPolynomial p1 = new MyPolynomial(-1.1, -2.2, -3.3);
        MyPolynomial p2 = new MyPolynomial(1.1, 2.2, 3.3, 4.4, 5.5);
// Can also invoke with an array
        double[] coeffs = {1.2, 3.4, 5.6, 7.8};
        MyPolynomial p3 = new MyPolynomial(coeffs);
        MyPolynomial p = new MyPolynomial("poly.txt");
        System.out.println(p1);
        System.out.println(p1.evaluate(3));

    }
}
