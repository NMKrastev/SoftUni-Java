package bg.softuni.resellerapp.service;

import bg.softuni.resellerapp.model.dto.AddOfferDTO;
import bg.softuni.resellerapp.model.dto.UsersOffersDTO;
import bg.softuni.resellerapp.model.entity.Condition;
import bg.softuni.resellerapp.model.entity.Offer;
import bg.softuni.resellerapp.model.entity.User;
import bg.softuni.resellerapp.model.mapper.OfferMapper;
import bg.softuni.resellerapp.repository.OfferRepository;
import bg.softuni.resellerapp.user.CurrentUser;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class OfferService {

    private final OfferRepository offerRepository;
    private final UserService userService;
    private final ConditionService conditionService;
    private final CurrentUser currentUser;
    private final OfferMapper offerMapper;

    public OfferService(OfferRepository offerRepository, UserService userService,
                        ConditionService conditionService, CurrentUser currentUser,
                        OfferMapper offerMapper) {

        this.offerRepository = offerRepository;
        this.userService = userService;
        this.conditionService = conditionService;
        this.currentUser = currentUser;
        this.offerMapper = offerMapper;
    }

    public boolean addOffer(AddOfferDTO addOfferDTO) {

        final Offer offer = this.offerMapper.addOfferDtoToOffer(addOfferDTO);

        final User seller = this.userService.findByUsername(this.currentUser.getUsername());

        final Condition condition =
                this.conditionService.findConditionByName(addOfferDTO.getCondition());

        offer.setSeller(seller);
        offer.setCondition(condition);

        this.offerRepository.save(offer);

        return true;
    }

    public Offer findOfferById(Long id) {

        return this.offerRepository
                .findById(id)
                .get();
    }

    public List<UsersOffersDTO> findAllOtherUsersOffers() {

        final User userNotIncluded = this.userService.findByUsername(this.currentUser.getUsername());

        return this.offerRepository
                .findAllBySellerNotAndBuyerNull(userNotIncluded)
                .stream()
                .map(this.offerMapper::offerToOfferDto)
                .sorted(Comparator.comparing(
                        UsersOffersDTO::getSeller, (usernameOne, usernameTwo)
                                        -> usernameTwo.getUsername().compareTo(usernameOne.getUsername()))
                        .reversed())
                .toList();
    }

    public List<UsersOffersDTO> findUserOffers() {

        return this.offerRepository
                .findAllBySellerAndBuyerNull(this.userService.findByUsername(this.currentUser.getUsername()))
                .stream()
                .map(this.offerMapper::offerToOfferDto)
                .toList();
    }

    public List<UsersOffersDTO> findUserBoughtItems() {

        return this.offerRepository
                .findAllByBuyerId(this.currentUser.getId())
                .stream()
                .map(this.offerMapper::offerToOfferDto)
                .toList();
    }

    public boolean deleteOffer(Long id) {

        this.offerRepository.deleteById(id);

        return this.offerRepository.findById(id).isEmpty();

    }
}