package bg.softuni.resellerapp.service;

import bg.softuni.resellerapp.model.entity.Offer;
import bg.softuni.resellerapp.model.entity.User;
import bg.softuni.resellerapp.repository.OfferRepository;
import bg.softuni.resellerapp.repository.UserRepository;
import bg.softuni.resellerapp.user.CurrentUser;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

@Service
public class UserBuyService {

    private final UserService userService;
    private final UserRepository userRepository;
    private final OfferService offerService;
    private final OfferRepository offerRepository;
    private final CurrentUser currentUser;

    public UserBuyService(UserService userService, UserRepository userRepository,
                          OfferService offerService, OfferRepository offerRepository, CurrentUser currentUser) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.offerService = offerService;
        this.offerRepository = offerRepository;
        this.currentUser = currentUser;
    }

    public void buyItem(Long id) {

        final Offer offer = this.offerService.findOfferById(id);

        final User buyer = this.userRepository.findByUsername(this.currentUser.getUsername()).get();

        offer.setBuyer(buyer);

        this.offerRepository.save(offer);

        System.out.println();
    }
}
