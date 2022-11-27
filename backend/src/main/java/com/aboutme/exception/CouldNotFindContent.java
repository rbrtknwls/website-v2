package com.aboutme.exception;

public class CouldNotFindContent extends RuntimeException {

    public CouldNotFindContent(String error) {super("Could not find internal content for query: " + error); }
}
