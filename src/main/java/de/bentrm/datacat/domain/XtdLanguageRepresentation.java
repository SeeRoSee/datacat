package de.bentrm.datacat.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.neo4j.ogm.annotation.NodeEntity;

import javax.validation.constraints.NotNull;

@NodeEntity(label = XtdLanguageRepresentation.LABEL)
public abstract class XtdLanguageRepresentation extends Entity implements Comparable<XtdLanguageRepresentation> {

	public static final String TITLE = "LanguageRepresentation";
	public static final String TITLE_PLURAL = "LanguageRepresentations";
	public static final String LABEL = PREFIX + TITLE;

	private String languageName;

	@NotNull
	private int sortOrder;

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public int getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

	@Override
	public int compareTo(XtdLanguageRepresentation o) {
		return Integer.compare(sortOrder, o.sortOrder);
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.appendSuper(super.toString())
				.append("id", id)
				.append("languageName", languageName)
				.append("sortOrder", sortOrder)
				.toString();
	}
}
