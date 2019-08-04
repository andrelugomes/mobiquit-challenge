package com.mobiquityinc.tescase;

import java.util.Objects;

/**
 * A Package
 */
public class Package implements Comparable<Package> {

    public static final String MONEY_SYMBOL = "€";

    private Integer index;
    private Double weight;
    private Double cost;

    public Package(final String textToTransform) {
        String[] fields = textToTransform.split(",");
        this.index = Integer.valueOf(fields[0]);
        this.weight = Double.valueOf(fields[1]);
        this.cost = Double.valueOf(fields[2].replaceAll(MONEY_SYMBOL, ""));
    }

    public Package(final Integer index, final Double weight, final Double cost) {
        this.index = index;
        this.weight = weight;
        this.cost = cost;
    }

    public Integer getIndex() {
        return index;
    }

    public double getWeight() {
        return weight;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public int compareTo(final Package o) {
        return Integer.compare(this.getIndex(), o.getIndex());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Package p = (Package) o;
        return Objects.equals(index, p.index) && Objects.equals(weight, p.weight) && Objects.equals(cost, p.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, weight, cost);
    }

    @Override
    public String toString() {
        return "Package{index=" + index + ", weight=" + weight + ", cost=" + cost + '}';
    }
}
