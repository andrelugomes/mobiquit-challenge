package com.mobiquityinc.utils;

import com.google.common.collect.Sets;
import com.mobiquityinc.tescase.Package;
import org.junit.Test;

import java.util.Collections;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FormatterTest {

    @Test
    public void shouldFormatterToStrings() {

        Package package1 = new Package(1, 53.38, 45d);
        Package package2 = new Package(2, 88.62, 98d);

        Set<Package> aPackages = Sets.newHashSet(package1, package2);

        String string = Formatter.toStrings(aPackages);

        assertThat(string, is("1,2"));
    }

    @Test
    public void shouldFormatterToSpecialCharacter() {

        Set<Package> aPackages = Collections.EMPTY_SET;

        String string = Formatter.toStrings(aPackages);

        assertThat(string, is("-"));
    }
}