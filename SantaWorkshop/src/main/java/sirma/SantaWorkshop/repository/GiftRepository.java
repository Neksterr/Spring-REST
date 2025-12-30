package sirma.SantaWorkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sirma.SantaWorkshop.entity.Gift;

@Repository
public interface GiftRepository extends JpaRepository<Gift,Long> {
    Gift findAllById(Long id);
}
