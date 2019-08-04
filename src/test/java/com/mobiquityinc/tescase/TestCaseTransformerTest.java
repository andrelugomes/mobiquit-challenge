package com.mobiquityinc.tescase;

import com.mobiquityinc.exception.TestCaseTransformerException;
import com.mobiquityinc.exception.ConstraintException;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TestCaseTransformerTest {

    @Test
    public void shouldTransformATestCaseStringInTestCaseObject() {

        TestCase testCase = TestCaseTransformer.transform("81 : (1,53.38,€45) (2,88.62,€98)");

        Package package1 = new Package(1, 53.38, 45d);
        Package package2 = new Package(2, 88.62, 98d);

        assertThat(testCase.getMaxWeight(), is(81));

        assertThat(testCase.getPackages().size(), is(2));

        assertThat(testCase.getPackages(), hasItems(package1, package2));

    }

    @Test(expected = TestCaseTransformerException.class)
    public void shouldNotTransformWithoutColon() {

        TestCaseTransformer.transform("81 (1,53.38,€45) (2,88.62,€98)");
    }

    @Test(expected = TestCaseTransformerException.class)
    public void shouldNotTransformWithoutThings() {

        TestCaseTransformer.transform("81 :");
    }

    @Test(expected = TestCaseTransformerException.class)
    public void shouldNotTransformWithoutMaxWeight() {

        TestCaseTransformer.transform(": (1,53.38,€45) (2,88.62,€98)");
    }

    @Test(expected = TestCaseTransformerException.class)
    public void shouldNotTransformWithWrongFormat() {

        TestCaseTransformer.transform("10 : (1,53.38,$45)(2,88.62,%98)");
    }

    @Test
    public void shouldTransformWithWrongFormatButValid() {

        TestCase testCase = TestCaseTransformer.transform("100 : 1,53.38,€45 2,88.62,98");

        Package package1 = new Package(1, 53.38, 45d);
        Package package2 = new Package(2, 88.62, 98d);

        assertThat(testCase.getMaxWeight(), is(100));

        assertThat(testCase.getPackages().size(), is(2));

        assertThat(testCase.getPackages(), hasItems(package1, package2));
    }

    @Test(expected = ConstraintException.class)
    public void shouldNotValidateLineWithMaxWeightBiggerThan100() {

        TestCaseTransformer.transform("101 : (1,53.38,€45) (2,88.62,€98)");
    }

    @Test(expected = ConstraintException.class)
    public void shouldNotValidateLineWithMaxWeightFormPackagesBiggerThan100() {

        TestCaseTransformer.transform("10 : (1,53.38,€450) (2,88.62,€98)");
    }

    @Test(expected = ConstraintException.class)
    public void shouldNotValidateLineWithCostFormPackagesBiggerThan100() {

        TestCaseTransformer.transform("10 : (1,53.38,€45) (2,102.62,€98)");
    }
}