package com.mouse.maps.tips;

import com.mouse.maps.tips.models.CreateTipRequest;
import com.mouse.maps.tips.models.GetTipRequest;
import com.mouse.maps.tips.models.Tip;
import com.mouse.maps.tips.models.UpdateTipRequest;
import com.mouse.maps.tips.queries.read.GetTipsQuery;
import com.mouse.maps.tips.queries.write.CreateTipQuery;
import com.mouse.maps.tips.queries.write.DeleteTipQuery;
import com.mouse.maps.tips.queries.write.UpdateTipQuery;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("/info")
@SecurityRequirement(name = "bearerAuth")
@PreAuthorize("isAuthenticated()")
@Tag(name = "Tip")
@RestController
public class TipsController {

    @Autowired
    public CreateTipQuery createTipQuery;
    
    @Autowired
    public DeleteTipQuery deleteTipQuery;
    
    @Autowired
    public UpdateTipQuery updateTipQuery;
    
    @Autowired
    public GetTipsQuery getTipsQuery;
    
    
    @GetMapping("/collect")
    @Operation(
        description = "Get info paginate endpoint",
        security = @SecurityRequirement(name = "bearerAuth")
    )
    public Collection<Tip> getTipPaginate() {
        return this.getTipsQuery.invoke();
    }

    @PostMapping("/create")
    @Operation(
        description = "Create tip endpoint",
        security = @SecurityRequirement(name = "bearerAuth")
    )
    public Tip createTip(@RequestBody CreateTipRequest request) {
        return this.createTipQuery.invoke(request);
    }

    @PutMapping("/update")
    @Operation(
        description = "Update tip endpoint",
        security = @SecurityRequirement(name = "bearerAuth")
    )
    public Tip updateTip(@RequestBody UpdateTipRequest request) {
        return this.updateTipQuery.invoke(request);
    }

    @DeleteMapping("/remove/{tipId}")
    @Operation(
        description = "Remove tip endpoint",
        security = @SecurityRequirement(name = "bearerAuth")
    )
    public String removeTip(@PathVariable Integer tipId) {
        this.deleteTipQuery.invoke(tipId);
        return "OK";
    }

}
