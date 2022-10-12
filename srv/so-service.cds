using sky.db as db from '../db/data-model';

service SalesOrderService {
    entity SalesOrders as projection on db.SalesOrders actions {
        action updateComment(comment : String) returns String;
        action postToErp(comment : String)     returns String;
    };

    action sayHello() returns String;
}

annotate SalesOrderService.SalesOrders with @odata.draft.enabled;
