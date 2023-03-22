package customer.cap_so_2210.handlers;

import com.sap.cds.Result;
import com.sap.cds.ql.Upsert;
import com.sap.cds.services.cds.CdsCreateEventContext;
import com.sap.cds.services.cds.CqnService;
import com.sap.cds.services.handler.EventHandler;
import com.sap.cds.services.handler.annotations.On;
import com.sap.cds.services.handler.annotations.ServiceName;
import com.sap.cds.services.persistence.PersistenceService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cds.gen.salesorderservice.*;
import static cds.gen.salesorderservice.SalesOrderService_.PRODUCTS;

@Component
@ServiceName(SalesOrderService_.CDS_NAME)
public class SalesOrdersServiceHandler implements EventHandler {

  private static final Logger LOGGER = LoggerFactory.getLogger(SalesOrdersServiceHandler.class);

  @Autowired
  PersistenceService db;

  @On(event = CqnService.EVENT_CREATE, entity = SalesOrders_.CDS_NAME)
  public void onCreateSalesOrders(CdsCreateEventContext context, SalesOrders entity) {
    LOGGER.debug("Enter onCreateSalesOrders -> entity:{}", entity);
  }

  @On(event = SaveProductsContext.CDS_NAME)
  public void onSaveProducts(SaveProductsContext context) {
    Result result = db.run(Upsert.into(PRODUCTS).entries(context.getProducts()));
    context.setResult("success upserted '" + result.rowCount() + "' count");
    context.setCompleted();
  }
}
