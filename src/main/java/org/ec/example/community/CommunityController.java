package org.ec.example.community;

import org.ec.example.community.dto.CommunityRequest;
import org.ec.example.community.dto.CommunityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/community")
public class CommunityController {

    private final CommunityService communityService;

    @Autowired
    public CommunityController(CommunityService communityService) {
        this.communityService = communityService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommunityResponse> getCommunity(@PathVariable Long id) {
        CommunityResponse communityResponse = communityService.getCommunity(id);
        return new ResponseEntity<>(communityResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CommunityResponse> postCommunity(@RequestBody CommunityRequest communityRequest) {
        CommunityResponse communityResponse = communityService.postCommunity(communityRequest);
        return new ResponseEntity<>(communityResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommunityResponse> putCommunity(@RequestBody CommunityRequest communityRequest, @PathVariable Long id) {
        CommunityResponse communityResponse = communityService.putCommunity(communityRequest, id);
        return new ResponseEntity<>(communityResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteCommunity(@PathVariable Long id) {
        communityService.deleteCommunity(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
