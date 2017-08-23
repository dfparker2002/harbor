package com.icfolson.aem.harbor.api.components.content.dynamicaccordion;

public interface AccordionItem {

    String RESOURCE_TYPE = "harbor/components/content/dynamicaccordion/item";
    String DEFAULT_STYLE = "panel-default";

    String getId();

    String getHeadingText();

    String getType();

    String getPath();

    //TODO: Get Classification in interface

    default String getStyle() {
        return DEFAULT_STYLE;
    }

}