package com.aboutme.service;

import com.aboutme.exception.CouldNotFindContent;
import com.aboutme.model.Constants;
import com.aboutme.model.FormattedData;
import com.aboutme.model.cards.ResponseCard;
import com.aboutme.model.cards.SpecialStyle1;
import com.aboutme.model.cards.Style1;
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

        Resource resource = new ClassPathResource("writing/story_1.txt");
        FormattedData content;

        try {
            File story = resource.getFile();
            Scanner scanner = new Scanner(story);

            content = formatFile(scanner);
            scanner.close();

            return content;
        } catch (IOException ex) {
            throw new CouldNotFindContent(ex.getMessage());
        }

    }

    private FormattedData formatFile(Scanner scanner) {
        ArrayList<ResponseCard> storyContent = new ArrayList<>();
        ResponseCard currentCard = null;
        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();

            if (data.contains(Constants.BOXTYPE)) {
                String boxType = data.split(": ")[1];

                switch (boxType) {
                    case (Constants.SPECIALSTYLE1):
                        currentCard = new SpecialStyle1();
                        break;
                    case (Constants.STYLE1):
                        currentCard = new Style1();
                        break;
                }
            } else if (data.contains(Constants.ENDBOX)) {
                storyContent.add(currentCard);
            } else {
                currentCard.updateContent(data);
            }
        }

        return FormattedData.builder().response(storyContent).build();
    }
}
