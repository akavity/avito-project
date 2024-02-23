package org.akavity.utils;

import com.codeborne.selenide.ElementsCollection;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public double extractDoubleFromText(String text, String regex) {
        double result = 0.0;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            result = Double.parseDouble(matcher.group()
                    .replace(",", ".")
                    .replace("м²", ""));
        }
        return result;
    }

    public int extractIntFromText(String text, String regex) {
        int result = 0;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            result = Integer.parseInt(matcher.group()
                    .replace(" ", "")
                    .replace("м²", ""));
        }
        return result;
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

    public boolean doShortDescriptionsContainText(ElementsCollection collection, List<String> parameters, int elements) {
        boolean result = true;
        if (collection.isEmpty()) {
            log.info("Collection is empty");
            result = false;
        } else {
            List<String> descriptions = new ArrayList<>(collection.first(elements).texts());
            for (String description : descriptions) {
                log.info("Array descriptions contains description: " + description);
                for (String parameter : parameters) {
                    if (!description.contains(parameter)) {
                        log.info("/// Description dose not contain parameter: " + parameter);
                        result = false;
                        break;
                    } else {
                        log.info("Description contains " + parameter);
                    }
                }
            }
        }
        return result;
    }
}
