package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.dto.AddOfferDTO;
import bg.softuni.mobilelele.model.dto.OfferUpdateDTO;
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

import java.time.LocalDateTime;
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

        final OfferEntity newOffer = this.offerMapper.addOfferDtoToOfferEntity(addOfferDTO);

        final UserEntity seller = this.userService.findByEmail(this.currentUser.getEmail());

        final ModelEntity model = this.modelService.findById(addOfferDTO.getModelId());

        newOffer.setModel(model);
        newOffer.setSeller(seller);
        newOffer.setCreated(LocalDateTime.now());

        this.offerRepository.saveAndFlush(newOffer);
    }

    @Override
    public OfferUpdateDTO findOfferToUpdate(Long id) {

        final OfferEntity offerEntity = this.offerRepository.findById(id).get();

        final OfferUpdateDTO offerUpdateDTO = this.offerMapper.offerEntityToOfferDto(offerEntity);

        final ModelEntity modelEntity = this.modelService.findById(offerEntity.getModel().getId());

        offerUpdateDTO.setModel(modelEntity);

        return offerUpdateDTO;
    }

    @Override
    public boolean updateOffer(AddOfferDTO addOfferDTO, Long offerId) {

        final OfferEntity offerEntity = this.offerRepository.findById(offerId).get();

        final OfferEntity changedOffer = this.compareOfferDifferences(addOfferDTO, offerEntity);

        this.offerRepository.saveAndFlush(changedOffer);

        return true;

    }

    private OfferEntity compareOfferDifferences(AddOfferDTO addOfferDTO, OfferEntity offerEntity) {

        boolean isModified = false;

        if (!addOfferDTO.getModelId().equals(offerEntity.getModel().getId())) {
            offerEntity.setModel(this.modelService.findById(addOfferDTO.getModelId()));
            isModified = true;
        }

        if (!addOfferDTO.getPrice().equals(offerEntity.getPrice())) {
            offerEntity.setPrice(addOfferDTO.getPrice());
            isModified = true;
        }

        if (!addOfferDTO.getEngine().equals(offerEntity.getEngine())) {
            offerEntity.setEngine(addOfferDTO.getEngine());
            isModified = true;
        }

        if (!addOfferDTO.getTransmission().equals(offerEntity.getTransmission())) {
            offerEntity.setTransmission(addOfferDTO.getTransmission());
            isModified = true;
        }

        if (!addOfferDTO.getYear().equals(offerEntity.getYear())) {
            offerEntity.setYear(addOfferDTO.getYear());
            isModified = true;
        }

        if (!addOfferDTO.getMileage().equals(offerEntity.getMileage())) {
            offerEntity.setMileage(addOfferDTO.getMileage());
            isModified = true;
        }

        if (!addOfferDTO.getDescription().equals(offerEntity.getDescription())) {
            offerEntity.setDescription(addOfferDTO.getDescription());
            isModified = true;
        }

        if (!addOfferDTO.getImageUrl().equals(offerEntity.getImageUrl())) {
            offerEntity.setImageUrl(addOfferDTO.getImageUrl());
            isModified = true;
        }

        if (isModified) {
            offerEntity.setModified(LocalDateTime.now());
        }

        return offerEntity;
    }
}