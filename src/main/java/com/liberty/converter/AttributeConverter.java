package com.liberty.converter;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.liberty.dto.AttributeTO;
import com.liberty.model.Attributes;
import org.springframework.stereotype.Component;

@Component
public class AttributeConverter {

    private static final String SPLITTER = ".";

    public AttributeTO convert(Attributes attributes) {
        AttributeTO attributeTO = new AttributeTO();
        attributeTO.setName(extractAttributeName(attributes.name));
        attributeTO.setValue(attributes.value);
        return attributeTO;
    }

    private String extractAttributeName(String fullName) {
        return Iterables.getLast(
                Splitter.on(SPLITTER).split(fullName)
        );
    }
}
