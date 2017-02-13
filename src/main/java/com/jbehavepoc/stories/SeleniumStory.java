package com.jbehavepoc.stories;

import com.jbehavepoc.selenium.steps.RegistrationInDemoQASteps;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;


/**
 * Created by linfante on 2/10/2017.
 */
public class SeleniumStory extends JUnitStories {

    private static final String STORY_PATH = "**/selenium/stories/*.story";
    private static final String EXCLUDED_PATH = "**/selenium/stories/excluded/*.story";

    @Override
    public Configuration configuration(){
        return new MostUsefulConfiguration()
                .useStoryReporterBuilder(
                        new StoryReporterBuilder()
                                .withDefaultFormats()
                                .withFormats(Format.CONSOLE, Format.TXT, Format.HTML)
                );
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(),
                new RegistrationInDemoQASteps());
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder()
                .findPaths(codeLocationFromClass(this.getClass()), STORY_PATH, EXCLUDED_PATH);
    }
}
