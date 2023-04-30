package mk.finki.ukim.emtlabs.repository;

import mk.finki.ukim.emtlabs.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {
}
