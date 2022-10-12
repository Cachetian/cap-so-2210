package customer.cap_so_2210.handlers;

import com.sap.cds.services.cds.CdsCreateEventContext;
import com.sap.cds.services.cds.CqnService;
import com.sap.cds.services.handler.EventHandler;
import com.sap.cds.services.handler.annotations.On;
import com.sap.cds.services.handler.annotations.ServiceName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cds.gen.salesorderservice.*;

@Component
@ServiceName(SalesOrderService_.CDS_NAME)
public class SalesOrdersServiceHandler implements EventHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(SalesOrdersServiceHandler.class);

    @On(event = CqnService.EVENT_CREATE, entity = SalesOrders_.CDS_NAME)
    public void onCreateSalesOrders(CdsCreateEventContext context, SalesOrders entity) {
        LOGGER.debug("Enter onCreateSalesOrders -> entity:{}", entity);
    }
}
