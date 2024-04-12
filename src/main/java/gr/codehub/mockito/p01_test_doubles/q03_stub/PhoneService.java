package gr.codehub.mockito.p01_test_doubles.q03_stub;

import java.util.List;

public class PhoneService {

    private final PhoneRepository phoneRepository;

    public PhoneService(PhoneRepository phoneRepository1) {
        phoneRepository = phoneRepository1;
    }

    public List<Phone> getNewPhonesWithAppliedDiscount(int discountRate, int days) {
        List<Phone> newPhones = phoneRepository.findNewPhones(days);
        for (Phone phone: newPhones) {
            int newPrice = phone.getPrice() - (discountRate * phone.getPrice() / 100);
            phone.setPrice(newPrice);
        }
        return newPhones;
    }
}
