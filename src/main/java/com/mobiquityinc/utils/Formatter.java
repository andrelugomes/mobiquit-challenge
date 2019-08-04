package com.mobiquityinc.utils;

import com.mobiquityinc.tescase.Package;

import java.util.Set;
import java.util.stream.Collectors;

public final class Formatter {

    private Formatter() {
    }

    public static String toStrings(final Set<Package> packages) {
        return packages.size() == 0 ? "-" : packages.stream().map(Package::getIndex)
                .map(integer ->  String.valueOf(integer)).collect(Collectors.joining(","));
    }
}
