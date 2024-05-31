package TestDTScom.example.TestDTS.repositories;

import TestDTScom.example.TestDTS.models.Data;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface DataRepository extends JpaRepository<Data, Long>, JpaSpecificationExecutor<Data> {

}
