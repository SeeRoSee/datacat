package de.bentrm.datacat.domain.relationship;

import de.bentrm.datacat.domain.XtdObject;
import de.bentrm.datacat.domain.XtdRoot;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

@NodeEntity(label = XtdRelGroups.LABEL)
public class XtdRelGroups extends XtdRelationship {

    public static final String LABEL = "XtdRelGroups";
    public static final String RELATIONSHIP_TYPE = "GROUPS";

    @Relationship(type = RELATIONSHIP_TYPE, direction = Relationship.INCOMING)
    private XtdRoot relatingThing;

    @Relationship(type = RELATIONSHIP_TYPE)
    private Set<XtdRoot> relatedThings = new HashSet<XtdRoot>();

    public XtdRoot getRelatingThing() {
        return relatingThing;
    }

    public void setRelatingThing(XtdObject relatingThing) {
        this.relatingThing = relatingThing;
    }

    public Set<XtdRoot> getRelatedThings() {
        return relatedThings;
    }

    public void setRelatedThings(Set<XtdRoot> relatedThings) {
        this.relatedThings = relatedThings;
    }

}
