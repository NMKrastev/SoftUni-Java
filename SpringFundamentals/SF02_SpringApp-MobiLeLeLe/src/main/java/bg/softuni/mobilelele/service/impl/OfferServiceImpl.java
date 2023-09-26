package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.dto.AddOfferDTO;
import bg.softuni.mobilelele.model.entity.ModelEntity;
import bg.softuni.mobilelele.model.entity.OfferEntity;
import bg.softuni.mobilelele.model.entity.UserEntity;
import bg.softuni.mobilelele.model.mapper.OfferMapper;
import bg.softuni.mobilelele.repository.OfferRepository;
import bg.softuni.mobilelele.service.CarModelService;
import bg.softuni.mobilelele.service.OfferService;
import bg.softuni.mobilelele.service.UserService;
import bg.softuni.mobilelele.user.CurrentUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final UserService userService;

    private final CarModelService modelService;
    private final CurrentUser currentUser;
    private final OfferMapper offerMapper;

    public OfferServiceImpl(OfferRepository offerRepository, UserService userService, CarModelService modelService, CurrentUser currentUser, OfferMapper offerMapper) {

        this.offerRepository = offerRepository;
        this.userService = userService;
        this.modelService = modelService;
        this.currentUser = currentUser;
        this.offerMapper = offerMapper;
    }

    @Override
    public List<OfferEntity> findAllOffers() {

        return this.offerRepository.findAll();
    }

    @Override
    public OfferEntity findOfferById(Long id) {

        Optional<OfferEntity> byId = this.offerRepository.findById(id);

        return byId.get();
    }

    @Override
    public void addOffer(AddOfferDTO addOfferDTO) {

        OfferEntity newOffer = this.offerMapper.addOfferDtoToOfferEntity(addOfferDTO);

        UserEntity seller = this.userService.findByEmail(this.currentUser.getEmail());

        ModelEntity model = this.modelService.findById(addOfferDTO.getModelId());

        newOffer.setModel(model);
        newOffer.setSeller(seller);

        this.offerRepository.saveAndFlush(newOffer);
    }
}