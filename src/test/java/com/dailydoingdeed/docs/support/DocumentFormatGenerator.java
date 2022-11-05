package com.dailydoingdeed.docs.support;

import org.springframework.restdocs.snippet.Attributes;

public interface DocumentFormatGenerator {
    static Attributes.Attribute field(final String key, final String value){
        return new Attributes.Attribute(key,value);
    }
}