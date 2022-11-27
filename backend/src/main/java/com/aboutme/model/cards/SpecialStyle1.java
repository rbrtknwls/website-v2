package com.aboutme.model.cards;

import lombok.Data;

@Data
public class SpecialStyle1 implements ResponseCard {
    private String style = "Special Style 1";
    private String content = "";

    @Override
    public void updateContent(String content) {
        this.content = this.content + 'n' + content;
    }
}
