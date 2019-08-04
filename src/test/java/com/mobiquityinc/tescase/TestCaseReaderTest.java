package com.mobiquityinc.tescase;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TestCaseReaderTest {

    @Test
    public void shouldReadFile() throws IOException {

        TestCaseReader testCaseReader = new TestCaseReader();
        List<String> strings = testCaseReader.read("src/test/resources/data-test.txt");

        assertThat(strings.size(), is(4));
        assertThat(strings.get(1), is("8 : (1,15.3,€34)"));
    }
}