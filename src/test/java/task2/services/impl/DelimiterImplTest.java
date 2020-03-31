package task2.services.impl;


import org.junit.Before;
import org.junit.Test;
import task2.models.CompositeTextElements;
import task2.models.MinTextElement;
import task2.services.ComponentOfText;
import task2.services.Delimiter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

class DelimiterImplTest {
    private ComponentOfText test_allText;
    private Delimiter test_delimiter;
    private ComponentOfText test_sentence;


    @Before
    public void init() {
        test_allText = new CompositeTextElements("первое предложение.\n" +
                "второе предложение длинное очень очень очень\n" +
                "очень очень и разделено на две строки.\n" +
                "третье содержит english слова.\n" +
                "четвертое содержит ссылку www.leningrad.ru.\n" +
                "пятоеВодноСлово.");
        test_delimiter = new DelimiterImpl();
        test_sentence = new CompositeTextElements();
        fillFirstSentence();

    }

    private void fillFirstSentence() {
        ((CompositeTextElements) this.test_sentence).add(new MinTextElement("первое"));
        ((CompositeTextElements) this.test_sentence).add(new MinTextElement(" "));
        ((CompositeTextElements) this.test_sentence).add(new MinTextElement("предложение"));
        ((CompositeTextElements) this.test_sentence).add(new MinTextElement("."));
        ((CompositeTextElements) this.test_sentence).add(new MinTextElement("\n"));
    }


    @Test
    public void shouldBeExpectedNumberOfSentence_whenTextParsedIntoSentence() {
        test_delimiter.sentenceMatcher(test_allText);
        assertTrue(((CompositeTextElements) test_allText).getSingleLevelComponent().size() == 5);
        assertEquals("", test_sentence, ((CompositeTextElements) test_allText).getSingleLevelComponent().get(0));

    }


}