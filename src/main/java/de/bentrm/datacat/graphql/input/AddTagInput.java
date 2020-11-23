package de.bentrm.datacat.graphql.input;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AddTagInput {
    @NotBlank
    private String entryId;

    @NotBlank
    private String tagId;
}
