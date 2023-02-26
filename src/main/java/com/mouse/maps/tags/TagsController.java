package com.mouse.maps.tags;

import com.mouse.maps.tags.models.CreateTagRequest;
import com.mouse.maps.tags.models.Tag;
import com.mouse.maps.tags.models.UpdateTagRequest;
import com.mouse.maps.tags.queries.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("/tags")
@SecurityRequirement(name = "bearerAuth")
@PreAuthorize("isAuthenticated()")
@io.swagger.v3.oas.annotations.tags.Tag(name = "Tags")
@RestController
public class TagsController {

    @Autowired protected GetTags getTags;

    @Autowired protected GetTag getTag;

    @Autowired protected CreateTag createTag;

    @Autowired protected UpdateTag updateTag;

    @Autowired protected DeleteTag deleteTag;

    @GetMapping
    @Operation(
        description = "Get tags endpoint",
        security = @SecurityRequirement(name = "bearerAuth")
    )
    public Collection<Tag> getTags() {
        return this.getTags.invoke();
    }

    @GetMapping("/{tagId}")
    @Operation(
        description = "Get tag endpoint",
        security = @SecurityRequirement(name = "bearerAuth")
    )
    public Tag getTag(@PathVariable Integer tagId) {
        return this.getTag.invoke(tagId);
    }

    @DeleteMapping("/{tagId}")
    @Operation(
        description = "Delete tag endpoint",
        security = @SecurityRequirement(name = "bearerAuth")
    )
    public String deleteTag(@PathVariable Integer tagId) {
        this.deleteTag.invoke(tagId);
        return "Ok";
    }

    @PostMapping
    @Operation(
            description = "Delete tag endpoint",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    public Tag createTag(@RequestBody CreateTagRequest request) {
        return this.createTag.invoke(request);
    }

    @PutMapping
    @Operation(
        description = "Update tag endpoint",
        security = @SecurityRequirement(name = "bearerAuth")
    )
    public Tag updateTag(@RequestBody UpdateTagRequest request) {
        return this.updateTag.invoke(request);
    }
}
