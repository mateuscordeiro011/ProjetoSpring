package com.intensivojavaspring.DSgames.projections;

public interface GameMinProjection {

    Long getId();
    String getTitle();
    int getYear();
    String getImgUrl();
    String getShortDescription();
    int getPosition();
}
