namespace sky.db;

using {cuid} from '@sap/cds/common';

entity Books {
    key ID    : Integer;
        title : String;
        stock : Integer;
}

entity SalesOrders : cuid {
    name    : String(255);
    desc    : String(255);
    comment : String(255);
}
