package com.profile_service.service;

import com.profile_service.dto.request.ProfileCreationRequest;
import com.profile_service.dto.response.UserProfileResponse;
import com.profile_service.entity.UserProfile;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import com.profile_service.mapper.UserProfileMapper;
import org.springframework.stereotype.Service;
import com.profile_service.repository.UserProfileRepository;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserProfileService {
    UserProfileRepository userProfileRepository;
    UserProfileMapper userProfileMapper;

    public UserProfileResponse createProfile(ProfileCreationRequest request) {
        UserProfile userProfile = userProfileMapper.toUserProfile(request);
        userProfile = userProfileRepository.save(userProfile);
        return userProfileMapper.toUserProfileResponse(userProfile);
    }

    public UserProfileResponse getProfile(String id) {
        return userProfileMapper.toUserProfileResponse(userProfileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile not found")));
    }
}
