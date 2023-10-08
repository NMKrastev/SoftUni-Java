package bg.softuni.resellerapp.repository;

import bg.softuni.resellerapp.model.entity.Offer;
import bg.softuni.resellerapp.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

    List<Offer> findAll();

    List<Offer> findAllBySellerNotAndBuyerNull(User seller);

    List<Offer> findAllBySellerAndBuyerNull(User user);

    List<Offer> findAllByBuyerId(Long id);
}
