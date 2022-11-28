package com.aboutme.service;

import com.aboutme.exception.CouldNotFindContent;
import com.aboutme.model.Constants;
import com.aboutme.model.FormattedData;
import com.aboutme.model.cards.ResponseCard;
import com.aboutme.model.cards.SpecialStyle1;
import com.aboutme.model.cards.SpecialStyle2;
import com.aboutme.model.cards.Style1;
import com.aboutme.repo.writing.Story1;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

@Service
public class StoryService {

    public FormattedData getStory1() {

        return formatFile(Story1.words);

    }

    private FormattedData formatFile(String story) {
        ArrayList<ResponseCard> storyContent = new ArrayList<>();
        ResponseCard currentCard = null;

        String[] lines = story.split("\n");
        for (int i = 0; i < lines.length; i++) {
            String data = lines[i];

            if (data.contains(Constants.BOXTYPE)) {
                String boxType = data.split(": ")[1];

                switch (boxType) {
                    case (Constants.SPECIALSTYLE1):
                        currentCard = new SpecialStyle1();
                        break;
                    case (Constants.SPECIALSTYLE2):
                        currentCard = new SpecialStyle2();
                        break;
                    case (Constants.STYLE1):
                        currentCard = new Style1();
                        break;
                }
            } else if (data.contains(Constants.ENDBOX)) {
                storyContent.add(currentCard);
            } else {
                assert currentCard != null;
                currentCard.updateContent(data.trim());
            }
        }

        return FormattedData.builder().response(storyContent).build();
    }
}
