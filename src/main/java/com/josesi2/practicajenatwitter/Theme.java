package com.josesi2.practicajenatwitter;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;

/**
 *
 * @author José María
 */
public class Theme {
    
    private Resource theme;
    private String URItheme;    
    private String tagTheme;

    public Theme(String URItheme, String tagTheme) {
        this.URItheme = URItheme;
        this.tagTheme = tagTheme;
    }
    
    public void init(Model model) {
        theme = model.createResource(this.URItheme);
        theme.addProperty(RDFS.label, this.tagTheme);
        theme.addProperty(RDF.type, RDFS.Class);
    }
    
    public Resource getTheme() {
        return this.theme;
    }
}
