package com.josesi2.practicajenatwitter;

import java.util.ArrayList;
import java.util.List;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author José María
 */
public class ApiTwitter {
    
    private String [] keys;
    private Twitter twitter;
    private List status;
    
    public ApiTwitter(String [] keys) {
        this.keys = keys;
        this.status = new ArrayList<Status>();
    }    
    
    public void connect() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
          .setOAuthConsumerKey(this.keys[0])
          .setOAuthConsumerSecret(this.keys[1])
          .setOAuthAccessToken(this.keys[2])
          .setOAuthAccessTokenSecret(this.keys[3]);
            
        TwitterFactory tf = new TwitterFactory(cb.build());
        this.twitter = tf.getInstance();    
    }
    
    public void pullTweetsByTerm(String term, int nTweets) {
        try {                  
            Query query = new Query(term);
            query.setCount(nTweets);
            QueryResult result = this.twitter.search(query);
            this.status = result.getTweets();
        } catch (TwitterException ex) {
            System.out.println("Error obteniendo los tweets");
        }
    }
    
    public String getUsername() {
        String username = "";
        try {
            username = this.twitter.getScreenName();
        } catch (TwitterException | IllegalStateException ex) {
            System.out.println("Error obteniendo el nombre de usuario");
        }
        return username;
    }
    
    public List<Status> getStatus() {
        return this.status;
    }
}
