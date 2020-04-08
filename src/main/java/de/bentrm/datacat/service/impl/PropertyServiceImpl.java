package de.bentrm.datacat.service.impl;

import de.bentrm.datacat.domain.XtdProperty;
import de.bentrm.datacat.repository.PropertyRepository;
import de.bentrm.datacat.service.PropertyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@Transactional(readOnly = true)
public class PropertyServiceImpl extends RootServiceImpl<XtdProperty, PropertyRepository> implements PropertyService {

    public PropertyServiceImpl(PropertyRepository repository) {
        super(repository);
    }

    @Override
    protected XtdProperty newEntityInstance() {
        return new XtdProperty();
    }
}
