package de.bentrm.datacat.catalog.service.impl;

import de.bentrm.datacat.base.specification.QuerySpecification;
import de.bentrm.datacat.catalog.domain.XtdNest;
import de.bentrm.datacat.catalog.repository.NestRepository;
import de.bentrm.datacat.catalog.service.NestService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
@Validated
@Transactional(readOnly = true)
public class NestServiceImpl implements NestService {

    private final QueryDelegate<XtdNest> queryDelegate;

    public NestServiceImpl(NestRepository repository) {
        this.queryDelegate = new QueryDelegate<>(repository);
    }

    @Override
    public @NotNull Optional<XtdNest> findById(@NotNull String id) {
        return queryDelegate.findById(id);
    }

    @Override
    public @NotNull List<XtdNest> findAllByIds(@NotNull List<String> ids) {
        return queryDelegate.findAllByIds(ids);
    }

    @Override
    public @NotNull Page<XtdNest> findAll(@NotNull QuerySpecification specification) {
        return queryDelegate.findAll(specification);
    }

    @Override
    public @NotNull long count(@NotNull QuerySpecification specification) {
        return queryDelegate.count(specification);
    }
}
