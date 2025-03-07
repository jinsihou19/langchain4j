package dev.langchain4j.store.embedding.filter.comparison;

import dev.langchain4j.data.document.Metadata;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class IsLessThanOrEqualToTest extends AbstractComparisonTest<IsLessThanOrEqualTo> {

    @BeforeEach
    void setUp() {
        subject = new IsLessThanOrEqualTo("key", 5);
    }

    @ParameterizedTest
    @CsvSource({
        "0, true",
        "4, true",
        "5, true",
        "6, false"
    })
    void testComparisonValue(Integer value, boolean expectedResult) {
        Map<String, Integer> t = new LinkedHashMap<>();
        t.put("key", value);
        Metadata metadata = Metadata.from(t);
        assertThat(subject.test(metadata)).isEqualTo(expectedResult);
    }

}
