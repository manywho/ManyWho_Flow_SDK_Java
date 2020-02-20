package com.manywho.services.example.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LambdaSuite.class,
        UndertowSuite.class
})
public class AllSuites {
}
