package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.dto.AddOfferDTO;
import bg.softuni.mobilelele.model.dto.OfferDetailsDTO;
import bg.softuni.mobilelele.model.dto.OfferUpdateDTO;
import bg.softuni.mobilelele.model.entity.ModelEntity;
import bg.softuni.mobilelele.model.entity.OfferEntity;
import bg.softuni.mobilelele.model.entity.UserEntity;
import bg.softuni.mobilelele.model.mapper.OfferMapper;
import bg.softuni.mobilelele.repository.OfferRepository;
import bg.softuni.mobilelele.service.CarModelService;
import bg.softuni.mobilelele.service.OfferService;
import bg.softuni.mobilelele.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final UserService userService;
    private final CarModelService modelService;
    private final OfferMapper offerMapper;

    public OfferServiceImpl(OfferRepository offerRepository, UserService userService,
                            CarModelService modelService, OfferMapper offerMapper) {

        this.offerRepository = offerRepository;
        this.userService = userService;
        this.modelService = modelService;
        this.offerMapper = offerMapper;
    }

    @Override
    public List<OfferDetailsDTO> findAllOffers() {

        return this.offerRepository
                .findAll()
                .stream()
                .map(this.offerMapper::offerEntityToOfferDetailsDto)
                .toList();
    }

    @Override
    public Optional<OfferDetailsDTO> findOfferById(Long id) {

        return this.offerRepository.findById(id)
                .map(this.offerMapper::offerEntityToOfferDetailsDto);
    }

    @Override
    public void addOffer(AddOfferDTO addOfferDTO) {

        final OfferEntity newOffer = this.offerMapper.addOfferDtoToOfferEntity(addOfferDTO);

        final ModelEntity model = this.modelService.findById(addOfferDTO.getModelId());

        newOffer.setModel(model);
        newOffer.setCreated(LocalDateTime.now());

        this.offerRepository.saveAndFlush(newOffer);
    }

    @Override
    public OfferUpdateDTO findOfferToUpdate(Long id) {

        final OfferEntity offerEntity = this.offerRepository.findById(id).get();

        final OfferUpdateDTO offerUpdateDTO = this.offerMapper.offerEntityToOfferDto(offerEntity);

        final ModelEntity modelEntity = this.modelService.findById(offerEntity.getModel().getId());

        offerUpdateDTO.setModel(modelEntity);
        offerUpdateDTO.setModelId(modelEntity.getId());

        return offerUpdateDTO;
    }

    @Override
    public boolean updateOffer(OfferUpdateDTO offerUpdateDTO, Long offerId) {

        OfferEntity offerEntity = this.offerRepository.findById(offerId).get();

        final UserEntity seller = offerEntity.getSeller();

        final LocalDateTime created = offerEntity.getCreated();

        offerEntity = this.offerMapper.updateOfferDtoToOfferEntity(offerUpdateDTO);

        offerEntity.setSeller(seller);
        offerEntity.setCreated(created);
        offerEntity.setModel(this.modelService.findById(offerUpdateDTO.getModelId()));
        offerEntity.setModified(LocalDateTime.now());

        this.offerRepository.saveAndFlush(offerEntity);

        return true;
    }

    @Override
    public boolean deleteOffer(Long id) {

        this.offerRepository.deleteById(id);

        final Optional<OfferEntity> deletedOffer = this.offerRepository.findById(id);

        return deletedOffer.isEmpty();
    }

    @Override
    public Page<OfferDetailsDTO> getAllOffers(Pageable pageable) {
        return this.offerRepository
                .findAll(pageable)
                .map(this.offerMapper::offerEntityToOfferDetailsDto);
    }
}