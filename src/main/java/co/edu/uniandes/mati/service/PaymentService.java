package co.edu.uniandes.mati.service;

import co.edu.uniandes.mati.entity.Order;
import co.edu.uniandes.mati.vo.EnableService;
import co.edu.uniandes.mati.vo.OrderPayment;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.SneakyThrows;
import org.jboss.logging.Logger;

import java.util.Date;
import java.util.Random;

@Path("api/v2/orders")
@ApplicationScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PaymentService {

    Boolean isEnabled = Boolean.TRUE;
    @Inject
    Logger log;

    @POST
    @Path("payment")
    public OrderPayment generatePayment(Order order) {
        log.info(order);
        if(isEnabled) {
            OrderPayment payment = new OrderPayment();
            payment.setReply("OK");
            payment.setDate(new Date());
            return payment;
        }
        throw new RuntimeException("Se produció un error");
    }

    @Path("setup")
    @POST
    public Response setUpService(EnableService setUpService) {
        isEnabled = setUpService.getIsActived();
        return Response.ok(isEnabled).build();
    }

}
