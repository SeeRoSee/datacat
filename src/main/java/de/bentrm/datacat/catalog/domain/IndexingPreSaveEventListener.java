package de.bentrm.datacat.catalog.domain;

import org.neo4j.ogm.session.event.Event;
import org.neo4j.ogm.session.event.EventListenerAdapter;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * This class supports indexing of catalog entry nodes for multilingual full text search queries.
 */
@Component
class IndexingPreSaveEventListener extends EventListenerAdapter {

    /**
     * The property {@link CatalogItem#getLabels()} represents a map all translations
     * mapped to their language tag. The persisted structure is used to index full text
     * queries honouring the current locale of the user.
     *
     * @param event The persistence event.
     */
    @Override
    public void onPreSave(Event event) {
        if (event.getObject() instanceof CatalogItem catalogItem) {
            final Map<String, String> labels = catalogItem.getNames().stream()
                    .collect(Collectors.toMap(Translation::getLanguageTag, Translation::getValue));

            catalogItem.getLabels().clear();
            catalogItem.getLabels().putAll(labels);
        }
    }
}
