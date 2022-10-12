using SalesOrderService as service from '../../srv/so-service';

annotate service.SalesOrders with @(
    UI.LineItem : [
        {
            $Type : 'UI.DataField',
            Value : ID,
            Label : 'ID',
        },
        {
            $Type : 'UI.DataField',
            Value : name,
            Label : 'name',
        },
        {
            $Type : 'UI.DataField',
            Value : comment,
            Label : 'comment',
        },
    ]
);
annotate service.SalesOrders with @(
    UI.HeaderInfo : {
        TypeName : 'Sales Order',
        TypeNamePlural : 'Sales Orders',
        Title : {
            $Type : 'UI.DataField',
            Value : ID,
        },
    }
);
annotate service.SalesOrders with @(
    UI.Facets : [
        {
            $Type : 'UI.ReferenceFacet',
            Label : 'Basic Information',
            ID : 'BasicInformation',
            Target : '@UI.FieldGroup#BasicInformation',
        },
    ],
    UI.FieldGroup #BasicInformation : {
        $Type : 'UI.FieldGroupType',
        Data : [
            {
                $Type : 'UI.DataField',
                Value : comment,
                Label : 'comment',
            },{
                $Type : 'UI.DataField',
                Value : desc,
                Label : 'desc',
            },{
                $Type : 'UI.DataField',
                Value : name,
                Label : 'name',
            },],
    }
);
annotate service.SalesOrders with @(
    UI.SelectionFields : [
        name,
    ]
);
annotate service.SalesOrders with {
    name @Common.Label : 'name'
};
