package de.bentrm.datacat.query;

import org.neo4j.ogm.session.Session;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class FindAllGroupingQuery<T, ID extends Serializable>
		extends AbstractCustomQuery<T>
		implements IterableQuery<T> {

	private static final String QUERY =
			"MATCH (name:XtdName)-[:IS_NAME_OF]->(root:${label})-[:GROUPS]->(relatedObject) " +
			"WHERE relatedObject.id = {relatedThingId} " +
			"WITH root, name ORDER BY name.sortOrder, toLower(name.name) ASC, name.name DESC " +
			"WITH DISTINCT root SKIP {skip} LIMIT {limit} " +
			"RETURN root, ${propertyAggregations}, ID(root)";

	public FindAllGroupingQuery(Class<T> entityType, Session session, String relatedThingId, Pageable pageable) {
		super(entityType, session);

		if (pageable.isUnpaged()) {
			pageable = PageRequest.of(DEFAULT_PAGE_NUMBER, DEFAULT_PAGE_SIZE, pageable.getSortOr(DEFAULT_SORT_ORDER));
		}

		this.queryParameters.put("relatedThingId", relatedThingId);
		this.queryParameters.put("skip", pageable.getOffset());
		this.queryParameters.put("limit", pageable.getPageSize());
	}

	@Override
	public @NotNull String getQueryTemplate() {
		return QUERY;
	}

	@Override
	public Iterable<T> execute() {
		return session.query(this.entityType, this.prepareCypherQuery(), this.queryParameters);
	}
}
