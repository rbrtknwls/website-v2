package com.aboutme.service;

import com.aboutme.exception.CouldNotFindData;
import com.aboutme.model.FormattedData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class RoutingService {

    public FormattedData getResponse(String info) {

        // Logic will be replaced with better later
        if (Objects.equals(info, "short_story_for_megan")) {
            return FormattedData.builder().build();
        } else {
            throw new CouldNotFindData(info);
        }
    }
}
