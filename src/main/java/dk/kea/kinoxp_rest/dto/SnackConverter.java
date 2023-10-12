package dk.kea.kinoxp_rest.dto;

import dk.kea.kinoxp_rest.model.Seat;
import dk.kea.kinoxp_rest.model.Snack;
import org.springframework.stereotype.Component;

@Component
public class SnackConverter {
    public Snack toEntity(SnackDTO snackDTO) {
       Snack snack = new Snack();
               snack.setSnack_ID(snackDTO.snack_ID());
        snack.setSnackType(snackDTO.snackType());
        snack.setPrice(snackDTO.price());
        snack.setTicket_ID(snackDTO.ticket_ID());
        return snack;
    }



    public SnackDTO toDTO(Snack snack) {
        return new SnackDTO(
              snack.getSnack_ID(),
                snack.getSnackType(),
                snack.getPrice(),
                snack.getTicket_ID());
    }
}
