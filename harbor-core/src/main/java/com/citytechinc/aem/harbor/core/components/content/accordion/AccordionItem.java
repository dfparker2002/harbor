package com.citytechinc.aem.harbor.core.components.content.accordion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.citytechinc.aem.bedrock.api.components.annotations.AutoInstantiate;
import com.citytechinc.aem.bedrock.core.components.AbstractComponent;
import com.citytechinc.aem.harbor.core.util.ComponentUtils;
import com.citytechinc.aem.harbor.core.util.icon.IconUtils;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.ContentProperty;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;

@Component(
    value = "Accordion Item",
    name = "accordion/accordionitem",
    actions = { "text: Accordion Item", "-", "edit", "delete" },
    listeners = {
        @Listener(name = "afterinsert", value = "REFRESH_PAGE"),
        @Listener(name = "afteredit", value = "REFRESH_PARENT"),
        @Listener(name = "afterdelete", value = "REFRESH_PARENT")
    },
    group = ".hidden",
    //noDecoration = true, //when enabled, it breakes the rollover edit layout, but it's needed for the collapse to work
    layout = "rollover",
    contentAdditionalProperties = { @ContentProperty(name = "dependencies", value = "[harbor.fontawesome]") }
)
@AutoInstantiate
public class AccordionItem extends AbstractComponent {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccordionItem.class);

    public static final String TYPE = "harbor/components/content/accordion/accordionitem";

    @DialogField(fieldLabel = "Title", fieldDescription = "The title of the accordion item.")
    private String title;

    private String uniqueId;
    private String name;

    public String getTitle() {
        if (title == null) {
            title = IconUtils.iconify(this.get("title", this.getName()));
        }
        return title;
    }

    public String getName() {
        if (name == null) {
            name = getResource().getName();
            LOGGER.debug("getName(): " + getResource().getName());
        }
        return name;
    }

    public String getUniqueId() {
        if (uniqueId == null) {
            uniqueId = ComponentUtils.getUniqueIdentifierForResourceInPage(getCurrentPage(), getResource());
        }
        return uniqueId;
    }
}