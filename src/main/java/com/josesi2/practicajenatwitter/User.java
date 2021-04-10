package com.josesi2.practicajenatwitter;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.VCARD;

/**
 *
 * @author José María
 */
public class User {
    
    private Resource user;
    private String URIuser;
    private String nameUser;
    private String locationUser;

    public User(String URIuser, String nameUser, String locationUser) {
        this.URIuser = URIuser;
        this.nameUser = nameUser;
        this.locationUser = locationUser;
    }

    public void init(Model model) {
        user = model.createResource(this.URIuser);
        user.addProperty(VCARD.FN, this.nameUser);
        user.addProperty(VCARD.Country, this.locationUser);
    }
    
    public Resource getUser() {
        return this.user;
    }
}
