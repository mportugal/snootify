package com.mportugal.snootify.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by mportugal on 12/8/2015.
 */
public class Runner {

    private static final Logger logger = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) {

        // 0 - Subreddit
        // 1 -
        if (args.length != 2) {
            logger.info("Nothing");
        }

        //TODO: Support more subreddits
        Snootifier snootifier = new Snootifier(args[0], args[1]);

        //TODO: Get JSON response for /r/<args[0]/.json
    }

}
