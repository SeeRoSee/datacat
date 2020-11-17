package de.bentrm.datacat.graphql.fetcher.delegate;

import de.bentrm.datacat.catalog.domain.XtdObject;
import de.bentrm.datacat.catalog.domain.XtdRelAssignsCollections;
import de.bentrm.datacat.catalog.domain.XtdRelAssignsProperties;
import de.bentrm.datacat.catalog.service.AssignsCollectionsService;
import de.bentrm.datacat.catalog.service.AssignsPropertiesService;
import de.bentrm.datacat.graphql.Connection;
import de.bentrm.datacat.graphql.fetcher.RelationshipFetcher;
import de.bentrm.datacat.graphql.fetcher.TagsFetcher;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ObjectFetchersDelegate implements FetchingDelegate {

    private final RelationshipFetcher<XtdRelAssignsCollections> assignedCollectionsFetcher;
    private final RelationshipFetcher<XtdRelAssignsProperties> assignedPropertiesFetcher;

    public ObjectFetchersDelegate(AssignsCollectionsService assignsCollectionsService,
                                  AssignsPropertiesService assignsPropertiesService) {
        this.assignedCollectionsFetcher = new RelationshipFetcher<>(assignsCollectionsService) {
            @Override
            public Connection<XtdRelAssignsCollections> get(DataFetchingEnvironment environment) {
                final XtdObject source = environment.getSource();
                final Set<XtdRelAssignsCollections> fieldValues = source.getAssignedCollections();
                return get(fieldValues, environment);
            }
        };

        this.assignedPropertiesFetcher = new RelationshipFetcher<>(assignsPropertiesService) {
            @Override
            public Connection<XtdRelAssignsProperties> get(DataFetchingEnvironment environment) {
                final XtdObject source = environment.getSource();
                final Set<XtdRelAssignsProperties> fieldValues = source.getAssignedProperties();
                return get(fieldValues, environment);
            }
        };
    }

    @Override
    public Map<String, DataFetcher> getFetchers() {
        return Map.of(
                "tags", new TagsFetcher(),
                "assignedCollections", assignedCollectionsFetcher,
                "assignedProperties", assignedPropertiesFetcher
        );
    }
}
