package co.edu.uniandes.mati.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Order {
    private Long idPayment;
    private Long idUser;
    private BigDecimal amount;
}
