package com.manywho.sdk.entities.run.elements.map;

import com.manywho.sdk.entities.ConfigurationValuesAware;
import com.manywho.sdk.entities.run.EngineValueCollection;
import com.manywho.sdk.entities.run.elements.config.Authorization;
import com.manywho.sdk.entities.run.state.UserVoteCollection;
import org.apache.commons.collections4.CollectionUtils;

import java.util.HashMap;

public class VoteRequest implements ConfigurationValuesAware {
    private EngineValueCollection configurationValues;
    private Authorization authorization;
    private UserVoteCollection userVotes;
    private String voteType;
    private int minimumCount;
    private int minimumPercent;
    private HashMap<String, String> attributes;
    private String selectedOutcomeId;

    public EngineValueCollection getConfigurationValues() {
        return configurationValues;
    }

    @Override
    public boolean hasConfigurationValues() {
        return CollectionUtils.isNotEmpty(configurationValues);
    }

    public void setConfigurationValues(EngineValueCollection configurationValues) {
        this.configurationValues = configurationValues;
    }

    public Authorization getAuthorization() {
        return authorization;
    }

    public void setAuthorization(Authorization authorization) {
        this.authorization = authorization;
    }

    public UserVoteCollection getUserVotes() {
        return userVotes;
    }

    public void setUserVotes(UserVoteCollection userVotes) {
        this.userVotes = userVotes;
    }

    public String getVoteType() {
        return voteType;
    }

    public void setVoteType(String voteType) {
        this.voteType = voteType;
    }

    public int getMinimumCount() {
        return minimumCount;
    }

    public void setMinimumCount(int minimumCount) {
        this.minimumCount = minimumCount;
    }

    public int getMinimumPercent() {
        return minimumPercent;
    }

    public void setMinimumPercent(int minimumPercent) {
        this.minimumPercent = minimumPercent;
    }

    public HashMap<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(HashMap<String, String> attributes) {
        this.attributes = attributes;
    }

    public String getSelectedOutcomeId() {
        return selectedOutcomeId;
    }

    public void setSelectedOutcomeId(String selectedOutcomeId) {
        this.selectedOutcomeId = selectedOutcomeId;
    }
}
