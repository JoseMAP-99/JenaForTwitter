package com.josesi2.practicajenatwitter;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.DC_11;
import org.apache.jena.vocabulary.RDFS;

/**
 *
 * @author José María
 */
public class Language {
    
    private Resource language;
    private String URILanguage;
    private String idLanguage;
    private String tagLanguage;

    public Language(String URILanguage, String idLanguage, String tagLanguage) {
        this.URILanguage = URILanguage;
        this.idLanguage = idLanguage;
        this.tagLanguage = tagLanguage;
    }
    
    public void init(Model model) {
        language = model.createResource(this.URILanguage);
        language.addProperty(DC_11.identifier, this.idLanguage);
        language.addProperty(RDFS.label, this.tagLanguage);
    }
    
    public Resource getLanguage() {
        return this.language;
    }
}
