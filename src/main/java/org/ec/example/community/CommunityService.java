package org.ec.example.community;

import org.ec.example.community.dto.CommunityRequest;
import org.ec.example.community.dto.CommunityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunityService {

    private final CommunityRepository communityRepository;

    @Autowired
    public CommunityService(CommunityRepository communityRepository) {
        this.communityRepository = communityRepository;
    }

    public CommunityResponse getCommunity(Long id) {
        Community community = communityRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Community is not found."));
        community.increaseViews();
        Community updated = communityRepository.save(community);
        return new CommunityResponse(updated.getId(), updated.getTitle(), updated.getContent(), updated.getViews(), updated.getCreatedAt(), updated.getUpdatedAt());
    }

    public CommunityResponse postCommunity(CommunityRequest communityRequest) {
        Community community = communityRepository.save(new Community(communityRequest.getTitle(), communityRequest.getContent()));
        return new CommunityResponse(community.getId(), community.getTitle(), community.getContent(), community.getViews(), community.getCreatedAt(), community.getUpdatedAt());
    }

    public CommunityResponse putCommunity(CommunityRequest communityRequest, Long id) {
        Community community = communityRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Community is not found."));
        Community updated = new Community(community.getId(), communityRequest.getTitle(), communityRequest.getContent(), community.getViews(), community.getCreatedAt(), System.currentTimeMillis());
        communityRepository.save(updated);
        return new CommunityResponse(updated.getId(), updated.getTitle(), updated.getContent(), updated.getViews(), updated.getCreatedAt(), updated.getUpdatedAt());
    }

    public Long deleteCommunity(Long id) {
        if (!communityRepository.existsById(id))
            throw new IllegalArgumentException("Community is not found.");
        communityRepository.deleteById(id);
        return id;
    }
}
