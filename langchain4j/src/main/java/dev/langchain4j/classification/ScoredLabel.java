package dev.langchain4j.classification;

import java.util.Objects;

/**
 * Represents a classification label with score.
 *
 * @param <L> The type of the label (e.g., String, Enum, etc.)
 */
public final class ScoredLabel<L> {
    private final L label;
    private final double score;

    public ScoredLabel(L label, double score) {
        this.label = label;
        this.score = score;
    }

    public L label() {
        return label;
    }

    public double score() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScoredLabel<?> that = (ScoredLabel<?>) o;
        return Double.compare(that.score, score) == 0 &&
                Objects.equals(label, that.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, score);
    }

    @Override
    public String toString() {
        return "ScoredLabel[" +
                "label=" + label +
                ", score=" + score +
                ']';
    }
}
