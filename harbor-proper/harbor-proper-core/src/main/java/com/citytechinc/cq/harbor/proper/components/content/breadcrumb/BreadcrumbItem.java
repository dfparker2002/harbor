package com.citytechinc.cq.harbor.proper.components.content.breadcrumb;

import com.citytechinc.cq.harbor.proper.components.content.page.TrailPage;
import com.citytechinc.cq.harbor.proper.content.page.HierarchicalPage;

public class BreadcrumbItem {

    private final TrailPage page;
    private final BreadcrumbItemConfiguration itemConfiguration;

    public BreadcrumbItem(TrailPage page, BreadcrumbItemConfiguration breadcrumbItemConfiguration) {
        this.page = page;
        this.itemConfiguration = breadcrumbItemConfiguration;
    }

    public boolean isHideIcon() {
        return itemConfiguration.getHideIcon();
    }

    public boolean isHideTitle() {
        return itemConfiguration.getHideTitle();
    }

    public String getHref() {
        return page.getHref();
    }

    public String getTitle() {
        return page.getTitle();
    }

    public TrailPage getPage() {
        return page;
    }

    public String getPageIcon() {
        return getPage().adaptTo(HierarchicalPage.class).getPageIcon();
    }

    public boolean isRoot(){
        return page.isRoot();
    }

    public boolean isCurrentPage() {
        return page.isCurrent();
    }

}
