package kr.co.fastcampus.eatgo.application;

import kr.co.fastcampus.eatgo.domain.Reservation;
import kr.co.fastcampus.eatgo.domain.ReservationRepository;
import kr.co.fastcampus.eatgo.domain.Restaurant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ReservationServiceTests {
    @InjectMocks
    ReservationService reservationService;

    @Mock
    private ReservationRepository reservationRepository;

    @Test
    public void addReservation() throws Exception {
        Long userId = 1004L;
        String name = "John";
        String date = "2019-12-24";
        String time = "20:00";
        Integer partySize = 20;
        Long restaurantId = 369L;

        Reservation mockReservation = Reservation.builder().build();
        given(reservationRepository.save(any())).will(invocation -> invocation.getArgument(0));

        Reservation reservation = reservationService.addReservation(restaurantId, userId, name, date, time, partySize);
        assertThat(reservation.getName(), is(name));

        verify(reservationRepository).save(any(Reservation.class));
    }
}