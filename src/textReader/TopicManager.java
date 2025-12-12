package textReader;

import java.util.HashMap;
import java.util.Map;

/**
 * The TopicManager Class helps group articles and relates a String to each ArticleComparer for easier
 * access and usage.
 */
public class TopicManager {

    private static final Map<String, ArticleComparer> topicRegistry = new HashMap<>();

    /**
     * This method adds ArticleComparers and Strings to the topicRegistry HashMap.
     *
     * @param name A String that can be used to access the ArticleComparer using a String
     * @param topic Corresponding ArticleComparer object.
     */
    public static void registerTopic(String name, ArticleComparer topic) {
        topicRegistry.put(name.toLowerCase(), topic);
    }

    /**
     * This method retrieves a topic by returning an ArticleComparer object through its corresponding
     * String value
     *
     * @param name A String that is used to access ArticleComparer for analysis
     * @return Returns ArticleComparer object accessed with the String that it is paired with.
     */
    public static ArticleComparer getTopicByName(String name) {
        return topicRegistry.get(name.toLowerCase());
    }
}
