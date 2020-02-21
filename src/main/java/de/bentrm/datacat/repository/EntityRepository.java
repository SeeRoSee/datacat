package de.bentrm.datacat.repository;

import de.bentrm.datacat.domain.Entity;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface EntityRepository<T extends Entity> extends Neo4jRepository<T, Long> {
}
