package com.mobiquityinc.calculator;

import com.google.common.collect.Sets;
import com.mobiquityinc.tescase.TestCase;
import com.mobiquityinc.tescase.Package;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class PackageCalculatorTest {

    @Test
    public void shouldCalculateThing() {
        //81 : (1,53.38,€45) (2,88.62,€98) (3,78.48,€3) (4,72.30,€76) (5,30.18,€9) (6,46.34,€48)

        Package package1 = new Package(1, 53.38, 45d);
        Package package2 = new Package(2, 88.62, 98d);
        Package package3 = new Package(3, 78.48, 3d);
        Package package4 = new Package(4, 72.30, 76d);
        Package package5 = new Package(5, 30.18, 9d);
        Package package6 = new Package(6, 46.34, 48d);

        TestCase testCase = new TestCase(81, Sets.newHashSet(package1, package2, package3, package4, package5, package6));

        Set<Package> result = PackageCalculator.calculate(testCase);

        assertThat(result, equalTo(Sets.newHashSet(new Package(4, 72.30, 76d))));
    }
}