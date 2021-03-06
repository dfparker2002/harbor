Harbor.Components.Accordion = Harbor.Components.Accordion || {};
Harbor.Components.Accordion.v1 = {};
Harbor.Components.Accordion.v1.Accordion = function ( ns, channel ) {

    var AccordionEditor = function() {

        this.addItem = function ( component, itemResourceType ) {

            Harbor.Lists.v1.ListsEditor.addListItem(component, {
                "sling:resourceType": itemResourceType
            }, {
                listItemNameBase: "item"
            })
                .done(function () {
                    //TODO: Consider following the model of manual injection of the content so as to not necessitate a refresh of the entire accordion group
                    ns.edit.actions.doRefresh(component);
                });

        };

        this.moveUp = function( component ) {

            Harbor.Lists.v1.ListsEditor.moveBackward( component )
                .then( function() {
                    ns.edit.actions.doRefresh( component.getParent() );
                } );

        };

        this.moveDown = function( component ) {

            Harbor.Lists.v1.ListsEditor.moveForward( component )
                .then( function() {
                    ns.edit.actions.doRefresh( component.getParent() );
                } );

        };

    };

    return new AccordionEditor();

}( Granite.author, jQuery( document ) );

