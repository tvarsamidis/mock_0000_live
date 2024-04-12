package gr.codehub.mockito.p01_test_doubles.q03_stub;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
