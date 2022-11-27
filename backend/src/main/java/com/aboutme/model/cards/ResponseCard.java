package com.aboutme.model.cards;

import lombok.Data;

public interface ResponseCard {

    public default void updateContent() {

    }

    void updateContent(String content);
}
