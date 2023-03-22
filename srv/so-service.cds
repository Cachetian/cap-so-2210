using sky.db as db from '../db/data-model';

service SalesOrderService {
  entity SalesOrders       as projection on db.SalesOrders actions {
    action updateComment(comment : String) returns String;
    action postToErp(comment : String)     returns String;
  };

  entity SalesOrderHeaders as projection on db.SalesOrderHeaders;
  entity SalesOrderItems   as projection on db.SalesOrderItems;
  entity Products          as projection on db.Products;
  action sayHello() returns String;
}

annotate SalesOrderService.SalesOrders with @odata.draft.enabled;
