package dev.langchain4j.classification;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Represent the result of classification.
 *
 * @param <L> The type of the label (e.g., String, Enum, etc.)
 */
public final class ClassificationResult<L> {
    private final List<ScoredLabel<L>> scoredLabels;

    // 构造方法包含防御性拷贝
    public ClassificationResult(List<ScoredLabel<L>> scoredLabels) {
        this.scoredLabels = Collections.unmodifiableList(
                new ArrayList<>(Objects.requireNonNull(scoredLabels, "scoredLabels不能为null"))
        );
    }

    // 访问方法返回不可修改的列表
    public List<ScoredLabel<L>> scoredLabels() {
        return scoredLabels;
    }

    // 自动生成的equals方法
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClassificationResult)) return false;
        ClassificationResult<?> that = (ClassificationResult<?>) o;
        return Objects.equals(scoredLabels, that.scoredLabels);
    }

    // 自动生成的hashCode
    @Override
    public int hashCode() {
        return Objects.hash(scoredLabels);
    }

    // 类似record的toString格式
    @Override
    public String toString() {
        return "ClassificationResult[scoredLabels=" + scoredLabels + "]";
    }
}
