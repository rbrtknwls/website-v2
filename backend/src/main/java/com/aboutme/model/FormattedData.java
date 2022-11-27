package com.aboutme.model;

import com.aboutme.model.cards.ResponseCard;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FormattedData {
    private List<ResponseCard> response;
}
