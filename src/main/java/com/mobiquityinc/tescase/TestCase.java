package com.mobiquityinc.tescase;

import java.util.Set;

/**
 * A set of test cases containing the maxWeight e packages
 *
 */
public class TestCase {

    private Integer maxWeight;
    private Set<Package> packages;

    public TestCase(final Integer maxWeight, final Set<Package> packages) {
        this.maxWeight = maxWeight;
        this.packages = packages;
    }

    public Integer getMaxWeight() {
        return maxWeight;
    }

    public Set<Package> getPackages() {
        return packages;
    }

    @Override
    public String toString() {
        return "TestCase{maxWeight=" + maxWeight + ", packages=" + packages + '}';
    }
}
