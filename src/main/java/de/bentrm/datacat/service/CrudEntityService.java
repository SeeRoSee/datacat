package de.bentrm.datacat.service;

import de.bentrm.datacat.domain.XtdEntity;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public interface CrudEntityService<T extends XtdEntity, C, U> extends EntityService<T> {

    @NotNull T create(@Valid C dto);

    @NotNull T update(@Valid U dto);

    Optional<T> delete(@NotNull String id);

}
