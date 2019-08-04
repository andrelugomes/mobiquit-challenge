package com.mobiquityinc.calculator;

import com.google.common.collect.Sets;
import com.mobiquityinc.tescase.TestCase;
import com.mobiquityinc.tescase.Package;
import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;


/**
 * Calculate packages and optimizing Cost and Weight
 */
public final class PackageCalculator {

    private static final Logger LOGGER = Logger.getLogger(PackageCalculator.class);

    private PackageCalculator() {
    }

    /**
     * Given some Test Case
     * @param testCase
     * @return a Set of most value Packages
     */
    public static Set<Package> calculate(final TestCase testCase) {
        LOGGER.info("Calculating packages : " + testCase);
        Integer maxWeight = testCase.getMaxWeight();
        Set<Package> packages = testCase.getPackages();

        return getMostValuePackages(maxWeight, packages);
    }

    /**
     * Given some Test case,
     *
     * Find the best combination over all possibilities SETs os Packages
     * @param maxWeight
     * @param packages
     * @return
     */
    private static Set<Package> getMostValuePackages(final Integer maxWeight, final Set<Package> packages) {
        double cost = 0;
        double weight = 0;
        Set<Set<Package>> possibilities = Sets.powerSet(packages);
        Set<Package> mostValuePackages = Collections.EMPTY_SET;

        for (Set<Package> possibility : possibilities) {
            final double totalWeight = possibility.stream().mapToDouble(Package::getWeight).sum();
            if (totalWeight <= maxWeight) {
                final double totalCost = possibility.stream().mapToDouble(Package::getCost).sum();
                if (totalCost > cost || totalCost == cost && totalWeight < weight) {
                    cost = totalCost;
                    mostValuePackages = new TreeSet<>(possibility);
                    weight = totalWeight;
                }
            }
        }
        return mostValuePackages;
    }
}
