package de.bentrm.datacat.domain;

import org.neo4j.ogm.session.event.Event;
import org.neo4j.ogm.session.event.EventListenerAdapter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
public class PreSaveEventListener extends EventListenerAdapter {

	@Override
	public void onPreSave(Event event) {
		Object obj = event.getObject();

		if (obj instanceof UniqueEntity) {
			UniqueEntity entity = (UniqueEntity) obj;
			if (entity.getUniqueId() == null) {
				entity.setUniqueId(UUID.randomUUID().toString());
			}
		}

		if (obj instanceof XtdRoot) {
			XtdRoot entity = (XtdRoot) obj;
			if (entity.getVersionId() == null) {
				entity.setVersionId("1");
			}
			if (entity.getVersionDate() == null) {
				entity.setVersionDate(LocalDate.now().toString());
			}
		}
	}

}
