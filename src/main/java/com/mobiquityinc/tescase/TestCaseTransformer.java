package com.mobiquityinc.tescase;

import com.mobiquityinc.exception.TestCaseTransformerException;
import com.mobiquityinc.exception.ConstraintException;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * TestCaseTransformer is a Parser that pase each line as a TestCase
 */
public final class TestCaseTransformer {

    private static final Logger LOGGER = Logger.getLogger(TestCaseTransformer.class);
    public static final String FILE_CONTAINS_LINE_WITH_WRONG_FORMAT = "File contains line with wrong format!";
    public static final int MAX = 100;

    private TestCaseTransformer() {
    }

    /**
     * Parser. Validate. Return
     * @param line
     * @return a valid TestCase(maxWeight, packages)
     * @throws TestCaseTransformerException
     */
    public static TestCase transform(final String line) throws TestCaseTransformerException {
        LOGGER.info("Transforming line : " + line);

        Integer maxWeight;
        Set<Package> packages;
        try {
            final String[] split = line.split(":");

            maxWeight = Integer.valueOf(split[0].trim());

            packages = Arrays.asList(split[1].trim().split(" ")).stream()
                    .map(s -> s.replaceAll("([()])", ""))
                    .map(Package::new)
                    .collect(Collectors.toSet());


        } catch (Exception e) {
            throw new TestCaseTransformerException(FILE_CONTAINS_LINE_WITH_WRONG_FORMAT, e);
        }
        return valid(new TestCase(maxWeight, packages));
    }

    private static TestCase valid(final TestCase testCase) {
        if (isMaxWeightFromTestCaseBiggerThan(testCase)) {
            throw new ConstraintException("There are test cases with max weight bigger than 100!");
        }
        if (hasMaxWeightOrCostFromTPackagesBiggerThan(testCase.getPackages())) {
            throw new ConstraintException("There are Packages with max weight or cost bigger than 100!");
        }
        return testCase;
    }

    private static boolean hasMaxWeightOrCostFromTPackagesBiggerThan(final Set<Package> packages) {
        return packages.stream().filter(p -> p.getWeight() > MAX || p.getCost() > MAX).count() > 0;
    }

    private static boolean isMaxWeightFromTestCaseBiggerThan(final TestCase testCase) {
        return testCase.getMaxWeight() > MAX;
    }
}
