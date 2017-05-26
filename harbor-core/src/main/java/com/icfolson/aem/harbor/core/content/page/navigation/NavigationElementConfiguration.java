package com.icfolson.aem.harbor.core.content.page.navigation;

import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.icfolson.aem.library.api.page.PageDecorator;

public class NavigationElementConfiguration {

    private final Boolean respectHideInNavigation;

    private final Integer navigationDepth;

    private final PageDecorator currentPage;

    public NavigationElementConfiguration(Boolean respectHideInNavigation, Integer navigationDepth) {
        this.respectHideInNavigation = respectHideInNavigation;
        this.navigationDepth = navigationDepth;
        this.currentPage = null;
    }

    public NavigationElementConfiguration(Boolean respectHideInNavigation, Integer navigationDepth,
        PageDecorator currentPage) {
        this.respectHideInNavigation = respectHideInNavigation;
        this.navigationDepth = navigationDepth;
        this.currentPage = currentPage;
    }

    public Boolean isRespectHideInNavigation() {
        return respectHideInNavigation;
    }

    public Integer getNavigationDepth() {
        return navigationDepth;
    }

    public Optional<PageDecorator> getCurrentPage() {
        return Optional.fromNullable(currentPage);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
            .add("respectHideInNavigation", respectHideInNavigation)
            .add("navigationDepth", navigationDepth)
            .add("currentPage", currentPage == null ? null : currentPage.getPath())
            .toString();
    }
}
