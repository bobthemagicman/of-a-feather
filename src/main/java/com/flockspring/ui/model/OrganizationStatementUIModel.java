/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.model;

/**
 * OrganizationStatementUIModel.java
 *
 * @author Justen L. Britain
 * @date Dec 15, 2013
 *
 */
public class OrganizationStatementUIModel
{
    public String missionStatement;
    public String statementOfFaith;
    public String welcomeMessage;
   
    public OrganizationStatementUIModel(String missionStatement, String statementOfFaith, String welcomeMessage)
    {
        super();
        
        this.missionStatement = missionStatement;
        this.statementOfFaith = statementOfFaith;
        this.welcomeMessage = welcomeMessage;
    }

    public String getMissionStatement()
    {
        return missionStatement;
    }

    public String getStatementOfFaith()
    {
        return statementOfFaith;
    }

    public String getWelcomeMessage()
    {
        return welcomeMessage;
    }
}