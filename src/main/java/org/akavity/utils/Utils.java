package org.akavity.utils;

import com.codeborne.selenide.ElementsCollection;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;
@Log4j2
public class Utils {
    public void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean doElementsContainText(ElementsCollection collection, String text, int elements) {
        boolean result = true;
        if (collection.isEmpty()) {
            log.info("Collection is empty");
            result = false;
        } else {
            List<String> names = new ArrayList<>(collection.first(elements).texts());
            for (String name : names) {
                log.info("Array names contains name: " + name);
                if (!name.contains(text)) {
                    log.info("/// Object name dose not contain text: " + text);
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}
