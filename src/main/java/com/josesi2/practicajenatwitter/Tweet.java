package com.josesi2.practicajenatwitter;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.DC_11;

/**
 *
 * @author José María
 */
public class Tweet {
        
    private Resource tweet;
    private String URItweet;
    private String creationTweet;
    private String idTweet;
    private String textTweet;
    private Tweet replyTweet;
    private User creatorTweet;
    private Language languageTweet;
    private Untheme relatedTweet;
    
    public Tweet(String URItweet, String creationTweet, String idTweet, String textTweet, User creatorTweet, Language languageTweet, Untheme relatedTweet, Tweet replyTweet) {
        this.URItweet = URItweet;
        this.creationTweet = creationTweet;
        this.idTweet = idTweet;
        this.textTweet = textTweet;
        this.creatorTweet = creatorTweet;
        this.languageTweet = languageTweet;
        this.relatedTweet = relatedTweet;
        this.replyTweet = replyTweet;
    }
        
    public void init(Model model) {
        tweet = model.createResource(this.URItweet);        
        tweet.addProperty(DC_11.date, this.creationTweet);
        tweet.addProperty(DC_11.identifier, this.idTweet);
        tweet.addProperty(DC_11.description, this.textTweet);
        tweet.addProperty(DC_11.relation, this.relatedTweet.getUntheme());
        tweet.addProperty(DC_11.language, this.languageTweet.getLanguage());
        tweet.addProperty(DC_11.creator, this.creatorTweet.getUser()); 
        
        if (this.replyTweet != null) {
            tweet.addProperty(model.getProperty("http://own.com/reply_to"), this.replyTweet.getTweet());
        }
    }    
            
    public Resource getTweet() {
        return this.tweet;
    }    
}
