package gr.codehub.mockito.p01_test_doubles.q03_stub;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StubTest {

    @Test
    public void demoStub() {
        PhoneRepository phoneRepository = new PhoneRepositoryStub();
        PhoneService phoneService = new PhoneService(phoneRepository);
        List<Phone> newPhonesWithAppliedDiscount = phoneService.getNewPhonesWithAppliedDiscount(10, 7);
        assertEquals(2, newPhonesWithAppliedDiscount.size());
        assertEquals(540, newPhonesWithAppliedDiscount.get(0).getPrice());
        assertEquals(450, newPhonesWithAppliedDiscount.get(1).getPrice());
    }

    @Test
    public void demoStubWithMockito() {
        PhoneRepository phoneRepository = mock(PhoneRepository.class);
        PhoneService phoneService = new PhoneService(phoneRepository);

        Phone phone1 = new Phone("1234", "CodeHub Pro", 300, LocalDate.now());
        Phone phone2 = new Phone("1235", "CodeHub Standard", 250, LocalDate.now());
        List<Phone> newPhones = List.of(phone1, phone2);

        List<Phone> newerPhones = List.of(phone2);

        when(phoneRepository.findNewPhones(7)).thenReturn(newPhones);
        when(phoneRepository.findNewPhones(2)).thenReturn(newerPhones);

        List<Phone> newPhonesWithAppliedDiscount = phoneService.getNewPhonesWithAppliedDiscount(10, 2);



        assertEquals(1, newPhonesWithAppliedDiscount.size());
        assertEquals(225, newPhonesWithAppliedDiscount.get(0).getPrice());
//        assertEquals(225, newPhonesWithAppliedDiscount.get(1).getPrice());
    }
}
