package com.mobiquityinc.tescase;

import com.mobiquityinc.exception.TestCaseReaderException;
import org.apache.log4j.Logger;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Reader to read each line of file
 */
public class TestCaseReader {

    private static final Logger LOGGER = Logger.getLogger(TestCaseReader.class);
    public static final String ERROR_WHILE_READING_FILE = "Error while reading file.";

    /**
     * Read file as Lista os String
     * @param filePath
     * @return List<String> lines
     * @throws TestCaseReaderException
     */
    public List<String> read(final String filePath) throws TestCaseReaderException {
        LOGGER.info("Reading file from : " + filePath);
        try {
            File file = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(file));

            /*
            String line = reader.readLine();
            LinkedList<String> lines = new LinkedList<>();
            while (line != null) {
                lines.addLast(line);

                line = reader.readLine();
            }*/

            List<String> lines = reader.lines().collect(Collectors.toCollection(LinkedList::new));
            return lines;
        } catch (IOException e) {
            throw new TestCaseReaderException(ERROR_WHILE_READING_FILE, e);
        }
    }
}
