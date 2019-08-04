package com.mobiquityinc;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.packer.Packer;
import org.apache.log4j.Logger;

public final class Program {

    private static final Logger LOGGER = Logger.getLogger(Program.class);

    private Program() {
    }

    public static void main(final String[] args) {
        LOGGER.info("Starting program...");

        try {
            if (hasNo(args)) {
                throw new APIException("Missing program arguments");
            }

            final String filePath = args[0];
            final String packages = Packer.pack(filePath);

            LOGGER.info("Output:\n" + packages);
        } catch (Exception e) {
            LOGGER.error("ERROR ", e);
        }
    }

    private static boolean hasNo(final String[] args) {
        return args.length == 0 || args[0] != null && args[0].trim().isEmpty();
    }
}
