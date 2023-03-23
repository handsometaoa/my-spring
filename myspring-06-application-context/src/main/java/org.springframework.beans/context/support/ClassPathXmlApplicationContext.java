package org.springframework.beans.context.support;

public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {

    String[] configLocations;

    public ClassPathXmlApplicationContext(String configLocation) {
        this(new String[]{configLocation});
    }

    public ClassPathXmlApplicationContext(String[] configLocations) {
        this.configLocations = configLocations;
        refresh();
    }

    @Override
    String[] getConfigLocations() {
        return configLocations;
    }
}
