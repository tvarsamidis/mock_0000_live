package gr.codehub.mockito.p01_test_doubles.q03_stub;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PhoneRepositoryStub implements PhoneRepository {
    @Override
    public List<Phone> findNewPhones(int days) {
        List<Phone> newPhones = new ArrayList<>();
        newPhones.add(new Phone("1234", "CodeHub Pro", 600, LocalDate.now()));
        newPhones.add(new Phone("1235", "CodeHub Standard", 500, LocalDate.now()));
        return newPhones;
    }
}
