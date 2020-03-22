package task2.services;

import task2.models.Composite;


public interface Delimiter {
    Component matchFinder(Composite composite, String regex, String text);
}
