package DiegoZelaya20240181.DiegoZelaya20240181Recuperacion.Repository;

import DiegoZelaya20240181.DiegoZelaya20240181Recuperacion.Entities.EntitesClientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryClientes extends JpaRepository<EntitesClientes, Long> {
}
