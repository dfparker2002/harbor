package com.citytechinc.cq.harbor.proper.components.content.tree;

import com.google.common.collect.Lists;

public class RenderableTreeNode <T> {

    private final TreeNode<T> treeNode;
    private final TreeNodeRenderingStrategy<T> renderingStrategy;

    private String renderedTreeNodeValue;
    private String renderedTreeNodeChildren;

    public RenderableTreeNode (TreeNode<T> treeNode, TreeNodeRenderingStrategy<T> renderingStrategy) {
        this.treeNode = treeNode;
        this.renderingStrategy = renderingStrategy;
    }

    public String getRenderedTreeNodeValue() {
        if (renderedTreeNodeValue == null) {
            renderedTreeNodeValue = renderingStrategy.renderNodeValue(treeNode);
        }

        return renderedTreeNodeValue;
    }

    public String getRenderedTreeNodeChildren() {
        if (renderedTreeNodeChildren == null) {
            renderedTreeNodeChildren = renderingStrategy.renderChildren(treeNode);
        }

        return renderedTreeNodeChildren;
    }

}
