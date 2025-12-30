package sirma.SantaWorkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sirma.SantaWorkshop.entity.Elf;
import sirma.SantaWorkshop.entity.Gift;

@Repository
public interface ElvesRepository extends JpaRepository <Elf, Long> {
    Elf findAllById(Long id);
}
