package com.mportugal.snootify.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.Date;

/**
 * Created by mportugal on 12/8/2015.
 */
public class Snootifier implements Runnable{

    private static final Logger logger = LoggerFactory.getLogger(Runner.class);

    private static final String REDDIT_URL = "http://www.reddit.com/r/%s/search.json?q=%s&restrict_sr=on&sort=relevance&t=new";
    private static final String PUSHBULLET_ACCESS_TOKEN = "yjIqnciaeiMP9FBJWHVAloyBAC3MWYjR";
    private static final long SLEEP = 1000 * 60;

    private String subreddit;
    private String query;
    private Date checkpoint;

    public Snootifier(String subreddit, String query) {
        this.subreddit = subreddit;
        this.query = query;
        this.checkpoint = new Date();
    }

    public void run() {
        //TODO: Request REDDIT_URL and parse JSON response
        //TODO: If checkpoint is within checkpoint and new Date(), check if regex matches the title

        Date now = new Date();

        logger.info("Checking /r/{} for {} at {}", subreddit, query, now);
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(String.format(REDDIT_URL, subreddit, query));
        String json = target.request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
    }
}
