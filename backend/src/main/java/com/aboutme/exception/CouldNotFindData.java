package com.aboutme.exception;

public class CouldNotFindData extends RuntimeException {

    public CouldNotFindData(String error) {super("Could not find data for query: " + error); }
}
