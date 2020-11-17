package de.bentrm.datacat.catalog.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
@NodeEntity(label = XtdRelAssignsUnits.LABEL)
public class XtdRelAssignsUnits extends XtdRelationship {

    public static final String LABEL = "XtdRelAssignsUnit";
    public static final String RELATIONSHIP_TYPE = "ASSIGNS_UNIT";

    @Relationship(type = RELATIONSHIP_TYPE, direction = Relationship.INCOMING)
    private XtdMeasureWithUnit relatingMeasure;

    @Relationship(type = RELATIONSHIP_TYPE)
    private final Set<XtdUnit> relatedUnits = new HashSet<>();
}
