package dk.kea.kinoxp_rest.dto;

import dk.kea.kinoxp_rest.model.Seat;
import dk.kea.kinoxp_rest.repository.SeatRepository;
import dk.kea.kinoxp_rest.service.SeatService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SeatConverterTest {

    @InjectMocks
    SeatConverter seatConverter;

    @Mock
    SeatRepository seatRepository;

    @Mock
    SeatService seatService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Arrange
    SeatDTO seatDTOtest = new SeatDTO(
            1,
            "A1",
            true,
            null,
            10.5
    );

    Seat seatTest = new Seat(
            1,
            "A1",
            true,
            10.5,
            null,
            null
    );

    @Test
    void toEntityTest() {
        // Act
        Seat resultSeat = seatConverter.toEntity(seatDTOtest);

        // Assert
        assertEquals(seatDTOtest.seat_ID(), resultSeat.getSeat_ID());
        assertEquals(seatDTOtest.seat_number(), resultSeat.getSeat_number());
        assertEquals(seatDTOtest.isReserved(), resultSeat.isReserved());
        assertEquals(seatDTOtest.theater(), resultSeat.getTheater());
        assertEquals(seatDTOtest.seat_Price(), resultSeat.getSeat_Price(), 0.01);
    }

    @Test
    void toDTOTest() {
        // Act
        SeatDTO resultSeatDTO = seatConverter.toDTO(seatTest);

        // Assert
        assertEquals(seatTest.getSeat_ID(), resultSeatDTO.seat_ID());
        assertEquals(seatTest.getSeat_number(), resultSeatDTO.seat_number());
        assertEquals(seatTest.isReserved(), resultSeatDTO.isReserved());
        assertEquals(seatTest.getTheater(), resultSeatDTO.theater());
        assertEquals(seatTest.getSeat_Price(), resultSeatDTO.seat_Price(), 0.01);
    }
}
