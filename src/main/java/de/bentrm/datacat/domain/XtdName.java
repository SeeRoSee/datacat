package de.bentrm.datacat.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.neo4j.ogm.annotation.NodeEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NodeEntity(label = XtdName.LABEL)
public class XtdName extends XtdLanguageRepresentation {

    public static final String TITLE = "Name";
    public static final String TITLE_PLURAL = "Names";
    public static final String LABEL = PREFIX + TITLE;
    public static final String RELATIONSHIP_TYPE = "IS_NAME_OF";

    @NotNull
    @NotBlank
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(name)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("name", name)
                .toString();
    }
}
