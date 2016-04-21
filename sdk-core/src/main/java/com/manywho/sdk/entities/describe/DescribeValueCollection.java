package com.manywho.sdk.entities.describe;

import java.util.ArrayList;
import java.util.Collections;

public class DescribeValueCollection extends ArrayList<DescribeValue> {
    public DescribeValueCollection() {
    }

    public DescribeValueCollection(DescribeValue... describeValues) {
        Collections.addAll(this, describeValues);
    }
}
