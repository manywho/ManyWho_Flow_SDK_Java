package com.manywho.sdk.api.run.elements.map;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.manywho.sdk.api.run.EngineValue;
import com.manywho.sdk.api.run.elements.ConfigurationValuesAware;
import com.manywho.sdk.api.run.elements.config.Authorization;
import com.manywho.sdk.api.run.state.UserVote;

import java.util.List;
import java.util.Map;

public class VoteRequest implements ConfigurationValuesAware {
    private List<EngineValue> configurationValues = Lists.newArrayList();
    private Authorization authorization;
    private List<UserVote> userVotes = Lists.newArrayList();
    private String voteType;
    private int minimumCount;
    private int minimumPercent;
    private Map<String, String> attributes = Maps.newHashMap();
    private String selectedOutcomeId;

    public List<EngineValue> getConfigurationValues() {
        return configurationValues;
    }

    @Override
    public boolean hasConfigurationValues() {
        return !configurationValues.isEmpty();
    }

    public void setConfigurationValues(List<EngineValue> configurationValues) {
        this.configurationValues = MoreObjects.firstNonNull(configurationValues, Lists.newArrayList());
    }

    public Authorization getAuthorization() {
        return authorization;
    }

    public void setAuthorization(Authorization authorization) {
        this.authorization = authorization;
    }

    public List<UserVote> getUserVotes() {
        return userVotes;
    }

    public void setUserVotes(List<UserVote> userVotes) {
        this.userVotes = MoreObjects.firstNonNull(userVotes, Lists.newArrayList());
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

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = MoreObjects.firstNonNull(attributes, Maps.newHashMap());
    }

    public String getSelectedOutcomeId() {
        return selectedOutcomeId;
    }

    public void setSelectedOutcomeId(String selectedOutcomeId) {
        this.selectedOutcomeId = selectedOutcomeId;
    }
}
