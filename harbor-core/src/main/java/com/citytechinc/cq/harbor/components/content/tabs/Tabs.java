package com.citytechinc.cq.harbor.components.content.tabs;


import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.ContentProperty;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.editconfig.ActionConfig;
import com.citytechinc.cq.library.components.AbstractComponent;
import com.citytechinc.cq.library.components.annotations.AutoInstantiate;
import com.citytechinc.cq.library.content.node.ComponentNode;
import com.citytechinc.cq.library.content.request.ComponentRequest;
import org.apache.jackrabbit.JcrConstants;
import org.apache.sling.api.resource.Resource;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Component(value = "Tabs",
        actions = {"text: Tabs", "-", "copymove", "delete", "-", "insert"},
        listeners = {
                @Listener(name = "afterinsert", value = "REFRESH_PAGE")
        },
        actionConfigs = {
                @ActionConfig(xtype = "tbseparator"),
                @ActionConfig(text = "Add Tab", handler = "function(){Harbor.Components.Tabs.addTab(this)}")
        },
        contentAdditionalProperties = {
                @ContentProperty(name="dependencies", value="[harbor.components.content.tabs,harbor.bootstrap]")
        }
)
@AutoInstantiate(instanceName = "tabs")
public class Tabs extends AbstractComponent {
    private List<Tab> tabs;

    public Tabs(ComponentRequest request) {
        super(request);
    }

    //TODO: remove this once implemented in cqlib
    public static String constructUniqueId(Resource r) {
        StringBuffer uniqueIdBuffer = new StringBuffer();

        Resource curResource = r;

        while (curResource != null && !curResource.getName().equals(JcrConstants.JCR_CONTENT)) {
            uniqueIdBuffer.append(curResource.getName());
            curResource = curResource.getParent();
        }

        return uniqueIdBuffer.toString();
    }

    public String getName() {
        return this.getResource().getName();
    }

    public List<Tab> getTabs() {
        if (this.tabs != null) {
            return this.tabs;
        }
        this.tabs = new ArrayList<Tab>();
        Iterator<ComponentNode> componentNodeIterator = request.getComponentNode().getComponentNodes().iterator();
        while (componentNodeIterator.hasNext()) {
            ComponentNode currentComponentNode = componentNodeIterator.next();

            if (currentComponentNode.getResource().isResourceType(Tab.TYPE)) {
                this.tabs.add(new Tab(currentComponentNode));
            }
        }
        return this.tabs;
    }

    public Boolean getHasTabs() {
        return !this.getTabs().isEmpty();
    }

    public String getUniqueId() {
        //TODO: change this to use a unique ID generator
        return constructUniqueId(request.getResource());
    }

}