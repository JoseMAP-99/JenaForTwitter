package com.josesi2.practicajenatwitter;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.DC_11;

/**
 *
 * @author José María
 */
public class Untheme {
    
    private Resource untheme;
    private String URIuntheme;
    private Theme typeUntheme;

    public Untheme(String URIuntheme, Theme typeUntheme) {
        this.URIuntheme = URIuntheme;
        this.typeUntheme = typeUntheme;
    }
    
    public void init(Model model) {
        untheme = model.createResource(this.URIuntheme);
        untheme.addProperty(DC_11.type, this.typeUntheme.getTheme());
    }
    
    public Resource getUntheme() {
        return this.untheme;
    }
}
