package edu.drexel.se320;

// Note that if you forget the * at the end of this, Java will complain that com.google.common does
// not exist, which is a bug
import static com.google.common.base.Preconditions.*;

public class Contracts {
    private int denominator = 1;
    private int numerator = 1;

    public void setNumerator(int x) {
        numerator = x;
    }
    public void setDenominator(int x) {
        checkArgument(x != 0, "Can't set denominator to 0");
        denominator = x;
    }
    public double asDecimal() {
        checkState(denominator != 0, "denominator was 0!");
        return ((double)numerator)/denominator;
    }
}
