package com.aboutme.model.cards;

import lombok.Data;

@Data
public class Style1 implements ResponseCard {
    private String style = "Style 1";
    private String content = "";


    @Override
    public void updateContent(String content) {
        if (this.content.equals("")) {
            this.content = content;
        } else {
            this.content = this.content + '\n' + content;
        }
    }
}
