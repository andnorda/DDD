package probability;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ProbabilityTest {

    Probability half = new Probability(new BigDecimal(0.5));
    Probability quarter = new Probability(new BigDecimal(0.25));
    Probability threeQuarters = new Probability(new BigDecimal(0.75));

    @Test (expected = IllegalArgumentException.class)
    public void shouldNotTakeDecimalOverOne() {
        new Probability(new BigDecimal(42));
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldNotTakeDecimalUnderZero() {
        new Probability(new BigDecimal(-1));
    }

    @Test
    public void shouldEqual() {
        assertEquals(half, half);
        assertNotEquals(quarter, half);
    }

    @Test
    public void shouldComputeCombinedProbability() {
        assertEquals(quarter, half.combinedWith(half));
    }
    
    @Test
    public void shouldComputeInverse() {
        assertEquals(quarter, threeQuarters.inverseOf());
    }

    @Test
    public void shouldComputeProbabilityOfEither() {
        assertEquals(threeQuarters, half.either(half));
    }
}

