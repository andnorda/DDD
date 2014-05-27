package probability;

import java.math.BigDecimal;

public class Probability {

    private final float percent;

    public Probability(BigDecimal percent) {
        this(percent.floatValue());
    }

    private Probability(float percent) {
        if (!isValid(percent)) {
            throw new IllegalArgumentException();
        }
        this.percent = percent;
    }

    private boolean isValid(float percent) {
        return percent > 0 && percent < 1;
    }

    public Probability combinedWith(Probability probability) {
        return new Probability(probability.percent * this.percent);
    }

    public Probability inverseOf() {
        return new Probability(1f - this.percent);
    }

    public Probability either(Probability probability) {
        return new Probability(this.percent + probability.percent - this.percent * probability.percent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Probability)) return false;

        Probability that = (Probability) o;

        return Float.compare(that.percent, percent) == 0;

    }

    @Override
    public int hashCode() {
        return (percent != +0.0f ? Float.floatToIntBits(percent) : 0);
    }

    @Override
    public String toString() {
        return String.valueOf(this.percent);
    }
}
