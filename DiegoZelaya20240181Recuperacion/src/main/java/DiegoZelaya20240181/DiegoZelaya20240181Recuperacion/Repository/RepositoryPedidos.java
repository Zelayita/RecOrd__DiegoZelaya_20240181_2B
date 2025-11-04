package DiegoZelaya20240181.DiegoZelaya20240181Recuperacion.Repository;

import DiegoZelaya20240181.DiegoZelaya20240181Recuperacion.Entities.EntitesPedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPedidos extends JpaRepository<EntitesPedidos, Long> {
}
