package com.mobiquityinc.packer;

import com.mobiquityinc.calculator.PackageCalculator;
import com.mobiquityinc.tescase.TestCase;
import com.mobiquityinc.tescase.TestCaseReader;
import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.tescase.TestCaseTransformer;
import com.mobiquityinc.tescase.Package;
import com.mobiquityinc.utils.Formatter;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class Packer {

  private static final Logger LOGGER = Logger.getLogger(Packer.class);

  private Packer() {
  }

  /**
   * The main unit of program
   *
   * Read test cases from file as string;
   * Transform to TestCase Objects;
   * Validate constraints like maximum weight take
   * Calculate how many packages can hold by bag for each Test Case
   * Format results as String
   *
   * @param filePath
   * @return Result as String
   * @throws APIException
   */
  public static String pack(final String filePath) throws APIException {
    LOGGER.info("Starting pack to : " + filePath);

    try {
      List<String> lines = readTestCasesFrom(filePath);
      List<TestCase> testCases = transformToTestCases(lines);
      List<Set<Package>> indexes = calculatePackagesBy(testCases);

      return formatResult(indexes);
    } catch (final Exception e) {
      throw new APIException(e.getMessage(), e);
    }
  }

  private static List<String> readTestCasesFrom(final String filePath) {
    TestCaseReader reader = new TestCaseReader();
    return reader.read(filePath);
  }

  private static List<TestCase> transformToTestCases(final List<String> lines) {
    return lines.stream().map(TestCaseTransformer::transform).collect(Collectors.toList());
  }

  private static List<Set<Package>> calculatePackagesBy(final List<TestCase> testCases) {
    return testCases.stream().map(PackageCalculator::calculate).collect(Collectors.toList());
  }

  private static String formatResult(final List<Set<Package>> indexes) {
    return indexes.stream().map(Formatter::toStrings).collect(Collectors.joining("\n"));
  }
}
