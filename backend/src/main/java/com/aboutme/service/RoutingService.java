package com.aboutme.service;

import com.aboutme.exception.CouldNotFindData;
import com.aboutme.model.FormattedData;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class RoutingService {

    @Autowired
    StoryService storyService;

    public FormattedData getResponse(String info) {

        // Logic will be replaced with better later
        if (Objects.equals(info, "short_story_for_megan")) {
            return storyService.getStory1();
        } else {
            throw new CouldNotFindData(info);
        }
    }
}
