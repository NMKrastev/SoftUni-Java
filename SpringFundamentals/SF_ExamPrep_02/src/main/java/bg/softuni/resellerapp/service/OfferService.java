package bg.softuni.resellerapp.service;

import bg.softuni.resellerapp.model.dto.AddOfferDTO;
import bg.softuni.resellerapp.model.entity.Condition;
import bg.softuni.resellerapp.model.entity.Offer;
import bg.softuni.resellerapp.model.entity.User;
import bg.softuni.resellerapp.model.mapper.OfferMapper;
import bg.softuni.resellerapp.repository.OfferRepository;
import bg.softuni.resellerapp.user.CurrentUser;
import org.springframework.stereotype.Service;

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

        final Offer savedOffer = this.offerRepository.save(offer);

        //this.userService.saveOfferToUser(savedOffer);

        return true;
    }

    public Offer findOfferById(Long id) {

        return this.offerRepository
                .findById(id)
                .get();
    }

    public List<Offer> findAllOtherUsersOffers() {

        return this.offerRepository.findAllBySellerNotAndBuyerNull(this.userService.findByUsername(this.currentUser.getUsername()));
    }

    public List<Offer> findUserOffers() {

        return this.offerRepository.findAllBySellerAndBuyerNull(this.userService.findByUsername(this.currentUser.getUsername()));
    }

    public List<Offer> findUserBoughtItems() {

        return this.offerRepository.findAllByBuyerId(this.currentUser.getId());
    }
}
