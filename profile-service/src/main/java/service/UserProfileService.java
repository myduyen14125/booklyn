package service;

import dto.request.ProfileCreationRequest;
import dto.response.UserProfileResponse;
import entity.UserProfile;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import mapper.UserProfileMapper;
import org.springframework.stereotype.Service;
import repository.UserProfileRepository;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserProfileService {
    UserProfileRepository userProfileRepository;
    UserProfileMapper userProfileMapper;

    public UserProfileResponse createProfile(ProfileCreationRequest request) {
        UserProfile userProfile = userProfileMapper.toUserProfile(request);
        userProfileRepository.save(userProfile);
        return userProfileMapper.toUserProfileResponse(userProfile);
    }

    public UserProfileResponse getProfile(String id) {
        return userProfileMapper.toUserProfileResponse(userProfileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile not found")));
    }
}
